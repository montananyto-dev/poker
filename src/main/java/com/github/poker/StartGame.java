package com.github.poker;

import java.util.ArrayList;

public class StartGame {

    public static void main(String[] args) {

        System.out.println("Starting Game...");

        ArrayList<Player> players = new ArrayList<Player>();

        int numberOfPlayers = Validator.reqNumber("How many Players (min. 2 and max. 5)", 2, 5);

        int chips = Validator.reqNumber("How many chips per player (min. 50 and max. 2000)",50,2000);

        int smallBlind = Validator.reqNumber("Enter the small Blind (min.20 and max. 50)",20,50);

        do {
            String name = Validator.reqPlayerName(players);
            players.add(new Player(name));

        } while ( players.size()<numberOfPlayers );

        Dealer.getInstance().setName("Dealer")
            .setPlayers(players,chips)
            .setSmallBlind(smallBlind)
            .setBoardInstance(Board.getInstance())
            .startSession();
    }

}
