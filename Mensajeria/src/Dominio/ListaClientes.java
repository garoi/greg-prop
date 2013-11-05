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
public class ListaClientes {
    //public int IDcliente = 0;
    ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();
    
    
    public void AnadirCliente(Cliente c){
        ListaClientes.add(c);
    }
    
    public void AnadirPaquete(Paquete p, int IDclient){
        Cliente c = ListaClientes.get(IDclient);
        c.AnadePaquete(p);
    
    }
    
    public void LeerCliente(){
        
    }
    
    public boolean EncontrarCliente(String nombre){
        for(int i = 0; i < ListaClientes.size(); ++i){
            if(ListaClientes.get(i).getNombre().equals(nombre)){
                System.out.println("nombre cliente es "+ ListaClientes.get(i).getNombre());
                return true;
                
            }
        }
        System.out.println("no he encontrao una mierda");
        return false;
    }
    
    public Cliente getClient(String nombre){
        for(int i = 0; i < ListaClientes.size(); ++i){
            if(ListaClientes.get(i).getNombre().equals(nombre)) return ListaClientes.get(i);
        }
         return null;
    }
    
    public void PacksClient(int IDCliente){
        Cliente c = ListaClientes.get(IDCliente);
        c.Ver_Lista();
        
    
    }
       
}
    
