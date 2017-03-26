package com.github.poker;

import java.util.ArrayList;

public class Dealer {

  private static Dealer dealer;

  private String name;
  private ArrayList<Player> players;
  
  int blindIdx;
  
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
    nextPlayer(subject);
  }

  public void flop() {

  }

  public void turn() {

  }

  public void river() {

  }

  public void declareWinner() {

  }

  public Player nextPlayer(Player current) {
    if(current==null) {
      return players.get(blindIdx);
    }
    return null;
  }
}
