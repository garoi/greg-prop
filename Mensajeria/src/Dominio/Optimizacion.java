/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author ivich
 */
public class Optimizacion {
    private float[][] subgrafo;
    private float comparador;
    private Integer[] solucion;
    private String[] nombres;

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
    
    
    public boolean pruebaOptimizar(){
        
        return true;
    }
    
    public void inicializa(Integer[] permutacion, String[] nombres, float[][] grafo, float costeRuta){
        setNombres(nombres);
        setSolucion(permutacion);
        setSubgrafo(grafo);
        setComparador(costeRuta);
    }
    
    
}
