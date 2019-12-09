package models;

import java.util.ArrayList;

public class EngDeck extends Deck {
    public EngDeck(){

    }

    public void fillDeck(){
        for(int i = 2; i < 15; i++){
            deckarray.add(new Card(i,Suit.Clubs));
            deckarray.add(new Card(i,Suit.Hearts));
            deckarray.add(new Card(i,Suit.Diamonds));
            deckarray.add(new Card(i,Suit.Spades));
        }
    }
}
