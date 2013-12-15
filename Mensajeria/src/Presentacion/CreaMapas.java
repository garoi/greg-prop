/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import java.io.*;
import java.util.*;
import java.lang.System;
import Dominio.ControlDominio;

/**
 *
 * @author ivich
 */
public class CreaMapas {
        ControlDominio cd = new ControlDominio();
        private void main(String[] args) {
            System.out.println("vamos a crear una ciudad");
            System.out.println("nombre de la ciudad: ");
            Scanner sc = new Scanner(System.in);
            String nombreCiudad = sc.next();
            System.out.println("Numero de nodos :");
            int numNodos = sc.nextInt();
        }
}
