/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.util.Scanner;

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
    
    public boolean registroCliente(){
        cl = new Cliente();
        cl.leerCliente();
        boolean existe = lc.comprueba(cl.getNombreCliente());
        if(!existe){
            lc.anadirCliente(cl);
            return true;
        }
        else{
            System.out.println("El usuario ya esta registrado");
            return false;
        }
    }
    
    
    public Operador registroOperador(){
        if(oper == null){
            oper = new Operador();
            String nombre = sc.nextLine();
            oper.setNombreOperador(nombre);
            String password = sc.nextLine();
            oper.setPassword(password);
            return oper;
        }
        else return null;
    }
    
    
    public Cliente loginCliente(){
        String nombre = sc.nextLine();
        cl = lc.compruebaCliente(nombre);
        if(cl != null){
            String password = sc.nextLine();
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
        String nombre = sc.nextLine();
        if(oper.getNombreOperador().equals(nombre)){
            String password = sc.nextLine();
            if(oper.getPassword().equals(password)){
                System.out.println("acceso concedido");
            }
            else{
                System.out.println("acceso denegado");

            }
        }
    }
    
    public Cliente iniCliente(){
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
    }
}
