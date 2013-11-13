package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
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
     
    public void anadirPaquete(Paquete p) {
        listaPaquetesParaEntregar.add(p);
    }
    public void ordenarPorIdPaquete() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.IdPaqueteComparator());
    }
    
    public void ordenarPorDestino() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.DestinoComparator());
    }
    
    public void verPaquetes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Para ver segun idCliente");
        System.out.println("2 Para ver segun Destino");
        int op = sc.nextInt();
        if (op == 1) {
            ordenarPorIdPaquete();
        }
        else if (op == 2) {
            ordenarPorDestino();
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
    public ArrayList<Integer> seleccionarPaquetes() {
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
    
    public void calcularRuta(ControlDominio cd) throws IOException {
        cd.calcularRuta(seleccionarPaquetes());
    }
    
    public void leerOperador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anadir el nombre del operador");
        nombreOperador = sc.next();
        System.out.println("Anadir el password del operador");
        password = sc.next();
    }
    
    public void cancelarPaquete(int idPaquete) {
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
    
    public void eliminarPaquete(int idPaquete) {
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
    
    public void anadirCiudad(ControlDominio cd) throws IOException, ClassNotFoundException{
        Mapa map = new Mapa();
        map.crearCiudad();
        String name = map.getNombreCiudad();
        cd.guardarMapa(map, name);
        
    }
    
    public void cargarCiudad(ControlDominio cd) throws FileNotFoundException, IOException, ClassNotFoundException{
        cd.leerCiudad();
    }
    
    private void modificaListaPaquetes(ArrayList<Paquete> paquetes){
        System.out.println("cuantos paquetes quiere eliminar de la lista?");
        Scanner sc = new Scanner(System.in);
        int numeliminados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea eliminar");
        for(int i = 0; i < numeliminados; ++i){
            int idpaquete = sc.nextInt();
        }
    }
    
    public void modificarRuta(ControlDominio cd) throws IOException, FileNotFoundException, ClassNotFoundException{
        Ruta r = new Ruta();
        r = (Ruta) cd.leerRuta();
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes = r.getListaPaquetesRuta();
        modificaListaPaquetes(paquetes);
    }
    
}