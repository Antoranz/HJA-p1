package com.hja.p1;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class P1 {

    public static void main(String[] args) {
        //handTest();
        //PlayerTest();
        PlayerOklahomaTest();
       /* DeckOfCards doc = new DeckOfCards();
        System.out.println(doc.getCards());
        System.out.println(doc.dealingCards(5));
        System.out.println(doc.getCards());*/
    }
    
    public static void handTest() {
        
        /*ArrayList<Card> cardList = new ArrayList<>();
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
        JFrame p = new Poker();*/
        
        HandStorage hs = new HandStorage();
        String ruta= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\casos.txt";
        String ruta2= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\casos2.txt";
        
        
        
        /*JFrame frame = new JFrame("My first JFrame");
        frame.setSize(600, 600);  
        ImageIcon image1 = new ImageIcon("C:\\Users\\usuario_local\\Documents\\NetBeansProjects\\HJA-p1\\p1\\src\\main\\java\\com\\hja\\p1\\cardsPng\\10_of_clubs.png");
        JLabel label = new JLabel(image1);
        label.setVisible(true);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
        

        

        //PRUEBAS DRAW 

	/*//OPEN STRAIGHT IZQ
        Hand hand30 = new Hand("QhJh2hKhAh");
        System.out.println(hand30);
        System.out.println(hand30.readDraw());
        //OPEN STRAIGHT DER
        Hand hand31 = new Hand("2h4hAh3h8h");
        System.out.println(hand31);
        System.out.println(hand31.readDraw());
        //OPEN STRAIGHT
        Hand hand32 = new Hand("7h8h9hThAh");
        System.out.println(hand32);
        System.out.println(hand32.readDraw());
        //GUTSHOT
        Hand hand33 = new Hand("7h9h8hJh2h");
        System.out.println(hand33);
        System.out.println(hand33.readDraw());
        //GUTSHOT OPEN STRAIGHT IZQ
        Hand hand34 = new Hand("9hQhJhKhAh");
        System.out.println(hand34);
        System.out.println(hand34.readDraw());
        //GUTSHOT OPEN STRAIGHT DER
        Hand hand35 = new Hand("2hAh6h3h4h");
        System.out.println(hand35);
        System.out.println(hand35.readDraw());
        //COLOR
        Hand hand36 = new Hand("9h2h8sJhAh");
        System.out.println(hand36);
        System.out.println(hand36.readDraw());
        //FULL PAREJAS
        Hand hand37 = new Hand("9h9s8h8sAh");
        System.out.println(hand37);
        System.out.println(hand37.readDraw());
        //FULL TRIO
        Hand hand38 = new Hand("9h9s9cJhAs");
        System.out.println(hand38);
        System.out.println(hand38.readDraw());
        //COLOR OPEN STRAIGHT IZQ
        Hand hand39 = new Hand("QhJs2hKhAh");
        System.out.println(hand39);
        System.out.println(hand39.readDraw());
        //COLOR OPEN STRAIGHT DER
        Hand hand40 = new Hand("2h4hAh3s8h");
        System.out.println(hand40);
        System.out.println(hand40.readDraw());
        //COLOR GUTSHOT
        Hand hand41 = new Hand("7h9h8sJh2h");
        System.out.println(hand41);
        System.out.println(hand41.readDraw());
        //COLOR GUTSHOT OPEN STRAIGHT IZQ
        Hand hand42 = new Hand("9hQhJhKsAh");
        System.out.println(hand42);
        System.out.println(hand42.readDraw());
        //COLOR GUTSHOT OPEN STRAIGHT DER
        Hand hand43 = new Hand("2hAh6h3s4h");
        System.out.println(hand43);
        System.out.println(hand43.readDraw());
        
        Hand hand44 = new Hand("QhAsJhTs9h");
        System.out.println(hand44);
        System.out.println(hand44.readDraw());
        
        Hand hand45 = new Hand("3hAs4h6s5h");
        System.out.println(hand45);
        System.out.println(hand45.readDraw());*/
        
    }
    public static void PlayerTest(){

        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            Player p = new Player("J" + i+"");
            
            // Cartas comunes de la mesa: 5dKs6cTh9h
            p.addCard(new Card("4","d"));
            p.addCard(new Card("2", "s"));
            p.addCard(new Card("3", "c"));
            p.addCard(new Card("T", "h"));
            p.addCard(new Card("5", "h"));

            //Cartas propias de cada jugador
            switch (i){
                case 0:
                    p.addCard(new Card("A","h"));
                    p.addCard(new Card("A","c"));
                    break;
                case 1:
                    p.addCard(new Card("J","s"));
                    p.addCard(new Card("J","h"));
                    break;
                case 2:
                    p.addCard(new Card("7","c"));
                    p.addCard(new Card("8","c"));
                    break;
                case 3:
                    p.addCard(new Card("4","s"));
                    p.addCard(new Card("K","c"));
                    break;
            }
            p.bestHand();
            playerList.add(p);
        }
        Collections.sort(playerList);
        for (Player p: playerList)
            System.out.println(p.toString());
            
    }
    
    public static void PlayerOklahomaTest(){
        
        //AhAc8s5h;4;2h2d2c2s
        HandStorage hs = new HandStorage();
        String ruta= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\entrada4.txt";
        
        try {
            PlayerOklahoma p = new PlayerOklahoma("J" + Player.N_PLAYERS);
            hs.readNCards(ruta,p);
            p.bestHand();
            System.out.println(p.getBestHand());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(P1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
