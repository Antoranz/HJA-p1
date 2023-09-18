package com.hja.p1;

public class P1 {

    public static void main(String[] args) {
        handTest();
    }
    
    public static void handTest(){
        
        Hand hand = new Hand("AhKhJhQhTh");
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
        
        Hand hand10 = new Hand("Ah9h6h7d8h");
        System.out.println(hand10);
        System.out.println(hand10.readHand().getElement0());
    }
}
