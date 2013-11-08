package Dominio;

import java.util.*;
/**
 *
 * @author Marc Garcia
 */
public class Operador {
    private String nombreOperador;
    private String password;
    private final ArrayList<Paquete> listaPaquetesParaEntregar = new ArrayList<Paquete>();
    
    public String getNombreOperador() {
        return nombreOperador;
    }

    public String getPassword() {
        return password;
    }
     
    public void AnadirPaquete(Paquete p) {
        listaPaquetesParaEntregar.add(p);
    }
    public void OrdenarPorIdPaquete() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.IdPaqueteComparator());
    }
    
    public void ImprimirLista() {
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
            System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
            System.out.println("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
        }
    }
    
    //Devuelve un vector con el identificador de los destinos de los paquetes seleccionados
    public ArrayList<Integer> SeleccionarPaquetes() {
        ArrayList<Integer> paquetesDestino = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el idPaquete de los paquetes de la siguiente lista:");
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
            System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
            System.out.println("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
        }
        System.out.println("Para parar de entrar paquetes pulsa 0"); 
        int idPaquete = sc.nextInt();
        paquetesDestino.add(idPaquete);
        while (idPaquete != 0) {
            idPaquete = sc.nextInt();
            paquetesDestino.add(idPaquete);
        }
        paquetesDestino.remove(paquetesDestino.size() - 1);
        return paquetesDestino;
    }
    
    public void LeerOperador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anadir el nombre del operador");
        nombreOperador = sc.next();
        System.out.println("Anadir el password del operador");
        password = sc.next();
    }
}