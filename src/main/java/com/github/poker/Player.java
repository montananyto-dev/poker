package com.github.poker;

import java.util.ArrayList;

public class Player implements CardHolder {

private String name;
private int age;
private ArrayList<Card> hand;
private int chips;

public Player (String name, int age,int chips){
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<Card>();
        this.chips = chips;

        //Initial hand
        Deck.getInstance().giveCard(this,2);

        System.out.println("I have...");
        for(int i=0; i<2; i++) {
                System.out.println(hand.get(i));
        }
}

public void receiveCard(Card newCard) {
        hand.add(newCard);
}

public void setName(String name){
        this.name = name;
}

public String getName(){
        return name;
}

public void setAge(int age){
        this.age = age;
}

public int getAge(){
        return age;
}

public void setHand(ArrayList<Card> hand){
        this.hand = hand;
}

public ArrayList<Card> getHand(){
        return hand;
}
public void setChips(int chips){
        this.chips = chips;
}
public int getChips(){
        return chips;
}

public void printHand() {
        for(Card aCard : hand)
                System.out.print(aCard + "\n");
}
public void placeBet(int amount){
        chips-= amount;
        Board.getInstance().setPot(amount);
        System.out.println("this is what you just bet " + amount);
        //What happen if the player doesn't have enough chips for the small or big blind

}


}
