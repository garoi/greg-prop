package Dominio;

import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class ControlUsuario {
    
   private boolean loginCliente = false;
   private boolean loginOper = false;
   
   /**
    * 
    * @return loginCliente
    */
   public boolean isLoginCliente() {
        return loginCliente;
    }

   /**
    * 
    * @return loginOper
    */
    public boolean isLoginOper() {
        return loginOper;
    }
    
    /**
     * Registra en el sistema un nuevo cliente
     * @param cl
     * @param lc
     * @return Si el cliente se ha registrado correctamente
     */
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
    
    /**
     * Registra al operador
     * @param oper 
     * 
     */
    public void registroOperador(Operador oper){
            Scanner sc = new Scanner(System.in);
            System.out.println("ponga el nombre del operador");
            String nombre = sc.nextLine();
            oper.setNombreOperador(nombre);
            System.out.println("ponga el password del operador");
            String password = sc.nextLine();
            oper.setPassword(password);
    }
    
    /**
     * Logeamos el cliente
     * @param lc
     * @return id del cliente que se ha logueado
     */
    public int loginCliente(ListaClientes lc){
        Scanner sc2 = new Scanner(System.in);
        String nombre = sc2.next();
        boolean valido = false;
        int indice = -1;
        indice = lc.compruebaCliente(nombre);
        if(indice != -1){
            Cliente cl = lc.getCliente(indice);
            while(!valido){
                System.out.println("Ingrese su contraseña");
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
    
    /**
     * Permite loguear al operador
     * @param oper
     * 
     */
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
}
