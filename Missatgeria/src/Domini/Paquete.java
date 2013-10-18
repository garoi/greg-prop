/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;
import java.util.*;
import java.lang.System;
/**
 *
 * @author ivich
 */
public class Paquete {
 private int IDPaquete;
 private int IDCliente;
 private String Destino = new String();
 private String Estado = new String();
 
 
 private Paquete(int IDPaquete, int IDCliente, String Destino, String Estado){
     this.IDPaquete = IDPaquete;
     this.IDCliente = IDCliente;
     this.Destino = Destino;
     this.Estado = Estado;
     
 }
 public Paquete(){}
 public int ConsultaPaquete(){
     return IDPaquete;
 }
 public int ConsultaCliente(){
     return IDCliente;
 }
 public String ConsultaDestino(){
     return Destino;
 }
 
 public String ConsultaEstado(){
     return Estado;
 }
 public void LeerPaquete(int IDCliente){
     Paquete p;
     this.IDCliente = IDCliente;
     Scanner sc = new Scanner(System.in);
     Destino = sc.next();

     
 }
 public void VerDestino(){
     System.out.println(this.Destino);
 }
 
}