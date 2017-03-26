package com.github.poker;

import java.util.Scanner;
import java.util.ArrayList;


public class StartGame
{
static int chips;
static ArrayList<Player> players;
static Scanner scan;
static int Chips;
static Dealer dealer;

public static void main(String[] args)
{
        System.out.println("Starting Game...");

        dealer = Dealer.getInstance();
        dealer.setName("Dealer");

        Board board = Board.getInstance();

        scan = new Scanner(System.in);

        players = new ArrayList<Player>();

        int numberOfPlayers = reqPlayerNumber();

        int chips = reqChips();

        do {
                String name = reqPlayerName();
                int age = reqPlayerAge();
                Player player = new Player(name,age,chips);
                players.add(player);
                setPlayers();
                numberOfPlayers--;

        } while ( numberOfPlayers > 0 );


}

private static int reqPlayerNumber() {
        boolean isNumber = false;
        boolean aboveLimit = true;
        String input;
        int amount=0;
        do {
                System.out.println("How many Players (max. 5)");
                input = scan.nextLine();

                isNumber = isNumeric(input);
                if(isNumber) {
                        amount = Integer.parseInt(input);
                        aboveLimit = amount > 5;
                        if(aboveLimit) { System.out.println("Above maximum."); }
                } else { System.out.println("Not a number."); }

        } while(!isNumber || aboveLimit);

        return amount;
}

private static int reqChips(){
        System.out.println("How much do you want to give to each player");
        chips = scan.nextInt();
        scan.nextLine();

        return chips;
}

private static void setPlayers(){
        dealer.setPlayers(players);
}

private static String reqPlayerName() {
        boolean nameInUse = true;
        String input;
        do {
                System.out.println("Name of the player");
                input = scan.nextLine();
                nameInUse=playerExists(input);
                if(nameInUse) { System.out.println("Name is already used."); }
        } while(nameInUse);

        return input;
}

private static int reqPlayerAge() {
        int age = 0;
        boolean tooYoung = true;
        boolean isNumber = false;
        String input;
        do {
                System.out.println("Age of the player");
                input = scan.nextLine();

                isNumber = isNumeric(input);
                if(isNumber)  {
                        age = Integer.parseInt(input);
                        tooYoung = age < 18;
                        if(tooYoung) { System.out.println("Too young."); }
                } else { System.out.println("Not a number."); }

        } while(tooYoung || !isNumber);

        return age;
}
private static boolean isNumeric(String input) {
        try {
                Integer.parseInt(input);
        } catch (NumberFormatException e) {
                return false;
        }
        return true;
}
private static boolean playerExists(String newName) {
        for(Player aPlayer : players)
                if(aPlayer.getName().equals(newName))
                        return true;

        return false;
}

}
