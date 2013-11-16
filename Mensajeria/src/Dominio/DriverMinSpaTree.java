/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

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
        // TODO code application logic here
        System.out.print("Selecciona funcion a probar" + "\n");
        System.out.print("1: Getters y setters" + "\n");
        System.out.print("2: reconvertirArbol" + "\n");
        System.out.print("3: MST" + "\n");
        System.out.print("0: Finalizar" + "\n");
        
        Scanner sc = new Scanner(System.in);
        MinSpaTree mst = new MinSpaTree();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                String[] n = new String[3];
                n[0] = "Octavio";
                n[1] = "Pere";
                n[2] = "Andreu";
                mst.setNombres(n);
                System.out.print("Estos son los nombres: " + "\n");
                String res[] = mst.getNombres();
                for(int i = 0; i < 3; ++i){
                    System.out.print(res[i] + " ");
                }
                System.out.print("\n");
                
                System.out.print("Escribe una matriz de floats de 3*3 para comprobar get y set de grafo" + "\n");
                float g[][] = new float[3][3];
                for(int i = 0; i < 3; ++i){
                    for(int j = 0; j < 3; ++j){
                        g[i][j] = sc.nextFloat();
                    }
                }
                System.out.print("Esta es la matriz: " + "\n");
                for(int i = 0; i < 3; ++i){
                    for(int j = 0; j < 3; ++j){
                        System.out.print(g[i][j] + " ");
                    }
                    System.out.print("\n");
                }
            }
            else if(op == 2){
                
            }
            else if(op == 3){
                
            }
            else System.out.print("Opcion Incorrecta, vuelve a introducir una opcion" + "\n");
            
            System.out.print("Selecciona funcion a probar" + "\n");
            op = sc.nextInt();
        }
    }
    
}
