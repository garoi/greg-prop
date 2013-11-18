/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.ArrayList;

/**
 *
 * @author marc
 */
class Christofides {

  
    
    private String[] nombres;
    private float[][] grafo;
    private Integer[] permutacion;

    
    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public void setGrafo(float[][] grafo) {
        this.grafo = grafo;
    }

    public void setPermutacion(Integer[] permutacion) {
        this.permutacion = permutacion;
    }
    
    public Integer[] buscaPermutacion() {
        SolveGreedy sg = new SolveGreedy(grafo);
        permutacion = sg.solve();
        return permutacion;
    }
    
}
