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
    
   private boolean loginCliente = false;
   private boolean loginOper = false;
   
   public boolean isLoginCliente() {
        return loginCliente;
    }

    public boolean isLoginOper() {
        return loginOper;
    }
    
    public boolean registroCliente(Cliente cl, ListaClientes lc){
        cl.leerCliente();
        boolean existe = lc.comprueba(cl.getNombreCliente());
        if(!existe){
            lc.anadirCliente(cl);
            System.out.println("registrado correctamente");
            return true;
        }
        else{
            System.out.println("El usuario ya esta registrado");
            return false;
        }
    }
    
    public void registroOperador(Operador oper){
            Scanner sc = new Scanner(System.in);
            System.out.println("ponga el nombre del operador");
            String nombre = sc.nextLine();
            oper.setNombreOperador(nombre);
            System.out.println("ponga el password del operador");
            String password = sc.nextLine();
            oper.setPassword(password);
    }
    
    
    public int loginCliente(ListaClientes lc){
        Scanner sc2 = new Scanner(System.in);
        String nombre = sc2.next();
        boolean valido = false;
        int indice = -1;
        indice = lc.compruebaCliente(nombre);
        if(indice != -1){
            Cliente cl = lc.getCliente(indice);
            while(!valido){
                String password = sc2.next();
                if(cl.getPassword().equals(password)){
                    System.out.println("acceso concedido");
                    valido = true;
                    loginCliente = true;
                    return indice;
                }
                else{ 
                    System.out.println("acceso denegado");
                }
            }
        }
        return -1;
    }
    
    public void loginOperador(Operador oper) {
        Scanner sc2 = new Scanner(System.in);
        boolean concuerdan = false;
        while(!concuerdan){
            System.out.println("Nombre usuario");
            String nombre = sc2.nextLine();
            if(oper.getNombreOperador().equals(nombre)){
                System.out.println("Contraseña");
                String password = sc2.nextLine();
                if(oper.getPassword().equals(password)){
                    System.out.println("acceso concedido");
                    concuerdan = true;
                    loginOper = true;
                }
                else{
                    System.out.println("acceso denegado");
                }
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
