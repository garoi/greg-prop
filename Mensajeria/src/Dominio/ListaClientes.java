package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ListaClientes implements Serializable {
    private static final long serialVersionUID = 9040177911315386368L;
    private int IDcliente = 0;
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    /**
     * Devuelve el cliente especificado por su idCliente
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
     * Busca si existe el cliente correspondiente
     * @param nombre
     * @return idCliente que corresponde al cliente con nombre nombre
     */
    private int encontrarCliente(String nombre){
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
     * Devuelve el numero de clientes total
     * @return tamano de la lista de clientes
     */
    private int tamanoListaClientes(){
        return listaClientes.size();
    }
    
    /**
     * Comprueba que exista el cliente con nombre especificado
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
     * Comprueba que exista el cliente con nombre especificado
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
    
    /**
     * Cambia el estado del paquete p
     * @param p
     */
    public void cambiarEstadoPaquetes(Paquete p){
        listaClientes.get(p.getIdCliente()).cambiarEstadoPaquetes(p);
    }
     
    /**
     * Devuelve una lista de paquetes en espera del cliente con identificador id
     * @param id
     * @return 
     */
    public String[] getPaquetesEspera(int id){
        ArrayList<String> res = new ArrayList<String>();
        res = listaClientes.get(id).getPaquetesEspera();
        String[] r = new String[res.size()];
        for(int i = 0; i < r.length; ++i) r[i] = res.get(i);
        return r;
    }
    
    /**
     * Devuelve una lista de paquetes enviados del cliente con identificador id
     * @param id
     * @return 
     */
    public String[] getPaquetesEnviados(int id){
        ArrayList<String> res = new ArrayList<String>();
        res = listaClientes.get(id).getPaquetesEnviados();
        String[] r = new String[res.size()];
        for(int i = 0; i < r.length; ++i) r[i] = res.get(i);
        return r;
    }
}
    
