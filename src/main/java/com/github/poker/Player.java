package com.github.poker;

import java.util.ArrayList;

public class Player{

public String name;
public int age;
public ArrayList<Card> hand;



public Player (String name, int age){
  this.name = name;
  this.age = age;
  this.hand = new ArrayList<Card>();

  //Initial hand
  hand.add(Deck.getInstance().drawCard());
  hand.add(Deck.getInstance().drawCard());
}

public void setName(String name){
  this.name = name;
}
public String getName(){
  return name;
}
public void setAge(int age){
  this.age = age;
}
public int getAge(){
  return age;
}
public void setHand(ArrayList<Card> hand){
  this.hand = hand;
}
public ArrayList<Card> getHand(){
  return hand;
}
public void printHand() {
  for(Card aCard : hand)
    System.out.print(aCard + "\n");

}

}
