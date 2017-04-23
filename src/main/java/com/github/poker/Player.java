package com.github.poker;

import java.util.ArrayList;

public class Player extends CardHolder {

    private String name;
    //private ArrayList<Card> hand;
    private int chips, previousBet;

    public Player (String name){
        super();
        this.name = name;
        previousBet=0;

        //Initial hand
        Deck.getInstance().giveCard(this,2);

        printHand();
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public String getName(){
        return name;
    }

    public int getChips(){
        return chips;
    }


    public void placeBet(int amount) {
        chips-= amount-previousBet; //Consider previousBet when adding to the pot
        Board.getInstance().addToPot(amount, previousBet);

        System.out.println("["+this.name+"] I've placed "+(amount-previousBet)+" in the pot");

        previousBet=amount;
        //What happen if the player doesn't have enough chips for the small or big blind

    }

    public Action getAction(int prevAmount) {
        System.out.println("["+this.name+"] You have "+this.chips+ " chips. Last bet was "+prevAmount+".");
        return Validator.returnAction();
    }
}
