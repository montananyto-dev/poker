package com.github.poker;

import java.util.Scanner;
import java.util.ArrayList;

class Validator {

    
    private static Scanner scan = new Scanner(System.in);

    public static boolean playerExists(String newName, ArrayList<Player> currentPlayers) {
        for(Player aPlayer : currentPlayers)
                if(aPlayer.getName().equals(newName))
                        return true;

        return false;
    }

    private static boolean isNumeric(String input) {
        try {
                Integer.parseInt(input);
        } catch (NumberFormatException e) {
                return false;
        }
        return true;
    }

    public static String reqPlayerName(ArrayList<Player> currentPlayers) {
        boolean nameInUse = true;
        String input;
        do {
                System.out.println("Name of the player");
                input = scan.nextLine();
                nameInUse=playerExists(input, currentPlayers);
                if(nameInUse) { System.out.println("Name is already used."); }
        } while(nameInUse);

        return input;
    }

    public static int reqChips(){
        System.out.println("How much do you want to give to each player");
        int chips = scan.nextInt();
        scan.nextLine();

        return chips;
    }

    public static int reqPlayerNumber() {
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

    public static Action reqAction() {
        String input;

        while(true) {
            System.out.println("Check, Raise or Fold? [C,R,F]");

            input = scan.next();
            input = input.toUpperCase();
            switch(input) {
                case "C":
                    return Action.CHECK;
                case "R":
                    return Action.RAISE;
                case "F":
                    return Action.FOLD;
                default:
                    System.out.println("Invalid input.");
            }
        }

    }
}