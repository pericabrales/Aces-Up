package models;


public class SpanishDeck extends Deck {

    public SpanishDeck() {
        //The real initializer is setupDeck below.
    }

    public void buildDeck() {
        for (int i = 1; i < 13; i++) {
            cards.add(new Card(i, Suit.Bastos));
            cards.add(new Card(i, Suit.Oros));
            cards.add(new Card(i, Suit.Copas));
            cards.add(new Card(i, Suit.Espadas));
        }
        cards.add(new Card(0, Suit.Joker));
        cards.add(new Card(0, Suit.Joker));
    }

    }