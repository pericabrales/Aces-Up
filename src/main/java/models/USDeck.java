package models;

public class USDeck extends Deck {

    public USDeck() {

    }

    public void buildDeck() {
        for(int i=2; i<15; i++) {
            cards.add(new Card(i, Suit.Diamonds));
            cards.add(new Card(i, Suit.Spades));
            cards.add(new Card(i, Suit.Hearts));
            cards.add(new Card(i, Suit.Clubs));
        }
    }
}
