package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Albert Gili
 */
public class ListaPaquetes implements Serializable {
     ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
     int idPaquete = 0;
    public ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }
     
    
    public void anadirPaquete(Paquete p){
        p.setIdPaquete(idPaquete);
        ++idPaquete;
        System.out.println("ahora añadiremos el paquete a la lista :D");
        listaPaquetes.add(p);    
    }
    
    public void packsCliente(int idCliente){
        for(int i = 0; i < listaPaquetes.size(); ++i){
            if(listaPaquetes.get(i).getIdCliente() == idCliente){
                escribirPaquete(i);
            }
        }
    }
    
    public int tamanoListaPaquetes(){
        return listaPaquetes.size();
    }
    
    public void escribirPaquete(int idPaquete){
        if(idPaquete > tamanoListaPaquetes()){
            System.out.print("El paquete no existe");
        }
        else{
            Paquete p = listaPaquetes.get(idPaquete);
            System.out.print(p.getIdPaquete() + "\n");
            System.out.print(p.getIdCliente() + "\n");
            System.out.print(p.getCiudad() + "\n");
            System.out.print(p.getDestino() + "\n");
            System.out.print(p.getEstado() + "\n");
        }
    }
    
    public void cancelarPaquete(int idPaquete){
        listaPaquetes.get(idPaquete).setEstado("cancelado");
    }
}
