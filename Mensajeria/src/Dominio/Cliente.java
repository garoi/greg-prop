/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.util.*;

/**
 *
 * @author ivich
 */
public class Cliente {
    private int IDCliente;
    private String NombreCliente = new String();
    
    
    public void AnadirCliente(int IDCliente){
        System.out.println("Anadir el nombre del cliente");
        this.IDCliente = IDCliente;
        Scanner sc = new Scanner(System.in);
        NombreCliente = sc.next();
        
    }
    
    public void AnadirPaquete(){
        Paquete p = new Paquete();
        p.InsertarPaquete(IDCliente);
        
    }
    
}