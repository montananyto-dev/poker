package com.github.poker;

import java.util.ArrayList;
import java.util.Random;

class Deck {
  private static Deck deck;
  private static ArrayList<Card> cards;

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

  public void giveCard(CardHolder receiver, int amount) {
    for(int i=0; i<amount; i++) {
      Random rnd = new Random();
  		Card drawn = cards.get(rnd.nextInt(cards.size()));
  		cards.remove(drawn);

      receiver.receiveCard(drawn);
      System.out.println("giveCard() called");
    }
  }

    public void displayAllCards(){

  		for(Card card : cards ){

  			System.out.println(card.toString());
  		}
  		System.out.println("\n");
  	}
  }
