/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.*;

/**
 *
 * @author Albert
 */
public class ControlUsuario {
    
    private Operador oper;
    private ListaClientes lc;
    private Scanner sc;
    private Cliente cl;
    public ControlUsuario(Operador oper, ListaClientes lc, Scanner sc) {
        this.oper = oper;
        this.lc = lc;
        this.sc = sc;
    }
    
    public Cliente registroCliente(){
        cl = new Cliente();
        cl.leerCliente();
        boolean existe = lc.comprueba(cl.getNombreCliente());
        if(!existe){
            return cl;
        }
        else{
            System.out.println("El usuario ya esta registrado");
            return null;
        }
    }
    
    
    public Operador registroOperador(){
                         // System.out.println("IVICH2");
        if(!oper.isCheckExistencia()){
            oper = new Operador(); 
            Scanner sc2 = new Scanner(System.in);
            System.out.println("ponga el nombre del operador");
            String nombre = sc2.nextLine();
            oper.setNombreOperador(nombre);
            System.out.println("ponga el password del operador");
            String password = sc2.nextLine();
            oper.setPassword(password);
            return oper;
        }
        else return null;
    }
    
    
    public Cliente loginCliente(){
        Scanner sc2 = new Scanner(System.in);
        String nombre = sc2.next();
        cl = lc.compruebaCliente(nombre);
        if(cl != null){
            String password = sc.next();
            if(cl.getPassword().equals(password)){
                System.out.println("acceso concedido");
                return cl;
            }
            else{ 
                System.out.println("acceso denegado");
                return null;
            }
        }
        else return null;
    }
    
    public void loginOperador() {
        System.out.println("argibajkln");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Nombre usuario");
        String nombre = sc2.nextLine();
        if(oper.getNombreOperador().equals(nombre)){
            String password = sc2.nextLine();
            if(oper.getPassword().equals(password)){
                System.out.println("acceso concedido");
            }
            else{
                System.out.println("acceso denegado");

            }
        }
    }
    
   /* public Cliente iniCliente(){
        System.out.println("pulse 1 para registrarse, 2 para loguearse");
        int op = sc.nextInt();
         if(op == 1){
             while(!registroCliente());
             return null;
         }
         else if(op == 2){
             while(loginCliente() == null);
             return cl;
         }
         else return null;
    }*/
}
