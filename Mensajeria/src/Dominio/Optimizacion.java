package Dominio;
import java.util.*;

/**
 *
 * @author Albert Gili Zaragoza 
 */
public class Optimizacion {
    private float[][] grafo = new float[0][0];
    private Integer[] permutacion = new Integer[0];
    private float coste;

    public float[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(float[][] grafo) {
        this.grafo = grafo;
    }

    public Integer[] getPermutacion() {
        return permutacion;
    }

    public void setPermutacion(Integer[] permutacion) {
        this.permutacion = permutacion;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }
    
    private float calculaCoste(Integer[] copia){
        float suma = 0;
        for (int i = 0; i < copia.length; ++i) {
            if (i + 1 < copia.length) {
                suma += grafo[copia[i]][copia[i+1]];
            }
            else {
                //O ES UN SOL PUNT O L'ULTIM ELEMENT
                if (copia.length == 1) {
                    suma += grafo[copia[i]][copia[i]];
                }
            }
        }
        return suma;
    }
    
    private void intercanvia(int num, int num2){
        Integer copia[] = permutacion.clone();
        int aux = permutacion[num];
        copia[num] = copia[num2];
        copia[num2] = aux;        
        float test = calculaCoste(copia);
        if(test < coste){
            permutacion = copia.clone();
            coste = test;
        }
    }
    public void randSwap(int numIteraciones){
        for(int i= 0; i < numIteraciones; ++i){
            int num = 0 + (int)(Math.random() * (((permutacion.length-1) - 0) + 1));
            int num2 = 0 + (int)(Math.random() * (((permutacion.length-1) - 0) + 1));
            intercanvia(num, num2);
        }
    }
}