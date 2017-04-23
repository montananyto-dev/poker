package com.github.poker;

import java.util.ArrayList;

public class Dealer {

    private static Dealer dealer;

    private Board board;

    private String name;
    private ArrayList<Player> sessionPlayers;
    private ArrayList<Player> gamePlayers;

    int smallIdx=0;
    int smallBlind;

    int checkCount;

    Player subject;

    private Dealer() {}

    public static Dealer getInstance() {
        if(dealer == null)
            dealer = new Dealer();
        return dealer;
    }

    public Dealer setName(String name) {
        this.name = name;
        return this;
    }

    public String getName(){
        return name;
    }

    public Dealer setPlayers(ArrayList<Player> players, int chips) {
        for(Player player: players)
            player.setChips(chips);

        this.sessionPlayers = players;
        return this;
    }

    public Dealer setSmallBlind(int smallBlind){
        this.smallBlind = smallBlind;
        return this;
    }

    public Dealer setBoardInstance(Board board) {
        this.board = board;
        return this;
    }

    private void declarePhase(String phaseName) {
        String text=phaseName+" Start";
        System.out.println(text);
        for (char c : text.toCharArray())
            System.out.print("=");
        System.out.println();
    }

    public void startSession() {
        declarePhase("Session");
        startGame();
    }

    private void startGame() {
        declarePhase("Game");
        gamePlayers=new ArrayList<Player>(sessionPlayers);

        declarePhase("Initial Bets");
        subject=gamePlayers.get(smallIdx);
        placeBlinds();
        betting();

        declarePhase("Flop");
        Deck.getInstance().giveCard(board,3);
        board.printHand();
        subject=gamePlayers.get(smallIdx);
        betting();

        turn();
        river();
        declareWinner();
    }

    public void betting() {
        checkCount=0;
        while(checkCount < gamePlayers.size()-1) {
            reqAction(subject);
            nextPlayer();
        }
        System.out.println("Escaped!");
    }

    private void placeBlinds() {
        subject.placeBet(smallBlind);
        nextPlayer();
        subject.placeBet(smallBlind*2); //big blind
        nextPlayer();
    }

    private void reqAction(Player player) {
        Action action = player.getAction(board.getPreviousAmount());

        switch(action) {
            case CHECK:
                player.placeBet(board.getPreviousAmount());

                checkCount++;
                break;
            case RAISE:
                int maximumRaise = player.getChips();
                int amount = Validator.reqNumber("How much would you like to raise(min. 1 and max. "+maximumRaise+")",1,maximumRaise);
                player.placeBet(amount + board.getPreviousAmount());

                checkCount=0;
                break;
            case FOLD:
                gamePlayers.remove(player);
                System.out.println("Removed player!");
                break;
            default:
                System.out.println("Handle RAISE and FOLD");
        }
    }

    public void flop() {

    }

    public void turn() {
        System.out.println("Additional card to the flop face up ");
    }

    public void river() {
        System.out.println("Additional card to the turn face up ");
    }

    public void declareWinner() {

    }

    private void nextPlayer() {
        int nextIdx = gamePlayers.indexOf(subject) + 1;
        if(nextIdx == gamePlayers.size()) {
            subject = gamePlayers.get(0);
        } else {
            subject = gamePlayers.get(nextIdx);
        }
    }
}
