package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Stack {

    public java.util.List<Card> stack = new ArrayList<Card>();

    public Stack(){
        //don't really have to construct anything here
    }
    @JsonIgnore
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
    }
}
