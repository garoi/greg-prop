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
    
    /**
     * 
     * @return idPaquete
     */
    public int getIdPaquete() {
        return idPaquete;
    }
    
    /**
     * 
     * @param idPaquete 
     */
    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    /**
     * 
     * @return idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }
    
    /**
     * 
     * @param idCliente 
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * 
     * @return idDestino
     */
    public int getIdDestino() {
        return idDestino;
    }
    
    /**
     * 
     * @param idDestino 
     */
    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }
    
    /**
     * 
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }
    
    /**
     * 
     * @param ciudad 
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * 
     * @return destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * 
     * @param destino 
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * 
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * 
     * @param turno 
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * 
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * 
     * @param fecha 
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Lee el paquete del cliente idCliente con destino a la ciudad nombreCiudad,
     * así como su fecha de envio y turno
     * @param idCliente
     * @param nombreCiudad 
     */
    public void leerPaquete(int idCliente, String nombreCiudad) {
        this.idCliente = idCliente;
        this.ciudad = nombreCiudad;
        Scanner sc = new Scanner(System.in);
        setEstado("para enviar");
        this.ciudad = nombreCiudad;
        System.out.println("escribe el destino del paquete");
        String destino = sc.nextLine();
        this.destino = destino;
        Fecha fecha = new Fecha();
        System.out.println("Es para hoy y el turno actual? s/n");
        String ord = sc.nextLine();
        if (ord.equals("s")) {
            this.fecha = fecha.fechaActual();
            this.turno = fecha.mañanaTarde();
        }
        else {
            System.out.println("Escribe la fecha (dd.mm.aa)");
            String dat = sc.nextLine();
            if (fecha.comprobarFecha(dat)) {
                this.fecha = dat;
                System.out.println("Entra el turno: (mañana/tarde)");
                this.turno = sc.nextLine();
            }
            else System.out.println("La fecha es incorrecta");
        }
    }
    
    /**
     * Compara dos idPaquete
     */
    public static class IdPaqueteComparator implements Comparator<Paquete> {
        @Override public int compare(Paquete p1, Paquete p2) {
            return p1.getIdPaquete() - p2.getIdPaquete();
        }
    }
    
    /**
     * Compara dos destinos
     */
    public static class DestinoComparator implements Comparator<Paquete> {
        @Override public int compare(Paquete p1, Paquete p2) {
            if (p1.getDestino().compareTo(p2.getDestino()) < 0) return 1;
            else return -1;
        }
    }
    
    /**
     * Compara dos fechas y turnos
     */
    public static class FechaTurnoComparator implements Comparator<Paquete> {
        @Override public int compare(Paquete p1, Paquete p2) {
            if (p1.getFecha().compareTo(p2.getFecha()) < 0) return 1;
            if (p1.getFecha().compareTo(p2.getFecha()) == 0) {
                if (p1.getTurno().compareTo(p2.getTurno()) < 0) return 1;
                else return -1;
            }
            else return -1;
        }
    }
}