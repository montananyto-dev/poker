package com.github.poker;

public class Board{

public static Board board;

public Board(){}

public static Board getInstance(){
  if(board == null){
    board = new Board();
  }
  return board;
  }

}
