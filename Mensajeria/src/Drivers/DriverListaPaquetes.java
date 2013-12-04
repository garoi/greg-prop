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
 * @author Albert Gili Zaragoza
 */
public class DriverListaPaquetes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        System.out.print("Selecciona funcion a probar" + "\n");
        System.out.print("1: anadirPaquete" + "\n");
        System.out.print("2: tamanoListaPaquetes" + "\n");
        System.out.print("3: escribePaquete" + "\n");
        System.out.print("0: Finalizar" + "\n");
        Scanner sc = new Scanner(System.in);
        ListaPaquetes lp = new ListaPaquetes();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                Paquete p = new Paquete();
                System.out.print("Crea un paquete para poder anadirlo" + "\n");
                System.out.print("Entra el id. del cliente" + "\n");
                int idcliente = sc.nextInt();
                System.out.print("entra el nombre de la ciudad" + "\n");
                String nombreciudad = sc.nextLine();
                p.leerPaquete(idcliente, nombreciudad);
                lp.anadirPaquete(p);
            }
            else if(op == 2){
                System.out.print("Tamano de la lista de paquetes: " + lp.tamanoListaPaquetes() + "\n");  
            }
            else if(op == 3){
                System.out.print("Escribimos los paquetes de la lista" + "\n");
                for(int i = 0; i < lp.tamanoListaPaquetes();++i){
                    lp.escribirPaquete(i);
                }
            }
            else {
                System.out.print("Opcion Incorrecta vuelve seleccionar una opcion" + "\n");
            }
            System.out.print("Selecciona funcion a probar" + "\n");
            op = sc.nextInt();
        }
        
        
    }
    
}