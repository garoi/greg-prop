/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class CreaPaquetes {
    public static void main(String[] args){
        ControlDominio cd = new ControlDominio();
        cd.iniControlDominio();
        cd.registroCliente("robot", "robot");
        Scanner sc = new Scanner(System.in);
        String[] ciudades = cd.getNombresCiudades();
        System.out.println("Escribe el nombre de una ciudad:");
        for (int i = 0; i < ciudades.length; i++) {
            System.out.print(ciudades[i] + ", ");
        }
        System.out.print("\n");
        String ciudad = sc.nextLine();
        float ta = System.currentTimeMillis();
        System.out.print("Vamos a crear un paquete por cada destino que tenga la ciudad\n");
        String[] fecha = cd.fechaHoy();
        String data = fecha[0] + "." + fecha[1] + "." + fecha[2];        
        String[] destinos = cd.getDestinosCiudad(ciudad);
        for (int i = 0; i < destinos.length; i++) {
            cd.anadirPaquete(ciudad, destinos[i], data, fecha[3], i==destinos.length-1);
            System.out.print(".");
        }
        float tb = System.currentTimeMillis()-ta;
        System.out.println("\nTiempo creando paquetes: " + tb);
    }
}
