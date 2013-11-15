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
    
    /**
     * 
     * @param idCliente
     * @return Cliente con identificador idCliente
     */
     public Cliente getCliente(int idCliente){
        return listaClientes.get(idCliente);
    }
    
     /**
      * Anade el cliente a la lista
      * @param c 
      * 
      */
    public void anadirCliente(Cliente c){
        c.setIDcliente(IDcliente);
        ++IDcliente;
        listaClientes.add(c);
    }
    
    /**
     * Anade el paquete p al cliente con identificador IDclient
     * @param p
     * @param IDclient 
     * 
     */
    public void anadirPaquete(Paquete p, int IDclient){
        Cliente c = listaClientes.get(IDclient);
        c.anadirPaquete(p);
    
    }
    
    /**
     * 
     * @param nombre
     * @return idCliente que corresponde al cliente con nombre nombre
     */
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
    
    /**
     * Muestra los paquetes del cliente con identificador idCliente
     * @param idCliente 
     * 
     */
    public void packsCliente(int idCliente){
        Cliente c = listaClientes.get(idCliente);
        c.verLista();
    }
    
    /**
     * 
     * @return tamano de la lista de clientes
     */
    public int tamanoListaClientes(){
        return listaClientes.size();
    }
    
    /**
     * 
     * @param nombre
     * @return Si el nombre del cliente es el mismo que nombre
     */
    public boolean comprueba(String nombre){
        for(int i = 0; i < listaClientes.size(); ++i){
            if(nombre.equals(listaClientes.get(i).getNombreCliente())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param nombre
     * @return id del cliente con nombre nombre
     */
    public int compruebaCliente(String nombre){
        for(int i = 0; i < listaClientes.size(); ++i){
            if(nombre.equals(listaClientes.get(i).getNombreCliente())){
                return listaClientes.get(i).getIdCliente();
            }
        }
        return -1;
    }
       
}
    
