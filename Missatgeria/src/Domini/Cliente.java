/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author ivich
 */
public class Cliente {
    private int IDCliente;
    private String NombreCliente = new String();
    
    
    private void AnadirCliente(int IDCliente, String NombreCliente){
        this.IDCliente = IDCliente;
        this.NombreCliente = NombreCliente;
        
    }
    
    public void InsertarPaquete(){
        Paquete p = new Paquete();
        p.LeerPaquete(IDCliente);
        
    }
    
}