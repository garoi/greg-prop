/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author Albert Gili Zaragoza
 */
public class DriverOperador {
    
   /**
    * Muestra el menú del driver.
    */
   public static void printMenu(){
       System.out.println("-----------------------------------------------------"
           + "--------------------------------------------");
        System.out.println("|1: Nuevo Operador                                   "
            + "     | 7: Cambiar estado paquetes          |");
        System.out.println("|2: Ver Operador                                     "
            + "     | 8: Añadir ciudad                    |");
        System.out.println("|3: Añadir paquete a la lista de paquetes por entregar"
            + "    | 9: Ver ciudad                       |");
        
        System.out.println("|4: Ver lista paquetes por entregar                  "
            + "     |10: Modificar ciudad                 |");
        System.out.println("|5: Seleccionar paquetes para la próxima ruta        "
            + "     | 0: Mostrar este menú                |");
        System.out.println("|6: Modificar lista paquetes por entregar            "
            + "     |-1: Finalizar                        |");
        System.out.println("-----------------------------------------------------"
           + "--------------------------------------------");
   }
    
   /**
    * Main del driver operador que permite testear el driver.
    * @param args parámetros mostrados por persona
    * @throws IOException
    * @throws ClassNotFoundException 
    */
   public static void main(String[] args) throws IOException, ClassNotFoundException {
        printMenu();
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        Operador o = new Operador();
        Mapa m = new Mapa();
        ArrayList <Paquete> lp = new ArrayList<Paquete>();
        
        String ciudad = new String();

        while(op != -1){
            if(op == 0){
                //"Imprime este menú"
                printMenu();
            }
            else if(op == 1){
                //"Nuevo Operador"
                System.out.println("Añadir operador:");
                o.leerOperador();
                o.setCheckExistencia(true);
            }
            else if(op == 2){
                //"Ver Operador"
                if (o.getNombreOperador() != null){
                    System.out.println("El operador se llama:");
                    System.out.println(o.getNombreOperador());
                }
                else System.out.println("No se ha definido el operador.");
            }
            else if(op==3){
                // Añadir paquete a pendientes
                if (o != null){
                    Paquete p = new Paquete();
                    if (ciudad != null){
                        p.setCiudad(ciudad);
                        p.setIdCliente(1);
                        p.leerPaquete(1, ciudad);
                        o.anadirPaquete(p);
                    }
                    else System.out.println("No se ha definido la ciudad");
                }
                else System.out.println("No se ha definido el operador");
            }
            else if(op == 4){
                //"Ver lista paquetes por entregar"
                System.out.println("Mostrando los paquetes por enviar:");
                if (o != null) o.verPaquetes();
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 5) {
                if (o != null){
                    //"5: Seleccionar paquetes para la próxima ruta"
                    System.out.println("Introduce una fecha en formato \"dd.mm.aa\":");
                    String fecha = sc.next();
                    System.out.println("Introduce un turno de entrega: (mañana/tarde)");
                    String turno = sc.next();
                    lp = o.seleccionarPaquetes(m.getNombreCiudad(), fecha, turno);
                }
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 6){
                //"Modificar lista paquetes por entregar -> recalcular ruta"
                if (o != null) o.modificaListaPaquetes(lp);
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 7){
                //"Cambiar el estado de los paquetes a enviados"
                if (o != null) o.cambiarEstadoPaquetes(lp);
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 8){
                //"Ver lista paquetes entregados"
                System.out.println("Mostrando los paquetes entregados:");
                if (o != null) o.verPaquetes();
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 9){
                //"Añadir ciudad"
                if (o != null) m = o.anadirCiudad(m);
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 10){
                //"Ver ciudad"
                if (o != null) o.verCiudad(m);
                else System.out.println("No se ha definido el operador.");
            }
            else if (op == 11){
                //"Modificar ciudad"
                if (o != null) o.modificarCiudad(m);
                else System.out.println("No se ha definido el operador.");
            }
            else{
                System.out.println("Opción inválida");
            }
            System.out.println("Selecciona funcion a probar (o 0 para mostrar las opciones):");
            op = sc.nextInt();
        }
   }
}
