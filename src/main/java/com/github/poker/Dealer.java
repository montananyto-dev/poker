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

  public void setName(String name) {
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setPlayers(ArrayList<Player> players) { 
    this.players = players;
  }

  public void startSession() {
    startGame();
  }

  private void startGame() {
    initialBets();
    flop();
    turn();
    river();
    declareWinner();
  }

  public void initialBets() {
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
    player.getAction(Board.getInstance().getPreviousAmount());
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
