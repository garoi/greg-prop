package Dominio;

import java.util.*;
import static java.lang.Math.*;
/**
 *
 * @author ivich
 */
public class Optimizacion {
    private float[][] subgrafo;
    private float comparador;
    private Integer[] solucion;
    private String[] nombres;
    private Integer[][] hijosTotales;
    private boolean cambio;
    
    public Integer[] getSolucion() {
        return solucion;
    }

    private String[] getNombres() {
        return nombres;
    }

    private void setSolucion(Integer[] solucion) {
        this.solucion = solucion;
    }

    private void setNombres(String[] nombres) {
        this.nombres = nombres;
    }
    
    private void setSubgrafo(float[][] subgrafo) {
        this.subgrafo = subgrafo;
    }

    private void setComparador(float comparador) {
        this.comparador = comparador;
    }

    
    
    private float[][] getSubgrafo() {
        return subgrafo;
    }

    public float getComparador() {
        return comparador;
    }
    
    private float calculaCoste(Integer[] copia){
        float suma = 0;
        
        for (int i = 0; i < copia.length; ++i) {
            if (i + 1 < copia.length) {
                suma += subgrafo[copia[i]][copia[i+1]];
            }
            else {
                //O ES UN SOL PUNT O L'ULTIM ELEMENT
                if (solucion.length == 1) {
                    suma += subgrafo[copia[i]][copia[i]];
                }
            }
        }
        return suma;
    }
    
    public boolean randSwap(){      
        cambio = false; 
        for(int i = 0; i < solucion.length*2 ; ++i){
            Integer[] copia;
            copia = solucion;
            int num = 0 + (int)(Math.random() * (((solucion.length-1) - 0) + 1));
            int num2 = 0 + (int)(Math.random() * (((solucion.length-1) - 0) + 1));        
            int aux = copia[num];
            copia[num] = copia[num2];
            copia[num2] = aux;
            float costeNuevo = calculaCoste(copia);
            if(costeNuevo < comparador){
                cambio = true;
                comparador = costeNuevo;
                solucion = copia;
            }
        }
        return cambio;
    }
    
     public void inicializa(Integer[] permutacion, String[] nombres, float[][] grafo, float costeRuta){
        setNombres(nombres);
        setSolucion(permutacion);
        setSubgrafo(grafo);
        setComparador(costeRuta);
    }
}