/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * Clase que permite ejecutar de forma individual las funciones de la clase Mapa
 * @author Luis García Estrades https://github.com/lgarest
 */
public class DriverMapa {
    
    /**
     * Imprime un menú que permite la interacción con el driver.
     */
    public static void imprimirMenu(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(
            "|0: Imprimir este menú.                 "
            + "| 5: Ejecutar función \"crearCiudad\"        |");
        System.out.println(
            "|1: Ejecutar función \"getNombres\"       "
            + "| 6: Ejecutar función \"imprimirCiudad\"     |");
        System.out.println(
            "|2: Ejecutar función \"getCiudad\"        "
            + "| 7: Ejecutar función \"modificarCiudad\"    |");
        System.out.println(
            "|3: Ejecutar función \"setNombreCiudad\"  "
            + "|                                          |");
        System.out.println(
            "|4: Ejecutar función \"getNombreCiudad\"  "
            + "|-1: Salir del driver.                     |");
//            + "|                                          |");
//        System.out.println(
        System.out.println("------------------------------------------------------------------------------------");
    }
    
    /**
     * Permite ejecutar los métodos de la clase Mapa.
     * @param args Los parametros introducidos por terminal.
     * @throws InputMismatchException Cuando la opción introducida no es un número entero.
     * @see Mapa para más información.
     */
    public static void main(String args[]) throws InputMismatchException {
        
        imprimirMenu();
        Scanner sc = new Scanner(System.in);
        Mapa m = new Mapa();
        int op = -1;
        try{
            System.out.println("Introduce una opción.");
            op = sc.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("La opción introducida debe ser un número entero. Saliendo del programa.");
        }
        while(op!=-1){
            
            switch(op){
                
                case 0:
                    imprimirMenu();
                    break;

                case 1:
                    ArrayList<String> s = new ArrayList<String>();
                    s = m.getNombres();
                    if (s != null){
                        System.out.println("Nombre de los puntos de la ciudad introducidos:");
                        for (int i = 0; i < s.size()-1; i++) {
                            System.out.print(s.get(i) + ", ");
                        }
                        System.out.print(s.get(s.size()-1) + "\n");
                    }
                    else{
                        System.out.println("No se han dado nombre a los puntos de la ciudad todavía.");
                    }
                    break;
                case 2:
                    m.imprimirCiudad();
                    break;
                case 3:
                    System.out.println("Introduce un nombre para la ciudad:");
                    String setNombre = sc.next();
                    m.setNombreCiudad(setNombre);
                    break;
                case 4:
                    String getNombre = m.getNombreCiudad();
                    if(getNombre != null){
                        System.out.printf("Nombre de la ciudad: %s.\n", getNombre);
                    }
                    else System.out.println("No se ha dado nombre a la ciudad todavía.");
                    break;
                case 5:
                    System.out.println("Introduce un nombre para la ciudad:");
                    String nombre = sc.next();
                    System.out.println("Introduce el número de puntos de la ciudad:");
                    int n_puntos = 0;
                    try{
                        n_puntos = sc.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("El número de puntos DEBE ser un número entero."
                            + " Saliendo del programa.");
                        System.exit(1);
                    }
                        
                    m.crearCiudad(nombre, n_puntos);
                    break;
                case 6:
                    m.imprimirCiudad();
                    break;
                case 7:
                    m.modificarCiudad();
                    break;
                case -1:
                default:
                    System.exit(0);
                    break;
            }
            try {
                System.out.println("Introduce una opción (0 muestra la lista de opciones).");
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("La opción introducida debe ser un número entero. Saliendo del programa.");
            }
        }
    }
}
