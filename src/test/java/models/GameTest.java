package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game g = new Game();

    Card testCard1 = new Card(2, Suit.Hearts);
    Card testCard2 = new Card(5, Suit.Spades);
    Card testCard3 = new Card(14, Suit.Spades);
    Card testCard4 = new Card(13, Suit.Spades);
    Card spanishCard1 = new Card(2, Suit.Oros);
    Card spanishCard2 = new Card(12, Suit.Espadas);
    Card spanishCard3 = new Card(13, Suit.Espadas);
    Card joker = new Card(0, Suit.Joker);

    @Test
    public void testCanRemove() {
        g.addCardToCol(1, testCard1);
        g.addCardToCol(2, testCard2);
        g.addCardToCol(3, testCard3);
        assertEquals(false, g.canRemove(1));
        assertEquals(true, g.canRemove(2));
        assertEquals(false, g.canRemove(3));
    }

    @Test
    public void testMove() {
        g.addCardToCol(1, testCard1);
        g.move(1, 2);
        assertEquals(false, g.colHasCards(1));
        assertEquals(2, g.getTopCardValue(2));
        assertEquals(Suit.Hearts, g.getTopCardSuit(2));
    }

    @Test
    public void testGameCreation() {
        g.setupGame("normal");
        assertNotNull(g);
    }

    @Test
    public void testGameStart() {
        g.setupGame("normal");

        g.deck.shuffle();
        g.dealFour();
    }

}