/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class DriverMinSpaTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Selecciona funcion a probar");
        System.out.println("1: Getters y setters");
        System.out.println("2: Crear arbol de recubrimiento minimo");
        System.out.println("0: Finalizar");
        
        Scanner sc = new Scanner(System.in);
        MinSpaTree mst = new MinSpaTree();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                String[] n = new String[3];
                n[0] = "casaOctavio";
                n[1] = "casaPere";
                n[2] = "casaAndreu";
                mst.setNombres(n);
                System.out.println("Estos son los nombres: ");
                String res[] = mst.getNombres();
                for(int i = 0; i < 3; ++i){
                    System.out.print(res[i] + " ");
                }
                System.out.println();
                
                System.out.println("Escribe una matriz de floats de 3*3 para comprobar get y set de grafo");
                float g[][] = new float[3][3];
                for(int i = 0; i < 3; ++i){
                    for(int j = 0; j < 3; ++j){
                        g[i][j] = sc.nextFloat();
                    }
                }
                mst.setGrafo(g);
                float c[][] = mst.getGrafo();
                System.out.println("Esta es la matriz: ");
                for(int i = 0; i < 3; ++i){
                    for(int j = 0; j < 3; ++j){
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else if(op == 2){
                ArrayList< ArrayList<Pair> >result = mst.MST();
                System.out.println("Este es el Arbol de recubrimiento minimo");
                for (int i = 0; i < result.size(); ++i) {
                    System.out.println("EL INDICE ES: " + i + " Y su tamaño es " + result.get(i).size());
                    for (int j = 0; j < result.get(i).size(); ++j) {
                        System.out.println(result.get(i).get(j).first() + " " + result.get(i).get(j).second());
            }
        }
            }
            else System.out.println("Opcion Incorrecta, vuelve a introducir una opcion");
            System.out.println("Selecciona funcion a probar");
            op = sc.nextInt();
        }
    }
    
}
