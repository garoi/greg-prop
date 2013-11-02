package Dominio;

import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author ivich
 */
public class Operador {
    private String nombre = new String();
    private int IDenc;
    
    //DEvuelve un vector con el identificador de los destinos de los paquetes seleccionados
    public int[] SeleccionarDestinos() {
        int[] PaquetesDestino = null;
        return PaquetesDestino;
    }
    
    public void LeerOPerador(){
        System.out.println("Anadir el nombre del operador");
        Scanner sc = new Scanner(System.in);
        nombre = sc.next();
        
        
    }
    
    
    
}