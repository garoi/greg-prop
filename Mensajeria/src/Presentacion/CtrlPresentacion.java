package Presentacion;
import Dominio.ControlDominio;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Representa la clase que controla toda la parte de la capa de vistas del programa.
 * @author Luis García Estrades https://github.com/lgarest
 */
public class CtrlPresentacion {
    
    // <editor-fold defaultstate="collapsed" desc="Declaración de variables">
    private ControlDominio ctrld;
    // Declaración de las vistas
    private VistaInicial vistaInicial;
    private VistaLogin vistaLogin;
    private VistaClientePrincipal vistaCliente;
    private VistaOperadorPrincipal vistaOperador;
    private VistaVerPaquetes vistaPaquetes;
    private VistaAnadirPaquete vistaAnadirPaquete;
    private VistaCiudad dibujoCiudad;
    private VistaSeleccionTurno vistaTurno;
    private VistaModificarCiudad vistaModificarCiudad;
    private VistaComparacionRutas vistaCompararRutas;
    private VistaSeleccionCiudad vistaCiudad;
    private VistaModificarRuta vistaModificarRuta;
    private Advertencia vistaAdvertencia;
    
    private javax.swing.JFrame ventanaPrimaria;
    private javax.swing.JFrame ventanaSecundaria;
    private String tipoUsuario;
    private String ciudad;
    private String ruta;
    private float max;
    private float min;
    // </editor-fold>
    
    /* CREADORA */
    
