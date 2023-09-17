/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hja.p1;

/**
 *
 * @author usuario_local
 */
public class P1 {

    public static void main(String[] args) {
        pruebaMano();
    }
    
    public static void pruebaMano(){
        Hand mano = new Hand("AhKhJhQhTh");
        System.out.println(mano);
        System.out.println(mano.readHand());
        
        Hand mano2 = new Hand("Th9h8h7h6h");
        System.out.println(mano2);
        System.out.println(mano2.readHand());
        
        Hand mano3 = new Hand("AhAdAhAh6h");
        System.out.println(mano3);
        System.out.println(mano3.readHand());
        
        Hand mano4 = new Hand("ThThThKhKh");
        System.out.println(mano4);
        System.out.println(mano4.readHand());
        
        Hand mano5 = new Hand("2h6h8h7h6h");
        System.out.println(mano5);
        System.out.println(mano5.readHand());
        
        Hand mano6 = new Hand("Th9d8h7d6h");
        System.out.println(mano6);
        System.out.println(mano6.readHand());
        
        Hand mano7 = new Hand("AhAhAh7d6h");
        System.out.println(mano7);
        System.out.println(mano7.readHand());
        
        Hand mano8 = new Hand("AhAh6h7d6h");
        System.out.println(mano8);
        System.out.println(mano8.readHand());
        
        Hand mano9 = new Hand("AhAh6h7d8h");
        System.out.println(mano9);
        System.out.println(mano9.readHand());
        
        Hand mano10 = new Hand("Ah9h6h7d8h");
        System.out.println(mano10);
        System.out.println(mano10.readHand());
    }
}
