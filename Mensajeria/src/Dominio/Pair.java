package Dominio;

import java.io.Serializable;

/**
 *
 * @author marc
 */
public class Pair implements Serializable{
    private int first;
    private float second;
    
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
     * 
     * @return first
     */
    public int first() {
        return first;
    }
    
    /**
     * 
     * @return second
     */
    public float second() {
        return second;
    }
}
