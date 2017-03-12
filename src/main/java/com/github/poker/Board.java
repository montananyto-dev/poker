package com.github.poker;

public class Board{

private static Board board;

private Board(){}

public static Board getInstance(){
  if(board == null){
    board = new Board();
    System.out.println("Board created");
  }
  return board;
  }
}
