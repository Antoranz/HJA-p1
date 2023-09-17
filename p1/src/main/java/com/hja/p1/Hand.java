package com.hja.p1;

import java.util.*;

public class Hand {
    ArrayList<Card> handList = new ArrayList<>();
    private static final int NCARDS = 5;
    
    public Hand(String hand){
        for(int i=0; i< NCARDS *2; i=i+2){
            handList.add(createCard(hand.charAt(i)+"", hand.charAt(i+1)+""));
        }
        Collections.sort(handList);
    }
    
    public Card createCard(String number, String suit){
        return new Card(number, suit); 
    }
    
    public String readHand(){
        
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
                    return "poker"; //3
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
            if(escaleraReal == 60) return "royal flush"; //1
            else return "straight flush"; //2
        }
        else if(pair == 1 && three == 1) return "full"; //4
        else if(color) return "flush"; //5
        else if(straight) return "straight"; //6
        else if(pair == 0 && three == 1) return "three"; //7
        else if(pair >= 1 && three == 0) return pair + " pair"; //8 y 9
    
        return "High Card: "+handList.get(NCARDS-1);//10
        
    }
    
    @Override
    public String toString(){
       return handList.toString();
    }
}
