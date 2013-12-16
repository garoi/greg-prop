package Dominio;

import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ControlUsuario {
    
 
    public boolean registroOperado(String usuario, String password, Operador oper){
        if (oper != null) {
            oper.setNombreOperador(usuario);
            oper.setPassword(password);
            return true;
        }
        else return false;
    }
    
    
    public boolean loginOperador(String usuario, String password, Operador oper){
        if(oper != null){
            if(oper.getNombreOperador().equals(usuario) && oper.getPassword().equals(password)) return true;
            else return false;
        }
        else return false;
    }
    
    public boolean registroCliente(String usuario, String password, Cliente cl, ListaClientes lc){
        if(lc.comprueba(usuario)){
            return false;
        }
        else{
            lc.anadirCliente(cl);
            return true;
        }
    }
    
    public int loginCliente(String usuario, String password,ListaClientes lc, Cliente cl2){
        System.out.println("LOGIN1");
        int idCliente;
        idCliente = lc.compruebaCliente(usuario);
        System.out.println("LOGIN2");
        if(idCliente == -1) {System.out.println("LOGIN3");return -1;}
        else{
            System.out.println("LOGIN4");
            cl2 = lc.getCliente(idCliente);
            if(cl2.getPassword().equals(password) && cl2.getNombreCliente().equals(usuario)) return idCliente;
            else return -11;
        }
    }
}
