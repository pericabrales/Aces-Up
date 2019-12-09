package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class SpanishDeckTest{

    Deck deck = new SpanDeck();

    @Test
    public void testDeckSize(){
        ((SpanDeck)deck).fillDeck();
        assertEquals(50,deck.size());
    }

    @Test
    public void testShuffleAndGet() {
        ((SpanDeck)deck).fillDeck();
        deck.shuffle();

        Card currCard = new Card (4, Suit.Oros);
        String CC = currCard.toString();

        String beforeC = "";
        String afterC = "";

        for(int i = 0; i < 50; i++){
            Card loopC = deck.get(i);
            String lC = loopC.toString();

            if(loopC.equals(CC)){
                Card b = deck.get(i-1);
                Card a = deck.get(i+1);

                beforeC = b.toString();
                afterC = a.toString();
            }
        }

        String isShuffled = "";

        if(!beforeC.equals("3Oros") || !afterC.equals("5Oros")){
            isShuffled = "true";
        }
        else if(beforeC.equals("3Oros") && afterC.equals("5Oros")){
            isShuffled = "false";
        }

        assertEquals("true", isShuffled);
    }

    @Test
    public void testRemove(){
        ((SpanDeck)deck).fillDeck();
        deck.remove(deck.size()-1);

        assertEquals(49, deck.size());
    }
}