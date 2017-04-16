package com.github.poker;

import java.util.ArrayList;

public class Dealer {

  private static Dealer dealer;

  private String name;
  private ArrayList<Player> players;
  
  int smallIdx=0;
  int smallAmount=25;
  
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

    this.players = players;
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
    subject.placeBet(smallAmount);
    nextPlayer();
    subject.placeBet(smallAmount*2); //big blind
  }

  private void reqAction(Player player) {
    Action action = player.getAction(Board.getInstance().getPreviousAmount());
    switch(action) {
      case CHECK:
        player.placeBet(Board.getInstance().getPreviousAmount());
        break;
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
