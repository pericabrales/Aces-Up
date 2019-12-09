package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class CardTest {

        @Test
        public void testGetSuit() {
            Card c = new Card(5, Suit.Clubs);
            assertEquals(Suit.Clubs, c.getSuit());
        }

        @Test
        public void testToString() {
            Card c = new Card(5, Suit.Clubs);
            assertEquals("5Clubs", c.toString());
        }

        //test if wrong value thats not in the type
        @Test
        public void testWrongValue() {
            Card c = new Card(15, Suit.Hearts);
            assertNotEquals("AHearts", c.toString());
        }
}