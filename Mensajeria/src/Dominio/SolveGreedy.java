package Dominio;
import java.util.*;
/**
 *
 * @author Sergio
 */
public class SolveGreedy {
    /**
     * @param M Grafo completo.
     */
    private float[][] M         = new float[0][0];
    /**
     * @param PrimerVertice Vertice por el que empezamos.
     */
    private Integer PrimerVertice = 0;
    
    /**
     * Constructor que recibe M y asigna un vertice de inicio aleatorio.
     * @param M Matriz del grafo completo que contiene los pesos de las aristas.
     */
    public SolveGreedy(float[][] M){
        this.M = M;
        Random gen         = new Random(System.currentTimeMillis());
        this.PrimerVertice = Math.abs(gen.nextInt() % M[0].length);
    }
    /**
     * Constructor que recibe M y el vertice por el cual se empieza el recorrido.
     * @param M Matriz del grafo completo que contiene los pesos de las aristas.
     * @param PrimerVertice Vertice por el cual empezamos la busqueda.
     */
    public SolveGreedy(float[][]M, Integer PrimerVertice){
        this.M              = M;
        this.PrimerVertice  = PrimerVertice; 
    }
    /**
     * 
     * @return Devuelve una permutacion obtenida siguiendo el algoritmo greedy. 
     */
    Integer[] solve(){
        Integer[] ret = new Integer[ M[0].length ];
        Boolean[] vis = new Boolean[ M[0].length ];
        for(int i = 0 ; i < vis.length ; ++i) vis[i] = false;
        
        Integer v       = PrimerVertice;
        Integer perm    = 0;
        
        for(int j=0;j<M[0].length;++j){
            ret[perm++] = v;
            vis[v]  = true ;
            Integer indiceMinimo = v;
            float   costeMinimo = Float.POSITIVE_INFINITY;
            for(int i = 0; i < M[0].length ; ++i){
                if(i!=v && M[v][i] < costeMinimo && !vis[i] ){
                    indiceMinimo = i;
                    costeMinimo = M[v][i];
                }
            }
            v = indiceMinimo;
        }
        
        return ret;
    }
    /**
     * Setter para PrimerVertice
     * @param n PrimerVertice = v
     */
    void setPrimerVertice(Integer n){
        this.PrimerVertice = n;
    }  
}