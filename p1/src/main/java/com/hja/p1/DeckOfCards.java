package com.hja.p1;

public class DeckOfCards {
   
    private String randomCards = "";
    
    public DeckOfCards(){
        //52 cartas
        String orderCards = "2h3h4h5h6h7h8h9hThJhQhKhAh2d3d4d5d6d7d8d9dTdJdQdKdAd2c3c4c5c6c7c8c9cTcJcQcKcAc2s3s4s5s6s7s8s9sTsJsQsKsAs";
        while(orderCards.length()>0){
            int numero = (int)(Math.random()*orderCards.length());//
            if(numero%2==0){
                randomCards += ""+orderCards.charAt(numero) + orderCards.charAt(numero + 1);
                orderCards = orderCards.replace(""+orderCards.charAt(numero) + orderCards.charAt(numero + 1),"");
            }else{
                randomCards += ""+orderCards.charAt(numero - 1) + orderCards.charAt(numero);
                orderCards = orderCards.replace(""+orderCards.charAt(numero - 1) + orderCards.charAt(numero),"");
            }
            System.out.println(orderCards.length());
        } 
        
    }
    
    public String getCards(){
        System.out.println(randomCards);
        return randomCards;
    }
}
