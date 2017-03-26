package com.github.poker;

import java.util.ArrayList;

public class Dealer {

  private String name;
  private ArrayList<Player> players;
  private static Dealer dealer;

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

  public ArrayList<Player> getPlayer(){
    return player;
  }
}
