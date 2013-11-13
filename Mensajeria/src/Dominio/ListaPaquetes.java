package Dominio;
import java.util.*;

/**
 *
 * @author Albert Gili
 */
public class ListaPaquetes {
     ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
     int idPaquete = 0;
    
    public void anadirPaquete(Paquete p){
        p.setIdPaquete(idPaquete);
        ++idPaquete;
        System.out.println("ahora añadiremos el paquete a la lista :D");
        listaPaquetes.add(p);    
    }
    
    public void packsCliente(int idCliente){
        for(int i = 0; i < listaPaquetes.size(); ++i){
            if(listaPaquetes.get(i).getIdCliente() == idCliente){
                escribirPaquete(listaPaquetes.get(i));
            }
        }
    }
    
    public void escribirPaquete(Paquete p){
        System.out.println("Destino paquete :\n");
        System.out.println();
        
    }
}
