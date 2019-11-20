package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public java.util.List<Card> deckarray = new ArrayList<Card>();

    public Deck(){
    }
    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deckarray.add(new Card(i,Suit.Clubs));
            deckarray.add(new Card(i,Suit.Hearts));
            deckarray.add(new Card(i,Suit.Diamonds));
            deckarray.add(new Card(i,Suit.Spades));
        }
    }
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deckarray, new Random(seed));
    }

    public int get_size_deck(){
       return this.deckarray.size();
    }
    public Card getTopCard() {
        Card temp = this.deckarray.get(get_size_deck()-1);
        this.deckarray.remove(get_size_deck()-1);
        return temp;
    }
 
}
