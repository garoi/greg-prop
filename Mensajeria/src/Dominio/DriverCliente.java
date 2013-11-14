/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class DriverCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Selecciona funcion a probar" + "\n");
        System.out.print("1: leerCliente" + "\n");
        System.out.print("2: anadirPaquete" + "\n");
        System.out.print("3: cancelarPaquete" + "\n");
        System.out.print("4: eliminarPaquete" + "\n");
        System.out.print("5: verLista" + "\n");
        System.out.print("0: Finalizar" + "\n");
        
        Scanner sc = new Scanner(System.in);
        Cliente c = new Cliente();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                c.leerCliente();
                
                System.out.print("Prueba de getters" + "\n");
                System.out.print("idCliente: " + c.getIdCliente() + "\n");
                System.out.print("password: " + c.getPassword() + "\n");
                System.out.print("nombreCliente: " + c.getNombreCliente() + "\n");
                System.out.print("listaPaquetes: " + c.getListaPaquetes() + "\n");
                
                System.out.print("set de idCliente" + "\n");
                System.out.print("Introduce nuevo id del cliente" + "\n");
                int id = sc.nextInt();
                c.setIDcliente(id);
                System.out.print("Nuevo id del cliente: " + c.getIdCliente() + "\n");
            }
            else if(op == 2){
                Paquete p = new Paquete();
                p.leerPaquete(c.getIdCliente());
                c.anadirPaquete(p);
            }
            else if(op == 3){
                System.out.print("Introduce el id del paquete a cancelar:" + "\n");
                int idPaquete = sc.nextInt();
                c.cancelarPaquete(idPaquete);
            }
            else if(op == 4){
                System.out.print("Introduce el id del paquete a eliminar:" + "\n");
                int idPaquete = sc.nextInt();
                c.eliminarPaquete(idPaquete);
            }
            else if(op == 5){
                System.out.print("Lista de paquetes del cliente: " + "\n");
                c.verLista();
            }
            else {
                System.out.print("Opcion Incorrecta vuelve a seleccionar una opcion");
            }
            
            System.out.print("Selecciona funcion a probar" + "\n");
            op = sc.nextInt();
        }
    }
    
}
