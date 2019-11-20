package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public java.util.List<Card> deckarray = new ArrayList<Card>();
    public int deckSize = 0;

    public Deck(){
    }
    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deckarray.add(new Card(i,Suit.Clubs));
            deckarray.add(new Card(i,Suit.Hearts));
            deckarray.add(new Card(i,Suit.Diamonds));
            deckarray.add(new Card(i,Suit.Spades));
        }
        deckSize = 52;
    }
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deckarray, new Random(seed));
    }

    public int get_size_deck(){
       return this.deckSize;
    }
    public Card getTopCard() {
        Card temp = this.deckarray.get(10);
        this.deckarray.remove(10);
        deckSize--;
        return temp;
    }
 
}
