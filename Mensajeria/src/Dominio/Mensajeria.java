package Dominio;
import java.io.*;
import java.util.*;
import java.lang.System;
/**
 *
 * @author ivich HEM DE TENR EN COMPTE EL DESTI DEL PAQUETS I DEL MAPA.
 */
public class Mensajeria {
    
    
    
   

    public static void InfoOperador() {
        System.out.println("1 ver paquetes");
        System.out.println("2 añadir ciudad");
        System.out.println("3 modificar ciudad");
        System.out.println("4 seleccionar paquetes y calcular ruta");
        System.out.println("0 Salir");
    }
    
    public static void InfoCliente() {
        System.out.println("1 anadir paquetes");
        System.out.println("2 ver paquetes");
        System.out.println("3 cancelar envio");
        System.out.println("4 eliminar paquetes");
        System.out.println("0 Salir");
    }

    public static void opcion(boolean operador, Operador oper, ListaClientes lc){
            String logreg;    
            Scanner sc = new Scanner(System.in);
            System.out.println("login o registro?");
            logreg = sc.next();
            if(logreg.equals("registro")){
                System.out.println("operador o cliente?");
                String tipo = sc.next();
                if (tipo.equals("operador")){
                    if(operador) {
                        System.out.println("Solo puede haber un operador");
                    }
                    else {
                        System.out.println("Datos operador");
                        oper.LeerOperador();
                        operador = true;
                    }
                }
                else if (tipo.equals("cliente")){
                    System.out.println("Datos cliente");
                    Cliente cl = new Cliente();
                    cl.LeerCliente(cl);
                    lc.AnadirCliente(cl);
                    //++idCliente;
                }
            }
    
    }
    
    public static void funcoperador(Operador oper, ListaPaquetes lp, ControlDominio cd) throws IOException, ClassNotFoundException {
         System.out.println("Escriba su nombre de operador");
                Scanner sc = new Scanner(System.in);
                String nombreoper = sc.next();
                int encontradooper;
                boolean exitoper = false;
                
                //Enctontrar nombre de operador
                if (oper.getNombreOperador().equals(nombreoper)) encontradooper = 1;
                else encontradooper = -1;
                
                while(encontradooper < 0 && !exitoper){
                    System.out.println("operador incorrecto");  
                    System.out.println("pulse 1 para salir");                   
                    System.out.println("pulse 2 para marcar otro nombre");
                    int opcionoper;
                    opcionoper = sc.nextInt();
                    if (opcionoper == 1) {
                        exitoper = true;
                    }
                    else {
                        System.out.println("Vuelva a escribir el nombre");
                        nombreoper = sc.nextLine();
                        if (oper.getNombreOperador() == nombreoper) encontradooper = 1;
                        else encontradooper = -1;
                    }
                }
                //Checkear password del operador encontrado, salir si exit = true
                if (encontradooper >= 0) {
                    System.out.println("ingrese su password");
                    boolean validpassoper = false;
                    String passwordoper = sc.next();
                    if(oper.getPassword().equals(passwordoper)){
                        System.out.println("Acceso concedido");
                        int op = 1;
                        InfoOperador();
                        op = sc.nextInt();
                        while(op != 0){
                            InfoOperador();
                            //VER PAQUETES
                            if (op == 1) {
                                oper.VerPaquetes();
                            }
                            //ANADIR CIUDAD
                            else if (op == 2) {
                                Mapa map = new Mapa();
                                map.CrearCiudad();
                                String name = map.getNombreCiudad();
                                cd.GuardaMapa(map, name);
                            }
                            else if (op == 3) {
                                Mapa m = (Mapa) cd.LeerCiudad();
                                m.ImprimirCiudad();
                            }
                            else if (op == 4) {
                            }

                            op = sc.nextInt();
                        }
                    }
                }
    }
    
    public static void funcliente(ListaClientes lc, Operador oper, ListaPaquetes lp, ControlDominio cd){
                Scanner sc = new Scanner(System.in);
                System.out.println("Escriba su nombre de usuario");
                String nombre;
                nombre = sc.next();
                int encontrado;
                boolean exit = false;
                 encontrado =  lc.EncontrarCliente(nombre);
                while (encontrado < 0 && !exit) {
                    System.out.println("username incorrecto");  
                    System.out.println("pulse 1 para salir");                   
                    System.out.println("pulse 2 para marcar otro nombre");
                    int opcion;
                    opcion = sc.nextInt();
                    if (opcion == 1) {
                        exit = true;
                    }
                    else {
                        System.out.println("Vuelva a escribir el nombre");
                        nombre = sc.nextLine();
                        encontrado =  lc.EncontrarCliente(nombre);                    
                    }
                }
                
                if (encontrado >= 0) {
                    Cliente cl = new Cliente();
                    cl = lc.getCliente(encontrado);
                    System.out.println("ingrese su password");
                    boolean validpass = false;
                    String password;
                    password = sc.next();
                    if (cl.getPassword().equals(password)) {
                        System.out.println("Acceso concedido");
                        int op = 1;
                        InfoCliente();
                        op = sc.nextInt();
                        while (op != 0) {
                            if (op == 1) {
                                Paquete p = new Paquete();
                                p.LeerPaquete(cl.getIdCliente());
                                lp.AnadirPaquete(p);
                                lc.AnadirPaquete(p, cl.getIdCliente());
                                oper.AnadirPaquete(p);
                            }
                            else if (op == 2) {
                                lc.PacksClient(cl.getIdCliente());
                            }
                            else if (op == 3) {
                                //Si el estado del paquete es: para enviar, lo eliminamos.
                                System.out.println("Cual es el idPaquete?");
                                int idPaq = sc.nextInt();
                                lc.CancelarPaquete(cl, idPaq);
                                oper.CancelarPaquete(idPaq);
                                //Falta para quitarlo del operador
                            }
                            else if (op == 4) {
                                //Si el estado es enviado lo eliminamos.
                                System.out.println("Cual es el idPaquete?");
                                int idPaq = sc.nextInt();
                                lc.EliminarPaquete(cl, idPaq);
                                oper.EliminarPaquete(idPaq);
                            }
                            InfoCliente();
                            op = sc.nextInt();
                        }
                    }
                }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ControlDominio cd = new ControlDominio();
        int idCliente = 0;
        int idPaquete = 0;
        boolean operador = false;
        Scanner sc = new Scanner(System.in);
        ListaClientes lc = new ListaClientes();
        Operador oper = new Operador();
        boolean salida = false;
        ListaPaquetes lp = new ListaPaquetes();
        //Bucle principal
        while (!salida) {
            opcion(operador, oper, lc);
            System.out.println("operador o cliente?");
            String tipo2 = sc.next();
            
            //OPERADOR
            if (tipo2.equals("operador")) {
                funcoperador(oper, lp, cd);
            }
            //CLIENTE
            else if (tipo2.equals("cliente")){
                funcliente(lc, oper, lp, cd);
            }
            else System.out.println("Aprende a escribir hijodeputa");   
        }
    }
}