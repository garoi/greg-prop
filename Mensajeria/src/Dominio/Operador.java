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
    private void setCheckExistencia(boolean checkExistencia) {
        this.checkExistencia = checkExistencia;
    }

    /**
     * 
     * @return checkExistencia
     */
    private boolean isCheckExistencia() {
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
        System.out.println("AÑADO EL PAQUETE" + p.getEstado());
        listaPaquetesParaEntregar.add(p);
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
    private void leerOperador() {
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
    
    public boolean eliminarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetesParaEntregar.get(i).getEstado().equals("enviado")) {
                    listaPaquetesParaEntregar.remove(i);
                    return true;
                }
            }
        }
        return false;
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
    private ArrayList<Paquete> modificaListaPaquetes(ArrayList<Paquete> paquetes) {
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

//    /**
//     * Modifica la ciudad del operador.
//     * @param map ciudad
//     */
//    public void modificarCiudad(Mapa map) {
//        map.modificarCiudad();
//    }
    
    /**
     * Muestra la ciudad del operador
     * @param map ciudad.
     */
    private void verCiudad(Mapa map) {
        map.imprimirCiudad();
    }
}
