package Dominio;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.lang.System;
/**
 *
 * @author Albert Gili
 */
public class Paquete implements Serializable{
    private int idPaquete;
    private int idCliente;
    private int idDestino;
    private String ciudad;
    private String destino;
    private String estado;
    private String fecha;
    private String turno;
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
    
    public int getidDestino(){
        return idDestino;
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
  
    public void setIdDestino(int idDestino){
        this.idDestino = idDestino;
    }
    //LECTORAS
    public void leerPaquete(int idCliente, String nombreCiudad) {
        this.idCliente = idCliente;
        this.ciudad = nombreCiudad;
        setEstado("para enviar");
        Scanner sc = new Scanner(System.in);
        System.out.println("escribe el destino del paquete");
        String destino = sc.nextLine();
        System.out.println("escriba la fecha (formato XX.XX.XX)");
        String fecha = sc.nextLine();
        this.fecha = fecha;
        String turno = sc.nextLine();
        this.turno = turno;
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