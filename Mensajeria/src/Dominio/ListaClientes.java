package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Albert Gili
 */
public class ListaClientes implements Serializable {
    private int IDcliente = 0;
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
     public Cliente getCliente(int idCliente){
        return listaClientes.get(idCliente);
    }
    
    public void anadirCliente(Cliente c){
        c.setIDcliente(IDcliente);
        ++IDcliente;
        listaClientes.add(c);
    }
    
    public void anadirPaquete(Paquete p, int IDclient){
        Cliente c = listaClientes.get(IDclient);
        c.anadirPaquete(p);
    
    }
    
    public int encontrarCliente(String nombre){
        for(int i = 0; i < listaClientes.size(); ++i){
            if(listaClientes.get(i).getNombreCliente().equals(nombre)){
                System.out.println("ID cliente es "+ listaClientes.get(i).getIdCliente());
                System.out.println("nombre cliente es "+ listaClientes.get(i).getNombreCliente());
                return i;
            }
        }
        System.out.println("cliente no encontrado");
        return -1;
    }
    
    
    public void packsCliente(int idCliente){
        Cliente c = listaClientes.get(idCliente);
        c.verLista();
    }
    
    public int tamanoListaClientes(){
        return listaClientes.size();
    }
    
    public boolean comprueba(String nombre){
        for(int i = 0; i < listaClientes.size(); ++i){
            if(nombre.equals(listaClientes.get(i).getNombreCliente())){
                return true;
            }
        }
        return false;
    }
    
    public int compruebaCliente(String nombre){
        for(int i = 0; i < listaClientes.size(); ++i){
            if(nombre.equals(listaClientes.get(i).getNombreCliente())){
                return listaClientes.get(i).getIdCliente();
            }
        }
        return -1;
    }
       
}
    
