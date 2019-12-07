package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class SpanishDeckTest{

    @Test
    public void testSpanishDeckSize(){
        Deck d = new SpanishDeck();
        d.buildDeck();
        assertEquals(50,d.size());
    }

    @Test
    public void testSpanishDeckShuffled() {
        Deck deck1 = new SpanishDeck();
        deck1.buildDeck();
        deck1.shuffle();
        Deck deck2 = new Deck();
        deck2.buildDeck();
        for (int i = 2; i < 15; i++) {
            assertFalse(Arrays.equals(deck1.deckarray.toArray(), deck2.deckarray.toArray()));
        }
    }
}