package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        assertEquals(52,g.deck.cards.size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game();
        g1.deck.shuffle();
        Game g2 = new Game();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.deck.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }

}