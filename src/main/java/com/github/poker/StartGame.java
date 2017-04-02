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
                        int age = Validator.reqPlayerAge();
                        Player player = new Player(name,age,chips);
                        players.add(player);
                        setPlayers();
                        numberOfPlayers--;

                } while ( numberOfPlayers > 0 );
        }

        private static void setPlayers(){
                dealer.setPlayers(players);
        }

}
