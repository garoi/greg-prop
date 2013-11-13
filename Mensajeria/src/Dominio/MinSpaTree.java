package Dominio;

import static java.lang.Double.POSITIVE_INFINITY;
import java.util.ArrayList;

/**
 *
 * @author Marc Garcia Roig
 */
public class MinSpaTree {
    private String[] nombres;
    private float[][] grafo;
    
    ArrayList< ArrayList<Pair> > MSTK = new ArrayList<>();
    
    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public float[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(float[][] grafo) {
        this.grafo = grafo;
    }
    
    private void reconvertirArbol(float[][] arbol){
        for (int j = 0; j < arbol.length; ++j) {
            ArrayList<Pair> v = new ArrayList<Pair>();
            for (int i = 0; i < arbol.length; ++i) {
                if (arbol[i][j] != POSITIVE_INFINITY) {
                    v.add(new Pair(i, arbol[i][j]));
                }
            }
            MSTK.add(v);
        }
    }
    
    /**
     *Devuelve un arbol de expancion minima
     */
    public ArrayList< ArrayList<Pair> > MST() {
        int numeroNodos = grafo.length;
        int[] pertenece = new int[numeroNodos];
        float[][] arbol = new float[numeroNodos][numeroNodos];
        
        for (int i = 0; i < numeroNodos; ++i) {
            pertenece[i] = i;
            for (int j = 0; j < numeroNodos; ++j) {
                arbol[i][j] = (float) POSITIVE_INFINITY;
            }
        }
        int nodoA, nodoB;
        nodoA = nodoB = (int)POSITIVE_INFINITY;
        int arcos = 1;
        while (arcos < numeroNodos) {
            float min = (float)POSITIVE_INFINITY;
            for (int i = 0; i < numeroNodos; ++i) {
                for (int j = 0; j < numeroNodos; ++j) {
                    if (min > grafo[i][j] && pertenece[i] != pertenece[j]) {
                        min = grafo[i][j];
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
                for(int k = 0; k < numeroNodos; k++) {
                    if(pertenece[k] == temp) {
                        pertenece[k] = pertenece[nodoA];
                    }
                }
                arcos++;
            }
        }
        reconvertirArbol(arbol);
        return MSTK;
    }
}