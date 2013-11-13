/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;
import java.util.Scanner;
import Dominio.Mensajeria;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class Main {
    static CtrlPresentacion ctrlp;
    static Mensajeria msn;
    
    public static void main(final String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("1 para arrancar la interfaz.");
                System.out.println("2 para ejecutar el programa por terminal.");
                System.out.println("3 para cerrar el programa.");
                int i = sc.nextInt();
                if( i == 1) ctrlp = new CtrlPresentacion();
                else if(i==2){ 
                    msn = new Mensajeria();
                    try {
                        msn.main(args);
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else System.exit(0);
            }
        });
    }
}
