package com.github.poker;

import java.util.ArrayList;

public class Player implements CardHolder {

        private String name;
        private ArrayList<Card> hand;
        private int chips;

        public Player (String name){
                this.name = name;
                this.hand = new ArrayList<Card>();

                //Initial hand
                Deck.getInstance().giveCard(this,2);

                printHand();
        }

        public void setChips(int chips) {
                this.chips = chips;
        }

        public void receiveCard(Card newCard) {
                hand.add(newCard);
        }

        public void setName(String name){
                this.name = name;
        }

        public String getName(){
                return name;
        }

        public void setHand(ArrayList<Card> hand){
                this.hand = hand;
        }

        public ArrayList<Card> getHand(){
                return hand;
        }

        public int getChips(){
                return chips;
        }

        public void printHand() {
                System.out.println("["+this.name+"] has...");
                for(int i=0; i<2; i++) {
                        System.out.println("\t>"+hand.get(i));
                }
        }
        public void placeBet(int amount){
                chips-= amount;
                Board.getInstance().addToPot(amount);
                System.out.println("["+this.name+"] I've placed "+amount+" in the pot");
                //What happen if the player doesn't have enough chips for the small or big blind

        }

        public Action getAction(int prevAmount) {
                System.out.println("["+this.name+"] You have "+this.chips+ " chips. Last bet was "+prevAmount+".");
                return Validator.reqAction();
        }




}
