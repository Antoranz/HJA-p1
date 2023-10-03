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
    public void readNCards(String ruta, Player p) throws FileNotFoundException{
        File doc = new File(ruta);
        Scanner obj = new Scanner(doc);
        
        while (obj.hasNextLine()){
            String[] a = obj.nextLine().split(";");
            for (int i = 0; i < a[0].length(); i+=2){
                Card c = new Card(a[0].charAt(i)+"",a[0].charAt(i+1)+"");
                p.addCard(c);
            }
            for (int i = 0; i < Integer.parseInt(a[1])*2; i+=2){
                Card c = new Card(a[2].charAt(i)+"",a[2].charAt(i+1)+"");
                p.addBoardCard(c);
            }
        }

    }
}
