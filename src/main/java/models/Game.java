package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
    }

    //Main should be somewhere in here, but not sure if before or after public Game()
    public static void main(String[] args) {

    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
    }

    // Kate added to this function
    private boolean columnHasCards(int columnNumber) {
        if(cols.get(columnNumber).isEmpty()) {
            System.out.println("This column is empty, a card can be moved here")
            return true;
        }
        else {
            System.out.println("This column is not empty, a card can not be moved here")
            return false;
        }
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
