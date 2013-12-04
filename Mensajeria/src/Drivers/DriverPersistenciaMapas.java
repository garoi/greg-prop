/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Drivers;

import Persistencia.PersistenciaMapas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class DriverPersistenciaMapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PersistenciaMapas pm = new PersistenciaMapas();
        System.out.println("1: leerMapaFichero");
        System.out.println("0: Salir");
        System.out.println("Introduce una opcion");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                
                String fichero = new String("setcases-mapa.txt");
                String city = new String();
                ArrayList<String> punts = new ArrayList();
                ArrayList<ArrayList<Float>> dists = new ArrayList<ArrayList<Float>>();
        
                pm.leerMapaFichero(fichero, city, punts, dists);
                System.out.println(city);
                for(int i = 0; i < punts.size(); ++i){
                    System.out.println(punts.get(i) + " ");
                }
                System.out.println("");
                for(int i = 0; i < dists.size(); ++i){
                    for(int j = 0; j < dists.get(i).size(); ++j){
                        System.out.print(dists.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }
            }
            
            else System.out.println("Opcion no existente");
            System.out.println("Introduce una opcion");
            op = sc.nextInt();
        }
    }
    
}
