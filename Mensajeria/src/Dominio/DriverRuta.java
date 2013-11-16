package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marc Garcia Roig
 */
public class DriverRuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Selecciona funcion a probar");
        System.out.println("1: Setters");
        System.out.println("2: calculo rapido");
        System.out.println("3: calculo efectivo");
        System.out.println("0: Finalizar");
        
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        Ruta r = new Ruta();
        while(op != 0){
            if(op == 1){
                r.setFecha("15.12.13");
                System.out.println("Escribe una matriz de floats de 4*4 para comprobar get y set de grafo");
                float g[][] = new float[4][4];
                for(int i = 0; i < 4; ++i){
                    for(int j = 0; j < 4; ++j){
                        g[i][j] = sc.nextFloat();
                    }
                }
                String[] n = new String[4];
                n[0] = "upc";
                n[1] = "ub";
                n[2] = "uab";
                n[3] = "upf";
                r.setGrafo(g);
                r.setListaPaquetesRuta(null);
                r.setNombres(n);
            }
            else if(op == 2) {
                r.calcularRapida();
                r.mostrarRuta();
            }
            else if(op == 3) {
                r.calcularMinSpaTree();
                r.calcularChristofides();
                r.mostrarRuta();
            }
            else System.out.println("Opcion Incorrecta, vuelve a introducir una opcion");
            System.out.println("Selecciona funcion a probar");
            op = sc.nextInt();
        }
    }    
}
