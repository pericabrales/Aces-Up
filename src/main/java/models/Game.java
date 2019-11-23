package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    private Deck deck = new Deck();

    public java.util.List<Stack> columns = new ArrayList<Stack>();
    public Stack column1 = new Stack();
    public Stack column2 = new Stack();
    public Stack column3 = new Stack();
    public Stack column4 = new Stack();


    //public java.util.List<Card> deck = new ArrayList<>();

   // public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    int playerScore = 0;
    boolean lastAttemptValid = true;

    public Game(){
        //initializing the columns
        columns.add(column1);
        columns.add(column2);
        columns.add(column3);
        columns.add(column4);
//        for(int i=0; i<4; i++)
//            columns.add(new Stack());


        // initialize a new game such that each column can store cards
//        cols.add(new ArrayList<Card>());
//        cols.add(new ArrayList<Card>());
//        cols.add(new ArrayList<Card>());
//        cols.add(new ArrayList<Card>());
    }

    public void buildDeck() {
        //initializing the deck
        deck.buildDeck();
        deck.shuffle();
//        for(int i = 2; i < 15; i++){
//            deck.add(new Card(i,Suit.Clubs));
//            deck.add(new Card(i,Suit.Hearts));
//            deck.add(new Card(i,Suit.Diamonds));
//            deck.add(new Card(i,Suit.Spades));
//        }
    }

//    public void shuffle() {
//        long seed = System.nanoTime();
//        Collections.shuffle(deck, new Random(seed));
//    }

    // check if there are cards in the deck

//    public boolean deckHasCards(){
//        return (!this.deck.isEmpty());
//    }

    public void dealFour() {
        for(int i = 0; i < 4; i++){
            columns.get(i).addCard(deck.getTopCard());
//            cols.get(i).add(deck.get(deck.size()-1));
//            deck.remove(deck.size()-1);
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        lastAttemptValid = false;
        if(columns.get(columnNumber).getNumCards() == 0){
          System.out.println("INVALID: Column has no cards to remove");

          return;
        }
        //make sure there are more cards with the same suit
        //if(moreCardsSameSuit(columnNumber)){
            //if there are more cards of the same suit, check to make sure it is the smallest card out of them
            if(smallestCard(columnNumber)){
                //since it is the smallest card out of all the top cards, and there are more cards with its suit, let it be removed
                columns.get(columnNumber).removeTopCard();
//                int size = cols.get(columnNumber).size();
//                cols.get(columnNumber).remove(size-1);
                playerScore++;
                lastAttemptValid = true;
            }
        //}
    }

//    private boolean columnHasCards(int columnNumber) {
//        if(this.cols.get(columnNumber).size()>0){
//            return true;
//        }
//        return false;
//    }

//    public Card getTopCard(int columnNumber) {
//        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
//    }


    //CODE TAKEN FROM GIVEN SPRINT 2 CODE
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        lastAttemptValid = false;
        if(columns.get(columnTo).getNumCards() == 0) {
            Card cardToMove = columns.get(columnFrom).cardFromTop();
            if(cardToMove.getValue() == 14) {
                columns.get(columnFrom).removeTopCard();
                columns.get(columnTo).addCard(cardToMove);
//                this.removeCardFromCol(columnFrom);
//                this.addCardToCol(columnTo, cardToMove);
                lastAttemptValid = true;
            }
        }
    }

//    public void addCardToCol(int columnTo, Card cardToMove) {
//        cols.get(columnTo).add(cardToMove);
//    }

//    public void removeCardFromCol(int colFrom) {
//        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
//    }


    //this function will check if there are more cards of the same suit of the card chosen
    public boolean moreCardsSameSuit(int colNum){
        Card tempCard = columns.get(colNum).cardFromTop();
        String suit = tempCard.getSuit().toString();

        //trying to get the suit of the card at the given column number
//        Card currCard = getTopCard(colNum);
//        String suit = currCard.getSuit().toString();

        int sameSuit = 0;

        //loop through the columns to make sure there is more than one card with this suit
        for(int i = 0; i < 4; i++){
            if(columns.get(i).getNumCards() != 0){
                Card loopCard = columns.get(i).cardFromTop();
                String currSuit = loopCard.getSuit().toString();

                //if there are more cards with the same suit, then add to the counter
                if (currSuit == suit) {
                    sameSuit++;
                }
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
        Card currCard = columns.get(colNum).cardFromTop();
        String suit = currCard.getSuit().toString();

        //get value of given card
        int val = currCard.getValue();
        //System.out.println("current value is: " + val);

        //loop through the columns to see if the card is smaller than any other cards with its suit
        for(int i = 0; i < 4; i++){

            if(columns.get(i).getNumCards() != 0) {
                Card loopCard = columns.get(i).cardFromTop();
                String currSuit = loopCard.getSuit().toString();
                int currVal = loopCard.getValue();

                //if the card has the name suit and its value is bigger, return true
                //able to discard given card
                if (currSuit == suit && val < currVal) {
                    return true;
                }
            }
        }

        //this card is the biggest card out of the cards on the top of the column
        return false;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public boolean getLastAttemptValid(){
        return lastAttemptValid;
    }

    public Deck getDeck(){return deck;}

    //@JsonIgnore
    public Stack getColumn1(){return columns.get(0);}
    //public void setColumn1(Stack s){columns.add(0, s);}

    public Stack getColumn2(){return columns.get(1);}
    //public void setColumn2(Stack s){columns.add(1, s);}

    public Stack getColumn3(){return columns.get(2);}
    //public void setColumn3(Stack s){columns.add(2, s);}

    public Stack getColumn4(){return columns.get(3);}
    //public void setColumn4(Stack s){columns.add(3, s);}

    //@JsonIgnore
    //public Stack getColumn2(){return columns.get(1);}
    //@JsonIgnore
    //public Stack getColumn3(){return columns.get(2);}
    //@JsonIgnore
   // public Stack getColumn4(){return columns.get(3);}
}
