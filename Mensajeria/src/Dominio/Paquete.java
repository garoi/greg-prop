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
    private String turno;
    private String fecha;
    //private String ciudad;
    
    //CONSULTORAS
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
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
  
    //LECTORAS
    public void leerPaquete(int idCliente, ControlDominio cd) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Mapa mapa = (Mapa) cd.leerCiudad();
        String[]nombresPuntos;
        nombresPuntos = mapa.getNombres();
        System.out.println("Destino del paquete?");
        String destinoPaquete = sc.nextLine();
        boolean encontrado = false;
        for(int i = 0; i < nombresPuntos.length & !encontrado; ++i){
            if(nombresPuntos[i].equals(destinoPaquete)){
                idDestino = i; 
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("El destino no existe");
        }
        else{
            setDestino(destinoPaquete);
            String estadoPaquete = "para enviar";
            setEstado(estadoPaquete);
            setIdCliente(idCliente);
        }
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