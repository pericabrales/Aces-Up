package models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.Collections;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS)
public class Deck {
    /*initialize deck with array of cards*/

    public java.util.List<Card> cards = new ArrayList<Card>();
    int points;

    public Deck() {
        points = 0;
    }
    public void buildDeck() {
        for(int i=2; i<15; i++) {
            cards.add(new Card(i, Suit.Hearts));
            cards.add(new Card(i, Suit.Clubs));
            cards.add(new Card(i, Suit.Spades));
            cards.add(new Card(i, Suit.Diamonds));
        }
    }
    //public abstract boolean isSpanishDeck();

    /*same as shuffle function in Game.java*/
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean hasCards(){ return !this.cards.isEmpty();}

    public int size() {
        return this.cards.size();
    }

    public Card get(int i) {
        return this.cards.get(i);
    }

    public void remove(int i){
        this.cards.remove(i);
    }


}