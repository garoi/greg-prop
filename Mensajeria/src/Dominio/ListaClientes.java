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
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
     public Cliente getCliente(int idCliente){
        return listaClientes.get(idCliente);
    }
    
    public void AnadirCliente(Cliente c){
        listaClientes.add(c);
    }
    
    public void AnadirPaquete(Paquete p, int IDclient){
        Cliente c = listaClientes.get(IDclient);
        c.AnadePaquete(p);
    
    }
    
    public int EncontrarCliente(String nombre){
        for(int i = 0; i < listaClientes.size(); ++i){
            if(listaClientes.get(i).getNombreCliente().equals(nombre)){
                System.out.println("nombre cliente es "+ listaClientes.get(i).getNombreCliente());
                return i;
            }
        }
        System.out.println("no he encontrao una mierda");
        return -1;
    }
    
    public void CancelarPaquete(Cliente cl) {
        System.out.println("Cual es el idPaquete?");
        Scanner sc = new Scanner(System.in);
        int idPaquete = sc.nextInt();
        cl.CancelarPaquete(idPaquete);  
    }
    
    public void EliminarPaquete(Cliente cl) {
        System.out.println("Cual es el idPaquete?");
        Scanner sc = new Scanner(System.in);
        int idPaquete = sc.nextInt();
        cl.EliminarPaquete(idPaquete);  
    }
    
    public void PacksClient(int idCliente){
        Cliente c = listaClientes.get(idCliente);
        c.VerLista();
    }
       
}
    
