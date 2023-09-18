package com.hja.p1;

import java.util.*;

public class Hand implements Comparable<Hand>{
    ArrayList<Card> handList = new ArrayList<>();
    private static final int NCARDS = 5;
    private String handString;
    private int handValue;
    
    public Hand(String hand){
        for(int i=0; i< NCARDS *2; i=i+2){
            handList.add(createCard(hand.charAt(i)+"", hand.charAt(i+1)+""));
        }
        Collections.sort(handList);
        Pair<String, Integer> a = readHand(); 
        handString = a.getElement0();
        handValue = a.getElement1();
    }
    
    public Card createCard(String number, String suit){
        return new Card(number, suit); 
    }
    
    public Pair<String,Integer> readHand(){
        
        //Se calcula todas las posibilidades de un solo recorrido, se puede hacer más eficiente¿?
        int pair = 0, three = 0, poker = 0, escaleraReal = handList.get(0).getNumber(); boolean lastPair = false, lastThree = false, straight =true, color = true;
        for (int i = 1; i < handList.size(); i++) {
            if(color && !handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-1).getSuit())) color = false;
            if(handList.get(i).getNumber() == handList.get(i-1).getNumber()){
                if(!lastPair && !lastThree){
                    pair += 1;
                    lastPair = true;
                }else if(lastPair){
                    three += 1;
                    pair -= 1;
                    lastPair = false;
                    lastThree = true;
                }else if(lastThree){
                    poker += 1; 
                    return new Pair("poker", 8); //3
                }         
            }
            else {
                if(straight) {
                    if(handList.get(i).getNumber()-1 == handList.get(i-1).getNumber()) escaleraReal += handList.get(i).getNumber();
                    else straight = false; 
                }
                lastPair = false;
                lastThree = false;
            }    
        }
        if(straight && color){
            if(escaleraReal == 60) return new Pair("Royal flush", 10); //1
            else return new Pair("Straight flush", 9); //2
        }
        else if(pair == 1 && three == 1) return new Pair("Full house", 7); //4
        else if(color) return new Pair("Flush", 6); //5
        else if(straight) return new Pair("Straight", 5); //6
        else if(pair == 0 && three == 1) return new Pair("Three of a kind", 3); //7
        else if(pair >= 1 && three == 0) return new Pair(pair + " pair", 2); //8 y 9
    
        return new Pair("High Card: "+handList.get(NCARDS-1),1);//10
        
    }
    
    @Override
    public String toString(){
       return handList.toString();
    }

    @Override
    public int compareTo(Hand o) {
        if(this.handValue > o.handValue) return 1;
        else if(this.handValue < o.handValue) return -1;
        else{
            int tValue;
            int oValue;
            for(int i = NCARDS; i >= 0; i--){
                tValue = handList.get(i).getNumber();
                oValue = o.handList.get(i).getNumber();
                if(tValue != oValue){
                    if(tValue > oValue)return 1;
                    else return -1;
                }
            }
            return 0;
        }
    }
}
