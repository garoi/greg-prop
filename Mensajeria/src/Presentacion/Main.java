/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;
import Dominio.Mensajeria;
/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class Main {
    static CtrlPresentacion ctrlp;
    
    public static void main(final String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ctrlp = new CtrlPresentacion();
            }
        });
    }
}
