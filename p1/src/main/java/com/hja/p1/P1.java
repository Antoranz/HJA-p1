package com.hja.p1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1 {

    public static void main(String[] args) {
        handTest();
       /* DeckOfCards doc = new DeckOfCards();
        System.out.println(doc.getCards());
        System.out.println(doc.dealingCards(5));
        System.out.println(doc.getCards());*/
    }
    
    public static void handTest(){
        
        /*Hand hand = new Hand("AhKhJhQhTh");
        System.out.println(hand);
        System.out.println(hand.readHand().getElement0());
        
        Hand hand2 = new Hand("Th9h8h7h6h");
        System.out.println(hand2);
        System.out.println(hand2.readHand().getElement0());
        
        Hand hand3 = new Hand("AhAdAcAs6h");
        System.out.println(hand3);
        System.out.println(hand3.readHand().getElement0());
        
        Hand hand4 = new Hand("ThTdTcKhKs");
        System.out.println(hand4);
        System.out.println(hand4.readHand().getElement0());
        
        Hand hand5 = new Hand("2hKh8h7h6h");
        System.out.println(hand5);
        System.out.println(hand5.readHand().getElement0());
        
        Hand hand6 = new Hand("Th9d8h7d6h");
        System.out.println(hand6);
        System.out.println(hand6.readHand().getElement0());
        
        Hand hand7 = new Hand("AhAcAs7d6h");
        System.out.println(hand7);
        System.out.println(hand7.readHand().getElement0());
        
        Hand hand8 = new Hand("AhAc6s7d6h");
        System.out.println(hand8);
        System.out.println(hand8.readHand().getElement0());
        
        Hand hand9 = new Hand("AcAh6h7d8h");
        System.out.println(hand9);
        System.out.println(hand9.readHand().getElement0());
        */
        
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(new Card("A","s"));
        cardList.add(new Card("2","s"));
        cardList.add(new Card("A","d"));
        cardList.add(new Card("A","h"));
        cardList.add(new Card("5","d"));
        cardList.add(new Card("J","s"));
        cardList.add(new Card("7","h"));
        
        int n = cardList.size();
        int k = 5;
        
        Combinations comb = new Combinations(); 
        List<List<Integer>> combinations = comb.combine(n, k);
        for (List<Integer> c : combinations) {
            System.out.println(c);
        }
             
        
        
        Hand hand10 = new Hand("");
        System.out.println(hand10);
        System.out.println(hand10.readHand().getElement0());
        
    }
}
