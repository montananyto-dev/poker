package com.github.poker;

public class StartGame
{
    public static void main(String[] args)
    {
        System.out.println("Starting Game...");

        //Create a new instance of Board
        Board board = Board.getInstance();

        Player player = new Player("tony",18);

        Deck.getInstance().displayAllCards();




    }
}
