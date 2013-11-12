package Dominio;
import java.util.*;
import java.lang.System;
/**
 *
 * @author Albert Gili
 */
public class Paquete {
    private int idPaquete;
    private int idCliente;
    private String ciudad;
    private String destino;
    private String estado;
    //private String ciudad;
    
    
    //CREADORA
    public Paquete(){}
    //CONSULTORAS
    public int getIdPaquete() {
        return idPaquete;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    public String getDestino() {
        return destino;
    }
        
    public String getEstado() {
        return estado;
    }
    
    public String getCiudad(){
        return ciudad;
    }

    //MODIFICADORAS
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public void setIdPaquete(int idPaquete) {
       this.idPaquete = idPaquete;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }



    public void setDestino(String destino) {
        this.destino = destino;
    }

    
    public void setEstado(String estado) {
        this.estado = estado;
    }
  
    //LECTORAS
    public void LeerPaquete(int idCliente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la ciudad");
        this.ciudad = sc.nextLine();
        System.out.println("Destino del paquete?");
        String destinoPaquete = sc.nextLine();
        setDestino(destinoPaquete);
        String estadoPaquete = "para enviar";
        setEstado(estadoPaquete);
        setIdCliente(idCliente);
    }
    
    public static class IdPaqueteComparator implements Comparator<Paquete> {
        @Override public int compare(Paquete p1, Paquete p2) {
            return p1.getIdPaquete() - p2.getIdPaquete();
        }
    }
    
    public static class DestinoComparator implements Comparator<Paquete> {
        @Override public int compare(Paquete p1, Paquete p2) {
            if (p1.getDestino().compareTo(p2.getDestino()) < 0) return 1;
            else return -1;
        }
    }
}