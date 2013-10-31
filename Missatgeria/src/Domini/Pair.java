/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

/**
 *
 * @author marc
 */
public class Pair {
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
