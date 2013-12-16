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
    private String tipo;
    private float costeRuta;

    private ArrayList< ArrayList<Pair> > MSTK = new ArrayList<>();

    public void setMSTK(ArrayList<ArrayList<Pair>> MSTK) {
        this.MSTK = MSTK;
    }
    
    public void setPermutacion(Integer[] permutacion) {
        this.permutacion = permutacion;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public float getCosteRuta() {
        return costeRuta;
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
    
    public void rapidaOptimizada(){
        SolveGreedy sg = new SolveGreedy(grafo);
        permutacion = sg.solve();
        distanciaRuta();
        Optimizacion op = new Optimizacion();
        op.setGrafo(grafo);
        op.setPermutacion(permutacion);
        op.setCoste(costeRuta);
        op.randSwap(permutacion.length*2);
        permutacion = op.getPermutacion();
        costeRuta = op.getCoste();
    }
    
    /**
     * Calcula el arbol de expansion minima de un grafo
     * @param
     */
    public void calcularMinSpaTree() {
        System.out.println("Entro al minSpatree");
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
        if (nombres.length > 3) {
            Christofides ch = new Christofides();
            ch.setGrafo(grafo);
            ch.setNombres(nombres);
            ch.setMST(MSTK);
            Integer[] aux = ch.buscaPermutacion();
            Integer[] aux2 = new Integer[aux.length - 1];

            for (int i = 0; i < aux2.length; ++i) {
                aux2[i] = aux[i];
            }
            permutacion = aux2;
            Optimizacion op = new Optimizacion();
            distanciaRuta();
            op.setGrafo(grafo);
            op.setPermutacion(permutacion);
            op.setCoste(costeRuta);
            op.randSwap(permutacion.length*2500);
            permutacion = op.getPermutacion();
            costeRuta = op.getCoste();
        }
        else {
            SolveGreedy sg = new SolveGreedy(grafo);
            permutacion = sg.solve();
        }
    }
    
    public void distanciaRuta() {
        System.out.println("la primera permu es");
        for(int i = 0; i < permutacion.length; ++i) {
            System.out.print(permutacion[i] + " ");
        }
        System.out.println("");
        float suma = 0;
        for (int i = 0; i < permutacion.length; ++i) {
            if (i + 1 < permutacion.length) {
                suma += grafo[permutacion[i]][permutacion[i+1]];
            }
            else {
                //O ES UN SOL PUNT O L'ULTIM ELEMENT
                if (permutacion.length == 1) {
                    suma += grafo[permutacion[i]][permutacion[i]];
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
        ArrayList<ArrayList<Float>> ciudads = mapa.getCiudad();
        for (int i = 0; i < paquetesSeleccionados.size(); ++i) {
            nombres[i] = paquetesSeleccionados.get(i).getDestino();
            listaPaquetesRuta.add(paquetesSeleccionados.get(i));
            for (int j = 0; j < paquetesSeleccionados.size(); ++j){
                grafo[i][j] = mapa.getD(paquetesSeleccionados.get(i).getIdDestino(), paquetesSeleccionados.get(j).getIdDestino());
            }
        }
        System.out.println("Imprimir el grafo");
        for (int i = 0; i < grafo.length; ++i) {
            for (int j = 0; j < grafo.length;++j) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void crearGrafoMod(Mapa map) {
        mapa = map; 
        Integer[] idNombres = encontrarIdNombres();
        if (grafo != null) grafo = null;
        grafo = new float[nombres.length][nombres.length];
        ArrayList<ArrayList<Float>> ciudad = mapa.getCiudad();
        for (int i = 0; i < nombres.length; ++i) {
            for (int j = 0; j < nombres.length; ++j){
                grafo[i][j] = mapa.getD(idNombres[i], idNombres[j]);
            }
        }
        setPermutacion(idNombres);
        distanciaRuta();
    }
    
    private Integer[] encontrarIdNombres() {
        Integer[] idNombres = new Integer[nombres.length];
        ArrayList<String> nombres1 = mapa.getNombres();
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; ++i) {
            for (int j = 0; !encontrado; ++j) {
                if (nombres1.get(j).equals(nombres[i])) {
                    idNombres[i] = j;
                    encontrado = true;
                }
            }
            encontrado = false;
        }
        return idNombres;
    }
}
