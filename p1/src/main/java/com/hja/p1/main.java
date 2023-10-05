package com.hja.p1;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

public class main {

    public static void main(String[] args) { // arg[0] = caso // arg[1] = fichero de entrada // arg[2] = fichero de salida
        
        String outStream = "";//String de Salida 
        String ruta= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\" + args[1];
        HandStorage hs = new HandStorage();
        try {
            switch(args[0]){//Elige caso
                case "1":{

                    List<Hand> hL = hs.readHands(ruta);
                    for(int i=0; i< hL.size();i++){
                        outStream += hL.get(i).toString() + "\n";
                        String aux1 = hL.get(i).readDraw();
                        if(aux1 != ""){
                            String[] aux2 = aux1.split(";");
                            for(String a: aux2)
                                outStream += " -Draw: " + a + "\n";
                        }
                    }
                break;
                }

                case "2":{

                    List<Player> pL = hs.readNCards(ruta,false);
                    for(int i=0; i< pL.size();i++){
                        outStream += pL.get(i).getBestHand() + "\n";
                        String aux1 = pL.get(i).getBestHand().readDraw();
                        if(aux1 != ""){
                            String[] aux2 = aux1.split(";");
                            for(String a: aux2)
                                outStream += " -Draw: " + a + "\n";
                        }
                    }
                break;
                }

                
                case "3":{

                    List<List<Player>> pL = hs.readNPlayer(ruta);
                    for(int i=0; i< pL.size();i++){
                        Collections.sort(pL.get(i));
                        for (Player p: pL.get(i))
                            outStream += p.toString() + "\n";
                    }
                break;
                }
                    
                case "4":{


                    List<Player> pL = hs.readNCards(ruta,true);
                    for(int i=0; i< pL.size();i++)
                        outStream += pL.get(i).getBestHand() + "\n";

                break;
                }
            }
        
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter myWriter = new FileWriter("src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\" + args[2]);//Creación de fichero de salida (sobrescribe)
            myWriter.write(outStream);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("No se ha podido guardar en archivo.");
            e.printStackTrace();
        }
      
    }
    
    
    public static void casosConsola(){ //Función para probar todos los casos por consola
        
        //Entrada 1 txt
        System.out.println("Caso 1");
        HandStorage hs = new HandStorage();
        String ruta1= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\entrada.txt";
        
        try {
            List<Hand> hL = hs.readHands(ruta1);
            for(int i=0; i< hL.size();i++){
                System.out.println(hL.get(i).toString());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Entrada 2 txt
        System.out.println("Caso 2");
        String ruta2= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\entrada2.txt";
        
        try {
            List<Player> pL = hs.readNCards(ruta2,false);
            for(int i=0; i< pL.size();i++){
                System.out.println(pL.get(i).getBestHand());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Entrada 3 txt
        System.out.println("Caso 3");
        String ruta3= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\entrada3.txt";
        
        try {
            List<List<Player>> pL = hs.readNPlayer(ruta3);
            for(int i=0; i< pL.size();i++){
                Collections.sort(pL.get(i));
                for (Player p: pL.get(i))
                    System.out.println(p.toString());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Entrada 4 txt
        System.out.println("Caso 4");
        String ruta= "src\\\\main\\\\java\\\\com\\\\hja\\\\p1\\\\entrada4.txt";
        
        try {
            List<Player> pL = hs.readNCards(ruta,true);
            for(int i=0; i< pL.size();i++){
                System.out.println(pL.get(i).getBestHand());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
