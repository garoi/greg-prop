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
        while(op != 0){
            if (op == 1){ 
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
                op.AnadirPaquete(p);
                
            }
            else if (op == 3) {
                if(!operador){
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