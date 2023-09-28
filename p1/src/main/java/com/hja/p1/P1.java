package com.hja.p1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        
        int n = cardList.size()-1;
        int k = 5;
        
        Combinations comb = new Combinations(); 
        List<List<Card>> combinations = comb.combine(n, k, cardList); //Combinaciones
        for (List<Card> c : combinations) {
            System.out.println(c);
        }
        JFrame p = new Poker();
        
        /*JFrame frame = new JFrame("My first JFrame");
        frame.setSize(600, 600);  
        ImageIcon image1 = new ImageIcon("C:\\Users\\usuario_local\\Documents\\NetBeansProjects\\HJA-p1\\p1\\src\\main\\java\\com\\hja\\p1\\cardsPng\\10_of_clubs.png");
        JLabel label = new JLabel(image1);
        label.setVisible(true);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
        
    }
}
