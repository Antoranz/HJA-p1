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
                    return new Pair("Poker", 8 + valorP1); //3
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
        else if(pair == 1 && three == 1) return new Pair("full", 7 + valorT1 + valorP1/100.0);
        
        else if(color) return new Pair("Flush of " + mostrarSuit(handList.get(0).getSuit()), 6.0);
        
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
        //Comprueba si es una escalera que empieza desde el AS ascendentemente
        boolean lowStraight = posibleEscaleraDesdeAbajo();  
        //Bucle de lectura de cartas
        for (int i = 1; i < handList.size(); i++) {
            //Comprobación de cartas con el mismo color
            if ((handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-1).getSuit()) && !recienCambiado) ||
            (recienCambiado && handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-2).getSuit()))){
                nColor++;
                recienCambiado = false;
            }
            //Comprobación de cambio de color
            else if(!handList.get(i).getSuit().equalsIgnoreCase(handList.get(i-1).getSuit())){
                recienCambiado = true;
            } 
            //Comprobación de cartas iguales para pares y trios
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
            //Comprobación escalera
            else {
                //Si es una escalera en la que el As no va a contar como un 1
                if(!lowStraight){
                    if(straightDraw) {
                        //Comprobación de que haya dos cartas consecutivas formando escalera
                        if(handList.get(i).getNumber()-1 == handList.get(i-1).getNumber() || (handList.get(i).getNumber() == 14 && handList.get(i-1).getNumber()==5)){ 
                            escaleraReal += handList.get(i).getNumber();
                            nStraight++;
                        }
                        //Comprobación de gutshot
                        else if (handList.get(i).getNumber()-2 == handList.get(i-1).getNumber() && !gutShot){
                            gutShot = true;
                            escaleraReal += handList.get(i).getNumber();
                            nStraight++;
                            //Se elimina la posibilidad del openEnded que se habia encontrado al detectar un gutshot
                            if(openEnded)
                                openEnded = false;
                            //Se comprueba si hay openEnded y gutshot al mismo tiempo
                            else if (i == 1 || i == 4 && pair == 0)
                                openEnded = true;
                        }
                        //Comprobación de openEnded
                        else if ((i == 1 || i == 4) && !openEnded && !gutShot){
                            openEnded = true;
                        //En caso de que no se cumpla nada de lo anterior no hay posibilidad de draw de escalera
                        }else{
                            straightDraw = false;
                        }
                    }
                }
                //Si es una posible escalera desde el As
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
            draws += "Flush;";
        if(nStraight >= 4 && gutShot)
            draws += "Straight Gutshow;";
        if(nStraight >= 4 && openEnded)
            draws += "Straight Open-end;";
        if((three == 1 && pair == 0)|| pair == 2)
            draws += "Full;";

        /*
        Para el caso de la escalera de color y escalera real la forma de hacerlo que se nos ha ocurrido es extremadamente costosa y no creemos
        que sea la solución adecuada para resolver el problema, por tanto no la hemos añadido pero la dejamos aquí por si sirve de algo
        
        */

        return draws;

    }

    public boolean posibleEscaleraDesdeAbajo(){
        return (handList.get(4).getNumber() == 14 && (handList.get(0).getNumber() == 2 || handList.get(0).getNumber() == 3) 
                && (handList.get(1).getNumber() == 3 || handList.get(1).getNumber() == 4));
    }
    
    @Override
    public String toString(){
      // return handList.toString() +" "+ handValue +" "+ handString +" "+ handDraw;
      return mostrarJugada() + " with " + handList.toString();
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
    
    public String mostrarJugada(){
        
        String str = String.valueOf(this.handValue);

        int parteEntera = Integer.parseInt(str.substring(0, str.indexOf('.')));
        int parteDecimal = Integer.parseInt(str.substring(str.indexOf('.') + 1));
        
        String s = "";
        
        switch (parteEntera){
            //Parejas y Poker
            case 2:
            case 8:
                s = handString + " of " + mostrarNumero(parteDecimal);
                break;
            //Doble pareja
            case 3: 
                s = handString + " of " + mostrarNumero(parteDecimal / 100) + " and " + mostrarNumero(parteDecimal % 100);
                break;
            //Trio
            case 4:
                s = handString + " (" +mostrarNumero(parteDecimal) + ")";
                break;
            //Full
            case 7:
                s = mostrarNumero(parteDecimal / 100) + " " + handString + " of " + mostrarNumero(parteDecimal % 100);
                break;
            default:
                s = handString;
                break;
        }
        return s;
    }
    
    public String mostrarNumero(int parteDecimal){

        String s = "";
        
        switch (parteDecimal){
            case 1:
                s = "10's";
                break;
            case 11:
                s = "Jacks";
                break;
            case 12:
                s = "Queens";
                break;
            case 13:
                s = "Kings";
                break;
            case 14:
                s = "Aces";
                break;
            default:
                s = parteDecimal + "'s";
        }
        
        return s;
    }
    
    //Solo se utiliza para el flush
    public String mostrarSuit(String suit){
        
        String s = "";
        switch (suit){
            case "h":
                s = "Hearts";
                break;
            case "d":
                s = "Diamonds";
                break;
            case "s":
                s = "Spades";
                break;
            case "c":
                s = "Clubs";
                break;
        }
        
        return s;
    }
}
