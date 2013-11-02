package Dominio;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ListaPaquetes {
     ArrayList<Paquete> Lista = new ArrayList<Paquete>();
    
    public ListaPaquetes(){}
    
    public void AnadirPaquete(Paquete p){
        System.out.println("ahora añadiremos el paquete a la lista :D");
        //Scanner sc = new Scanner(System.in);
        //int NPaquets = sc.nextInt();
            Lista.add(p);
            
    }
}
