/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class DriverListaClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        System.out.print("Selecciona funcion a probar" + "\n");
        System.out.print("1: getCliente" + "\n");
        System.out.print("2: anadirCliente" + "\n");
        System.out.print("3: anadirPaquete" + "\n");
        System.out.print("4: encontrarCliente" + "\n");
        System.out.print("5: cancelarPaquete" + "\n");
        System.out.print("6: eliminarPaquete" + "\n");
        System.out.print("7: packsCliente" + "\n");
        System.out.print("8: tamanoListaClientes" + "\n");
        System.out.print("0: Finalizar" + "\n");
        
        Scanner sc = new Scanner(System.in);
        ListaClientes lc = new ListaClientes();
        ControlDominio cd = new ControlDominio();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                System.out.print("Introduce id del cliente" + "\n");
                int id = sc.nextInt();
                if(id < lc.tamanoListaClientes()){
                    System.out.print(lc.getCliente(id).getNombreCliente() + "\n");
                }
                else System.out.print("No existe un cliente con este id" + "\n");
            }
            else if(op == 2){
                Cliente c = new Cliente();
                c.leerCliente();
                lc.anadirCliente(c);
            }
            else if(op == 3){
                System.out.print("Entra el id del cliente al que quieras anadir el paquete");
                int id = sc.nextInt();
                System.out.print("Entra el paquete que quieras anadir");
                Paquete p = new Paquete();
                p.leerPaquete(id,cd);
                
                lc.anadirPaquete(p, id);
                
            }
            else if(op == 4){
                System.out.print("Entra el nombre del cliente que quieras encontrar" + "\n");
                String s = new String(sc.nextLine());
                lc.encontrarCliente(s);
            }
            else if(op == 5){
                System.out.print("Entra el id del paquete que quieras eliminar");
                int idPaquete = sc.nextInt();
                System.out.print("Entra el id del cliente propietario del paquete");
                int idCliente = sc.nextInt();
                Cliente c = new Cliente();
                c = lc.getCliente(idCliente);
                lc.cancelarPaquete(c,idPaquete);
            }
            else if(op == 6){
                System.out.print("Entra el id del paquete que quieras eliminar");
                int idPaquete = sc.nextInt();
                System.out.print("Entra el id del cliente propietario del paquete");
                int idCliente = sc.nextInt();
                Cliente c = new Cliente();
                c = lc.getCliente(idCliente);
                lc.eliminarPaquete(c,idPaquete);
            }
            else if(op == 7){
                System.out.print("Entra el id del cliente");
                int idCliente = sc.nextInt();
                lc.packsCliente(idCliente);
            }
            else if(op == 8){
                System.out.print(lc.tamanoListaClientes() + "\n");
            }
            else System.out.print("Opcion Incorrecta vuelve seleccionar una opcion" + "\n");
            
            System.out.print("Selecciona funcion a probar" + "\n");
            op = sc.nextInt();
        }
    }
    
}
