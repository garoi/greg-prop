package Dominio;

import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author ivich
 */
public class Operador {
    private String Nombre = new String();
    private int IDenc;
    private final ArrayList<Paquete> ListaPaquetesParaEntregar = new ArrayList<Paquete>();
    
    public ArrayList<Paquete> OrdenarPorCliente() {
        ArrayList<
        Collections.sort(ListaPaquetesPAraEntregar, )
    }
    
    public AnadirPaquete(Paquete p) {
        ListaPaquetesParaEntregar.add(p);
    }
    
    //DEvuelve un vector con el identificador de los destinos de los paquetes seleccionados
    public int[] SeleccionarDestinos() {
        int[] PaquetesDestino = null;
        return PaquetesDestino;
    }
    
    public void LeerOPerador(){
        System.out.println("Anadir el nombre del operador");
        Scanner sc = new Scanner(System.in);
        nombre = sc.next();
        
        
    }
    
    
    
}