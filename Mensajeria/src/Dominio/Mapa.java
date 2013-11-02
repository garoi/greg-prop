package Dominio;
import java.io.Serializable;
import java.util.*;
import java.lang.System;

/**
 *
 * @author Marc Garcia Roig
 */
public class Mapa implements Serializable {
    private String[] Nombres;
    private float[][] Ciudad;

    
    public String[] getNombres() {
        return Nombres;
    }

    public float[][] getCiudad() {
        return Ciudad;
    }

    public void CrearCiudad(){
        System.out.println("Quants nodes hi ha?");
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        Ciudad = new float[nodes][nodes];
        Nombres = new String[nodes];
        for (int i = 0; i < nodes; ++i) {
            System.out.println("Entra el nom del node " + (i+1));
            String NombreNodo = sc.next();
            Nombres[i] = NombreNodo;
            System.out.println("Ara les distancies dels node [0....inf]");
            for (int j = 0; j < nodes; ++j) {
                Ciudad[i][j] = sc.nextInt();
            }
        }  
    }
    

    public void ImprimirCiudad() {
        System.out.println("la ciutat es " + Ciudad.length);
        for (int j = 0; j < Ciudad.length; ++j) {
            for (int i = 0; i < Ciudad.length; ++i) {
                System.out.print(Ciudad[i][j] + " ");
            }
            System.out.println();
        }
    }
}