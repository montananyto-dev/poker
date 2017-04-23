
package com.github.poker;

import java.util.ArrayList;

public class Board implements CardHolder {

        private static Board board;
        private ArrayList<Card> boardHand;
        private int pot;
        private int previousAmount;

        private Board(){
        }

        public static Board getInstance(){
                if(board == null) {
                        board = new Board();
                }
                return board;
        }

        public void receiveCard(Card newCard) {
                boardHand.add(newCard);
        }

        public void setBoardHand(ArrayList<Card> boardHand){
                this.boardHand = new ArrayList<Card>();
                Deck.getInstance().giveCard(this,3);

        }

        public ArrayList<Card> getBoardHand(){
                return boardHand;
        }

        public void addToPot(int amount, int diff){
                this.pot+=amount-diff;
                this.previousAmount =amount;
        }

        public int getPreviousAmount() {
                return this.previousAmount;
        }

        public int getPot(){
                return pot;
        }

}
