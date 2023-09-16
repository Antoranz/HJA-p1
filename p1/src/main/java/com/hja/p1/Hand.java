/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hja.p1;

import java.util.*;
/**
 *
 * @author usuario_local
 */
public class Hand {
    private Set<Card> handSet = new HashSet<Card>();
    private static final int NCARDS = 5;
    
    public Hand(String hand){
        for(int i=0; i< NCARDS; i=i+2){
            handSet.add(createCard(hand.charAt(i)+"", hand.charAt(i+1)+""));
        }
    }
    
    public Card createCard(String number, String suit){
        return new Card(number, suit); 
    }
    
    public String readHand(){        
        return "pair";
    }
    
    @Override
    public String toString(){
       return handSet.toString();
    }
}
