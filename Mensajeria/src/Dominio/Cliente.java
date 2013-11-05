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
     ArrayList<Paquete> ListaPaquetes = new ArrayList<Paquete>();
    
     
    public void AnadirCliente(int IDCliente){
        System.out.println("Anadir el nombre del cliente");
        this.IDCliente = IDCliente;
        Scanner sc = new Scanner(System.in);
        NombreCliente = sc.next();
        
    }
    
    public void AnadePaquete(Paquete p){
        ListaPaquetes.add(p);
        
    }
    public void Ver_Lista(){
        ListaPaquetes lp = new ListaPaquetes();
        lp.PacksClient(IDCliente);
    }
    
}