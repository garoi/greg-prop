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
    
    /**
     * 
     * @return nombres
     */
    private String[] getNombres() {
        return nombres;
    }

    /**
     * 
     * @param nombres 
     */
    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    /**
     * 
     * @return grafo
     */
    private float[][] getGrafo() {
        return grafo;
    }

    /**
     * 
     * @param grafo 
     */
    public void setGrafo(float[][] grafo) {
        this.grafo = grafo;
    }
    
    /**
     * Pasa el arbol de recobrimiento minimo, que esta en forma de matriz 
     * a una estructura de ArrayList de ArrayList
     * @param arbol 
     * 
     */
    private void reconvertirArbol(float[][] arbol){
        for (int j = 0; j < arbol.length; ++j) {
            ArrayList<Pair> v = new ArrayList<Pair>();
            for (int i = 0; i < arbol.length; ++i) {
                if (arbol[i][j] != POSITIVE_INFINITY && i != j) {
                    v.add(new Pair(i, arbol[i][j]));
                }
            }
            MSTK.add(v);
        }
    }
    
    /**
     *Devuelve un arbol de recubrimiento minimo
     * @param
     */
    public ArrayList< ArrayList<Pair> > MST() {
        int numeroNodos = grafo.length;
        // indica a que árbol pertenece el nodo para poder hacer los subconjuntos
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
        //Buscamos la arista mas pequena, nos tenemos que asegurar que no forme un ciclo
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
            //Empezamos a unir las aristas
            if (pertenece[nodoA] != pertenece[nodoB]) {
                arbol[nodoA][nodoB] = min;
                arbol[nodoB][nodoA] = min;
                int temp = pertenece[nodoB];
                pertenece[nodoB] = pertenece[nodoA];
                //Unimos las aristas y nodos que faltan.
                for(int k = 0; k < numeroNodos; k++) {
                    if(pertenece[k] == temp) {
                        pertenece[k] = pertenece[nodoA];
                    }
                }
                arcos++;
            }
        }
        
        /*Passamos de una matriz a una arraylist y 
        quitamos todas las posiciones que son vacias
        asi como nodos que llevan a ellos mismos*/
        reconvertirArbol(arbol);
        return MSTK;
    }
}