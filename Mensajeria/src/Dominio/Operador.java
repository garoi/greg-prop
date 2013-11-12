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
    
    public void OrdenarPorDestino() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.DestinoComparator());
    }
    
    public void VerPaquetes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Para ver segun idCliente");
        System.out.println("2 Para ver segun Destino");
        int op = sc.nextInt();
        if (op == 1) {
            OrdenarPorIdPaquete();
        }
        else if (op == 2) {
            OrdenarPorDestino();
        }
        else {
            System.out.println("Mal escrito");
        }
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
        System.out.println("Para parar de entrar(seleccionar) paquetes pulsa 0"); 
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
    
    public void CancelarPaquete(int idPaquete) {
        boolean encontrado = false;
        int i = 0;
        while (i < listaPaquetesParaEntregar.size() && !encontrado) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetesParaEntregar.get(i).getEstado().equals("para enviar")) {
                    listaPaquetesParaEntregar.remove(i);
                    encontrado = true;
                }
            }
            else {
                ++i;
            }
        }
        if (!encontrado) {
            System.out.println("Paquete no encontrado para este cliente");
        }
    }
    
    public void EliminarPaquete(int idPaquete) {
        boolean encontrado = false;
        int i = 0;
        while (i < listaPaquetesParaEntregar.size() && !encontrado) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetesParaEntregar.get(i).getEstado().equals("enviado")) {
                    listaPaquetesParaEntregar.remove(i);
                    encontrado = true;
                }
                else {
                    System.out.println("El paquete aun no se ha enviado, lo tienes que cancelar");
                    encontrado = true;
                }
            }
            else {
                ++i;
            }
        }
        if (!encontrado) {
            System.out.println("Paquete no encontrado para este cliente");
        }
    }
}