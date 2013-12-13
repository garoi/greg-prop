/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;
import Dominio.ControlDominio;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Representa la clase que controla toda la parte de la capa de vistas del programa.
 * @author Luis García Estrades https://github.com/lgarest
 */
public class CtrlPresentacion {
    private ControlDominio ctrld;
    // Declaración de las vistas
    private VistaInicial vistaInicial;
    private VistaLogin vistaLogin;
    private VistaClientePrincipal vistaCliente;
    private VistaOperadorPrincipal vistaOperador;
    private VistaVerPaquetes vistaPaquetes;
    private VistaMapa vistaMapa;
    private VistaCiudad dibujoCiudad;
    private VistaSeleccionTurno vistaTurno;
    private VistaModificarCiudad vistaModificarCiudad;
    private VistaComparacionRutas vistaCompararRutas;
    private VistaSeleccionCiudad vistaCiudad;
    
    private javax.swing.JFrame ventanaPrimaria;
    private javax.swing.JFrame ventanaSecundaria;
    private String tipoUsuario;
    private String ciudad;
    
    /**
     * Permite un control sobre la capa de presentación del programa.
     */
    public CtrlPresentacion(){
        ctrld = new ControlDominio();
//        javax.swing.UIManager.put("ButtonUI", new CustomButton());
        try {
            ctrld.iniControlDominio();
        } catch (IOException ex) {
            Logger.getLogger(CtrlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Entra CtrlPresentacion");
        if (ventanaPrimaria == null){
            vistaInicial = new VistaInicial(this);
            ventanaPrimaria = vistaInicial;
            vistaInicial=null;
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/icono.png"));
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
        if (tipo == "Cliente" || tipo == "Operador") tipoUsuario = tipo;
        else System.out.print("\nTipo de usuario inválido. Los tipos son: \"Cliente\" u \"Operador\"\n");
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
    
    
    /**
     * Permite mostrar una ventana secundaria.
     * @param nuevaVentana el selector de la ventana secundaria que se va a abrir.
     */
    public void iniVentanaSecundaria(String nuevaVentana){
        switch(nuevaVentana){
            case "añadirPaquete":
                if(vistaMapa == null) vistaMapa = new VistaMapa(this);
                ventanaSecundaria = new VistaMapa(this);
                vistaMapa = null;
                ventanaSecundaria.setTitle("Añadir Paquete");
            break;
                
            case "vistaMapa":
                if(vistaMapa == null) vistaMapa = new VistaMapa(this);
                vistaMapa.getContentPane().remove(vistaMapa.getSidebar());
                ventanaSecundaria = vistaMapa;
                ventanaSecundaria.setTitle("Mapa de la ciudad");
//                setTamanoVentanaSecundaria(-165, 0);
            break;
                
            case "vistaTurno":
                if(vistaTurno == null) vistaTurno = new VistaSeleccionTurno(this);
                ventanaSecundaria = vistaTurno;
                vistaTurno = null;
                ventanaSecundaria.setTitle("Selector de turno");
                setTamanoVentanaSecundaria(0, 0);
            break;
                
            case "vistaCiudad":
                if(vistaCiudad == null) vistaCiudad = new VistaSeleccionCiudad(this);
                ventanaSecundaria = vistaCiudad;
                ventanaSecundaria.setTitle("Selector de turno");
                setTamanoVentanaSecundaria(0, 0);
            break;
                
            case "verDibujoCiudad":
                if (dibujoCiudad == null) dibujoCiudad = new VistaCiudad(this);
                ventanaSecundaria = dibujoCiudad;
                ventanaSecundaria.setTitle("Dibujo de la ciudad");
                setTamanoVentanaSecundaria(0, 0);
            break;
                
            case "vistaPaquetes":
                if(vistaPaquetes == null) vistaPaquetes = new VistaVerPaquetes(this);
                ventanaSecundaria = vistaPaquetes;
                ventanaSecundaria.setTitle("Lista de todos los paquetes");
                setTamanoVentanaSecundaria(0, 0);     
            break;
                
            case "vistaModificarCiudad":
                if (vistaModificarCiudad == null) vistaModificarCiudad = new VistaModificarCiudad(this);
                ventanaSecundaria = vistaModificarCiudad;
                ventanaSecundaria.setTitle("Modificar ciudad");
                setTamanoVentanaSecundaria(0, 0);
            break;
                
            case "vistaCompararRutas":
                if (vistaCompararRutas == null) vistaCompararRutas = new VistaComparacionRutas(this);
                ventanaSecundaria = vistaCompararRutas;
                ventanaSecundaria.setTitle("Comparar Rutas");
                setTamanoVentanaSecundaria(0, 0);
            break;
                
            default:
                System.out.println("***** ERROR iniVentanaSecundaria llamada inválida");
                ventanaSecundaria = new VistaMapa(this);
                ventanaSecundaria.setTitle("Mapa de la ciudad");
            break;
        }
        System.out.println("setrelative null");
        ventanaSecundaria.setLocationRelativeTo(null);
        ventanaSecundaria.setVisible(true);
        ventanaSecundaria.setResizable(false);
        ventanaSecundaria.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }
    
    /**
     * Aumenta o disminuye el tamaño de la ventana primaria según su tamaño.
     * @param w el ancho con el que aumenta o disminuye la ventana primaria.
     * @param h el alto con el que aumenta o disminuye la ventana primaria.
     */
    public void setTamanoVentanaPrimaria(int w, int h){
        ventanaPrimaria.setSize(ventanaPrimaria.getWidth() + w, ventanaPrimaria.getHeight() + h);
    }
    
    /**
     * Aumenta o disminuye el tamaño de la ventana secundaria según su tamaño.
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
    public void setVentanaPrincipal(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException{
        switch(nombre){
            case "vistaLogin":
                if (vistaLogin == null) vistaLogin = new VistaLogin(this, tipoUsuario);
                cambiarContenidoVentanaPrimaria(vistaLogin.getContentPane());
                ventanaPrimaria.setTitle("Mensajeria | Login | " + tipoUsuario);
                Dimension d0 = new Dimension(vistaLogin.getPreferredSize());
                d0.setSize(d0.getWidth()-6, d0.getHeight()+10);
//                ventanaPrimaria.setResizable(false);
                ventanaPrimaria.setSize(d0);
                actualizarVentanaPrimaria();
                vistaInicial = null;
                break;
            case "vistaCliente":
                if (vistaCliente == null) vistaCliente = new VistaClientePrincipal(this);
                cambiarContenidoVentanaPrimaria(vistaCliente.getContentPane());
                setTamanoVentanaPrimaria(-8, 15);
                ventanaPrimaria.setTitle("Mensajeria | Cliente");
                Dimension d = new Dimension(vistaCliente.getPreferredSize());
                d.setSize(d.getWidth()-5, d.getHeight()+15);
//                ventanaPrimaria.setResizable(false);
                ventanaPrimaria.setSize(d);
                actualizarVentanaPrimaria();
                vistaLogin = null;
                break;
            case "vistaOperador":
                if (vistaOperador == null)vistaOperador = new VistaOperadorPrincipal(this);
                cambiarContenidoVentanaPrimaria(vistaOperador.getContentPane());
//                setTamanoVentanaPrimaria(-8, 15);
                ventanaPrimaria.setTitle("Mensajeria | Operador");
                Dimension d2 = new Dimension(vistaOperador.getPreferredSize());
                d2.setSize(d2.getWidth()-6, d2.getHeight()-12);
//                ventanaPrimaria.setResizable(false);
                ventanaPrimaria.setSize(d2);
                actualizarVentanaPrimaria();
                vistaLogin = null;
                break;
            default:
                System.out.println("***** ERROR llamada a setVentanaPrincipal con una vista inválida");
                break;
        }
    }
    
    /**
     * Gestiona todas las actualizaciones necesarias en la vista del cliente.
     */
    void actualizarVistaCliente() {
        if (vistaCliente != null)
            vistaCliente.actualizarlista();
    }

    
    /**
     * Permite actualizar el nombre de la ciudad seleccionada por el operador.
     * @param nombreCiudad el nombre de la ciudad seleccionada.
     */
    void actualizarVistaOperador(String nombreCiudad) {
        if (vistaOperador != null)
            vistaOperador.actualizarCiudad(nombreCiudad);
    }

    /**
     * Permite actualizar la fecha y turno de la vista del operador.
     * @param dia dia al que se actualiza
     * @param mes mes al que se actualiza
     * @param ano año al que se actualiza
     * @param turno turno al que se actualiza
     */
    void actualizarDia(int dia, int mes, int ano, String turno) {
        if (vistaOperador != null)
            vistaOperador.actualizarDia(dia, mes, ano, turno);
    }
    
    
    /**
     * Devuelve un string con la primera letra en mayúscula
     * @param s el string que se quiere convertir
     * @return un string con su primera letra en mayúscula y el resto en minúscula
     */
    String titularizar(String s){
        if (s.length()>=1)
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        return "";
    }

    
    /**
     * jfewiaop
     * @return 
     */
    public String getCiudadOperador() {
        return vistaOperador.getCiudad();
    }
    void setCiudad(String nombreCiudad) {
        this.ciudad = nombreCiudad;
        if (this.vistaModificarCiudad != null) this.vistaModificarCiudad.setCiudad(this.ciudad);
    }
}
