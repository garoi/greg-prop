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
    private String password;
    private String NombreCliente;;
     ArrayList<Paquete> ListaPaquetes = new ArrayList<Paquete>();
    
     
    public void LeerCliente(Cliente cl, int IDCliente){
        System.out.println("Anadir el nombre del cliente");
        Scanner sc = new Scanner(System.in);
        NombreCliente = sc.next();
        System.out.println("Anadir el password del cliente");
        password = sc.next();
        this.IDCliente = IDCliente;
    }
    
    public void AnadePaquete(Paquete p){
        ListaPaquetes.add(p);
        
    }
    
    public void Ver_Lista(){
        ListaPaquetes lp = new ListaPaquetes();
        lp.PacksClient(IDCliente);
    }
    
    public String getPass(){
        return password;
    }
    
}