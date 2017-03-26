package com.github.poker;

import java.util.ArrayList;

public class Dealer{

  private String name;
  private static ArrayList<Player> player;
  private static Dealer dealer;

private Dealer(){}

public static Dealer getInstance(){
  if(dealer == null){
    dealer = new Dealer();
    System.out.println("Dealer created");
  }
  return dealer;
}

public void setName(String name){
  this.name = name;
  }

public String getName(){
  return name;
  }
public void setPlayer(ArrayList<Player> player){
  this.player = player;
}
public ArrayList<Player> getPlayer(){
  return player;
}
}
