package models;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testGameCreation(){
        Game testG = new Game();
        assertNotNull(testG);
        assertEquals(4, testG.cols.size());
    }

    @Test
    public void testMakeGame(){
        Game testG = new Game();
        testG.makeGame();
        assertEquals(52, testG.deck.deckarray.size());
    }

    @Test
    public void testDealFour(){
        Game testG = new Game();
        testG.makeGame();
        testG.dealFour();
        assertEquals(48, testG.deck.deckarray.size());
    }

    @Test
    public void testRemove(){
        Game testG = new Game();
        testG.makeGame();
        testG.dealFour();
        assertEquals(1, testG.cols.get(0).size());
        assertEquals(1, testG.cols.get(1).size());
        assertEquals(1, testG.cols.get(2).size());
        assertEquals(1, testG.cols.get(3).size());
        testG.remove(0);
        if(testG.lastAttemptValid == true)
            assertEquals(0, testG.cols.get(0).size());
        testG.remove(1);
        if(testG.lastAttemptValid == true)
            assertEquals(0, testG.cols.get(1).size());
        testG.remove(2);
        if(testG.lastAttemptValid == true)
            assertEquals(0, testG.cols.get(2).size());
        testG.remove(3);
        if(testG.lastAttemptValid == true)
            assertEquals(0, testG.cols.get(3).size());
    }

    @Test
    public void testMove(){
        Game testG = new Game();
        testG.makeGame();
        testG.cols.get(0).add(testG.deck.get(testG.deck.size()-1));
        assertEquals(1, testG.cols.get(0).size());
        assertEquals(0, testG.cols.get(1).size());
        testG.move(0,1);
        assertEquals(0, testG.cols.get(0).size());
        assertEquals(1, testG.cols.get(1).size());
    }

    @Test
    public void testSwitchSpanish(){
        Game testG = new Game();
        testG.makeGame();
        testG.switchSpanish();
        assertEquals(46, testG.deck.deckarray.size());
        assertEquals(1, testG.cols.get(0).size());
        assertEquals(1, testG.cols.get(1).size());
        assertEquals(1, testG.cols.get(2).size());
        assertEquals(1, testG.cols.get(3).size());

    }

    @Test
    public void testSwitchEnglish(){
        Game testG = new Game();
        testG.makeGame();
        testG.switchEnglish();
        assertEquals(48, testG.deck.deckarray.size());
        assertEquals(1, testG.cols.get(0).size());
        assertEquals(1, testG.cols.get(1).size());
        assertEquals(1, testG.cols.get(2).size());
        assertEquals(1, testG.cols.get(3).size());

    }
}
