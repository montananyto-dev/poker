package com.github.poker;

import java.util.ArrayList;


public class StartGame {

        static ArrayList<Player> players;
        static Dealer dealer;

        public static void main(String[] args) {
                System.out.println("Starting Game...");

                dealer = Dealer.getInstance();
                dealer.setName("Dealer");

                Board board = Board.getInstance();

                players = new ArrayList<Player>();

                int numberOfPlayers = Validator.reqPlayerNumber();

                int chips = Validator.reqChips();

                do {
                        String name = Validator.reqPlayerName(players);
                        players.add(new Player(name,chips));
                        numberOfPlayers--;

                } while ( numberOfPlayers > 0 );

                dealer.setPlayers(players);

                dealer.startSession();
        }

}
