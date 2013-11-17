/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.Scanner;

/**
 *
 * @author Marc Garcia Roig
 */
public class DriverPair {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe el primer elemento del pair" + "\n");
        int first = sc.nextInt();
        System.out.print("Escribe el segundo elemento del pair" + "\n");
        float second = sc.nextFloat();
        Pair p = new Pair(first,second);
        
        System.out.print("get de first: " + p.first() + "\n");
        System.out.print("get de second: " + p.second() + "\n");
    }
    
}
