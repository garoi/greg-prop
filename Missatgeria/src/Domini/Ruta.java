package Domini;
import static java.lang.Double.POSITIVE_INFINITY;
import java.util.*;
import java.lang.System;
/**
 *
 * @author Marc Garcia Roig
 */
public class Ruta {
    Mapa m = new Mapa();
    private String[] Nombres;
    private int[][] Ciudad;
    
    public String[] getNombres() {
        return Nombres;
    }

    public int[][] getCiudad() {
        return Ciudad;
    }
    
    public void CrearCiudad() {
        m.CrearCiudad();
        Ciudad = m.getCiudad();
        Nombres = m.getNombres();
    }
    
    public void ImprimirCiudad() {
        m.ImprimirCiudad();
        MST();
    }
    
    /**
     *Devuelve un arbol de expancion minima
     */
    public void MST() {
        int NumeroNodos = Ciudad.length;
        int[] pertenece = new int[NumeroNodos];
        double[][] arbol = new double[NumeroNodos][NumeroNodos];
        
        for (int i = 0; i < NumeroNodos; ++i) {
            pertenece[i] = i;
            for (int j = 0; j < NumeroNodos; ++j) {
                arbol[i][j] = POSITIVE_INFINITY;
            }
        }
        int nodoA, nodoB;
        nodoA = nodoB = (int)POSITIVE_INFINITY;
        int arcos = 1;
        while (arcos < NumeroNodos) {
            int min = (int)POSITIVE_INFINITY;
            for (int i = 0; i < NumeroNodos; ++i) {
                for (int j = 0; j < NumeroNodos; ++j) {
                    if (min > Ciudad[i][j] && pertenece[i] != pertenece[j]) {
                        min = Ciudad[i][j];
                        nodoA = i;
                        nodoB = j;
                    }
                    if (j == i) arbol[i][j] = arbol[j][i] = 0;
                }
            }
            if (pertenece[nodoA] != pertenece[nodoB]) {
                arbol[nodoA][nodoB] = min;
                arbol[nodoB][nodoA] = min;
                int temp = pertenece[nodoB];
                pertenece[nodoB] = pertenece[nodoA];
                for(int k = 0; k < NumeroNodos; k++) {
                    if(pertenece[k] == temp) {
                        pertenece[k] = pertenece[nodoA];
                    }
                }
                arcos++;
            }
        }
        for (int j = 0; j < NumeroNodos; ++j) {
            for (int i = 0; i < NumeroNodos; ++i) {
                System.out.print(arbol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
