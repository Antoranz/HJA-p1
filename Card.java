/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hja.p1;

/**
 *
 * @author usuario_local
 */
public class Card {
    public final String id;
    
    
    public Card(String card){
        id = card;
    }
    public Card(char num, char suit){
        id = num + "" + suit;
    }
    
    public char getNumber(){
        return id.charAt(0);
    }
    public char getSuit(){
        return id.charAt(1);
    }
}
