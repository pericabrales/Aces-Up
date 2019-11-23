package models;

import java.util.ArrayList;

public class Column {
    public java.util.List<Card> col = new ArrayList<Card>();

    public Column(){

    }

    public boolean removeCard() {
        if(columnHasCards()) {
            this.col.remove(this.col.size() - 1);
            return true;
        }
        else {


            return false;
        }
    }

    public boolean columnHasCards() {
        if(this.col.size()>0){
            return true;
        } else {
            return false;
        }
    }

    public Card getTopCard() {
        return this.col.get(this.col.size()-1);
    }

    public void addCardToCol(Card cardToMove) {
        col.add(cardToMove);
    }

    /*public java.util.List<Card> stack = new ArrayList<Card>();

    public Stack(){
        //don't really have to construct anything here
    }

    public int getNumCards(){
        return this.stack.size();
    }

    public void addCard(Card c){
        this.stack.add(c);
    }

    public void removeTopCard(){
        this.stack.remove(getNumCards()-1);
    }

    public Card cardFromTop(){
        return this.stack.get(getNumCards()-1);
    }*/
}
