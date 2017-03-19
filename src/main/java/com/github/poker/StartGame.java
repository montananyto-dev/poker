package com.github.poker;

public class StartGame
{
    public static void main(String[] args)
    {
        System.out.println("Starting Game...");

        Dealer dealer = new Dealer("Dealer");


        System.out.println("How many players ?")
        Scanner scan = new Scanner(System.in);
        int numOfPlayer = scan.nextInt();


        //Dealer.getInstance().setPlayer()





    }
}
