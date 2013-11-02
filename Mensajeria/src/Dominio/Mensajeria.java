package Dominio;
import java.util.*;
import java.lang.System;
/**
 *
 * @author ivich
 */
public class Mensajeria {
    
    /**
     * @param args the command line arguments
     */
    public static void info() {
        System.out.println("Entra una opcion\n" + "1 = Crear ciudad");
        System.out.println("2 = Añadir paquetes\n" + "3 = Calculo de la ruta");
        System.out.println("0 = Cerrar");
    }
    
    public static void main(String[] args) {
        int IDclient = 0;
        boolean operador = false;
        ControlDominio cd = new ControlDominio();
        int op;
        Scanner sc = new Scanner(System.in);
        info();
        op = sc.nextInt();
        while(op != 0){
            if (op == 1){ 
                Ruta r = new Ruta();
                r.CrearCiudad();
                r.ImprimirCiudad();
            }
            else if (op == 2){
                ListaPaquetes lp = new ListaPaquetes();
                Paquete p = new Paquete();
                p.InsertarPaquete(IDclient);
                lp.AnadirPaquete(p);
            }
            else if (op == 3) {
                if(!operador){
                    Operador oper = new Operador();
                    oper.LeerOPerador();
                    operador = true;
                }
                else{
                    Cliente cl = new Cliente();
                    cl.AnadirCliente(IDclient);
                    ++IDclient;
                }
            }
            info();
            op = sc.nextInt();
        }
    }
}