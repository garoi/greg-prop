package Domini;
import java.util.*;
import java.lang.System;
/**
 *
 * @author ivich
 */
public class Paquete {
    private int IDPaquete;
    private int IDCliente;
    private String Destino;
    private String Estado;

    public int getIDPaquete() {
        return IDPaquete;
    }

    private void setIDPaquete(int IDPaquete) {
        this.IDPaquete = IDPaquete;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    private void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getDestino() {
        return Destino;
    }

    private void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getEstado() {
        return Estado;
    }

    private void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public void insertarPaquete() {
        Scanner sc = new Scanner(System.in);
        //String Estado = sc.next(); 
        /** De momento solo necesitamos el destino*/
        System.out.println("Entra el desti del paquet");
        String Destino = sc.next();
        setDestino(Destino);
    }
}