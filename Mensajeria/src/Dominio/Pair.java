package Dominio;

import java.io.Serializable;

/**
 *
 * @author Marc Garcia Roig
 */
public class Pair implements Serializable{
    private static final long serialVersionUID = 9040177911315386368L;
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
