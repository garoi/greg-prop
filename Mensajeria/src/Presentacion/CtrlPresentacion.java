/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;
import Dominio.ControlDominio;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 * Representa la clase que controla toda la parte de la capa de vistas del programa.
 * @author Luis García Estrades https://github.com/lgarest
 */
public class CtrlPresentacion {
    private ControlDominio ctrld;
    private VistaInicial vistaInicial;
    private VistaLogin vistaLogin;
    private VistaClientePrincipal vistaCliente;
    private VistaOperadorPrincipal vistaOperador;
    private VistaMapa vistaMapa;
    private javax.swing.JFrame ventanaPrimaria;
    private javax.swing.JFrame ventanaSecundaria;
    private String tipoUsuario;
    
    /**
     * Permite un control sobre la capa de presentación del programa.
     */
    public CtrlPresentacion(){
        ctrld = new ControlDominio();
        System.out.println("Entra CtrlPresentacion");
        if (ventanaPrimaria == null){
            
            // devolver la última ventanaPrimaria vista
            vistaInicial = new VistaInicial(this);
            ventanaPrimaria = vistaInicial;
            vistaInicial=null;
            ImageIcon img = new ImageIcon("Data/Resource/icono.png");
            ventanaPrimaria.setIconImage(img.getImage());
            ventanaPrimaria.setLocationRelativeTo(null);
            ventanaPrimaria.setVisible(true);
        }
    }
    
    public ControlDominio getDominio(){
        return ctrld;
    }
    
    /**
     * Define el tipo de usuario que está utilizando la plataforma
     * @param tipo soportados: "Cliente" u "Operador"
     */
    public void setTipoUsuario(String tipo){
        if (tipo == "Cliente" || tipo == "Operador"){
            tipoUsuario = tipo;
        }
        else{
            System.out.print("\nTipo de usuario inválido. Los tipos son: \"Cliente\" u \"Operador\"\n");
        }
    }
    
    /**
     * Permite ejecutarse sin depender del main del paquete
     * @param args son los argumetos que se pasan por terminal.
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CtrlPresentacion c = new CtrlPresentacion();
            }
        });
    }
    
    /**
     *  Reemplaza todo el contenido de la ventana primaria por el contenido pasado por parámetro.
     * @param c2 el contenido con el que se reemplaza.
     */
    public void cambiarContenidoVentanaPrimaria(java.awt.Container c2){
        ventanaPrimaria.getContentPane().removeAll();
        ventanaPrimaria.getContentPane().add(c2);
        ventanaPrimaria.setSize(c2.getSize().width +10, c2.getSize().height+10);
    }
    
//    /**
//     *  Reemplaza todo el contenido de la ventana secundaria por el contenido pasado por parámetro.
//     * @param c2 el contenido con el que se reemplaza.
//     */
//    public void cambiarContenidoVentanaSecundaria(java.awt.Container c2){
//        ventanaSecundaria.getContentPane().removeAll();
//        ventanaSecundaria.getContentPane().add(c2);
//        ventanaSecundaria.setSize(c2.getSize().width +10, c2.getSize().height+10);
//    }
    
    /**
     * Actualiza la ventana primaria redibujando sus componentes
     */
    public void actualizarVentanaPrimaria(){
        ventanaPrimaria.setLocationRelativeTo(null);
        ventanaPrimaria.repaint();
    }

//    /**
//     * Actualiza la ventana secundaria redibujando sus componentes
//     */
//    public void actualizarVentanaSecundaria(){
//        ventanaSecundaria.repaint();        
//    }
    
    public void iniVentanaSecundaria(String nuevaVentana){
        switch(nuevaVentana){
            case "añadirPaquete":
                if(vistaMapa == null)
                    vistaMapa = new VistaMapa(this);
                ventanaSecundaria = new VistaMapa(this);
                ventanaSecundaria.setTitle("Añadir Paquete");
            break;
                
            case "vistaMapa":
                if(vistaMapa == null)
                    vistaMapa = new VistaMapa(this);
                vistaMapa.getContentPane().remove(vistaMapa.getSidebar());
                ventanaSecundaria = vistaMapa;
                ventanaSecundaria.setTitle("Mapa de la ciudad");
//                setTamanoVentanaSecundaria(-165, 0);
            break;
            
            default:
                ventanaSecundaria = new VistaMapa(this);
                ventanaSecundaria.setTitle("Mapa de la ciudad");
            break;
        }
        ventanaSecundaria.setResizable(false);
        ventanaSecundaria.setLocationRelativeTo(null);
        ventanaSecundaria.setVisible(true);
        ventanaSecundaria.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }
    
    /**
     * Aumenta o disminuye el tamaño de la ventana primaria.
     * @param w el ancho con el que aumenta o disminuye la ventana primaria.
     * @param h el alto con el que aumenta o disminuye la ventana primaria.
     */
    public void setTamanoVentanaPrimaria(int w, int h){
        ventanaPrimaria.setSize(ventanaPrimaria.getWidth() + w, ventanaPrimaria.getHeight() + h);
    }
    
    /**
     * Aumenta o disminuye el tamaño de la ventana secundaria.
     * @param w el ancho con el que aumenta o disminuye la ventana secundaria.
     * @param h el alto con el que aumenta o disminuye la ventana secundaria.
     */
    public void setTamanoVentanaSecundaria(int w, int h){
        ventanaSecundaria.setSize(ventanaSecundaria.getWidth() + w, ventanaSecundaria.getHeight() + h);
    }
    
    /**
     * Permite el flujo del programa entre vistas.
     * @param nombre el nombre de la ventana que queremos activar. \nPuede ser: vistaLogin, vistaCliente, etc.
     */
    public void setVentanaPrincipal(String nombre){
        switch(nombre){
            case "vistaLogin":
                if (vistaLogin == null){
                    vistaLogin = new VistaLogin(this, tipoUsuario);
                }
                cambiarContenidoVentanaPrimaria(vistaLogin.getContentPane());
                ventanaPrimaria.setTitle("Mensajeria | Login");
                Dimension d0 = new Dimension(vistaLogin.getMinimumSize());
                d0.setSize(d0.getWidth()-6, d0.getHeight()+10);
                ventanaPrimaria.setResizable(false);
                ventanaPrimaria.setSize(d0);
                actualizarVentanaPrimaria();
                break;
            case "vistaCliente":
                if (vistaCliente == null){
                    vistaCliente = new VistaClientePrincipal(this);
                }
                cambiarContenidoVentanaPrimaria(vistaCliente.getContentPane());
                setTamanoVentanaPrimaria(-8, 15);
                ventanaPrimaria.setTitle("Mensajeria | Cliente");
                Dimension d = new Dimension(vistaCliente.getMinimumSize());
                d.setSize(d.getWidth()-5, d.getHeight()+15);
                ventanaPrimaria.setResizable(false);
                ventanaPrimaria.setSize(d);
                actualizarVentanaPrimaria();
                break;
            case "vistaOperador":
                if (vistaOperador == null){
                    vistaOperador = new VistaOperadorPrincipal(this);
                }
                cambiarContenidoVentanaPrimaria(vistaOperador.getContentPane());
//                setTamanoVentanaPrimaria(-8, 15);
                ventanaPrimaria.setTitle("Mensajeria | Operador");
                Dimension d2 = new Dimension(vistaOperador.getMinimumSize());
                d2.setSize(d2.getWidth()-6, d2.getHeight()-12);
                ventanaPrimaria.setResizable(false);
                ventanaPrimaria.setSize(d2);
                actualizarVentanaPrimaria();
                break;
            default:
                System.out.println("derp");
                break;
        }
    }
}
