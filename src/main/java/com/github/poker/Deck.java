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

  public Card drawCard(){
  		Random rnd = new Random();
  		Card drawn = cards.get(rnd.nextInt(cards.size()));
  		cards.remove(drawn);

  		return drawn;
  	}

    public void displayAllCards(){

  		for(Card card : cards ){

  			System.out.println(card.toString());
  		}
  		System.out.println("\n");
  	}
  }
