package com.github.poker;

import java.util.ArrayList;

class Deck {
  private static Deck deck;
  private ArrayList<Card> cards;

  private Deck() {
    cards = new ArrayList<Card>();

    for(Rank r : Rank.values())
      for(Suit s : Suit.values())
        cards.add(new Card(r,s));


  }

  public static Deck getInstance() {
    if(deck==null) {
      deck=new Deck();
    }
    return deck;
  }
}
