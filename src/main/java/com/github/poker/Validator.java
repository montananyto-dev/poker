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
            System.out.println("Enter the name of the player");
            input = scan.nextLine();
            nameInUse=playerExists(input, currentPlayers);

            if(nameInUse) { System.out.println("Name is already used."); }

        } while(nameInUse);

        return input;
    }

    public static int reqNumber(String message, int min,int max) {
        boolean isNumber = false;
        boolean aboveLimit = true;
        boolean belowLimit = true;
        String input;
        int amount=0;

        while(!isNumber || aboveLimit || belowLimit)  {
            System.out.println(message);
            input = scan.nextLine();
            isNumber = isNumeric(input);

            if(isNumber) {
                amount = Integer.parseInt(input);
                aboveLimit = amount > max;
                belowLimit = amount < min;

                if(aboveLimit) { System.out.println("Above maximum. Enter a number between "+min+ " and "+max); }
                if(belowLimit) { System.out.println("Below minimum. Enter a number between "+min+ " and "+max); }
            } else {
                System.out.println("Not a number.");
            }
        }

        return amount;
    }

    public static Action returnAction() {
        String input;

        while(true) {
            System.out.println("Check, Raise or Fold? [C,R,F]");

            input = scan.nextLine();
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