    // <editor-fold defaultstate="collapsed" desc="public CtrlPresentacion()">
    /**
     * Permite un control sobre la capa de presentación del programa.
     */
    public CtrlPresentacion(){
        ctrld = new ControlDominio();
        try {
            ctrld.iniControlDominio();
        } catch (IOException ex) {
            Logger.getLogger(CtrlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ventanaPrimaria == null){
            vistaInicial = new VistaInicial(this);
            ventanaPrimaria = vistaInicial;
            vistaInicial=null;
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/icono.png"));
            ventanaPrimaria.setIconImage(img.getImage());
            ventanaPrimaria.setLocationRelativeTo(null);
            ventanaPrimaria.setVisible(true);
        }
        max = -1f;
        min = -1f;
    } // </editor-fold>
    
    /* GETTERS */
    
    // <editor-fold defaultstate="collapsed" desc="public String getCiudad()"> 
    /**
     * Devuelve la ciudad seleccionada por el operador.
     * @return nombre de la ciudad.
     */
    public String getCiudad() {
        if (vistaOperador != null){
            String ret = vistaOperador.getCiudad();
            setCiudad(ret);
            return ret;
        }
        return ciudad;
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String getRuta() "> 
    /**
     * Devuelve la ruta seleccionada por el operador
     * @return 
     */
    public String getRuta() {
        return ruta;
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String getFechaOperador()"> 
    /**
     * Permite obtener la fecha y el turno seleccionado por el operador.
     * @return la fecha y turno
     */
    public String getFechaOperador() {
        return vistaOperador.getFecha();
    } // </editor-fold>
    
    /* SETTERS */
    
    // <editor-fold defaultstate="collapsed" desc="public void setTipoUsuario(String tipo)">  
    /**
     * Define el tipo de usuario que está utilizando la plataforma
     * @param tipo soportados: "Cliente" u "Operador"
     */
    public void setTipoUsuario(String tipo){
        if (tipo == "Cliente" || tipo == "Operador") tipoUsuario = tipo;
        else System.out.print("\nTipo de usuario inválido. Los tipos son: \"Cliente\" u \"Operador\"\n");
    }// </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="public void setCiudad(String nombreCiudad)"> 
    /**
     * Modifica la ciudad seleccionada por el operador
     * @param nombreCiudad  nombre de la ciudad seleccionada
     */
    public void setCiudad(String nombreCiudad) {
        ciudad = nombreCiudad;
        if (vistaOperador != null) {
            vistaOperador.actualizarCiudad(ciudad);
        }
        if (vistaModificarCiudad != null){
            vistaModificarCiudad.setCiudad(ciudad);
        }
        if (dibujoCiudad != null) {
            dibujoCiudad.setCiudad(ciudad);
        }
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setRuta(String ruta)"> 
    /**
     * Modifica el nombre de la ruta seleccionada por el operador
     * @param ruta  nombre de la ruta
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setContenidoVentanaPrimaria(java.awt.Container c2)">  
    /**
     *  Reemplaza todo el contenido de la ventana primaria por el contenido pasado por parámetro.
     * @param c2 el contenido con el que se reemplaza.
     */
    public void setContenidoVentanaPrimaria(java.awt.Container c2){
        ventanaPrimaria.getContentPane().removeAll();
        ventanaPrimaria.getContentPane().add(c2);
        ventanaPrimaria.setSize(c2.getSize().width +10, c2.getSize().height+10);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setVentanaPrincipal(String nombre)"> 
    /**
     * Permite el flujo del programa entre vistas.
     * @param nombre el nombre de la ventana que queremos activar. \nPuede ser: vistaLogin, vistaCliente, etc.
     */
    public void setVentanaPrincipal(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException{
        switch(nombre){
            case "vistaLogin":
                if (vistaLogin == null) vistaLogin = new VistaLogin(this, tipoUsuario);
                setContenidoVentanaPrimaria(vistaLogin.getContentPane());
                setTamanoVentanaPrimaria(20,10);
                ventanaPrimaria.setTitle("Mensajeria | Login | " + tipoUsuario);
//                Dimension d0 = new Dimension(vistaLogin.getPreferredSize());
//                d0.setSize(d0.getWidth()-6, d0.getHeight()+10);
//                ventanaPrimaria.setResizable(false);
//                ventanaPrimaria.pack();
//                ventanaPrimaria.setSize(d0);
                vistaInicial = null;
                break;
            case "vistaCliente":
                if (vistaCliente == null) vistaCliente = new VistaClientePrincipal(this);
                setContenidoVentanaPrimaria(vistaCliente.getContentPane());
//                setTamanoVentanaPrimaria(-8, 15);
                setTamanoVentanaPrimaria(0,0);
                ventanaPrimaria.setTitle("Mensajeria | Cliente");
//                Dimension d = new Dimension(vistaCliente.getPreferredSize());
//                d.setSize(d.getWidth()-5, d.getHeight()+15);
//                ventanaPrimaria.setResizable(false);
//                ventanaPrimaria.setSize(d);
                vistaLogin.dispose();
                break;
            case "vistaOperador":
                if (vistaOperador == null)vistaOperador = new VistaOperadorPrincipal(this);
                setContenidoVentanaPrimaria(vistaOperador.getContentPane());
//                setTamanoVentanaPrimaria(-8, 15);
                setTamanoVentanaPrimaria(-90,40);
                ventanaPrimaria.setTitle("Mensajeria | Operador");
//                Dimension d2 = new Dimension(vistaOperador.getPreferredSize());
//                d2.setSize(d2.getWidth()-6, d2.getHeight()-12);
//                ventanaPrimaria.setResizable(false);
//                ventanaPrimaria.setSize(d2);
                vistaLogin.dispose();
                break;
            default:
                System.out.println("***** ERROR llamada a setVentanaPrincipal con una vista inválida");
                break;
                
        }
        actualizarVentanaPrimaria();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setVentanaSecundaria(String nuevaVentana"> 
    /**
     * Permite mostrar una ventana secundaria.
     * @param nuevaVentana el selector de la ventana secundaria que se va a abrir.
     */
    public void setVentanaSecundaria(String nuevaVentana) throws IOException, FileNotFoundException, ClassNotFoundException{
        switch(nuevaVentana){
            case "añadirPaquete":
                if(vistaAnadirPaquete == null) vistaAnadirPaquete = new VistaAnadirPaquete(this);
                ventanaSecundaria = new VistaAnadirPaquete(this);
                vistaAnadirPaquete = null;
                ventanaSecundaria.setTitle("Añadir Paquete");
            break;
                
            case "vistaModificarRuta":
//                if(vistaModificarRuta != null) vistaModificarRuta = new VistaModificarRuta(this, getDestinosRuta());
                ventanaSecundaria = new VistaModificarRuta(this);
                vistaModificarRuta = null;
                ventanaSecundaria.setTitle("Ver / Editar Ruta");
                
//                    VistaModificarRuta vistaModificarRuta
            break;
                
            case "vistaTurno":
                if(vistaTurno == null) vistaTurno = new VistaSeleccionTurno(this);
                ventanaSecundaria = vistaTurno;
                vistaTurno = null;
                ventanaSecundaria.setTitle("Selector de turno");
            break;
                
            case "vistaCiudad":
                if(vistaCiudad == null) vistaCiudad = new VistaSeleccionCiudad(this);
                ventanaSecundaria = vistaCiudad;
                ventanaSecundaria.setTitle("Selector de turno");
            break;
                
            case "verDibujoCiudad":
                if (dibujoCiudad == null) dibujoCiudad = new VistaCiudad(this);
                dibujoCiudad.reset();
                ventanaSecundaria = dibujoCiudad;
                ventanaSecundaria.setTitle(ciudad);
            break;
                
            case "vistaPaquetes":
                if(vistaPaquetes == null) vistaPaquetes = new VistaVerPaquetes(this);
                ventanaSecundaria = vistaPaquetes;
                ventanaSecundaria.setTitle("Lista de todos los paquetes");
            break;
                
            case "vistaModificarCiudad":
                if (vistaModificarCiudad == null) vistaModificarCiudad = new VistaModificarCiudad(this, getCiudad());
                ventanaSecundaria = vistaModificarCiudad;
                ventanaSecundaria.setTitle("Modificar ciudad");
            break;
                
            case "vistaCompararRutas":
                if (vistaCompararRutas == null) vistaCompararRutas = new VistaComparacionRutas(this);
                ventanaSecundaria = vistaCompararRutas;
                ventanaSecundaria.setTitle("Comparar Rutas");
                
            break;
                
            case "advertencia":
                if (vistaAdvertencia == null) vistaAdvertencia = new Advertencia(this);
                ventanaSecundaria = vistaAdvertencia;
                ventanaSecundaria.setTitle("Error");
                setTamanoVentanaSecundaria(0, 0);
            break;
                
            default:
                System.out.println("***** ERROR iniVentanaSecundaria llamada inválida");
                ventanaSecundaria = new VistaAnadirPaquete(this);
                ventanaSecundaria.setTitle("Mapa de la ciudad");
            break;
        }
        setTamanoVentanaSecundaria(0, 0);
        ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/icono.png"));
        ventanaSecundaria.setIconImage(img.getImage());
        ventanaSecundaria.setLocationRelativeTo(null);
        ventanaSecundaria.setVisible(true);
        ventanaSecundaria.setResizable(false);
        ventanaSecundaria.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setTamanoVentanaPrimaria(int w, int h)"> 
    /**
     * Aumenta o disminuye el tamaño de la ventana primaria según su tamaño.
     * @param w el ancho con el que aumenta o disminuye la ventana primaria.
     * @param h el alto con el que aumenta o disminuye la ventana primaria.
     */
    public void setTamanoVentanaPrimaria(int w, int h){
        ventanaPrimaria.setSize(ventanaPrimaria.getWidth() + w, ventanaPrimaria.getHeight() + h);
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public void setTamanoVentanaSecundaria(int w, int h)"> 
    /**
     * Aumenta o disminuye el tamaño de la ventana secundaria según su tamaño.
     * @param w el ancho con el que aumenta o disminuye la ventana secundaria.
     * @param h el alto con el que aumenta o disminuye la ventana secundaria.
     */
    public void setTamanoVentanaSecundaria(int w, int h){
        ventanaSecundaria.setSize(ventanaSecundaria.getWidth() + w, ventanaSecundaria.getHeight() + h);
    } // </editor-fold>

    
    /* SINCRONIZADORES */

    // <editor-fold defaultstate="collapsed" desc="public void actualizarVentanaPrimaria("> 
    /**
     * Actualiza la ventana primaria redibujando sus componentes
     */
    public void actualizarVentanaPrimaria(){
        ventanaPrimaria.setLocationRelativeTo(null);
        ventanaPrimaria.repaint();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void actualizarVentanaSecundaria()"> 
    public void actualizarVentanaSecundaria() {
        ventanaSecundaria.setLocationRelativeTo(null);
        ventanaSecundaria.repaint();
    } // </editor-fold>

    // OPERADOR
    
    // <editor-fold defaultstate="collapsed" desc="public void actualizarDia(int dia, int mes, int ano, String turno)"> 
    /**
     * Permite actualizar la fecha y turno de la vista del operador.
     * @param dia dia al que se actualiza
     * @param mes mes al que se actualiza
     * @param ano año al que se actualiza
     * @param turno turno al que se actualiza
     */
    public void actualizarDia(int dia, int mes, int ano, String turno) {
        if (vistaOperador != null)
            vistaOperador.actualizarDia(dia, mes, ano, turno);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void actualizarVistaSelCiudades()"> 
    public void actualizarVistaSelCiudades() {
        if(vistaCiudad != null){
            vistaCiudad.actualizarListaCiudades();
        }
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void actualizarRutasOperador()"> 
    public void actualizarRutasOperador() {
        vistaOperador.actualizarRutas();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setListaEnRutaS(ArrayList<String> listaEnRutaS)"> 
    /**
     * Modifica la lista de las rutas en el operador
     * @param listaEnRutaS 
     */
    public void setListaEnRutaS(ArrayList<String> listaEnRutaS) {
        vistaOperador.setListaEnRutas(listaEnRutaS);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void actualizarListaEnRuta()"> 
    /**
     * Actualiza la lista de paquetes en ruta en el operador.
     */
    public void actualizarListaEnRuta() {
        vistaOperador.actualizarListaEnRuta();
    } // </editor-fold>
    
    // CLIENTE
    
    // <editor-fold defaultstate="collapsed" desc="public void actualizarVistaCliente()"> 
    /**
     * Gestiona todas las actualizaciones necesarias en la vista del cliente.
     */
    public void actualizarVistaCliente() {
        if (vistaCliente != null)
            vistaCliente.actualizarlista();
    } // </editor-fold>

    
    /* COMUNICACION CON LA CAPA DE DOMINIO */
    
    // SESIÓN
    
    // <editor-fold defaultstate="collapsed" desc="public boolean registroCliente(String usuario, String password)"> 
    public boolean registroCliente(String usuario, String password) throws IOException{
        return ctrld.registroCliente(usuario, password);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public boolean registroOperador(String usuario, String password)"> 
    public boolean registroOperador(String usuario, String password) throws IOException, ClassNotFoundException{
        return ctrld.registroOperador(usuario, password);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public boolean loginCliente(String usuario, String password)"> 
    public boolean loginCliente(String usuario, String password) throws IOException{
        return ctrld.loginCliente(usuario, password);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public boolean loginOperador(String usuario, String password)"> 
    public boolean loginOperador(String usuario, String password) throws IOException, ClassNotFoundException{
        return ctrld.loginOperador(usuario, password);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String[] getFechaAhora()"> 
    /**
     * Devuelve la fecha y turno del sistema.
     * @return 
     */
    public String[] getFechaAhora(){
        return ctrld.fechaHoy();
    } // </editor-fold>
    
    
    // CIUDAD
    
    // <editor-fold defaultstate="collapsed" desc="public String[] getNombresCiudades()"> 
    public String[] getNombresCiudades(){
        return ctrld.getNombresCiudades();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String[] getDestinosCiudad(String nombreCiudad)"> 
    /**
     * Devuelve los destinos de la ciudad
     * @param nombreCiudad el nombre de la ciudad
     * @return los destinos disponibles para la ciudad
     * @throws IOException 
     */
    public String[] getDestinosCiudad(String nombreCiudad) throws IOException{
        return ctrld.getDestinosCiudad(nombreCiudad);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<String> getNombresCiudad(String nombreCiudad)"> 
    /**
     * Devuelve los destinos de la ciudad
     * @param nombreCiudad ciudad seleccionada.
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public ArrayList<String> getNombresCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException, IOException, IOException, IOException, IOException, IOException, IOException, IOException{
        return ctrld.getNombresCiudad(nombreCiudad);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<ArrayList<Float>> getDistancias(String nombreCiudad)"> 
    /**
     * Devuelve 
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public Float getDistancias(String a ,String b) throws FileNotFoundException, IOException, ClassNotFoundException {
//        return ctrld.pesosAristas(ciudad);
        return ctrld.getDistancia(ciudad,a,b);
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void modificarCiudadFichero(String ciudad)"> 
    /**
     * Modifica una ciudad desde fichero
     * @param ciudad ciudad que se desea modificar
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void modificarCiudadFichero(String ciudad) throws IOException, FileNotFoundException, ClassNotFoundException { 
        ctrld.modificarCiudad(ciudad);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void anadirCiudad(String nombre, int n, ArrayList<String> nombreNodos, float[] distanciasNodos)"> 
    /**
     * Añade una ciudad.
     * @param nombre nombre que se le da a la cuidad.
     * @param n número de nodos que componen la ciudad.
     * @param nombreNodos nombre de los nodos de la ciudad.
     * @param distanciasNodos distancias entre los nodos.
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void anadirCiudad(String nombre, int n, ArrayList<String> nombreNodos, float[] distanciasNodos) throws ClassNotFoundException, IOException {
        System.out.println("[anadirCiudad]");
        for (int i = 0; i < distanciasNodos.length; i++) {
            System.out.print(distanciasNodos[i] + ", ");
        }
        System.out.print("\n");
        ctrld.anadirCiudad(nombre, n, nombreNodos, distanciasNodos);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void eliminarCiudad(String nombreCiudad)"> 
    /**
     * Elimina una ciudad según su nombre
     * @param nombreCiudad nombre de la ciudad.
     */
    public void eliminarCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.eliminarCiudad(nombreCiudad);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void anadirPunto(String nombre, float[] distancias)"> 
    /**
     * Añade un punto a la ciudad seleccionada por el operador
     * @param nombre nombre que se le ha asignado al punto
     * @param distancias distancias desde el punto al resto de puntos
     */
    public void anadirPunto(String nombre, float[] distancias) throws IOException, ClassNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ctrld.anadirPunto(nombre, distancias);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void renombrarPunto(String nombre1, String nombre2)"> 
    /**
     * Renombra un punto
     * @param nombre1 nombre que se quiere renombrar
     * @param nombre2 nombre que se le da al punto
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void renombrarPunto(String nombre1, String nombre2) throws IOException, ClassNotFoundException {
        ctrld.renombrarPunto(nombre1, nombre2);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void modificaDistancia(String nombre1, String nombre2, String dist)"> 
    /**
     * Modifica la distancia entre dos puntos A y B
     * @param nombre1 punto A
     * @param nombre2 punto B
     * @param dist distancia nueva que se le asigna
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void modificaDistancia(String nombre1, String nombre2, String dist) throws IOException, ClassNotFoundException{
       float dist2 =  Float.parseFloat(dist);
       if (dist2 >= 0f)
           ctrld.modificaDistancia(nombre1, nombre2, dist2);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void eliminarPunto(String nombre1)"> 
    /**
     * Elimina un punto de la ciudad seleccionada por el operador según su nombre
     * @param nombre1
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void eliminarPunto(String nombre1) throws IOException, ClassNotFoundException{
        ctrld.eliminarPunto(nombre1);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void leerCiudad(String nombreCiudad)"> 
    /**
     * Lee una ciudad
     * @param nombreCiudad nombre de la ciudad que se quiere leer
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void leerCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.leerCiudad(nombreCiudad);
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public void leerMapaFichero(String nomFichero, String nombreCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad)"> 
    /**
     * Lee un mapa desde un fichero
     * @param nomFichero nombre del fichero
     * @param nombreCiudad nombre de la ciudad
     * @param nombres nombres de los destinos
     * @param ciudad distancias entre los nodos
     */
    public void leerMapaFichero(String nomFichero, String nombreCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad) {
        ctrld.leerMapaFichero(nomFichero,nombreCiudad,nombres,ciudad);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void pasarAObjeto(String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad)"> 
    /**
     * Convierte a un objecto una ciudad
     * @param nomCiudad nombre de la ciudad
     * @param nombres nombre de los nodos
     * @param ciudad distancias entre los nodos
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void pasarAObjeto(String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad) throws IOException, ClassNotFoundException{
        ctrld.pasarAObjeto(nomCiudad, nombres, ciudad);
    } // </editor-fold>
    
    
    // PAQUETES
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<String> getPaquetesPendientes(String nombreCiudad, String fechaCD"> 
    /**
     * Devuelve la lista de paquetes pendientes para una ciudad y un turno.
     * @param nombreCiudad nombre de la ciudad seleccionada por el operador.
     * @param fechaCD fecha seleccionada por el operador.
     * @return paquetes pendientes para la ciudad y la fecha/turno
     */
    public ArrayList<String> getPaquetesPendientes(String nombreCiudad, String fechaCD) {
        return ctrld.getPaquetesPendientes(nombreCiudad, fechaCD);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<String> getPaquetesRuta(String nombreRuta)"> 
    public ArrayList<String> getPaquetesRuta(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException{
        return ctrld.getPaquetesRuta(nombreRuta);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void paquetesEnviados(String nombreRuta)"> 
    /**
     * Indica que se han enviado los paquetes pendientes para una ruta
     * @param nombreRuta nombre de la ruta
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void paquetesEnviados(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.paquetesEnviados(nombreRuta);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void anadirPaquete(String nombreCiudad, String destino, String fecha, String turno)"> 
    /**
     * Añade un paquete desde el cliente
     * @param nombreCiudad nombre de la ciudad
     * @param destino a donde va el paquete
     * @param fecha el día que se desea enviar el paquete
     * @param turno
     * @throws IOException 
     */
    public void anadirPaquete(String nombreCiudad, String destino, String fecha, String turno) throws IOException{
        ctrld.anadirPaquete(nombreCiudad, destino, fecha, turno);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String[] getPaquetesEnviados()"> 
    /**
     * Devuelve los paquetes enviados
     * @return 
     */
    public String[] getPaquetesEnviados(){
        return ctrld.getPaquetesEnviados();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String[] getPaquetesEspera()"> 
    public String[] getPaquetesEspera(){
        return ctrld.getPaquetesEspera();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<String> verPaquetesOperador(String orden)"> 
    /**
     * Devuelve todos los paquetes del operador
     * @param orden el orden por los que se muestran
     * @return 
     */
    public ArrayList<String> verPaquetesOperador(String orden){
        return ctrld.verPaquetesOperador(orden);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void eliminarPaquetes()"> 
    /**
     * Elimina los paquetes del cliente.
     */
    public void eliminarPaquetes(){
        ctrld.eliminarPaquetes();
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public boolean cancelarPaquete(int idPaquete)"> 
    /**
     * Cancela un paquete según su id
     * @param idPaquete la id del paquete
     * @return true si se ha podido cancelar
     * @throws IOException 
     */
    public boolean cancelarPaquete(int idPaquete) throws IOException{
        return ctrld.cancelarPaquete(idPaquete);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public boolean eliminarPaquete(int idPaquete)"> 
    /**
     * Elimina un paquete según su id
     * @param idPaquete id del paquete
     * @return true si se ha podido eliminar
     * @throws IOException 
     */
    public boolean eliminarPaquete(int idPaquete) throws IOException{
        return ctrld.eliminarPaquete(idPaquete);
    } // </editor-fold>

    
    // RUTAS
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<String> getRutas(String nombreCiudad"> 
    /**
     * Devuelve las rutas que hay para una ciudad
     * @param nombreCiudad nombre de la ciudad.
     * @return 
     */
    public ArrayList<String> getRutas(String nombreCiudad){
        return ctrld.getRutas(nombreCiudad);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void aceptarRuta(String ruta, String fecha, String nombreCiudad)"> 
    /**
     * Acepta una ruta
     * @param ruta nombre de la ruta
     * @param fecha fecha y turno
     * @param nombreCiudad nombre de la ciudad sobre la que opera la ruta
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void aceptarRuta(String ruta, String fecha, String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.acceptarRuta(ruta, fecha, nombreCiudad);
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public void calcularRuta(ArrayList<String> listaEnRutaS, String fecha, String nombreCiudad, String tipo)"> 
    /**
     * Calcula una ruta
     * @param listaEnRutaS lista de paquetes que están seleccionados en la ruta
     * @param fecha fecha del turno
     * @param nombreCiudad ciudad de la ruta
     * @param tipo de ruta que se desea calcular
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void calcularRuta(ArrayList<String> listaEnRutaS, String fecha, String nombreCiudad, String tipo) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.calcularRuta(listaEnRutaS, fecha, nombreCiudad, tipo);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public String getDestinosRuta()"> 
    /**
     * Devuelve los destinos de la ruta seleccionada por el operador
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public String getDestinosRuta() throws IOException, FileNotFoundException, ClassNotFoundException {
        return ctrld.getDestinosRuta(ruta);
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public void modificarRuta(String ruta, String res)"> 
    /**
     * Modifica una ruta
     * @param ruta el nombre de la ruta que se quiere modificar
     * @param res los destinos por los que pasa la ruta
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public boolean modificarRuta(String ruta, String res) throws IOException, FileNotFoundException, ClassNotFoundException {
        return ctrld.modificarRuta(ruta, res);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void eliminarRutaComp(String inicioRuta, String nombreRuta)"> 
    /**
     * Elimina una ruta completada.
     * @param inicioRuta
     * @param nombreRuta 
     */
    public void eliminarRutaComp(String inicioRuta, String nombreRuta){
        ctrld.eliminarRutaComp(inicioRuta, nombreRuta);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void eliminarRuta(String ruta)"> 
    /**
     * Elimina una ruta del sistema
     * @param ruta nombre de la ruta que se elimina
     */
    public void eliminarRuta(String ruta){
        ctrld.eliminarRuta(ruta);
        if (this.ruta == ruta) {
            this.ruta = null;
        }
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public ArrayList<String> rutasComparadas(String fecha, String nombreCiudad)"> 
    /**
     * Devuelve una comparación de las rutas realizadas en una ciudad y en una fecha concreta
     * @param fecha fecha seleccionada
     * @param nombreCiudad nombre de la ciudad seleccionada
     * @return 
     */
    public ArrayList<String> rutasComparadas(String fecha, String nombreCiudad){
        return ctrld.rutasComparadas(fecha, nombreCiudad);
    } // </editor-fold>
    
    
    /* Otros */
    
    // <editor-fold defaultstate="collapsed" desc="public Color getColorDistancia(float max, float min, float d"> 
    /**
     * Devuelve un color según la distancia
     * @param max es la distancia representada como un rojo puro
     * @param min es la distancia representada como un verde puro
     * @param d la distancia de la cual se quiere obtener el color
     * @return el color proporcional
     */
    public Color getColorDistancia(float d) throws FileNotFoundException, IOException, ClassNotFoundException{
        max = ctrld.getMax(ciudad);
        min = ctrld.getMin(ciudad);
//        System.out.println("\nmax " + max);
//        System.out.println("min " + min);
//        System.out.println("d " + d);
        float proporcion = ((d-min)*100f)/(max-min);
//        System.out.println("proporcion " + proporcion);
	float rd = 1f;
	float gd = 1f;
        float media = (max+min)/2f;
//        System.out.println("media " + media);
	if (d > media) gd = ((100f-proporcion)/100f);
        else if (d == media);
        else rd = (proporcion/100f);
//        System.out.println("rd " + rd);
//        System.out.println("gd " + gd);
//        System.out.println("rd " + rd);
//        System.out.println("gd " + gd);
        return new Color(rd, gd, 0f);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void setAdvertencia(boolean advertencia)"> 
    public void setAdvertencia(boolean advertencia) {
        vistaOperador.setAdvertencia(advertencia);
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="public void crearFichero(String nombreFichero)"> 
    /**
     * Crea un fichero
     * @param nombreFichero nombre del fichero que se va a crear.
     * @throws IOException 
     */
    public void crearFichero(String nombreFichero) throws IOException{
        ctrld.crearFichero(nombreFichero);
    } // </editor-fold>
    
    public void validarRuta(String nombreRuta) {
        vistaOperador.validarRuta(nombreRuta);
    }
}
