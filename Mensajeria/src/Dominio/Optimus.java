package Dominio;
import java.util.*;
import static java.lang.Math.*;

/**
 *
 * @author Rafa, David
 */
public class Optimus {
    
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
     * Creadora vacia
     */
    Optimus(){
    }
    
    
    /**
     * Creadora de Optimus
     * @param g Grafo completo.
     * @param p Permutacion de nodos inicial.
     * @param c Coste de la permutacion actual.
     */
    public Optimus(float[][] g, Integer[] p, float c){
        this.M = g;
        this.order = p;
        this.c = c;
    }
    
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
    
    /**
     * Mejora la permutacion para el problema de TSP dado.
     * @param method Metodo que se usara para optimizar
     * @param bound Cota en el tiempo/numero de iteraciones del algoritmo (?)
     */
    public void opt(int method, int bound) 
    {
        opt(method,bound,true);
    }
    /**
     * Mejora la permutacion para el problema de TSP dado.
     * @param method Metodo que se usara para optimizar.
     * @param bound Cota en el tiempo/numero de iteraciones del algoritmo.
     * @param flag Dice si la solucion es un camino abierto (false) o cerrado (true).
     */
    public void opt(int method, int bound, boolean flag) 
    {
        
        CheckAll(method, bound, flag);
        
        switch(method){
            case 0:    RandSwap(bound, flag);
                       break;
            case 1:    BFSOpt2(bound, flag);
                       break;
            case 2:    DeepOpt2(flag);
                       break;
        }
    }
    
    //  EXCEPTION RAISERS
    //  =================
    
    /**
     * Comprueba que no haya errores en la entrada.
     */
    private void CheckAll(int m, int b, boolean f){
        /*
        CheckSquareMatrix();
        CheckDimensions();
        CheckSolutionIndex();
        CheckCostValues();
        CheckValidBoundary(m, b);
        */
    }
    
