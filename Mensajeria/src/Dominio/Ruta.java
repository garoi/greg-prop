package Dominio;
import java.io.Serializable;
import java.util.*;
import java.lang.System;
/**
 *
 * @author Marc Garcia Roig
 */
public class Ruta implements Serializable {
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
    
    public Integer[] calcularRapida() {
        SolveGreedy sg = new SolveGreedy(grafo);
        Integer[] rutaRapida = sg.solve();
        return rutaRapida;
    }
    
    public void calcularMinSpaTree() {
        MinSpaTree mst = new MinSpaTree();
        mst.setGrafo(grafo);
        mst.setNombres(nombres);
        MSTK = mst.MST();
    }
    public Integer[] calcularChristofides() {
        Christofides ch = new Christofides();
        ch.setGrafo(grafo);
        ch.setNombres(nombres);
        ch.setMST(MSTK);
        return ch.buscaPermutacion();
    }
}
