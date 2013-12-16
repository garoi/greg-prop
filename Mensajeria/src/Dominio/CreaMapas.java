/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.ControlPersistencia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ivich
 */
public class CreaMapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ControlDominio cd = new ControlDominio();
        cd.iniControlDominio();
         System.out.println("vamos a crear una ciudad");
            System.out.println("nombre de la ciudad: ");
            Scanner sc = new Scanner(System.in);
            String nombreCiudad = sc.nextLine();
            System.out.println("Numero de nodos :");
            int numNodos = sc.nextInt();
            float ta = System.currentTimeMillis();
            ArrayList<String> nombreNodos = new ArrayList<>();
            for(int i = 0; i < numNodos; ++i){
                nombreNodos.add(Integer.toString(i));
            }
            int auxdistancias = (numNodos*(numNodos-1))/2;
            float[] distancias = new float[auxdistancias];
            for(int i = 0; i < distancias.length; ++i){
//                System.out.println(i);
                float num = 1 + (int)(Math.random() * (((100) - 1) + 1));
                distancias[i] = num;
            }
            float tc = System.currentTimeMillis();
            cd.anadirCiudad(nombreCiudad, numNodos, nombreNodos, distancias);
            float td = System.currentTimeMillis()-tc;
            System.out.println("Creación de la ciudad terminada.");
            float tb = System.currentTimeMillis()-ta;
            System.out.println("Tiempo creando la ciudad e introduciendola en el sistema: " + tb);
            System.out.println("Tiempo Total creando la ciudad: " + tb);
    }
}
