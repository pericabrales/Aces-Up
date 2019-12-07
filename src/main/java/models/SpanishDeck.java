package models;

import java.util.ArrayList;

public class SpanishDeck extends Deck {

    public SpanishDeck() {
        //The real initializer is setupDeck below.
    }

    public void buildDeck() {
        for (int i = 1; i < 13; i++) {
            deckarray.add(new Card(i, Suit.Bastos));
            deckarray.add(new Card(i, Suit.Oros));
            deckarray.add(new Card(i, Suit.Copas));
            deckarray.add(new Card(i, Suit.Espadas));
        }
        deckarray.add(new Card(0, Suit.Joker));
        deckarray.add(new Card(0, Suit.Joker));
    }
}