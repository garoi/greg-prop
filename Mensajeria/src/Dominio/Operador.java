package Dominio;

import java.util.*;

/**
 *
 * @author ivich
 */
public class Operador {
    private String nombre = new String();
    private int IDenc;
    
    
    public void LeerOPerador(){
        System.out.println("Anadir el nombre del operador");
        Scanner sc = new Scanner(System.in);
        nombre = sc.next();
        
        
    }
    
    
    
}