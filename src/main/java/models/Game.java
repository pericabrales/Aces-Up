package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    //public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    int playerScore = 0;
    public Deck deck;
    //public java.util.List<Column> cols = new ArrayList<>();
    boolean lastAttemptValid = true;

    public Game(){
        // initialize a new game such that each column can store cards
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

    public void makeGame(){
        deck = new Deck();
        deck.buildDeck();
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++){
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        lastAttemptValid = false;
        if(cols.get(columnNumber).isEmpty()){
          System.out.println("INVALID: Column has no cards to remove");

          return;
        }
        //make sure there are more cards with the same suit
        if(moreCardsSameSuit(columnNumber)){
            //if there are more cards of the same suit, check to make sure it is the smallest card out of them
            if(smallestCard(columnNumber)){
                //since it is the smallest card out of all the top cards, and there are more cards with its suit, let it be removed
                int size = cols.get(columnNumber).size();
                cols.get(columnNumber).remove(size-1);
                deck.points++;
                lastAttemptValid = true;
            }
        }
    }

    public void move(int columnFrom, int columnTo) {
        if (cols.get(columnFrom).columnHasCards()) {
            Card cardToMove = cols.get(columnFrom).getTopCard();
            if (!cols.get(columnTo).columnHasCards() && cardToMove.getValue() == 14 && cols.get(columnFrom).columnHasCards()) { //check that moving to empty column. Will need to change this line a bit when refactor
                cols.get(columnFrom).removeCard();
                cols.get(columnTo).addCardToCol(cardToMove);
            }
        }
    }*/


    private boolean columnHasCards(int columnNumber) {
        if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    //CODE TAKEN FROM GIVEN SPRINT 2 CODE
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        lastAttemptValid = false;
        if(cols.get(columnTo).isEmpty()) {
            Card cardToMove = getTopCard(columnFrom);
            if(cardToMove.getValue() == 14) {
                this.removeCardFromCol(columnFrom);
                this.addCardToCol(columnTo, cardToMove);
                lastAttemptValid = true;
            }
        }
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }


    //this function will check if there are more cards of the same suit of the card chosen
    public boolean moreCardsSameSuit(int colNum){
        //trying to get the suit of the card at the given column number
        Card currCard = getTopCard(colNum);
        String suit = currCard.getSuit().toString();

        int sameSuit = 0;

        //loop through the columns to make sure there is more than one card with this suit
        for(int i = 0; i < cols.size(); i++){

            if(cols.get(i).isEmpty() == false){
                Card loopCard = getTopCard(i);
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
        Card currCard = getTopCard(colNum);
        String suit = currCard.getSuit().toString();

        //get value of given card
        int val = currCard.getValue();
        //System.out.println("current value is: " + val);

        //loop through the columns to see if the card is smaller than any other cards with its suit
        for(int i = 0; i < cols.size(); i++){

            if(cols.get(i).isEmpty() == false) {
                Card loopCard = getTopCard(i);
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
        return deck.points;
    }

    public boolean getLastAttemptValid(){
        return lastAttemptValid;
    }

}
