package Dominio;

import java.io.Serializable;

/**
 *
 * @author Marc Garcia Roig
 */
public class Pair implements Serializable{
    int first;
    float second;
    
    /**
     * 
     * @param a
     * @param b 
     */
    public Pair(int a, float b) {
        first = a; 
        second = b;
    }
    
    /**
     * Consultora del primer elemento del pair
     * @return first
     */
    public int first() {
        return first;
    }
    
    /**
     * Consultora del segundo elemento del pair
     * @return second
     */
    public float second() {
        return second;
    }
}
