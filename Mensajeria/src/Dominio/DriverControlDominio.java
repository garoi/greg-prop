/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Albert Gili Zaragoza
 */
public class DriverControlDominio {
    
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
    ControlDominio cd = new ControlDominio();
    //INICIALIZACION DE TODAS LAS CARACTERISTICAS DEL CONTROL DE DOMINIO
    cd.iniControlDominio();
    System.out.println("Funcion de registrar o logear a un usuario u operador :");
    System.out.println("primero registraremos y loguearemos un operador un operador");
    boolean reg;
    reg = cd.registroLogin();
    cd.anadirCiudad();
    System.out.println("Ahora registraremos y loguearemos a un cliente, y lo añadiremos a la lista");
    reg = cd.registroLogin();
    System.out.println("Ahora logearemos con un cliente y un operador ya existentes");
    ControlDominio cd2 = new ControlDominio();
    System.out.println("Ahora vamos a entrar dentro de las funcionalidades del cliente");
    System.out.println("anadiremos 4 paquetes a la lista para posteriormente poder calcular una ruta con ellos");
    cd.anadirPaquete();
    cd.anadirPaquete();
    cd.anadirPaquete();
    cd.anadirPaquete();
    System.out.println("ahora veremos los paquetes que este cliente tiene asignados");
    cd.verPaquetesCliente();
    System.out.println("Vamos a cancelar un paquete");
    cd.cancelarPaquete();
    System.out.println("volvemos a mirar los paquetes y vemos que ha sido eliminado");
    cd.verPaquetesCliente();
    System.out.println("Volvemos a logear con el operador y entramos en sus funcionalidades");
    reg = cd.registroLogin();
    System.out.println("vamos a seleccionar una ciudad, y a partir de aqui crear una ruta");
    cd.seleccionarCiudad();
    System.out.println("vamos a recalcular la ruta eliminando un paquete de la lista");
    cd.seleccionarCiudad();
    }
    
}