    //
    //  ALGORITMOS
    //  ==========
    //
    
    
    //  FUNCIONES USADAS POR LOS ALGORIMOS QUE SIGUEN
    //  ----------------------------------------------
    /**
     * @param node
     * @param pos
     * @param flag Dice si el grafo es un camino abierto (false) o cerrado (true).
     * @return  Dado el orden actual, el coste de tener al nodo "a" en la posicion "pos".
     */
    private float Coste(int node, int pos, boolean flag){
        float costa;
        if (pos==0){
           if (flag) costa = M[order[order.length-1]][node];
           else  costa = 0;
        }
        else costa= M[order[pos-1]][node];
        
        float costb;
        if (pos==order.length-1){
          if (flag) costb = M[node][order[0]];
          else costb = 0;
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
    private float CosteEditado(int node, int pos, boolean flag, int shadownode){
        float costa;
        if (pos==0){
           if (flag){
               if (order[order.length-1] == node) costa = M[shadownode][node];
               else costa = M[order[order.length-1]][node];
           }
           else  costa = 0;
        }
        else if (order[pos-1] == node) costa = M[shadownode][node];
        else costa= M[order[pos-1]][node];
        
        float costb;
        if (pos==order.length-1){
          if (flag){
              if (order[0] == node) costb = M[node][shadownode];
              else costb = M[node][order[0]];
          }
          else costb = 0;
        }
        else if (order[pos+1] == node) costb = M[node][shadownode];
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
    private float BuenSwap(int a, int b, boolean flag){
        float pre = Coste(order[a], a, flag)+Coste(order[b], b, flag);
        float post = CosteEditado(order[a], b, flag, order[b])+CosteEditado(order[b], a, flag, order[a]);
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
    
    /**
     * Intercambia el 'a'-esimo elemento de 'x' con el 'b'-esimo.
     * @param x
     * @param a
     * @param b 
     */
    private void Swap(Integer[] x, int a, int b){
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    
    /**
     * 
     * @param x
     * @param posa
     * @param posb
     * @param flag
     * @return Ganancia de realizar un Opt2 con las aristas que salen de posa y 
     * posb, asumiendo simetria.
     */
    private float BuenOptSim(Integer[] x, int posa, int posb, boolean flag){
        if (flag) return BuenOptSimCycle(x, posa, posb);
        else return BuenOptSimList(x, posa, posb);
    }
    
    /**
     * 
     * @param x
     * @param posa
     * @param posb
     * @return Ganancia de realizar un Opt2 con las aristas que salen de posa y 
     * posb, asumiendo simetria y que el camino es abierto.
     */
    private float BuenOptSimList(Integer[] x, int posa, int posb){
        int nexta = posa+1;        
        float pre = M[x[posa]][x[nexta]];
        float post = M[x[posa]][x[posb]];
        if (posb != x.length-1){
            int nextb = posb+1;
            pre += M[x[posb]][x[nextb]];
            post += M[x[nexta]][x[nextb]];
        }
        return pre - post;
    }
    
    /**
     * 
     * @param x
     * @param posa
     * @param posb
     * @return Ganancia de realizar un Opt2 con las aristas que salen de posa y 
     * posb, asumiendo simetria y que el camino es cerrado.
     */
    private float BuenOptSimCycle(Integer[] x, int posa, int posb){
        int nexta = posa+1; int nextb = posb+1;
        if (posb == x.length-1) nextb = 0;
        
        float pre; float post;
        pre = M[x[posa]][x[nexta]] + M[x[posb]][x[nextb]];
        post = M[x[posa]][x[posb]] + M[x[nexta]][x[nextb]];
        
        return pre - post;
    }
    
    /**
     * Invierte los elementos de 'x' entre el 'a'-esimo y el 'b'-esimo, ambos
     * inclusive.
     * @param x
     * @param a
     * @param b 
     */
    private void InvierteSim(Integer[] x, int a, int b){
        for(int i=a; i<(1+b+a)/2; ++i){
            Swap(x,i,b+a-i);
        }
    }
    
    //  RANDSWAP
    //  --------    
     
    /**
     * Cambia la permutacion por otra mejorada mediante random swaps.
     */
    private void RandSwap(int b, boolean flag){
        for(int i = 0; i < b ; ++i){
            Random gen = new Random(System.currentTimeMillis());
            int one = Math.abs(gen.nextInt() % order.length);
            int two = Math.abs(gen.nextInt() % order.length);
            float x = BuenSwap(one, two, flag);
            if ( x > 0 ){
                c -= x;
                Swap(one,two);
            }
        }
    }

    //  LOCAL BFS OPT-2
    //  ---------------
   
    /**
     * Cambia la permutacion por otra mejorada mediante una 
     * busqueda BFS de las permutaciones cercanas "buenas" usando
     * movimientos Opt-2.
     * Se usa simetria.
     */  
    private void BFSOpt2(int b, boolean flag){
       Integer[] res = new Integer[order.length];
       for(int i=0; i<order.length; i++){
           res[i] = new Integer(order[i]);
       }
       
       
       Stack<Integer[]> estados = new Stack();
       Stack<Integer> contador = new Stack();
       Stack<Float> diff = new Stack();
       Float resdiff = new Float(0);
       Set vistos = new HashSet();
       
       estados.push(res);
       contador.push(0);
       diff.push(resdiff);
       
       while(!estados.empty()){
           Integer[] x = estados.pop();
           Integer c = contador.pop();
           Float d = diff.pop();
           
           if (d < resdiff){
               resdiff = d;
               res = x;
           }
                      
           if(!vistos.contains(x) && c<(new Integer(b)) ){
               vistos.add(x);
               for (int i=0; i<order.length; ++i){
                   for (int j=i+1; j<order.length; ++j){
                       Float d2 = BuenOptSim(x, i, j, flag);
                       if( d2 > 0 ){
                           InvierteSim(x, i+1, j);
                           estados.push(x);
                           contador.push(c+1);
                           diff.push(d+d2);
                       }
                   }
               }
           }
       }
       
       for(int i=0; i<order.length; i++){
           order[i]=res[i];
       }
       c -= resdiff;
       
   }
    
    // LOCAL DEEP OPT-2
    // ----------------
    
    /**
     * Cambia la permutacion por otra mejorada mediante Opt-2 hasta que es
     * 2optima.
     * Se usa simetria.
     */
    private void DeepOpt2(boolean flag){
        Integer[] x = new Integer[order.length];
        for(int i=0; i<order.length; i++){
            x[i]=order[i];
        }
        
        boolean dirty;
        do{
            float bestdif=0;
            int besti=0;
            int bestj=0;
            for(int i=0; i<order.length; i++){
                for (int j=i+1; j<order.length; j++){
                    float d = BuenOptSim(x, i, j, flag);
                    if (d>bestdif){
                        bestdif = d;
                        besti = i;
                        bestj = j;
                    }
                }
            }
            if (bestdif>0){
                InvierteSim(x,besti+1,bestj);
                c -= bestdif;
                dirty = true;
            }
            else dirty = false;
        }while(dirty);
        
        for(int i=0; i<order.length; i++){
            order[i] = x[i];
        }
    }
    
}

