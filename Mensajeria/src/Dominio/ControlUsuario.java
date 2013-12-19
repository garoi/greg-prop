package Dominio;

import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ControlUsuario {
    
 
    /**
     *
     * @param usuario
     * @param password
     * @param oper
     * @return retorna true si el operador ha sido registrado con exito
     * false si ya esta registrado
     */
    public boolean registroOperado(String usuario, String password, Operador oper){
        if (oper != null) {
            oper.setNombreOperador(usuario);
            oper.setPassword(password);
            return true;
        }
        else return false;
    }
    
    
    /**
     *
     * @param usuario
     * @param password
     * @param oper
     * @return retorna true si el usuario y el password coinciden con operador
     * si no retorna false
     */
    public boolean loginOperador(String usuario, String password, Operador oper){
        if(oper != null){
            if(oper.getNombreOperador().equals(usuario) && oper.getPassword().equals(password)) return true;
            else return false;
        }
        else return false;
    }
    
    /**
     *
     * @param usuario
     * @param password
     * @param cl
     * @param lc
     * @return true si el cliente no exisitia, se crea, false en el caso de que
     * ya exista en el sistema
     */
    public boolean registroCliente(String usuario, String password, Cliente cl, ListaClientes lc){
        if(lc.comprueba(usuario)){
            return false;
        }
        else{
            lc.anadirCliente(cl);
            return true;
        }
    }
    
    /**
     *
     * @param usuario
     * @param password
     * @param lc
     * @param cl2
     * @return true si el password y el usuario coinciden con el cliente, false
     * si no coinciden.
     */
    public int loginCliente(String usuario, String password,ListaClientes lc, Cliente cl2){
        int idCliente;
        idCliente = lc.compruebaCliente(usuario);
        if(idCliente == -1) return -1;
        else{
            cl2 = lc.getCliente(idCliente);
            if(cl2.getPassword().equals(password) && cl2.getNombreCliente().equals(usuario)) return idCliente;
            else return -11;
        }
    }
}
