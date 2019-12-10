package models;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeckTest {
    @Test
    public void testDeckCreation(){
        Deck d = new EngDeck();
        assertNotNull(d);
    }

    @Test
    public void testDeckSize(){
        Deck d = new EngDeck();
        assertEquals(d.size(),d.deckarray.size());
    }

    @Test
    public void testBuildDeck(){
        Deck d = new EngDeck();
        ((EngDeck) d).fillDeck();
        assertEquals(52,d.size());
    }

    @Test
    public void testDeckShuffle(){
        Deck deck1 = new EngDeck();
        ((EngDeck) deck1).fillDeck();
        deck1.shuffle();
        Deck deck2 = new EngDeck();
        ((EngDeck) deck2).fillDeck();
        deck2.shuffle();
        for(int i = 2; i < 15; i++){
            assertFalse( Arrays.equals(deck1.deckarray.toArray(),deck2.deckarray.toArray()));
        }
    }

    @Test
    public void testRemoveDeck(){
        Deck d = new EngDeck();
        ((EngDeck) d).fillDeck();
        assertEquals(52,d.size());
        d.remove(51);
        assertEquals(51,d.size());
    }
}