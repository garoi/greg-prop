package Dominio;

import java.io.Serializable;

/**
 *
 * @author marc
 */
public class Pair implements Serializable{
    private int first;
    private float second;
    
    public Pair(int a, float b) {
        first = a; 
        second = b;
    }
    public int first() {
        return first;
    }
    
    public float second() {
        return second;
    }
}
