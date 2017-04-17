package com.github.poker;

import java.util.ArrayList;

public class Dealer {

private static Dealer dealer;

private Board board;

private String name;
private ArrayList<Player> players;

int smallIdx=0;
int smallBlind;

Player subject;

private Dealer() {
}

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

        this.players = players;
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
        initialBets();
        flop();
        turn();
        river();
        declareWinner();
}

public void initialBets() {
        declarePhase("Initial Bets");
        subject=players.get(smallIdx);
        placeBlinds();

        nextPlayer();
        reqAction(subject);
}

private void placeBlinds() {
        subject.placeBet(smallBlind);
        nextPlayer();
        subject.placeBet(smallBlind*2); //big blind
}

private void reqAction(Player player) {
        Action action = player.getAction(board.getPreviousAmount());
        switch(action) {
        case CHECK:
                player.placeBet(board.getPreviousAmount());
                break;
        // case RAISE:
        //         Validator.reqRaise("How much would you like to raise(min. "+Board.getInstance().getPreviousAmount()+" and max. "+Board.getInstance().getChips())",50,2000");
        // case FOLD:

        default:
                System.out.println("Handle RAISE and FOLD");
        }
}

public void flop() {

}

public void turn() {

}

public void river() {

}

public void declareWinner() {

}

private void nextPlayer() {
        int nextIdx = players.indexOf(subject) + 1;
        if(nextIdx == players.size()) {
                subject = players.get(0);
        } else {
                subject = players.get(nextIdx);
        }
}


}
