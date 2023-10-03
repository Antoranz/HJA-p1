/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hja.p1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario_local
 */
public class PlayerOklahoma extends Player{
    
    
    public PlayerOklahoma(String id) {
        super(id);
    }
    
    @Override
    public void bestHand(){
        double bestValue = -1;
        
        int nPlayer = playerCards.size()-1;
        int kPlayer = 2;
        
        Combinations combPlayerCards = new Combinations();
        List<List<Card>> combinationsPlayerCards = combPlayerCards.combine(nPlayer, kPlayer, playerCards); //Combinaciones
        
        int nBoard = boardCards.size()-1;
        int kBoard = 3;
        
        Combinations combBoardCards = new Combinations();
        List<List<Card>> combinationsBoardCards = combBoardCards.combine(nBoard, kBoard, boardCards); //Combinaciones
        
        
        for(List<Card> cP: combinationsPlayerCards){
            
            for (List<Card> cB : combinationsBoardCards) {
                
                cB.addAll(cP);
                Hand currentHand = new Hand (cB); 

                if (currentHand.compareTo(bestHand) == 1)
                    bestHand = currentHand;
            }
        }
    }
}
