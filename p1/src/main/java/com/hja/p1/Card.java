package com.hja.p1;

public class Card implements Comparable<Card>{
    
    private final int number;
    private final String suit;
    
    
    public Card(String num, String suit){
        //Opcion A -> En el peor de los casos (A) O(5)
        switch(num){
            case "T":
                number = 10;
                break;
            case "J":
                number = 11;
                break;
            case "Q":
                number = 12;
                break;
            case "K":
                number = 13;
                break;
            case "A":
                number = 14;
                break;
            default:
                number = Integer.parseInt(num);   
        }
       /*Opcion B En el peor de los casos (A) O(12) 
        String valueOrder = "23456789TJQKA";
        number = valueOrder.indexOf(num)+2;
        */
        this.suit = suit;
    }
    
    public int getNumber(){
        return number;
    }
    public String getSuit(){
        return suit;
    }

    @Override
    public int compareTo(Card other) {        
        if(number > other.getNumber()){
            return 1;
        }
        else if (number < other.getNumber()){
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString(){
        String valueOrder = "TJQKA";
        if(number < 10){
            return number+suit+"";
        }
        return valueOrder.charAt(number%10)+suit+""; 
    }
    
}
