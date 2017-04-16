package com.github.poker;

import java.util.ArrayList;


public class StartGame {

        public static void main(String[] args) {
                System.out.println("Starting Game...");

                ArrayList<Player> players = new ArrayList<Player>();

                int numberOfPlayers = Validator.reqNumber("How many Players (max. 5)", 5, 1);

                int chips = Validator.reqNumber("How many chips per player", 2000, 50);

                do {
                        String name = Validator.reqPlayerName(players);
                        players.add(new Player(name));

                } while ( players.size()<numberOfPlayers );

                Dealer.getInstance().setName("Dealer")
                                    .setPlayers(players,chips)
                                    .startSession();
        }

}
