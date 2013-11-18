/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Albert Gili Zaragoza
 */
public class DriverOperador {
    
     public static void main(String[] args) throws IOException, ClassNotFoundException{
         ListaPaquetes lp = new ListaPaquetes();
         Operador oper = new Operador();
         System.out.println("setters: nombre = alicia, password = hola, bool = true");
         oper.setNombreOperador("Alicia");
         oper.setPassword("hola");
         oper.setCheckExistencia(true);
         System.out.println("Prueba de getters");
         System.out.println(oper.getNombreOperador());
         System.out.println(oper.getPassword());
         System.out.println("añadiremos 3 paquetes");
         Paquete p1 = new Paquete();
         Paquete p2 = new Paquete();
         Paquete p3 = new Paquete();
         p1.leerPaquete(0, "bcn");
         p2.leerPaquete(0, "bcn");
         p3.leerPaquete(0, "bcn");
         lp.anadirPaquete(p1);         
         lp.anadirPaquete(p2);         
         lp.anadirPaquete(p3);
         oper.anadirPaquete(p1);
         oper.anadirPaquete(p2);
         oper.anadirPaquete(p3);
         oper.verPaquetes();
         oper.verPaquetes();
         oper.verPaquetes();
         ArrayList <Paquete> paquetes = new ArrayList<>();
         System.out.println("vamos a seleccionar paquetes para crear una ruta");
         paquetes = oper.seleccionarPaquetes("bcn", "17.12.13", "tarde");
         Mapa map = new Mapa();
         oper.anadirCiudad(map);
         oper.modificarCiudad(map);
         paquetes = oper.modificaListaPaquetes(paquetes);
         
     }
    
}