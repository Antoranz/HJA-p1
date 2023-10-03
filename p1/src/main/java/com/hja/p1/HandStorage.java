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
    public List<Player> readNCards(String ruta, boolean oklahoma) throws FileNotFoundException{
        File doc = new File(ruta);
        Scanner obj = new Scanner(doc);
        List<Player> pL = new ArrayList<Player>();
        while (obj.hasNextLine()){
            Player p;
            if(oklahoma)
                p = new PlayerOklahoma("J0");
            else
                p = new Player("J0");
            String[] a = obj.nextLine().split(";");
            for (int i = 0; i < a[0].length(); i+=2){
                Card c = new Card(a[0].charAt(i)+"",a[0].charAt(i+1)+"");
                p.addCard(c);
            }
            for (int i = 0; i < Integer.parseInt(a[1])*2; i+=2){
                Card c = new Card(a[2].charAt(i)+"",a[2].charAt(i+1)+"");
                p.addBoardCard(c);
            }
            p.bestHand();
            pL.add(p);
        }
        return pL;
    }
    
    public List<List<Player>> readNPlayer(String ruta) throws FileNotFoundException{
        File doc = new File(ruta);
        Scanner obj = new Scanner(doc);
        List<List<Player>> playerListList = new ArrayList<List<Player>>();
        while (obj.hasNextLine()){
            List<Player> pL = new ArrayList<Player>();
            String[] a = obj.nextLine().split(";");
            for(int i=1; i<= Integer.parseInt(a[0]);i++){
                Player p = new Player(a[i].charAt(0)+a[i].charAt(1)+"");
                Card c1 = new Card(a[i].charAt(2)+"",a[i].charAt(3)+"");
                Card c2 = new Card(a[i].charAt(4)+"",a[i].charAt(5)+"");
                p.addCard(c1);
                p.addCard(c2);
                for(int j=0; j< 5*2;j+=2){
                    Card c = new Card(a[a.length-1].charAt(j)+"",a[a.length-1].charAt(j+1)+"");
                    p.addBoardCard(c);
                }
                p.bestHand();
                pL.add(p);
            }
            playerListList.add(pL);
        }
        return playerListList;
    }
}
