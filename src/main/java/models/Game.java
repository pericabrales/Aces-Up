package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        //for(int i=0; i<4; i++){
          //  cols.add(new ArrayList<Card>());
        //}
        //create the deck
        //buildDeck();
        //System.out.println("Created the deck");
        //shuffle all cards in the deck
        //shuffle();
        //put 4 cards in the column arraylist
        //dealFour();
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
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
        Collections.shuffle(deck);
        // System.out.println("Results after shuffle operation:");
//        for(Card str: deck){
//            System.out.println(str);
//        }
        // shuffles the deck so that it is random
    }

    // check if there are cards in the deck

    public boolean deckHasCards(){
        return (!this.deck.isEmpty());
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        int deckSize = deck.size()-1;
        for(int i=0; i<4; i++){
            //check if the deck is empty
            if(deckHasCards()){
                cols.get(i).add(deck.get(deck.size()-1));
                deck.remove(deck.size()-1);
            }
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if(cols.get(columnNumber).isEmpty()){
          System.out.println("INVALID: Column has no cards to remove");
          return;
        }
        int size = cols.get(columnNumber).size();
        cols.get(columnNumber).remove(size-1);
    }

    private boolean columnHasCards(int columnNumber) {
        if(cols.get(columnNumber).isEmpty()) {
            System.out.println("This column is empty, a card can be moved here");
            return true;
        }
        else {
            System.out.println("This column is not empty, a card can not be moved here");
            return false;
        }
    }

    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }

    public void deleteTopCard(int colNum){
        //make sure there are more cards with the same suit
        if(moreCardsSameSuit(colNum)){
            //if there are more cards of the same suit, check to make sure it is the smallest card out of them
            if(smallestCard(colNum)){
                //since it is the smallest card out of all the top cards, and there are more cards with its suit, let it be removed
                remove(colNum);
            }
        }
    }

    //this function will check if there are more cards of the same suit of the card chosen
    public boolean moreCardsSameSuit(int colNum){
        //trying to get the suit of the card at the given column number
        //not sure if this is how you do it, but it got mad at me when I tried to do one less .get()
        Card currCard = getTopCard(colNum);
        String suit = currCard.getSuit().toString();

        int sameSuit = 0;

        //loop through the columns to make sure there is more than one card with this suit
        for(int i = 0; i < cols.size(); i++){
            Card loopCard = getTopCard(i);
            String currSuit = loopCard.getSuit().toString();

            //if there are more cards with the same suit, then add to the counter
            if(currSuit == suit){
                sameSuit++;
            }
        }
        //if there are more than one card with the suit, return true
        //also couts the card that we gave it
        if(sameSuit > 1){
            return true;
        }

        //no other cards with the same suit
        return false;
    }

    //check if given column number houses the smallest card
    public boolean smallestCard (int colNum){
        //get the suit from the card in the given column
        Card currCard = getTopCard(colNum);
        String suit = currCard.getSuit().toString();

        //get value of given card
        int val = currCard.getValue();

        //loop through the columns to see if the card is smaller than any other cards with its suit
        for(int i = 0; i < cols.size(); i++){
            Card loopCard = getTopCard(i);
            String currSuit = loopCard.getSuit().toString();
            int currVal = loopCard.getValue();

            //if the card has the name suit and its value is bigger, return true
            //able to discard given card
            if(currSuit == suit && val < currVal){
                return true;
            }
        }

        //this card is the biggest card out of the cards on the top of the column
        return false;
    }

}
