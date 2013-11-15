/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Albert Gili
 */
public class Cliente implements Serializable {
    private int idCliente;
    private String password;
    private String nombreCliente;
    ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
    
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
     * 
     * @param p 
     */
    public void anadirPaquete(Paquete p){
        listaPaquetes.add(p);
        
    }
    
    /**
     * 
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
     * Elimina un paquete
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
            System.out.println("Estado " + listaPaquetes.get(i).getEstado() + " ");
        }
    }
}