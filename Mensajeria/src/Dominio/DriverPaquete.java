/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author ivich
 */
public class DriverPaquete {
    
    
    public static void main(String[] args){
        //FUNCION LECTORA
        Scanner sc = new Scanner(System.in);
        System.out.println("procedemos a leer el paquete");
        System.out.println("Escriba un identificador de cliente (entero):");
        int idCliente = sc.nextInt();
        System.out.println("Escriba la ciudad del paquete");
        System.out.println("hola");
        Scanner sc2 = new Scanner(System.in);
        String nombreCiudad = sc2.nextLine();
        Paquete p = new Paquete();
        p.leerPaquete(idCliente, nombreCiudad);
        //CONSULTORAS 
         System.out.print("Destino :");
         System.out.println(p.getDestino());
         System.out.print("Estado :");
         System.out.println(p.getEstado());
         System.out.print("IDcliente :");
         System.out.println(p.getIdCliente());
         System.out.print("IDpaquete :");
         System.out.println(p.getIdPaquete());
         System.out.print("Ciudad :");
         System.out.println(p.getCiudad());
         /*PODEMOS VER QUE LAS FUNCIONES DE GET FUNCIONAN IMPLICITAMENTE AL LLAMAR
          * A LA FUNCION LECTORA DE PAQUETE
          */
        
        
        
    }
    
}
