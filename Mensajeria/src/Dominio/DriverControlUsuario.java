/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.Scanner;

/**
 *
 * @author Marc Garcia Roig
 */
public class DriverControlUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Selecciona funcion a probar" + "\n");
        System.out.print("1: Get y set de loginCliente y loginOper" + "\n");
        System.out.print("2: registroCliente" + "\n");
        System.out.print("3: registroOperador" + "\n");
        System.out.print("4: loginCliente" + "\n");
        System.out.print("5: loginOperador" + "\n");
        
        Scanner sc = new Scanner(System.in);
        ControlUsuario cu = new ControlUsuario();
        Cliente c = new Cliente();
        ListaClientes lc = new ListaClientes();
        Operador o = new Operador();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                boolean cl = cu.isLoginCliente();
                boolean ope = cu.isLoginOper();
                int cliente = 0;
                int operador = 0;
                if(cl) cliente = 1;
                System.out.print("loginCliente, 1 si true, 0 si es false" + "\n");
                System.out.print(cliente + "\n");
                if(ope) operador = 1;
                System.out.print("loginOper, 1 si true, 0 si es false" + "\n");
                System.out.print(operador + "\n");
            }
            else if(op == 2){
                cu.registroCliente(c,lc);
            }
            else if(op == 3){
                cu.registroOperador(o);
            }
            else if(op == 4){
                cu.loginCliente(lc);
            }
            else if(op == 5){
                cu.loginOperador(o);
            }
            else System.out.print("Opcion Incorrecta, vuelve a seleccionar una opcion");
            System.out.print("Selecciona funcion a probar" + "\n");
            op = sc.nextInt();
        }
        
    }
    
}
