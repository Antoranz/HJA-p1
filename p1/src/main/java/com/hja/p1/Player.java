package com.hja.p1;

import java.util.ArrayList;
import java.util.List;


public class Player implements Comparable<Player>{
    
    public static int N_PLAYERS = 0;
    protected ArrayList<Card> playerCards = new ArrayList<>();
    protected ArrayList<Card> boardCards = new ArrayList<>();
    
    private String id;  //J1, J2 ...
    protected Hand bestHand = new Hand();

    public Player(String id){
        this.id = id;
        this.N_PLAYERS++;
    }
    public ArrayList<Card> getPlayerCards(){
        return playerCards;
    }
    public void addBoardCard(Card c){
        boardCards.add(c);
    }
    public void addCard(Card c){
        playerCards.add(c);
    }
    public void bestHand(){
        double bestValue = -1;
        ArrayList<Card> allCards = new ArrayList<>();
        allCards.addAll(boardCards);
        allCards.addAll(playerCards);
        
        int n = allCards.size()-1;
        int k = 5;
        
        Combinations comb = new Combinations();
        List<List<Card>> combinations = comb.combine(n, k, allCards); //Combinaciones
        for (List<Card> c : combinations) {
            Hand currentHand = new Hand (c); 

            if (currentHand.compareTo(bestHand) == 1)
                bestHand = currentHand;
        }            
    }

    @Override
    public int compareTo(Player other){
        if(this.bestHand.compareTo(other.getBestHand()) == 1) return -1;
        else if (this.bestHand.compareTo(other.getBestHand()) == -1) return 1;
        else return 0;
    }

    @Override
    public String toString(){
        return "Player " + this.id + " " + this.bestHand.toString();
    }

    public Hand getBestHand(){
        return bestHand;
    }
}