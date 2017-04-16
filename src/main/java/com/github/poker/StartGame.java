package com.github.poker;

import java.util.ArrayList;


public class StartGame {

        public static void main(String[] args) {
                System.out.println("Starting Game...");

                ArrayList<Player> players = new ArrayList<Player>();

                int numberOfPlayers = Validator.reqPlayerNumber();

                int chips = Validator.reqChips();

                do {
                        String name = Validator.reqPlayerName(players);
                        players.add(new Player(name));

                } while ( players.size()<numberOfPlayers );

                Dealer.getInstance().setName("Dealer")
                                    .setPlayers(players,chips)
                                    .startSession();
        }

}
