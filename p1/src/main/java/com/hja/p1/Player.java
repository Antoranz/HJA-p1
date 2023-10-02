package com.hja.p1;

import java.util.ArrayList;
import java.util.List;


public class Player implements Comparable<Player>{

    private static int N_PLAYERS = 0;
    public ArrayList<Card> playerCards = new ArrayList<>();

    private String id;  //J1, J2 ...
    private Hand bestHand;

    public Player(String id){
        this.id = id;
        this.N_PLAYERS++;
    }

    public void bestHand(){
        double bestValue = -1;
        
        int n = playerCards.size()-1;
        int k = 5;

        Combinations comb = new Combinations();
        List<List<Card>> combinations = comb.combine(n, k, playerCards); //Combinaciones
        for (List<Card> c : combinations) {
            Hand currentHand = new Hand (c.toString());

            if (currentHand.compareTo(bestHand) == 1)
                bestHand = currentHand;
        }
    }

    public static int get_NPlayers(){
        return this.N_PLAYERS;
    }

    @Override
    public int compareTo(Player other){
        if(bestHand.compareTo(other.getBestHand()) == 1) return 1;
        else if (bestHand.compareTo(other.getBestHand()) == -1) return -1;
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