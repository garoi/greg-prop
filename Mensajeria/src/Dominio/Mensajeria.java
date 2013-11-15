package Dominio;
import java.io.*;
import java.util.*;
import java.lang.System;
/**
 *
 * @author ivich HEM DE TENR EN COMPTE EL DESTI DEL PAQUETS I DEL MAPA.
 */
public class Mensajeria {

    public static void infoOperador() {
        System.out.println("1 ver paquetes");
        System.out.println("2 añadir ciudad");
        System.out.println("3 Seleccionar ciudad");
        System.out.println("0 Salir");
    }
    
    public static void infoCliente() {
        System.out.println("1 anadir paquetes");
        System.out.println("2 ver paquetes");
        System.out.println("3 cancelar envio");
        System.out.println("4 eliminar paquetes enviados");
        System.out.println("0 Salir");
    }
    

    public static void funcCliente(ControlDominio cd) throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        infoCliente();
        int op = sc.nextInt();
        while(op != 0){
            if (op == 1){
                cd.anadirPaquete();
            }
            else if (op == 2) {
                cd.verPaquetesCliente();
            }
            else if (op == 3) {
                cd.cancelarPaquete();
            }
            else if (op == 4) {
                cd.elminarPaquete();
            }
            infoCliente();
            op = sc.nextInt();
        }
    }
    

    public static void funcOperador(ControlDominio cd) throws ClassNotFoundException, IOException {

        Scanner sc = new Scanner(System.in);
        infoOperador();
        int op = sc.nextInt();
        while(op != 0){
            if (op == 1){
                cd.verPaquetesOperador();
            }
            else if (op == 2) {
                cd.anadirCiudad();
            }        
            else if (op == 3) {
                cd.seleccionarCiudad();
            }
            infoOperador();
            op = sc.nextInt();
        }
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ControlDominio cd = new ControlDominio();
        cd.iniControlDominio();
        boolean esCliente = false;
        boolean salir = false;
        cd.registroLogin(esCliente, salir);
        //cliente
        if (!esCliente & !salir) {
            funcOperador(cd);
        }
        //operador
        else if(esCliente & !salir){
            funcCliente(cd);
        }
    }
}