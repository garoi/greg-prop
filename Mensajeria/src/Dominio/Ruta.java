package Dominio;
import static java.lang.Double.POSITIVE_INFINITY;
import java.util.*;
import java.lang.System;
/**
 *
 * @author Marc Garcia Roig
 */
public class Ruta {
    Mapa m = new Mapa();
    private String[] nombresSubgrafo;
    private float[][] subgrafo;

    ArrayList< ArrayList<Pair> > MSTK = new ArrayList<>();
    
    //Modificadoras

    public String[] getNombresSubgrafo() {
        return nombresSubgrafo;
    }

    public float[][] getSubgrafo() {
        return subgrafo;
    }
    
    public void setNombresSubgrafo(String[] nombresSubgrafo) {
        this.nombresSubgrafo = nombresSubgrafo;
    }

    public void setSubgrafo(float[][] subgrafo) {
        this.subgrafo = subgrafo;
    }
    
    private ArrayList< ArrayList<Pair> > ReconvertirArbol(float[][] arbol){
        ArrayList< ArrayList<Pair> > mstkaux = new ArrayList<>();
        for (int j = 0; j < arbol.length; ++j) {
            ArrayList<Pair> v = new ArrayList<Pair>();
            for (int i = 0; i < arbol.length; ++i) {
                if (arbol[i][j] != POSITIVE_INFINITY) {
                    v.add(new Pair(i, arbol[i][j]));
                }
            }
            mstkaux.add(v);
        }
        return mstkaux;
    }
    
    /**
     *Devuelve un arbol de expancion minima
     */
    public ArrayList< ArrayList<Pair> > MST() {
        int numeroNodos = subgrafo.length;
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
                    if (min > subgrafo[i][j] && pertenece[i] != pertenece[j]) {
                        min = subgrafo[i][j];
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
        for (int j = 0; j < numeroNodos; ++j) {
            for (int i = 0; i < numeroNodos; ++i) {
                System.out.print(arbol[i][j] + " ");
            }
            System.out.println();
        }
        MSTK = ReconvertirArbol(arbol);
        for (int i = 0; i < arbol.length; ++i) {
            System.out.println("EL INDICE ES: " + i + " Y su tamaño es " + MSTK.get(i).size());
            for (int j = 0; j < MSTK.get(i).size(); ++j) {
                System.out.println(MSTK.get(i).get(j).first() + " " + MSTK.get(i).get(j).second());
            }
        }
        return MSTK;
    }

}
