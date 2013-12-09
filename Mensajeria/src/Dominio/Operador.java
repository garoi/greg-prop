package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Albert Gili Zaragoza
 */
public class Operador implements Serializable {
    private static final long serialVersionUID = 9040177911315386368L;
    private String nombreOperador;
    private String password;
    private ArrayList<Paquete> listaPaquetesParaEntregar = new ArrayList<Paquete>();
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
     * Devuelve el nombre del operador.
     * @return nombreOperador
     */
    public String getNombreOperador() {
        return nombreOperador;
    }

    /**
     * Devuelve la contraseña del operador.
     * @return password
     */
    public String getPassword() {
        return password;
    }
     
   /**
    * Atribuye un nombre al operador.
    * @param nombreOperador nombre con el que se quiere identificar al operador.
    */
    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    /**
     * Atribuye una contraseña al operador.
     * @param password contraseña que se quiere definir para el operador.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Añade un paquete a la lista de paquetes para enviar del operador.
     * @param p Objeto paquete que se va a añadir a la lista de paquetes por enviar.
     * @see Paquete
     */
    public void anadirPaquete(Paquete p) {
        listaPaquetesParaEntregar.add(p);
    }
    
    /**
     * Ordena los paquetes por identificador.
     */
    public void ordenarPorIdPaquete() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.IdPaqueteComparator());
    }
    
    /**
     * Ordena por paquetes por destino.
     */
    public void ordenarPorDestino() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.DestinoComparator());
    }
    
    /**
     * Ordena los paquetes por fecha y turno.
     */
    public void ordenarPorFechaTurno() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.FechaTurnoComparator());
    }
    
    /**
     * Muestra los paquetes por pantalla segun el criterio que se pida.
     */
    public void verPaquetes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Para ver segun idCliente 2 Para ver segun Destino 3 Para ver segun feha y turno.");
        int op = sc.nextInt();
        if (op == 1) {
            ordenarPorIdPaquete();
        }
        else if (op == 2) {
            ordenarPorDestino();
        }
        else if (op == 3) {
            ordenarPorFechaTurno();
        }
        else {
            System.out.println("Mal escrito");
        }
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
            System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
            System.out.print("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
            System.out.print("Fecha " + listaPaquetesParaEntregar.get(i).getFecha() + " ");
            System.out.println("Turno " + listaPaquetesParaEntregar.get(i).getTurno() + " ");
        }
    }
    
    /**
     * Devuelve el paquete de id "idPaquete" pasado por referencia.
     * @param idPaquete entero que identifica un paquete.
     * @return el paquete con el identificador idPaquete pasado por referencia
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
     * Selecciona los paquetes que irán en la próxima ruta.
     * @param nombreCiudad nombre de la ciudad.
     * @param fecha fecha de envío
     * @param turno turno de envío
     * @return Vector con los paquetes seleccionados
     */
    public ArrayList<Paquete> seleccionarPaquetes(String nombreCiudad, String fecha, String turno) {
        ArrayList<Paquete> paquetesDestino = new ArrayList<>();
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            if (listaPaquetesParaEntregar.get(i).getCiudad().equals(nombreCiudad)) {
                if (fecha.equals(listaPaquetesParaEntregar.get(i).getFecha())) {
                    if (turno.equals(listaPaquetesParaEntregar.get(i).getTurno())) {
                        paquetesDestino.add(listaPaquetesParaEntregar.get(i));

                    }
                }
            }
        }
        return paquetesDestino;
    }
    
    /**
     * Lee los parametros del operador y los inicializa.
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
     */
    public boolean cancelarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetesParaEntregar.get(i).getEstado().equals("para enviar")) {
                    listaPaquetesParaEntregar.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
        
    /**
     * Crea una ciudad para el operador.
     * @param map mapa vacío.
     * @return Mapa el mapa de la ciudad ya inicializado.
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Mapa anadirCiudad(Mapa map) throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la ciudad:");
        String name = sc.next();
        System.out.println("Introduce el número de puntos de la ciudad:");
        int n = sc.nextInt();
        map.crearCiudad(name, n);
        return map;
    }
    
    /**
     * Elimina el paquete de la lista de paquetes de la ruta que 
     * se quiere recalcular con identificador idpaquete
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
     * Anade el paquete de la lista de paquetes de la ruta que se quiere recalcular 
     * con identificador idagregado a la lista de paquetes
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
     * Modifica la lista de paquetes para la ruta.
     * @param paquetes 
     * @return ArrayList<Paquete>
     */
    public ArrayList<Paquete> modificaListaPaquetes(ArrayList<Paquete> paquetes) {
        System.out.println("cuantos paquetes quiere eliminar de la lista?");
        Scanner sc = new Scanner(System.in);

        int numeliminados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea eliminar");
        //ordenaPaquetes(paquetes);
        for(int i = 0; i < numeliminados; ++i){
            int idpaquete = sc.nextInt();
            buscayElimina(paquetes, idpaquete);
        }
        System.out.println("cuantos paquetes quiere agregar de la lista?");
        int numagregados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea agregar");
        for(int i = 0; i < numagregados; ++i){
            int idagregado = sc.nextInt();
            buscayAgrega(paquetes, idagregado);
        }
        return paquetes;
    }
    
    /**
     * Una vez confirmada la ruta, cambia el estado del paquete, como enviado.
     * @param paquetesEnviados
     */
    public void cambiarEstadoPaquetes(ArrayList<Paquete>paquetesEnviados) {
        for (int i = 0; i < paquetesEnviados.size(); ++i) {
            boolean encontrado = false;
            for (int j = 0; j < listaPaquetesParaEntregar.size() & !encontrado; ++j) {
                if (listaPaquetesParaEntregar.get(j).getIdPaquete() == (paquetesEnviados.get(i).getIdPaquete())) {
                    listaPaquetesParaEntregar.remove(j);
                    encontrado = true;
                }
            }
        }
    }

    /**
     * Modifica la ciudad del operador.
     * @param map ciudad
     */
    public void modificarCiudad(Mapa map) {
        map.modificarCiudad();
    }
    
    /**
     * Muestra la ciudad del operador
     * @param map ciudad.
     */
    public void verCiudad(Mapa map) {
        map.imprimirCiudad();
    }
}
