package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Marc Garcia
 */
public class Operador implements Serializable {
    private String nombreOperador;
    private String password;
    private ArrayList<Paquete> listaPaquetesParaEntregar = new ArrayList<Paquete>();
    private Mapa mapa;
    private ListaPaquetes lp;
    private boolean checkExistencia = false;

    
    
    
    public void setCheckExistencia(boolean checkExistencia) {
        this.checkExistencia = checkExistencia;
    }

    public boolean isCheckExistencia() {
        return checkExistencia;
    }
    
    public String getNombreOperador() {
        return nombreOperador;
    }

    public String getPassword() {
        return password;
    }
     
   
    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public Paquete buscarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                return listaPaquetesParaEntregar.get(i);
            }
        }
        return null;
    }
    
    //Devuelve un vector con el identificador de los destinos de los paquetes seleccionados
    public ArrayList<Paquete> seleccionarPaquetes() {
        ArrayList<Paquete> paquetesDestino = new ArrayList<Paquete>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el idPaquete de los paquetes de la siguiente lista:");
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
                System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
                System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
                System.out.println("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
        }
        System.out.println("Para parar de entrar/seleccionar, paquetes pulsa -1"); 
        int idPaquete = sc.nextInt();
        paquetesDestino.add(buscarPaquete(idPaquete));
        while (idPaquete >= 0) {
            idPaquete = sc.nextInt();
            paquetesDestino.add(buscarPaquete(idPaquete));
        }
        //paquetesDestino.remove(paquetesDestino.size() - 1);
        return paquetesDestino;
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
    
    public Mapa anadirCiudad() throws IOException, ClassNotFoundException{
        Mapa map = new Mapa();
        map.crearCiudad();
        //String name = map.getNombreCiudad();
        return map;
        //cd.guardarMapa(map, name);
        
    }
    
    /*public void cargarCiudad() throws FileNotFoundException, IOException, ClassNotFoundException{
        mapa = (Mapa) cd.leerCiudad();
    }*/
    
    private void ordenaPaquetes(ArrayList<Paquete> paquetes){
        
        //MERGESORT!!!! PRO AHORA ME DA PALO IMPLEMENTAR!!!!!!
        //PUES MIRAQUE ES FACIL; SOLO TIENES QUE LLAMAR A UNA PUTA FUNCION; YA LO HICE TODO YO
        //HIJOPUTA!!! xD
    }
    
    private void buscayElimina(ArrayList<Paquete> paquetes, int idpaquete){
        
        //HAURIA DE SER UNA BINARY SEARCH PRO NECESSITEM EL VECTOR ORDENAT
        for(int i = 0; i < paquetes.size(); ++i){
            if(idpaquete == paquetes.get(i).getIdPaquete()){
                paquetes.remove(i);
            }
        }
    }
    
    private void buscayAgrega(ArrayList <Paquete> paquetes, int idagregado){
        for(int i = 0; i < listaPaquetesParaEntregar.size(); ++i){
            if(listaPaquetesParaEntregar.get(i).getIdPaquete() == idagregado){
                
                paquetes.add(listaPaquetesParaEntregar.get(i));
            }
        }
    }
    
    public void modificaListaPaquetes(ArrayList<Paquete> paquetes){
        System.out.println("cuantos paquetes quiere eliminar de la lista?");
        Scanner sc = new Scanner(System.in);
        int numeliminados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea eliminar");
        ordenaPaquetes(paquetes);
        for(int i = 0; i < numeliminados; ++i){
            int idpaquete = sc.nextInt();
            buscayElimina(paquetes, idpaquete);
        }
        //ArrayList <Paquete> nuevospaquetes = new ArrayList<>();
        System.out.println("cuantos paquetes quiere agregar de la lista?");
        int numagregados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea agregar");
        for(int i = 0; i < numagregados; ++i){
            int idagregado = sc.nextInt();
            buscayAgrega(paquetes, idagregado);
        }
        
    }
    
    /*public void recalcularRuta() throws IOException, FileNotFoundException, ClassNotFoundException{
        Ruta r = new Ruta();
        r = (Ruta) cd.leerRuta();
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes = r.getListaPaquetesRuta();
        modificaListaPaquetes(paquetes);
        Mapa map = new Mapa();
        map = r.getMapa();
        String nom = map.getNombreCiudad();
        System.out.println("Procedemos al recalculo de la ruta");
        for(int i = 0; i < paquetes.size(); ++i){
            System.out.println(paquetes.get(i).getidDestino()+" ");
        }
        cd.calcularRuta(paquetes, nom, map);
        
   }*/
    
}