package Domini;
import java.util.*;
import java.lang.System;

/**
 *
 * @author Marc Garcia Roig
 */
public class Mapa {
    private Map<String , HashMap<String, Integer> > Ciudad = new HashMap();
    
    public void CrearCiudad(){
        System.out.println("Quants nodes hi ha?");
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        for (int i = 0; i < nodes; ++i) {
            System.out.println("Entra el nom del node " + (i+1));
            String NombreNodo = sc.next();
            System.out.println("Ara tots els nodes adjacents amb la distancia");
            HashMap<String, Integer> aux = new HashMap();
            for (int j = 0; j < nodes - 1; ++j) {
                String NodoAdj = sc.next();
                int dist = sc.nextInt();
                aux.put(NodoAdj, dist);
            }
            Ciudad.put(NombreNodo, aux);
        }  
    }
    
    public void ImprimirCiudad() {
        Iterator it = Ciudad.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    
}