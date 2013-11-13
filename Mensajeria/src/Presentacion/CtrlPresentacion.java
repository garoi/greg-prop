/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;
import Dominio.ControlDominio;
import java.awt.Dimension;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class CtrlPresentacion {
    private ControlDominio ctrlDominio;
    private VistaInicial vistaInicial;
    private VistaLogin vistaLogin;
    private VistaClientePrincipal vistaCliente;
    //private javax.swing.JFrame activeFrame;
    
    public CtrlPresentacion(){
        System.out.println("Entra CtrlPresentacion");
        if (vistaInicial == null){
            /* Configura la interfaz para utilizar Nimbus */
            //<editor-fold defaultstate="collapsed" desc=" Comprueba que Nimbus es accesible ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            vistaInicial = new VistaInicial(this);
            vistaInicial.setLocationRelativeTo(null);
            vistaInicial.setVisible(true);
        }
    }
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CtrlPresentacion c = new CtrlPresentacion();
            }
        });
    }
    
    public static void cambiarContenido(java.awt.Container c1, java.awt.Container c2){
        c1.removeAll();
        c1.add(c2);
    }
    
//    public static void setFrameActivo(String nombre){
//        switch(nombre){
//            case "vistaLogin":
//                VistaLogin this.activeFrame;
//                break;
//            default:
//                System.out.println("derp");
//                break;
//        }
//    }

//    public static void setTamanoFrame(Dimension minimumSize) {
//        activeFrame.setSize(minimumSize);
//        activeFrame.setMinimumSize(minimumSize);
//    }

    boolean canLogin(String usuario, String contrasena) {
        if(usuario=="admin" && contrasena=="1234") return true;
        return false;
    }
}
