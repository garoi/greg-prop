package Dominio;
import java.io.Serializable;
import java.util.*;
import java.lang.System;

/**
 *
 * @author Marc Garcia Roig
 */
public class Mapa implements Serializable {
    private String[] nombres;
    private float[][] ciudad;

    
    public String[] getNombres() {
        return nombres;
    }

    public float[][] getCiudad() {
        return ciudad;
    }

    public void CrearCiudad(){
        System.out.println("Quants nodes hi ha?");
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        ciudad = new float[nodes][nodes];
        nombres = new String[nodes];
        for (int i = 0; i < nodes; ++i) {
            System.out.println("Entra el nom del node " + (i+1));
            String nombreNodo = sc.next();
            nombres[i] = nombreNodo;
            System.out.println("Ara les distancies dels node [0....inf]");
            for (int j = 0; j < nodes; ++j) {
                ciudad[i][j] = sc.nextInt();
            }
        }  
    }
    

    public void ImprimirCiudad() {
        System.out.println("la ciutat es " + ciudad.length);
        for (int j = 0; j < ciudad.length; ++j) {
            for (int i = 0; i < ciudad.length; ++i) {
                System.out.print(ciudad[i][j] + " ");
            }
            System.out.println();
        }
    }
}