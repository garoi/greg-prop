/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.IOException;

/**
 *
 * @author Angel
 */
public class Proves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         ControlPersistencia cp = new ControlPersistencia();
        try{
            cp.crearFichero("sanhi");           
        }
        catch(Exception e){
            
        }
        try{
            cp.abrirFichero("sanhi-mapa.txt");
        }catch(IOException e){
            
        }
        
    }
    
}
