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
    
}
