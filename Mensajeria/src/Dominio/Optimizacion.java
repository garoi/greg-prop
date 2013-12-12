/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public String[] getNombres() {
        return nombres;
    }

    public void setSolucion(Integer[] solucion) {
        this.solucion = solucion;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }
    
    public void setSubgrafo(float[][] subgrafo) {
        this.subgrafo = subgrafo;
    }

    public void setComparador(float comparador) {
        this.comparador = comparador;
    }

    
    
    public float[][] getSubgrafo() {
        return subgrafo;
    }

    public float getComparador() {
        return comparador;
    }
    
    private float calculaCoste(Integer[] copia){
        float suma = 0;
        
        for (int i = 0; i < copia.length; ++i) {
            if (i + 1 < copia.length) {
                System.out.println("MUUUU " + subgrafo[copia[i]][copia[i+1]]);
                suma += subgrafo[copia[i]][copia[i+1]];
            }
            else {
                //O ES UN SOL PUNT O L'ULTIM ELEMENT
                if (solucion.length == 1) {
                    suma += subgrafo[copia[i]][copia[i]];
                }
            }
            System.out.println("suma :" + suma);
        }
        return suma;
    }
    
    private void swap(int num, int num2, Integer[] copia){
        
        
       
    }
    
    public boolean randSwap(){      
        cambio = false; 
        for(int i = 0; i < solucion.length*2 ; ++i){
            Integer[] copia;
            copia = solucion;
            int num = 0 + (int)(Math.random() * (((solucion.length-1) - 0) + 1));
            int num2 = 0 + (int)(Math.random() * (((solucion.length-1) - 0) + 1));
            System.out.println("RAND1 :" + num + "RAND2 : " + num2);

            System.out.println("COPIA1 :");
            for(int j = 0; j < copia.length; ++j){
                System.out.print(copia[j]+ " ");
            }
            System.out.println();
        
            int aux = copia[num];
            copia[num] = copia[num2];
            copia[num2] = aux;
            for(int j = 0; j < copia.length; ++j){
                System.out.print(copia[j]+ " ");
            }
            System.out.println();
            float costeNuevo = calculaCoste(copia);
            if(costeNuevo < comparador){
                System.out.println("hijosdeputa");
                cambio = true;
                comparador = costeNuevo;
                System.out.println("costenuevo : " + costeNuevo);
                System.out.println("comparador : " + comparador);
                solucion = copia;
            }
        }
        return cambio;
    }
     public void inicializa(Integer[] permutacion, String[] nombres, float[][] grafo, float costeRuta){
        setNombres(nombres);
        setSolucion(permutacion);
        setSubgrafo(grafo);
        System.out.println("cooossssteruta : " + costeRuta);
        setComparador(costeRuta);
    }
}
