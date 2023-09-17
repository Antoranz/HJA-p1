package com.hja.p1;

public class P1 {

    public static void main(String[] args) {
        handTest();
    }
    
    public static void handTest(){
        
        Hand hand = new Hand("AhKhJhQhTh");
        System.out.println(hand);
        System.out.println(hand.readHand());
        
        Hand hand2 = new Hand("Th9h8h7h6h");
        System.out.println(hand2);
        System.out.println(hand2.readHand());
        
        Hand hand3 = new Hand("AhAdAcAs6h");
        System.out.println(hand3);
        System.out.println(hand3.readHand());
        
        Hand hand4 = new Hand("ThTdTcKhKs");
        System.out.println(hand4);
        System.out.println(hand4.readHand());
        
        Hand hand5 = new Hand("2hKh8h7h6h");
        System.out.println(hand5);
        System.out.println(hand5.readHand());
        
        Hand hand6 = new Hand("Th9d8h7d6h");
        System.out.println(hand6);
        System.out.println(hand6.readHand());
        
        Hand hand7 = new Hand("AhAcAs7d6h");
        System.out.println(hand7);
        System.out.println(hand7.readHand());
        
        Hand hand8 = new Hand("AhAc6s7d6h");
        System.out.println(hand8);
        System.out.println(hand8.readHand());
        
        Hand hand9 = new Hand("AcAh6h7d8h");
        System.out.println(hand9);
        System.out.println(hand9.readHand());
        
        Hand hand10 = new Hand("Ah9h6h7d8h");
        System.out.println(hand10);
        System.out.println(hand10.readHand());
    }
}
