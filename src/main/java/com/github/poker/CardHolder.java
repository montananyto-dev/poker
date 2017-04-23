package com.github.poker;

import java.util.ArrayList;

class CardHolder {
    private ArrayList<Card> hand;

    protected CardHolder() {
        hand = new ArrayList<>();
    }

    public void receiveCard(Card newCard) {
        hand.add(newCard);
    }

    public void printHand() {
        for(Card card : hand) {
            System.out.println(">"+card);
        }
    }
}
