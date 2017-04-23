
package com.github.poker;

public class Board extends CardHolder {

    private static Board board;
    private int pot;
    private int previousAmount;

    private Board(){
        super();
    }

    public static Board getInstance(){
        if(board == null) {
            board = new Board();
        }
        return board;
    }

    public void addToPot(int amount, int diff){
        this.pot+=amount-diff;
        this.previousAmount =amount;
    }

    public int getPreviousAmount() {
        return this.previousAmount;
    }

}
