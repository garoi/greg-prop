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
    private String[] NombresSubgrafo;
    private float[][] Subgrafo;

    ArrayList< ArrayList<Pair> > MSTK = new ArrayList<>();
    
    //CREADORA
    public Ruta(float[][] Subgrafo, String[] NombresSubgrafo) {
        this.NombresSubgrafo = NombresSubgrafo; 
        this.Subgrafo = Subgrafo;
    }
    //CONSULTORAS
    public String[] getNombresSubgrafo() {
        return NombresSubgrafo;
    }

    public float[][] getSubgrafo() {
        return Subgrafo;
    }
    
    public void CrearSubgrafo() {      
        m.CrearCiudad();
        Subgrafo = m.getCiudad();
        NombresSubgrafo = m.getNombres();
    }
    
    public void ImprimirSubgrafo() {
        m.ImprimirCiudad();
        MST();
    }
    
    private ArrayList< ArrayList<Pair> > ReconvertirArbol(float[][] arbol){
        ArrayList< ArrayList<Pair> > MSTKaux = new ArrayList<>();
        for (int j = 0; j < arbol.length; ++j) {
            ArrayList<Pair> v = new ArrayList<Pair>();
            for (int i = 0; i < arbol.length; ++i) {
                if (arbol[i][j] != POSITIVE_INFINITY) {
                    v.add(new Pair(i, arbol[i][j]));
                }
            }
            MSTKaux.add(v);
        }
        return MSTKaux;
    }
    
    /**
     *Devuelve un arbol de expancion minima
     */
    public void MST() {
        int NumeroNodos = Subgrafo.length;
        int[] pertenece = new int[NumeroNodos];
        float[][] arbol = new float[NumeroNodos][NumeroNodos];
        
        for (int i = 0; i < NumeroNodos; ++i) {
            pertenece[i] = i;
            for (int j = 0; j < NumeroNodos; ++j) {
                arbol[i][j] = (float) POSITIVE_INFINITY;
            }
        }
        int nodoA, nodoB;
        nodoA = nodoB = (int)POSITIVE_INFINITY;
        int arcos = 1;
        while (arcos < NumeroNodos) {
            float min = (float)POSITIVE_INFINITY;
            for (int i = 0; i < NumeroNodos; ++i) {
                for (int j = 0; j < NumeroNodos; ++j) {
                    if (min > Subgrafo[i][j] && pertenece[i] != pertenece[j]) {
                        min = Subgrafo[i][j];
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
        MSTK = ReconvertirArbol(arbol);
        for (int i = 0; i < arbol.length; ++i) {
            System.out.println("EL INDICE ES: " + i + " Y su tamaño es " + MSTK.get(i).size());
            for (int j = 0; j < MSTK.get(i).size(); ++j) {
                System.out.println(MSTK.get(i).get(j).first() + " " + MSTK.get(i).get(j).second());
            }
        }
    }

}
