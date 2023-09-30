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
}
