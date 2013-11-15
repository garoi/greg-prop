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

    
    
    /**
     * 
     * @param checkExistencia 
     */
    public void setCheckExistencia(boolean checkExistencia) {
        this.checkExistencia = checkExistencia;
    }

    /**
     * 
     * @return checkExistencia
     */
    public boolean isCheckExistencia() {
        return checkExistencia;
    }
    
    /**
     * 
     * @return nombreOperador
     */
    public String getNombreOperador() {
        return nombreOperador;
    }

    /**
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }
     
   /**
    * 
    * @param nombreOperador 
    */
    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 
     * @param p 
     */
    public void anadirPaquete(Paquete p) {
        listaPaquetesParaEntregar.add(p);
    }
    
    /**
     * Ordena los paquetes por identificador
     * @param
     */
    public void ordenarPorIdPaquete() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.IdPaqueteComparator());
    }
    
    /**
     * Ordena los paquetes por destino
     * @param
     */
    public void ordenarPorDestino() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.DestinoComparator());
    }
    
    /**
     * Muestra los paquetes por pantalla
     * @param
     */
    public void verPaquetes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Para ver segun idCliente 2 Para ver segun Destino");
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
    
    /**
     * 
     * @param idPaquete
     * @return El paquete con identificador idPaquete
     */
    public Paquete buscarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                return listaPaquetesParaEntregar.get(i);
            }
        }
        return null;
    }
    
    /**
     * 
     * @return Vector con el identificador de los destinos de los paquetes seleccionados
     */
    public ArrayList<Paquete> seleccionarPaquetes() {
        ArrayList<Paquete> paquetesDestino = new ArrayList<Paquete>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el idPaquete de los paquetes de la siguiente lista:");
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
                System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
                System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
                System.out.println("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
                System.out.print("Dia " + listaPaquetesParaEntregar.get(i).getFecha() + " ");
                System.out.print("Turno " + listaPaquetesParaEntregar.get(i).getTurno() + " ");
        }
        System.out.println("Si desea parar de entrar/seleccionar paquetes pulsa -1"); 
        int idPaquete = sc.nextInt();
        paquetesDestino.add(buscarPaquete(idPaquete));
        while (idPaquete >= 0) {
            idPaquete = sc.nextInt();
            paquetesDestino.add(buscarPaquete(idPaquete));
        }
        return paquetesDestino;
    }
    
    /**
     * Lee los parametros del operador
     * @param
     */
    public void leerOperador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anadir el nombre del operador");
        nombreOperador = sc.next();
        System.out.println("Anadir el password del operador");
        password = sc.next();
    }
    
    /**
     * Cancela el paquete con identificador idPaquete
     * @param idPaquete 
     * 
     */
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
    
    /**
     * Elimina el paquete con identificador idPaquete
     * @param idPaquete 
     * 
     */
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
    
    /**
     * Crea una ciudad
     * @param map
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     * 
     */
    public Mapa anadirCiudad(Mapa map) throws IOException, ClassNotFoundException{
        map.crearCiudad();
        return map;
    }
    
    /*public void cargarCiudad() throws FileNotFoundException, IOException, ClassNotFoundException{
        mapa = (Mapa) cd.leerCiudad();
    }*/
    
    private void ordenaPaquetes(ArrayList<Paquete> paquetes){
        
        //MERGESORT!!!! PRO AHORA ME DA PALO IMPLEMENTAR!!!!!!
        //PUES MIRAQUE ES FACIL; SOLO TIENES QUE LLAMAR A UNA PUTA FUNCION; YA LO HICE TODO YO
        //HIJOPUTA!!! xD
    }
    
    /**
     * Elimina el paquete de la lista de paquetes con identificador idpaquete
     * @param paquetes
     * @param idpaquete 
     * 
     */
    private void buscayElimina(ArrayList<Paquete> paquetes, int idpaquete){
        
        //HAURIA DE SER UNA BINARY SEARCH PRO NECESSITEM EL VECTOR ORDENAT
        for(int i = 0; i < paquetes.size(); ++i){
            if(idpaquete == paquetes.get(i).getIdPaquete()){
                paquetes.remove(i);
            }
        }
    }
    
    /**
     * Anade el paquete con identificador idagregado a la lista de paquetes
     * @param paquetes
     * @param idagregado
     * 
     */
    private void buscayAgrega(ArrayList <Paquete> paquetes, int idagregado){
        for(int i = 0; i < listaPaquetesParaEntregar.size(); ++i){
            if(listaPaquetesParaEntregar.get(i).getIdPaquete() == idagregado){
                
                paquetes.add(listaPaquetesParaEntregar.get(i));
            }
        }
    }
    
    /**
     * Modifica la lista de paquetes
     * @param paquetes 
     * 
     */
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