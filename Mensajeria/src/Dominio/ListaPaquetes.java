package Dominio;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ListaPaquetes {
     ArrayList<Paquete> Lista = new ArrayList<Paquete>();
     int IDPaquete = 0;
  
    public ListaPaquetes(){}
    
    public void AnadirPaquete(Paquete p){
        System.out.println("ahora añadiremos el paquete a la lista :D");
        //Scanner sc = new Scanner(System.in);
        //int NPaquets = sc.nextInt();
            
            Lista.add(p);
            
    }
    public void PacksClient(int IDClient){
        for(int i = 0; i < Lista.size(); ++i){
            if(Lista.get(i).getIDCliente() == IDClient){
                EscribePaquete(Lista.get(i));
            }
        }
    }
    
    public void EscribePaquete(Paquete p){
        System.out.println("Destino paquete :\n");
        System.out.println();
        
    }
}
