package models;

import com.google.inject.internal.cglib.proxy.$Factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    //public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    int playerScore = 0;
    boolean startGame = true;
    public int deckType;

    public Deck deck;
    //public java.util.List<Column> cols = new ArrayList<>();
    boolean lastAttemptValid = true;

    public Game(){
        // initialize a new game such that each column can store cards
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        makeGame();
    }

    public void makeGame(){
        if(deckType == 0) { //0 is regular
            deck = new USDeck();
            ((USDeck)deck).buildDeck();
        }else if(deckType == 1){ //1 is Spanish
            deck = new SpanishDeck();
            ((SpanishDeck)deck).buildDeck();
            ((SpanishDeck)deck).shuffle();
        }
    }

    public void setupGame (String version) {
        if(version.equals("normal") || version.equals("")) {
            deck = new USDeck();
        }
        else if (version.equals("spanish")) {
            deck = new SpanishDeck();
        }
        deck.buildDeck();
    }

    public void dealFour() {
        //if(startGame == true) {
        for (int i = 0; i < 4; i++) {
            //if(deck.size() > 0){
            cols.get(i).add(deck.get(deck.size() - 1));
            deck.remove(deck.size() - 1);
            //}
        }
    }

    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).add(deck.get(c1));
        deck.remove(c1);
        cols.get(1).add(deck.get(c2));
        deck.remove(c2);
        cols.get(2).add(deck.get(c3));
        deck.remove(c3);
        cols.get(3).add(deck.get(c4));
        deck.remove(c4);
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

    private boolean columnHasCards(int columnNumber) {
        if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    public int getTopCardValue(int colNumber) {
        return this.getTopCard(colNumber).getValue();
    }

    public Suit getTopCardSuit(int colNumber) {
        return this.getTopCard(colNumber).getSuit();
    }

    public boolean colHasCards(int colNumber) {
        return !cols.get(colNumber).isEmpty();
    }


    //CODE TAKEN FROM GIVEN SPRINT 2 CODE
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        lastAttemptValid = false;
        if(cols.get(columnTo).isEmpty()) {
            Card cardToMove = getTopCard(columnFrom);
           // if(cardToMove.getValue() == 14) {
                this.removeCardFromCol(columnFrom);
                this.addCardToCol(columnTo, cardToMove);
                lastAttemptValid = true;
           // }
        }
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public boolean canRemove(int index) {
        Card card = this.getTopCard(index);
        for (int i = 0; i < 4; i++) {
            if (columnHasCards(i)) {
                Card toCompare = getTopCard(i);
                if (toCompare.getValue() > card.getValue() && toCompare.getSuit() == card.getSuit()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int canMove() {
        int emptyIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (!this.columnHasCards(i)) {
                emptyIndex = i;
            }
        }
        return emptyIndex;
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

    public void switchDeck() {
        if (this.deckType == 0) {
            this.deckType = 1;
        } else if (this.deckType == 1) {
            this.deckType = 0;
        }

        //reset other variables
        this.makeGame();
        this.dealFour();
    }

}
