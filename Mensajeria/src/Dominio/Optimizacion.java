package Dominio;
import java.util.*;

/**
 *
 * @author David
 */
public class Optimizacion {
    
    //  GLOBAL
    //  ======
    
    /**
     * @param M Grafo completo.
     */
    private float[][] M         = new float[0][0];
    
    /**
     * @param permutacion Permutacion de los nodos.
     */
    private Integer[] order = new Integer[0];
    
    /**
     * @param c Coste de la permutacion actual.
     */
    private float c;
    
    /**
     * Setter del grafo
     * @param M Matriz de costes del grafo completo.
     */
    public void setM(float[][] M) {
        this.M = M;
    }
    
    /**
     * Setter de permutacion
     * @param permutacion Permutacion inicial a mejorar.
     */
    public void setPermutacion(Integer[] permutacion) {
        this.order = permutacion;
    }
    
    /**
     * 
     * @return Devuelve el valor de la permutacion.
     */
    public Integer[] getPermutacion(){
        return order;
    }
    
    /**
     * 
     * @return Devuelve el coste de la permutacion.
     */
    public float cost(){
        return c;
    }
    private float Coste(int node, int pos){
        float costa;
        if (pos==0){
            costa = 0;
        }
        else costa= M[order[pos-1]][node];
        
        float costb;
        if (pos==order.length-1){
            costb = 0;
        }
        else costb= M[node][order[pos+1]];
       
        return costa + costb;
    }
    
    /**
     * 
     * @param node
     * @param pos
     * @param flag Dice si el grafo es un camino abierto (false) o cerrado (true).
     * @param shadownode
     * @return Dado un swap de node con shadownode sobre el orden actual, el coste de 
     * tener al nodo "a" en la posicion "pos".
     */
    private float CosteEditado(int node, int pos,int shadownode){
        float costa;
        if (pos==0){
           costa = 0;
        }
        if (order[pos-1] == node) costa = M[shadownode][node];
        else costa= M[order[pos-1]][node];
        
        float costb;
        if (pos==order.length-1){
              costb = 0;
        }
        if (order[pos+1] == node) costb = M[node][shadownode];
        else costb= M[node][order[pos+1]];
       
        return costa + costb;
    }
    
    /**
     * 
     * @param a
     * @param b
     * @param flag
     * @return Ganancia entre el estado anterior y el resultante de cambiar 'a' por 'b'.
     */
    private float BuenSwap(int a, int b){
        float pre = Coste(order[a], a)+Coste(order[b], b);
        float post = CosteEditado(order[a], b, order[b])+CosteEditado(order[b], a,order[a]);
        return pre - post;
    }
    
    /**
     * Intercambia el 'a'-esimo elemento de 'order' con el 'b'-esimo.
     * @param a
     * @param b 
     */
    private void Swap(int a, int b){
        int temp = order[a];
        order[a] = order[b];
        order[b] = temp;
    }
    //  RANDSWAP
    //  --------    
     
    /**
     * Cambia la permutacion por otra mejorada mediante random swaps.
     */
    public void RandSwap(int b){
        for(int i = 0; i < b ; ++i){
            Random gen = new Random(System.currentTimeMillis());
            int one = Math.abs(gen.nextInt() % order.length);
            int two = Math.abs(gen.nextInt() % order.length);
            float x = BuenSwap(one, two);
            if ( x > 0 ){
                c -= x;
                Swap(one,two);
            }
        }
    }
}