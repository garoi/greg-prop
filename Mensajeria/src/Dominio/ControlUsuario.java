package Dominio;

import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ControlUsuario {
    
 
    public boolean registroOperado(String usuario, String password, Operador oper){
        if(oper != null){
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
    
    public boolean loginCliente(String usuario, String password,ListaClientes lc, Cliente cl2){
        int idCliente;
        idCliente = lc.compruebaCliente(usuario);
        if(idCliente == -1) return false;
        else{
            cl2.setNombre(usuario);
            cl2.setPassword(password);
            cl2.setIDcliente(idCliente);
            if(cl2.getPassword().equals(password)) return true;
            else return false;
        }
    }
}
