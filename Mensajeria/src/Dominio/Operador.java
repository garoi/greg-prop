package Dominio;

import java.util.*;
/**
 *
 * @author Marc Garcia
 */
public class Operador {
    private final String Nombre = new String();
    private int IDenc;
    private final ArrayList<Paquete> ListaPaquetesParaEntregar = new ArrayList<Paquete>();
     
    public void AnadirPaquete(Paquete p) {
        ListaPaquetesParaEntregar.add(p);
    }
    
    //Dvuelve un vector con el identificador de los destinos de los paquetes seleccionados
    public ArrayList<Integer> SeleccionarPaquetes() {
        ArrayList<Integer> PaquetesDestino = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el IDPAQUETE de los paquetes de la siguiente lista:");
        for (int i = 0; i < ListaPaquetesParaEntregar.size(); ++i) {
            System.out.print("ID Paquete " + ListaPaquetesParaEntregar.get(i).getIDPaquete() + " ");
            System.out.print("ID Cliente " + ListaPaquetesParaEntregar.get(i).getIDCliente() + " ");
            System.out.println("Destino " + ListaPaquetesParaEntregar.get(i).getDestino() + " ");
        }
        System.out.println("Para parar de entrar paquetes pulsa 0"); 
        int IDPaquete = sc.nextInt();
        while (IDPaquete != 0) {
            IDPaquete = sc.nextInt();
            PaquetesDestino.add(IDPaquete);
        }
        return PaquetesDestino;
    }
    
    public void LeerOPerador(){
        System.out.println("Anadir el nombre del operador");
        Scanner sc = new Scanner(System.in);
        //nombre = sc.next();
    }
    
    
    
}