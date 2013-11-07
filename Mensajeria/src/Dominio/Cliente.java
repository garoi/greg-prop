/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.util.*;

/**
 *
 * @author ivich
 */
public class Cliente {
    private int idCliente;
    private String password;
    private String nombreCliente;
    ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
    
    public int getIdCliente() {
        return idCliente;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }
     
    public void LeerCliente(Cliente cl, int idCliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Anadir el nombre del cliente");
        nombreCliente = sc.next();
        System.out.println("Anadir el password del cliente");
        password = sc.next();
        this.idCliente = idCliente;
    }
    
    public void AnadePaquete(Paquete p){
        listaPaquetes.add(p);
        
    }
    
    public void CancelarPaquete(int idPaquete) {
        boolean encontrado = false;
        int i = 0;
        while (i < listaPaquetes.size() && !encontrado) {
            if (listaPaquetes.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetes.get(i).getEstado() == "para enviar") {
                    listaPaquetes.remove(i);
                    encontrado = true;
                }
            }
            else {
                ++i;
            }
        }
        if (encontrado) {
            //eliminar el fichero de disco
        }
        else {
            System.out.println("Paquete no encontrado para este cliente");
        }
    }
    
    public void EliminarPaquete(int idPaquete) {
        boolean encontrado = false;
        int i = 0;
        while (i < listaPaquetes.size() && !encontrado) {
            if (listaPaquetes.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetes.get(i).getEstado() == "enviado") {
                    listaPaquetes.remove(i);
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
        if (encontrado) {
            //eliminar el fichero de disco, no siempre
        }
        else {
            System.out.println("Paquete no encontrado para este cliente");
        }
    }
    
    public void VerLista(){
        for (int i = 0; i < listaPaquetes.size();++i) {
            System.out.print("IDpaquete " + listaPaquetes.get(i).getIdPaquete() + " ");
            System.out.print("Destino " + listaPaquetes.get(i).getDestino() + " ");
            System.out.println("Estado " + listaPaquetes.get(i).getEstado() + " ");
        }
    }
}