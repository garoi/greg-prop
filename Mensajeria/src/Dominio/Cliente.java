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
        for(int i = 0; i < ListaPaquetes.size();++i){
            System.out.print("IDpaquete"+ListaPaquetes.get(i).getIDPaquete() + " ");
            System.out.print("Destino"+ListaPaquetes.get(i).getDestino()+ " ");
            System.out.println("Estado"+ListaPaquetes.get(i).getEstado()+ " ");
            
        }
    }
    
    public String getPass(){
        return password;
    }
    
    public int getIDCliente(){
        return IDCliente;
    }
    
    public String getNombre(){
        return NombreCliente;
    }
    
}