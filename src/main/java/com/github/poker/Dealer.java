package com.github.poker;

import java.util.ArrayList;

public class Dealer {

  private static Dealer dealer;

  private String name;
  private ArrayList<Player> players;
  
  Integer smallIdx=0;
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

  public void startGame() {
    initialBets();
    flop();
    turn();
    river();
    declareWinner();
  }

  public void initialBets() {
    placeBlinds();
  }

  public void flop() {

  }

  public void turn() {

  }

  public void river() {

  }

  public void declareWinner() {

  }
  public void placeBlinds() {
    nextPlayer(subject);
    subject.placeBet(smallAmount);
    nextPlayer(subject);
    subject.placeBet(smallAmount*2); //big blind
  }

  public void nextPlayer(Player currentPlayer) {
    if(currentPlayer==null) {
      currentPlayer=players.get(smallIdx);
      nextIndex(smallIdx); //For next round
    }

    Integer nextIdx = players.indexOf(currentPlayer)+1;
    nextIndex(nextIdx);

    currentPlayer = players.get(nextIdx);
  }

  public void nextIndex(Integer currentIdx) {
    currentIdx = ( currentIdx+1 == players.size() ? 0 : currentIdx+1 );
  }
}
