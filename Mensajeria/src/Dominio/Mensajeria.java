package Dominio;
import java.io.*;
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
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int IDclient = 0;
        boolean operador = false;
        ControlDominio cd = new ControlDominio();
        int op;
        Scanner sc = new Scanner(System.in);
        info();
        op = sc.nextInt();
        ListaClientes lc = new ListaClientes();
        //Cliente c = new Cliente();
        //Paquete p = new Paquete();
        Operador oper = new Operador();
        
        //Bucle principal
        while(op != 0){
            
            
            Scanner sc2 = new Scanner(System.in);
            String logreg;
            logreg = sc2.next();
            System.out.println("login o registro?");
            if(logreg.equals("registro")){
                String tipo = sc2.next();
                System.out.println("operador o cliente?");
                if(tipo.equals("operador")){
                    if(operador) System.out.println("Solo puede haber un operador");
                        else{
                        System.out.println("datos operador");
                        oper.LeerOPerador();
                        operador = true;
                        }
                }
                else if (tipo.equals("cliente")){
                     System.out.println("datos cliente");
                        Cliente cl = new Cliente();
                        cl.LeerCliente(cl,IDclient);
                        lc.AnadirCliente(cl);
                        ++IDclient;
                }
            }
            System.out.println("operador o cliente?");
            String tipo2 = sc2.next();
            if(tipo2.equals("operador")){}
            else if(tipo2.equals("cliente")){
                //Cliente cl = new Cliente();
                System.out.println("escriba su nombre de usuario");
                String nombre;
                nombre = sc2.next();
                boolean encontrado = false;
                boolean exit = false;
                
                //Enctontrar nombre de ususario del cliente
                encontrado =  lc.EncontrarCliente(nombre);
                Scanner sc3 = new Scanner(System.in);
                while(!encontrado && !exit){
                    System.out.println("username incorrecto");  
                    System.out.println("pulse 1 para salir");                   
                    System.out.println("pulse 2 para marcar otro nombre");
                    int opcion;
                    opcion = sc3.nextInt();
                    if(opcion == 1){
                        exit = true;
                    }
                    else{
                    nombre = sc2.next();
                    encontrado =  lc.EncontrarCliente(nombre);                    
                    }
                }
                //Checkear password del usuario encontrado, salir si exit = true
                if(encontrado){
                    System.out.println("ingrese su password");
                    boolean validpass = false;
                    String password;
                    password = sc2.next();
                    Cliente cl = new Cliente();
                    cl = lc.getClient(nombre);
                    if(cl.getPass() == password){
                        
                    }
                }
                
                
            }
            else System.out.println("Aprende a escribir hijodeputa");
            
            }
            
            
            
            
            /*if (op == 1){ 
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/mapa1.txt"))) {
                    Mapa m = new Mapa();
                    m.CrearCiudad();
                    m.ImprimirCiudad();
                    oos.writeObject(m);
                }
                System.out.println("VOY A ESCRIBIR EL MAPA DESDE FICHERO");
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/mapa1.txt"))) {
                    Mapa m2 = (Mapa) ois.readObject();
                    m2.ImprimirCiudad();
                }
                
            }
            else if (op == 2){
                //ListaPaquetes lp = new ListaPaquetes();
                Paquete p = new Paquete();
                p.LeerPaquete(IDclient);
                lc.AnadirPaquete(p, IDclient);
                //0op.AnadirPaquete(p);     
            }
            else if (op == 3) {
                Scanner sc2 =  new Scanner(System.in);
                String tipo;
                System.out.println("operador o cliente?");
                tipo = sc2.next();
                if(tipo.equals("operador")){
                    if(operador) System.out.println("Solo puede haber un operador");
                    else{
                    System.out.println("datos operador");
                    oper.LeerOPerador();
                    operador = true;
                    }
                }
                else{
                    System.out.println("datos cliente");
                    Cliente cl = new Cliente();
                    cl.LeerCliente(cl,IDclient);
                    lc.AnadirCliente(cl);
                    ++IDclient;
                }
            }
            info();*/
            op = sc.nextInt();
        }
    }
//}