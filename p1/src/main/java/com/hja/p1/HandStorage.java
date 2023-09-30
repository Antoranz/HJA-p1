/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hja.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fjavi
 */
public class HandStorage {
    
    public List<Hand> readHands(String ruta) throws FileNotFoundException{
        File doc = new File(ruta);
        Scanner obj = new Scanner(doc);

        List<Hand> list = new ArrayList<Hand>();
        while (obj.hasNextLine()){
            list.add(new Hand(obj.nextLine()));
        }
        return list;
    }
    public List<List<Card>> readNCards(String ruta) throws FileNotFoundException{
        File doc = new File(ruta);
        Scanner obj = new Scanner(doc);

        List<List<Card>> list = new ArrayList<List<Card>>();
        while (obj.hasNextLine()){
            String nCards = obj.nextLine();
            List<Card> l = new ArrayList<Card>();
            for (int i = 0; i<nCards.length(); i+=2){
                l.add(new Card(nCards.charAt(i)+"",nCards.charAt(i+1)+""));
            }
            list.add(l);
        }
        
        return list;
    }
}
