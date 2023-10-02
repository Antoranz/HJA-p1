package com.hja.p1;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class P1 {

    public static void main(String[] args) {
        //handTest();
        PlayerTest();
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
        try{
            List<Hand> hl = hs.readHands(ruta);
            for(int i = 0; i < hl.size(); i++){
                System.out.println(hl.get(i).toString());
                System.out.println(hl.get(i).readHand().getElement0());
            }
            List<List<Card>> loc = hs.readNCards(ruta2);
            for(int i=0; i<loc.size();i++){
                List<Card> list = loc.get(i);
                ArrayList<Card> cardList= new ArrayList<Card>(list);
                int n = cardList.size()-1;
                int k = 5;

                Combinations comb = new Combinations(); 
                List<List<Card>> combinations = comb.combine(n, k, cardList); //Combinaciones
                System.out.println("Caso "+i);
                for (List<Card> c : combinations) {
                    System.out.println(c);
                }      
            }
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo");
        }
        
        
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
            playerList.add(new Player("J" + i+""));

            // Cartas comunes de la mesa: 5dKs6cTh9h
            playerList.get(i).playerCards.add(new Card("5","d"));
            playerList.get(i).playerCards.add(new Card("K", "s"));
            playerList.get(i).playerCards.add(new Card("6", "c"));
            playerList.get(i).playerCards.add(new Card("T", "h"));
            playerList.get(i).playerCards.add(new Card("9", "h"));

            //Cartas propias de cada jugador
            switch (i){
                case 0:
                    playerList.get(i).playerCards.add(new Card("A","h"));
                    playerList.get(i).playerCards.add(new Card("A","c"));
                    break;
                case 1:
                    playerList.get(i).playerCards.add(new Card("J","s"));
                    playerList.get(i).playerCards.add(new Card("J","h"));
                    break;
                case 2:
                    playerList.get(i).playerCards.add(new Card("7","c"));
                    playerList.get(i).playerCards.add(new Card("8","c"));
                    break;
                case 3:
                    playerList.get(i).playerCards.add(new Card("4","s"));
                    playerList.get(i).playerCards.add(new Card("K","c"));
                    break;
            }
        }
        Collections.sort(playerList);
        for (Player p: playerList)
            p.toString();

    }
}
