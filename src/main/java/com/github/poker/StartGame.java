package com.github.poker;

import java.util.Scanner;
import java.util.ArrayList;


public class StartGame
{
    public static void main(String[] args)
    {
        System.out.println("Starting Game...");

        Dealer dealer = Dealer.getInstance();
        dealer.setName("dealer");

        Board board = Board.getInstance();


        System.out.println("How many players ?");
        Scanner scan = new Scanner(System.in);
        int numOfPlayer = scan.nextInt();

        Player player = new Player ("tony",18);

        ArrayList<Card> currentPlayerHand = new ArrayList<Card>();
        currentPlayerHand = player.getHand();

    }
}
