package models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck {
    @JsonProperty("deckarray")
    public java.util.List<Card> deckarray = new ArrayList<Card>();
    @JsonProperty("deckSize")
    public int deckSize;

    @JsonCreator
    public Deck(@JsonProperty("deckarray") List<Card> deckarray, @JsonProperty("deckSize") int deckSize){
        this.deckarray = deckarray;
        this.deckSize = deckSize;
        System.out.println("Calling special constructor");
    }
    public Deck(){
        System.out.println("I am calling the default construct");
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deckarray.add(new Card(i,Suit.Clubs));
            deckarray.add(new Card(i,Suit.Hearts));
            deckarray.add(new Card(i,Suit.Diamonds));
            deckarray.add(new Card(i,Suit.Spades));
        }
        this.deckSize = 52;

        System.out.println(this.deckSize);
    }
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deckarray, new Random(seed));
    }

    public int get_size_deck(){
       return this.deckSize;
    }
    public Card getTopCard() {
        System.out.println("get top card fn");
        System.out.println(this.deckSize);
        System.out.println(this.getDeckSize());
        Card temp = this.deckarray.get(this.getDeckSize() -1);
        this.deckarray.remove(this.getDeckSize()-1);
        this.deckSize--;
        return temp;
    }

    public int getDeckSize(){
        return this.deckSize;
    }
//    public List<Card> getDeckArray(){
//        return deckarray;
//    }
 
}
