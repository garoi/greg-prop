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
                ctrlp = new CtrlPresentacion();
            }
        });
    }
}
