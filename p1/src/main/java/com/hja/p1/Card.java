package com.hja.p1;

public class Card implements Comparable<Card>{
    private final String id;
    
    public Card(String card){
        id = card;
    }
    
    public Card(String num, String suit){
        id = num + "" + suit;
    }
    
    public char getNumber(){
        return id.charAt(0);
    }
    public char getSuit(){
        return id.charAt(1);
    }

    @Override
    public int compareTo(Card a) {
        String valueOrder = "23456789TJQKA";
                
        int aValue = valueOrder.indexOf(a.getNumber());
        int bValue = valueOrder.indexOf(this.getNumber());
        if(bValue > aValue){
            return 1;
        }
        else if (bValue < aValue){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    @Override
    public String toString(){
        return id;
    }
    
}
