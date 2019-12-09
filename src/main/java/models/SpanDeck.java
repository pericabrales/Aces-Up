package models;

public class SpanDeck extends Deck {
    public SpanDeck(){

    }

    public void fillDeck(){
        for (int i = 1; i < 13; i++){
            deckarray.add(new Card(i, Suit.Bastos));
            deckarray.add(new Card(i, Suit.Oros));
            deckarray.add(new Card(i, Suit.Copas));
            deckarray.add(new Card(i, Suit.Espadas));
        }
        deckarray.add(new Card(0, Suit.comodines));
        deckarray.add(new Card(0, Suit.comodines));
    }
}
