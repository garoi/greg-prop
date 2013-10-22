package Domini;
import java.util.*;
import java.lang.System;

/**
 *
 * @author Marc Garcia Roig
 */
public class Mapa {
    private String[] Nombres;
    private int[][] Ciudad;
    
    public String[] getNombres() {
        return Nombres;
    }

    public int[][] getCiudad() {
        return Ciudad;
    }

    public void CrearCiudad(){
        System.out.println("Quants nodes hi ha?");
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        Ciudad = new int[nodes][nodes];
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
        for (int i = 0; i < Ciudad.length; ++i) {
            for (int j = 0; j < Ciudad.length; ++j) {
                System.out.print(Ciudad[i][j] + " ");
            }
            System.out.println();
        }
    }
}