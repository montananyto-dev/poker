package com.github.poker;

class Card {
  private Rank m_rank;
  private Suit m_suit;

  public Card(Rank rank, Suit suit) {
    m_rank = rank;
    m_suit = suit;
    System.out.println(rank + " OF " + suit + "S");
  }
}
