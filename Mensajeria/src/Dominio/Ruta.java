package Dominio;
import java.io.Serializable;
import java.util.*;
import java.lang.System;
/**
 *
 * @author Marc Garcia Roig
 */
public class Ruta implements Serializable {
    private static final long serialVersionUID = 9040177911315386368L;
    private String[] nombres;
    private float[][] grafo;
    private Integer[] permutacion;
    private ArrayList<Paquete> listaPaquetesRuta = new ArrayList<>();
    private boolean verificada = false;
    private Mapa mapa;
    private String fecha;
    private String turno;
    private float costeRuta;

    private ArrayList< ArrayList<Pair> > MSTK = new ArrayList<>();

    public void setMSTK(ArrayList<ArrayList<Pair>> MSTK) {
        this.MSTK = MSTK;
    }
    

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
     * @param grafo 
     */
    public void setGrafo(float[][] grafo) {
        this.grafo = grafo;
    }
    
    /**
     * 
     * @param listaPaquetesRuta 
     */
    public void setListaPaquetesRuta(ArrayList<Paquete> listaPaquetesRuta) {
        this.listaPaquetesRuta = listaPaquetesRuta;
    }
    
    /**
     * 
     * @param verificada 
     */
    public void setVerificada(boolean verificada) {
        this.verificada = verificada;
    }
    
    /**
     * 
     * @param fecha 
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * @return grafo
     */
    public float[][] getGrafo() {
        return grafo;
    }
    
    /**
     * 
     * @return nombres
     */
    public String[] getNombres() {
        return nombres;
    }
    
    /**
     * 
     * @return permutacion
     */
    public Integer[] getPermutacion() {
        return permutacion;
    }
    
    /**
     * 
     * @return listaPaquetesRuta
     */
    public ArrayList<Paquete> getListaPaquetesRuta() {
        return listaPaquetesRuta;
    }

    /**
     * 
     * @return verificada
     */
    public boolean isVerificada() {
        return verificada;
    }
    
    /**
     * 
     * @return mapa
     */
     public Mapa getMapa() {
        return mapa;
    }
     
    /**
     * 
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }
    
    /**
     * Calcula una ruta de entrega con el algoritmo rapido
     * @param
     */
    public void calcularRapida() {
        SolveGreedy sg = new SolveGreedy(grafo);
        permutacion = sg.solve();
    }
    
    /**
     * Calcula el arbol de expansion minima de un grafo
     * @param
     */
    public void calcularMinSpaTree() {
        MinSpaTree mst = new MinSpaTree();
        mst.setGrafo(grafo);
        mst.setNombres(nombres);
        MSTK = mst.MST();
    }
    
    /**
     * Ejecuta el algoritmo de Christofides
     * @param
     */
    public void calcularChristofides() {
        Christofides ch = new Christofides();
        ch.setGrafo(grafo);
        ch.setNombres(nombres);
        ch.setMST(MSTK);
        permutacion = ch.buscaPermutacion();
    }
    
    /**
     * Optimiza la ruta encontrada
     */
    public void optimizar() {
        
    }
    
    /**
     * Muestra los puntos del mapa por donde pasara la ruta
     * @param
     */
    public void mostrarRuta() {
        System.out.println("La ruta pasara por los siguientes puntos del mapa:");
        for (int i = 0; i < permutacion.length; ++i) {
            System.out.print(" " + nombres[permutacion[i]]);
        }
        System.out.println();
    }
    
    public void distanciaRuta() {
        int suma = 0;
        for (int i = 0; i < permutacion.length; ++i) {
            if (i + 1 < permutacion.length) {
                suma += grafo[i][i+1];
            }
            else {
                //O ES UN SOL PUNT O L'ULTIM ELEMENT
                if (permutacion.length == 1) {
                    suma += grafo[i][i];
                }
            }
        }
        costeRuta = suma;
    }
    
    /**
     * Verifica una ruta
     * @param
     */
    public void acceptarRuta() {
        verificada = true;
    }
    
    /**
     * Crea un subgrafo del mapa de los puntos por donde 
     * tendra que recoger los paquetes
     * @param paquetesSeleccionados
     * @param map
     * 
     */
    public void crearGrafo(ArrayList<Paquete> paquetesSeleccionados, Mapa map) {
        mapa = map; 
        if (listaPaquetesRuta != null) listaPaquetesRuta = new ArrayList <>();
        if (grafo != null) grafo = null;
        grafo = new float[paquetesSeleccionados.size()][paquetesSeleccionados.size()];
        if (nombres != null) nombres = null;
        nombres = new String[paquetesSeleccionados.size()];
        ArrayList<ArrayList<Float>> ciudad = mapa.getCiudad();
        for (int i = 0; i < paquetesSeleccionados.size(); ++i) {
            nombres[i] = paquetesSeleccionados.get(i).getDestino();
            listaPaquetesRuta.add(paquetesSeleccionados.get(i));
            for (int j = 0; j < paquetesSeleccionados.size(); ++j){
                // Ahora se accede de esta manera a las distancias.
                grafo[i][j] = mapa.getD(paquetesSeleccionados.get(i).getIdDestino(), paquetesSeleccionados.get(j).getIdDestino());
            }
        }
    }
}
