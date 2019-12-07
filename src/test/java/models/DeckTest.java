package models;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class DeckTest {
    @Test
    public void testDeckCreate(){
        Deck d = new Deck();
        assertNotNull(d);
    }

    @Test
    public void testDeckFilled(){

        Deck d = new Deck();

        d.buildDeck();
        assertEquals(52,d.deckarray.size());
    }

    @Test
    public void testDeckShuffled(){
        Deck deck1 = new Deck();
        deck1.buildDeck();
        deck1.shuffle();
        Deck deck2 = new Deck();
        deck2.buildDeck();
        deck2.shuffle();
        for(int i = 2; i < 15; i++){
            assertFalse( Arrays.equals(deck1.deckarray.toArray(),deck2.deckarray.toArray()));
        }
    }

    @Test
    public void testDeckNotCreated(){

        Deck d = new Deck();
        assertEquals(0,d.deckarray.size());
    }
}