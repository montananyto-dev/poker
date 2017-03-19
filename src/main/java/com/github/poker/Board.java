
package com.github.poker;

import java.util.ArrayList;

public class Board{

private static Board board;
private ArrayList<Card> boardHand;

private Board(){}

public static Board getInstance(){
  if(board == null){
    board = new Board();
    System.out.println("Board created");
  }
  return board;
  }
public void setBoardHand(ArrayList<Card> boardHand){
  this.boardHand = new ArrayList<Card>();
  boardHand.add(Deck.getInstance().drawCard());
  boardHand.add(Deck.getInstance().drawCard());
}
public ArrayList<Card> getBoardHand(){
  return boardHand;
}

}
