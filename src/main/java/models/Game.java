package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    int playerScore = 0;
    boolean startGame = true;
    public Deck deck;
    boolean lastAttemptValid = true;

    public Game(){
        // initialize a new game such that each column can store cards
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

    public void makeGame(){
        deck = new EngDeck();
        deck.buildDeck();
    }

    public void dealFour() {
        int limit = 4;
        int tempsize = deck.size();
        if (tempsize < 4){limit = 2;}
        for(int i = 0; i < limit; i++){
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    public void remove(int columnNumber) {
        System.out.println(playerScore);
        boolean hasjoker = false;
        Card temp;
        int joker=-1;
        for(int i =0; i < 4;i++){
            temp = getTopCard(i);
            if(temp.getValue() == 0){
                hasjoker = true;
                joker = i;

            }
        }

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

        if(hasjoker == true){
            int size = cols.get(columnNumber).size();
            cols.get(columnNumber).remove(size-1);
            int jokercolsize = cols.get(joker).size();
            cols.get(joker).remove(jokercolsize-1);

            deck.points++;
            deck.points++;
            lastAttemptValid = true;
        }
    }

    public void clearcols(){
        int tempSize;
        for (int i =0; i < 4;i++){
            //System.out.println("COLUMN " + i + "HAS " + cols.get(i).size() + " CARDS");
            tempSize = cols.get(i).size();
            for (int j =0; j < tempSize;j++){
                //System.out.println("IN COL: " + i + " DELETING CARD : " + j);
                cols.get(i).remove(0);
            }
        }
        //System.out.println("here haha");
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

    public void move(int columnFrom, int columnTo) {
        lastAttemptValid = false;
        if(cols.get(columnTo).isEmpty()) {
            Card cardToMove = getTopCard(columnFrom);

                this.removeCardFromCol(columnFrom);
                this.addCardToCol(columnTo, cardToMove);
                lastAttemptValid = true;

        }
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }

    public boolean moreCardsSameSuit(int colNum){
        Card currCard = getTopCard(colNum);
        String suit = currCard.getSuit().toString();
        int sameSuit = 0;

        for(int i = 0; i < cols.size(); i++){
            if(cols.get(i).isEmpty() == false){
                Card loopCard = getTopCard(i);
                String currSuit = loopCard.getSuit().toString();
                if (currSuit == suit) {
                    sameSuit++;
                }
            }
        }

        if(sameSuit > 1){
            return true;
        }

        return false;
    }

    public boolean smallestCard (int colNum){
        Card currCard = getTopCard(colNum);
        String suit = currCard.getSuit().toString();

        int val = currCard.getValue();

        for(int i = 0; i < cols.size(); i++){
            if(cols.get(i).isEmpty() == false) {
                Card loopCard = getTopCard(i);
                String currSuit = loopCard.getSuit().toString();
                int currVal = loopCard.getValue();
                if (currSuit == suit && val < currVal) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getPlayerScore(){
        return deck.points;
    }

    public boolean getLastAttemptValid(){
        return lastAttemptValid;
    }

    public void switchSpanish() {
        clearcols();
        deck = new SpanDeck();
        ((SpanDeck) deck).fillDeck();
        deck.shuffle();
        dealFour();
        //System.out.println("TO SPANISH");
    }

    public void switchEnglish() {
        clearcols();
        deck = new EngDeck();
        ((EngDeck) deck).fillDeck();
        deck.shuffle();
        dealFour();
        //System.out.println("TO ENGLISH");
    }
}
