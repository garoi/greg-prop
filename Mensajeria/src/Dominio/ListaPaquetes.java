package Dominio;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ListaPaquetes {
     ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
     int idPaquete = 0;
    
    public void AnadirPaquete(Paquete p){
        System.out.println("ahora añadiremos el paquete a la lista :D");
        listaPaquetes.add(p);    
    }
    
    public void PacksClient(int idCliente){
        for(int i = 0; i < listaPaquetes.size(); ++i){
            if(listaPaquetes.get(i).getIdCliente() == idCliente){
                EscribePaquete(listaPaquetes.get(i));
            }
        }
    }
    
    public void EscribePaquete(Paquete p){
        System.out.println("Destino paquete :\n");
        System.out.println();
        
    }
}
