package Dominio;
import java.io.Serializable;
import java.util.Collections;
import java.util.*;

/**
 *
 * @author Angel Rierola Mora
 */
public class Cliente implements Serializable {
    private static final long serialVersionUID = 9040177911315386368L;
    private int idCliente;
    private String password;
    private String nombreCliente;
    ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
    
    public Cliente(){}
     
    public Cliente(String nombre, String contrasena){
        nombreCliente = nombre;
        password = contrasena;
        idCliente = listaPaquetes.size();
    }
    
    /**
     * 
     * @return Id del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }
    
    /**
     * 
     * @param idCliente 
     */
    public void setIDcliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public void setNombre(String nombre){
        nombreCliente = nombre;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    /**
     * 
     * @return El passwoed del cliente
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     * @return El nombre del cliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    /**
     * 
     * @return Lista de paquetes del cliente
     */
    public ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;

    }
     
    /**
     * Lee los datos del cliente
     * 
     */
    public void leerCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Anadir el nombre del client"
                + "e");
        nombreCliente = sc.next();
        System.out.println("Anadir el password del cliente");
        password = sc.next();
    }
    
    /**
     * Añade un paquete a la lista de paquetes del cliente
     * @param p Paquete
     */
    public void anadirPaquete(Paquete p){
        System.out.println("ANADIR PAK: " + listaPaquetes.size());
        listaPaquetes.add(p);
        
    }
    
    /**
     * Cancelamos un paquete que aun no ha sido enviado
     * @param idPaquete
     * @return Si ha podido cancelar el paquete
     */
    public boolean cancelarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetes.size(); ++i) {
            if (listaPaquetes.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetes.get(i).getEstado().equals("para enviar")) {
                    listaPaquetes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean eliminarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetes.size(); ++i) {
            if (listaPaquetes.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetes.get(i).getEstado().equals("enviado")) {
                    listaPaquetes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Elimina todos los paquetes enviados
     * 
     */
    public void eliminarPaquetes() {
        for (int i = 0; i < listaPaquetes.size(); ++i) {
            if (listaPaquetes.get(i).getEstado().equals("enviado")) {
                listaPaquetes.remove(i);
            }
        }
    }
    
    /**
     * Una vez enviados los paquetes cambia el estado
     * @param paquetesEnviados
     */
    public void cambiarEstadoPaquetes(Paquete p) {
        for(int i = 0; i < listaPaquetes.size(); ++i)
            if(p.getIdPaquete() == listaPaquetes.get(i).getIdPaquete()){
                listaPaquetes.get(i).setEstado("Enviado");
            }    
    }
    
    /**
     * Devuelve una lista con los paquetes en espera del cliente
     * @return res
     */
    public ArrayList<String> getPaquetesEspera(){
        ArrayList<String> res = new ArrayList<String> ();
        for(int i = 0; i < listaPaquetes.size(); ++i){
            if(listaPaquetes.get(i).getEstado().equals("para enviar")){
                res.add(listaPaquetes.get(i).getCiudad() + ", " + listaPaquetes.get(i).getDestino() + ", " + 
                        listaPaquetes.get(i).getFecha() + ", " + listaPaquetes.get(i).getTurno() + "-" + 
                        listaPaquetes.get(i).getIdPaquete());
            }
        }
        Collections.sort(res);
        return res;
    }
    
    /**
     * Devuelve una lista con los paquetes enviados del cliente
     * @return res
     */
    public ArrayList<String> getPaquetesEnviados(){
        ArrayList<String> res = new ArrayList<String> ();
        for(int i = 0; i < listaPaquetes.size(); ++i){
            if(listaPaquetes.get(i).getEstado().equals("enviado")){
                res.add(listaPaquetes.get(i).getCiudad() + ", " + listaPaquetes.get(i).getDestino() + ", " + 
                        listaPaquetes.get(i).getFecha() + ", " + listaPaquetes.get(i).getTurno() + "-" +
                        listaPaquetes.get(i).getIdPaquete());
            }
        }
        Collections.sort(res);
        return res;
    }
    
}
