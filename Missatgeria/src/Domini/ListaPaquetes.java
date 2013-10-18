package Domini;
import java.util.*;
//import Paquete.*;
/**
 *
 * @author ivich
 */
public class ListaPaquetes {
     ArrayList<Paquete> Lista = new ArrayList<Paquete>();
    
    public ListaPaquetes(){}
    
    public void AnadirPaquete(Paquete n){
        Lista.add(n);
        n.VerDestino();
        //System.out.println("hola barragan");
    }
    
    
}
