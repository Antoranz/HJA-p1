package com.hja.p1;


import java.io.FileNotFoundException;
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
        
    }
}
