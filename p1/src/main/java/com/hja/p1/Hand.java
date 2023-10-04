package com.hja.p1;

import java.util.*;

public class Hand implements Comparable<Hand>{
    ArrayList<Card> handList = new ArrayList<>();
    private static final int NCARDS = 5;
    private String handString;
    private Double handValue;
    private String handDraw;
    
    public Hand(String hand){
        for(int i=0; i< NCARDS *2; i=i+2){
            handList.add(createCard(hand.charAt(i)+"", hand.charAt(i+1)+""));
        }
        Collections.sort(handList);
        Pair<String, Double> a = readHand(); 
        handString = a.getElement0();
        handValue = a.getElement1();
        handDraw = readDraw();
    }
    public Hand(){
        handString = "none";
        handValue = 0.0;
    }
    public Hand(List<Card> c){
        for(int i=0; i< c.size(); i++){
            handList.add(c.get(i));
        }
        Collections.sort(handList);
        Pair<String, Double> a = readHand(); 
        handString = a.getElement0();
        handValue = a.getElement1();
        handDraw = readDraw();
    }
    public Card createCard(String number, String suit){
        return new Card(number, suit); 
    }
    
    
    public Pair<String,Double> readHand(){
                int pair = 0, three = 0, poker = 0, escaleraReal = handList.get(0).getNumber();
                double valorP1 = 0, valorP2 = 0, valorT1 = 0 , valorS = 0;
                boolean lastPair = false, lastThree = false, straight =true, color = true;
        for (int i = 1; i < handList.size(); i++) {
            if(color && !handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-1).getSuit())) color = false;
            if(handList.get(i).getNumber() == handList.get(i-1).getNumber()){
                straight = false;
                if(!lastPair && !lastThree){
                    pair++;
                    if(pair == 1)valorP1 = handList.get(i).getNumber()/100.0;
                    else valorP2 = handList.get(i).getNumber()/100.0; 
                    lastPair = true;
                }else if(lastPair){
                    three += 1;
                    pair -= 1;
                    lastPair = false;
                    lastThree = true;
                    valorT1 = handList.get(i).getNumber()/100.0;
                }else if(lastThree){
                    poker += 1; 
                    return new Pair("poker", 8 + valorP1); //3
                }         
            }
            else {
                if(straight) {
                    if(handList.get(i).getNumber()-1 == handList.get(i-1).getNumber()|| (handList.get(i).getNumber() == 14 && handList.get(i-1).getNumber()==5)){
                        valorS = handList.get(i).getNumber()/100.0;
                        escaleraReal += handList.get(i).getNumber();
                    }
                    else straight = false; 
                }
                lastPair = false;
                lastThree = false;
            }    
        }
        if(straight && color){
            if(escaleraReal == 60) return new Pair("Royal flush", 10.0); 
            else return new Pair("Straight flush", 9.0); 
        }
        else if(pair == 1 && three == 1) return new Pair("Full house", 7 + valorT1 + valorP1/100.0);
        else if(color) return new Pair("Flush", 6.0);
        else if(straight) return new Pair("Straight", 5 + valorS);
        else if(pair == 0 && three == 1) return new Pair("Three of a kind", 4 + valorT1);
        else if(pair == 2) return new Pair("Double Pair" , 3 + valorP2 + valorP1/100.0);
        else if(pair == 1) return new Pair("Pair" ,2 + valorP1);
    
        return new Pair("High Card: "+handList.get(NCARDS-1),1.0+ handList.get(NCARDS-1).getNumber()/100.0);
    }

    public String readDraw(){

        //Se calcula todas las posibilidades de un solo recorrido, se puede hacer más eficiente¿?
        int pair = 0, three = 0, escaleraReal = handList.get(0).getNumber(), nColor = 1, nStraight = 1; 
        boolean lastPair = false, lastThree = false, straightDraw =true, gutShot = false, openEnded = false, recienCambiado = false;
        boolean lowStraight = posibleEscaleraDesdeAbajo();
        for (int i = 1; i < handList.size(); i++) {
            if ((handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-1).getSuit()) && !recienCambiado) ||
            (recienCambiado && handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-2).getSuit()))){
                nColor++;
                recienCambiado = false;
            }
            else if(!handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-1).getSuit())){
                recienCambiado = true;
            } 
            if(handList.get(i).getNumber() == handList.get(i-1).getNumber()){
                if(!lastPair && !lastThree){
                    pair += 1;
                    lastPair = true;
                }else if(lastPair){
                    three += 1;
                    pair -= 1;
                    lastPair = false;
                    lastThree = true;
                }    
            }
            else {
                if(!lowStraight){
                    if(straightDraw) {
                        if(handList.get(i).getNumber()-1 == handList.get(i-1).getNumber() || (handList.get(i).getNumber() == 14 && handList.get(i-1).getNumber()==5)){ 
                            escaleraReal += handList.get(i).getNumber();
                            nStraight++;
                        }
                        else if (handList.get(i).getNumber()-2 == handList.get(i-1).getNumber() && !gutShot){
                            gutShot = true;
                            escaleraReal += handList.get(i).getNumber();
                            nStraight++;
                            if(openEnded)
                                openEnded = false;
                            else if (i == 1 || i == 4 && pair == 0)
                                openEnded = true;
                        }
                        else if ((i == 1 || i == 4) && !openEnded && !gutShot){
                            openEnded = true;
                        }else{
                            straightDraw = false;
                        }
                    }
                }
                else{

                    if(straightDraw) {
                        if(i == 1){
                            if(handList.get(0).getNumber() == 2){
                                nStraight++;
                            }
                            else{
                                gutShot = true;
                                nStraight++;
                                openEnded = true;
                            }
                        }
                        else if(handList.get(i-1).getNumber()-1 == handList.get(i-2).getNumber()){ 
                            nStraight++;
                        }
                        else if (handList.get(i-1).getNumber()-2 == handList.get(i-2).getNumber() && !gutShot){
                            gutShot = true;
                            nStraight++;
                            if (i == 4)
                                openEnded = true;
                        }
                        else if (i == 4 && !openEnded && !gutShot){
                            openEnded = true;
                        }else{
                            straightDraw = false;
                            if(openEnded)
                                openEnded = false;
                        }
                        
                    }
                }
                lastPair = false;
                lastThree = false;
            }
        }

        //POSIBLES DRAW DE COLOR, ESCALERA O FULL
        String draws = "";
        if(nColor == 4)
            draws += "Color Draw;";
        if(nStraight >= 4 && gutShot)
            draws += "Straight Gutshow Draw;";
        if(nStraight >= 4 && openEnded)
            draws += "Straight Open-end Draw;";
        if((three == 1 && pair == 0)|| pair == 2)
            draws += "Full Draw;";

        return draws;

    }

    public boolean posibleEscaleraDesdeAbajo(){
        return (handList.get(4).getNumber() == 14 && (handList.get(0).getNumber() == 2 || handList.get(0).getNumber() == 3) 
                && (handList.get(1).getNumber() == 3 || handList.get(1).getNumber() == 4));
    }
    
    @Override
    public String toString(){
       return handList.toString() +" "+ handValue +" "+ handString +" "+ handDraw;
    }

    @Override
    public int compareTo(Hand o) {
        if(this.handValue > o.handValue) return 1;
        else if(this.handValue < o.handValue) return - 1;
        else{
            int tValue;
            int oValue;
            for(int i = handList.size()-1; i >= 0; i--){
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
    public ArrayList<Card> getHandList(){
        return handList;
    }
}
