package Dominio;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ListaPaquetes {
     ArrayList<Paquete> Lista = new ArrayList<Paquete>();
    
    public ListaPaquetes(){}
    
    public void AnadirPaquete(){
        System.out.println("Quants paquets vols afegir?");
        Scanner sc = new Scanner(System.in);
        int NPaquets = sc.nextInt();
        for (int i = 0; i < NPaquets; ++i) {
            Paquete p = new Paquete();
            p.insertarPaquete();
            Lista.add(p);
        }
    }
}
