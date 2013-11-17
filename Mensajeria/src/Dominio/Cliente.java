package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Angel Rierola Mora
 */
public class Cliente implements Serializable {
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
    
    /**
     * Elimina todos los paquetes enviados
     * 
     */
    public void eliminarPaquetes() {
        boolean encontrado = false;
        for (int i = 0; i < listaPaquetes.size(); ++i) {
            if (listaPaquetes.get(i).getEstado().equals("enviado")) {
                listaPaquetes.remove(i);
                encontrado = true;
            }
        }
        if (!encontrado) { 
            System.out.println("No tienes ningun paquete enviado");
        }
    }
    
    /**
     * Muestra la lista de paquetes del cliente
     */
    public void verLista(){
        for (int i = 0; i < listaPaquetes.size();++i) {
            System.out.print("IDpaquete " + listaPaquetes.get(i).getIdPaquete() + " ");
            System.out.print("Ciudad " + listaPaquetes.get(i).getCiudad() + " ");
            System.out.print("Destino " + listaPaquetes.get(i).getDestino() + " ");
            System.out.print("Estado " + listaPaquetes.get(i).getEstado() + " ");
            System.out.print("Fecha " + listaPaquetes.get(i).getFecha() + " ");
            System.out.println("Turno " + listaPaquetes.get(i).getTurno() + " ");
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
}
