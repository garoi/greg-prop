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
    private Mapa mapa;
    private String fecha;
    
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
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
     public Mapa getMapa() {
        return mapa;
    }
     
    public String getFecha() {
        return fecha;
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
    public void optimizar() {
        
    }
    
    public void mostrarRuta() {
        System.out.println("La ruta pasara por los siguientes puntos del mapa:");
        for (int i = 0; i < permutacion.length; ++i) {
            System.out.print(" " + permutacion[i]);
        }
    }
    public void acceptarRuta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Verificas la ruta. s/n");
        String ord = sc.nextLine();
        if (ord.equals("s")) {
            verificada = true;
        }
        else {
            verificada = false;
        }
    }
    
    public void crearGrafo(ArrayList<Paquete> paquetesSeleccionados, Mapa map) {
        mapa = map;
        grafo = new float[paquetesSeleccionados.size()][paquetesSeleccionados.size()];
        nombres = new String[paquetesSeleccionados.size()];
        float[][] ciudad = mapa.getCiudad();
        for (int i = 0; i < paquetesSeleccionados.size(); ++i) {
            nombres[i] = paquetesSeleccionados.get(i).getDestino();
            listaPaquetesRuta.add(paquetesSeleccionados.get(i));
            for (int j = 0; j < paquetesSeleccionados.size(); ++j){
                grafo[i][j] = ciudad[paquetesSeleccionados.get(i).getidDestino()][paquetesSeleccionados.get(j).getidDestino()];
            }
        }
    }
}
