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
    private Integer[] permutacion;
    private ArrayList<Paquete> listaPaquetesRuta = new ArrayList <>();
    private boolean verificada;
    
    ArrayList< ArrayList<Pair> > MSTK = new ArrayList<>();
    
    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }
    
    public void setGrafo(float[][] grafo) {
        this.grafo = grafo;
    }
    
    public void setListaPaquetesRuta(ArrayList<Paquete> listaPaquetesRuta) {
        this.listaPaquetesRuta = listaPaquetesRuta;
    }
    
    public void setVerificada(boolean verificada) {
        this.verificada = verificada;
    }

    public float[][] getGrafo() {
        return grafo;
    }
    
    public String[] getNombres() {
        return nombres;
    }
    
    public Integer[] getPermutacion() {
        return permutacion;
    }
    
    public ArrayList<Paquete> getListaPaquetesRuta() {
        return listaPaquetesRuta;
    }

    public boolean isVerificada() {
        return verificada;
    }
    
    public void calcularRapida() {
        SolveGreedy sg = new SolveGreedy(grafo);
        permutacion = sg.solve();
    }
    
    public void calcularMinSpaTree() {
        MinSpaTree mst = new MinSpaTree();
        mst.setGrafo(grafo);
        mst.setNombres(nombres);
        MSTK = mst.MST();
    }
    public void calcularChristofides() {
        Christofides ch = new Christofides();
        ch.setGrafo(grafo);
        ch.setNombres(nombres);
        ch.setMST(MSTK);
        permutacion = ch.buscaPermutacion();
    }
}
