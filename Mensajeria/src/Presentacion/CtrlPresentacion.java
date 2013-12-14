package Presentacion;
import Dominio.ControlDominio;
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
    
    public void cambiarContenidoPanel(javax.swing.JPanel p1, javax.swing.JPanel p2){
        p1.removeAll();
        for (int i = 0; i< p2.getComponentCount(); i++){
            p1.add(p2.getComponent(i));
        }
        p1.getParent().repaint();
//        p1.repaint();
    }
    
    /**
     * Actualiza la ventana primaria redibujando sus componentes
     */
    public void actualizarVentanaPrimaria(){
        ventanaPrimaria.setLocationRelativeTo(null);
        ventanaPrimaria.repaint();
    }
    
    
    void actualizarVentanaSecundaria() {
        ventanaSecundaria.setLocationRelativeTo(null);
        ventanaSecundaria.repaint();
    }
    
    
    /**
     * Permite mostrar una ventana secundaria.
     * @param nuevaVentana el selector de la ventana secundaria que se va a abrir.
     */
    public void iniVentanaSecundaria(String nuevaVentana){
        switch(nuevaVentana){
            case "añadirPaquete":
                if(vistaAnadirPaquete == null) vistaAnadirPaquete = new VistaAnadirPaquete(this);
                ventanaSecundaria = new VistaAnadirPaquete(this);
                vistaAnadirPaquete = null;
                ventanaSecundaria.setTitle("Añadir Paquete");
            break;
                
            case "vistaModificarRuta":
                if(vistaModificarRuta != null) vistaModificarRuta = new VistaModificarRuta(this, getDestinosRuta());
                ventanaSecundaria = new VistaModificarRuta(this, getDestinosRuta());
                vistaModificarRuta = null;
                ventanaSecundaria.setTitle("Ver / Editar Ruta");
                
//                    VistaModificarRuta vistaModificarRuta
            break;
                
//            case "vistaAnadirPaquete":
//                if(vistaAnadirPaquete == null) vistaAnadirPaquete = new VistaAnadirPaquete(this);
//                vistaAnadirPaquete.getContentPane().remove(vistaAnadirPaquete.getSidebar());
//                ventanaSecundaria = vistaAnadirPaquete;
//                ventanaSecundaria.setTitle("Mapa de la ciudad");
////                setTamanoVentanaSecundaria(-165, 0);
//            break;
                
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
                ventanaSecundaria = dibujoCiudad;
                ventanaSecundaria.setTitle("Dibujo de la ciudad");
            break;
                
            case "vistaPaquetes":
                if(vistaPaquetes == null) vistaPaquetes = new VistaVerPaquetes(this);
                ventanaSecundaria = vistaPaquetes;
                ventanaSecundaria.setTitle("Lista de todos los paquetes");
            break;
                
            case "vistaModificarCiudad":
                if (vistaModificarCiudad == null) vistaModificarCiudad = new VistaModificarCiudad(this, getCiudadOperador());
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
//                Dimension d0 = new Dimension(vistaLogin.getPreferredSize());
//                d0.setSize(d0.getWidth()-6, d0.getHeight()+10);
                ventanaPrimaria.setResizable(false);
//                ventanaPrimaria.setSize(d0);
                vistaInicial = null;
                break;
            case "vistaCliente":
                if (vistaCliente == null) vistaCliente = new VistaClientePrincipal(this);
                cambiarContenidoVentanaPrimaria(vistaCliente.getContentPane());
//                setTamanoVentanaPrimaria(-8, 15);
                ventanaPrimaria.setTitle("Mensajeria | Cliente");
//                Dimension d = new Dimension(vistaCliente.getPreferredSize());
//                d.setSize(d.getWidth()-5, d.getHeight()+15);
//                ventanaPrimaria.setResizable(false);
//                ventanaPrimaria.setSize(d);
                vistaLogin.dispose();
                break;
            case "vistaOperador":
                if (vistaOperador == null)vistaOperador = new VistaOperadorPrincipal(this);
                cambiarContenidoVentanaPrimaria(vistaOperador.getContentPane());
//                setTamanoVentanaPrimaria(-8, 15);
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
        setTamanoVentanaPrimaria(0,0);
        actualizarVentanaPrimaria();
    }
    
    /**
     * Gestiona todas las actualizaciones necesarias en la vista del cliente.
     */
    void actualizarVistaCliente() {
        if (vistaCliente != null)
            vistaCliente.actualizarlista();
    }
    
    void actualizarVistaSelCiudades() {
        if(vistaCiudad != null){
            System.out.println("vistaCiudad != null");
            vistaCiudad.actualizarListaCiudades();
        }
    }

    
    /**
     * Permite actualizar el nombre de la ciudad seleccionada por el operador.
     * @param nombreCiudad el nombre de la ciudad seleccionada.
     */
    void setOperador(String nombreCiudad) {
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


    public String getCiudadOperador() {
        return vistaOperador.getCiudad();
    }
    
    public String getFechaOperador() {
        return vistaOperador.getFecha();
    }
    
    public void actualizarRutasOperador() {
        vistaOperador.actualizarRutas();
    }
    
    public void setAdvertencia(boolean advertencia) {
        vistaOperador.setAdvertencia(advertencia);
    }


    public void setListaEnRutaS(ArrayList<String> listaEnRutaS) {
        vistaOperador.setListaEnRutaS(listaEnRutaS);
    }
    
    public void actualizarListaEnRuta() {
        vistaOperador.actualizarListaEnRuta();
    }
    
    public ArrayList<String> getPaquetesPendientes(String nombreCiudad, String fechaCD) {
        return ctrld.getPaquetesPendientes(nombreCiudad, fechaCD);
    }
    
    public String[] fechaHoy(){
        return ctrld.fechaHoy();
    }
    
    public void eliminarRutaComp(String inicioRuta, String nombreRuta){
        ctrld.eliminarRutaComp(inicioRuta, nombreRuta);
    }
    
    public void calcularRuta(ArrayList<String> listaEnRutaS, String fecha, String nombreCiudad, String tipo) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.calcularRuta(listaEnRutaS, fecha, nombreCiudad, tipo);
    }
    
    public void paquetesEnviados(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.paquetesEnviados(nombreRuta);
    }
    
    public void acceptarRuta(String ruta, String fecha, String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.acceptarRuta(ruta, fecha, nombreCiudad);
    }
    
    public void eliminarRuta(String ruta){
        ctrld.eliminarRuta(ruta);
    }
    
    public ArrayList<String> getRutas(String nombreCiudad){
        return ctrld.getRutas(nombreCiudad);
    }
    
    private String[] getDestinosRuta() {
        return ctrld.getDestinosRuta(ruta);
    }
    
    public ArrayList<String> getPaquetesRuta(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException{
        return ctrld.getPaquetesRuta(nombreRuta);
    }
    void setCiudad(String nombreCiudad) {
        this.ciudad = nombreCiudad;
        if (this.vistaModificarCiudad != null) this.vistaModificarCiudad.setCiudad(this.ciudad);
    }
    
    public String[] getNombresCiudades(){
        return ctrld.getNombresCiudades();
    }
    
    public String[] getDestinosCiudad(String nombreCiudad) throws IOException{
        return ctrld.getDestinosCiudad(nombreCiudad);
    }
    
    public void anadirPaquete(String nombreCiudad, String destino, String fecha, String turno) throws IOException{
        ctrld.anadirPaquete(nombreCiudad, destino, fecha, turno);
    }
    
    public ArrayList<String> getNombresCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException, IOException, IOException, IOException, IOException, IOException, IOException, IOException{
        return ctrld.getNombresCiudad(nombreCiudad);
    }
    
    public String[] getPaquetesEnviados(){
        return ctrld.getPaquetesEnviados();
    }
    
    public String[] getPaquetesEspera(){
        return ctrld.getPaquetesEspera();
    }
    
    public void eliminarPaquetes(){
        ctrld.eliminarPaquetes();
    }
    
    public boolean cancelarPaquete(int idPaquete) throws IOException{
        return ctrld.cancelarPaquete(idPaquete);
    }
    
    public boolean eliminarPaquete(int idPaquete) throws IOException{
        return ctrld.eliminarPaquete(idPaquete);
    }
    
    public ArrayList<String> rutasComparadas(String fecha, String nombreCiudad){
        return ctrld.rutasComparadas(fecha, nombreCiudad);
    }
    
    public boolean registroCliente(String usuario, String password) throws IOException{
        return ctrld.registroCliente(usuario, password);
    }
    
    public boolean registroOperador(String usuario, String password) throws IOException, ClassNotFoundException{
        return ctrld.registroOperador(usuario, password);
    }
    
    public boolean loginCliente(String usuario, String password) throws IOException{
        return ctrld.loginCliente(usuario, password);
    }
    
    public boolean loginOperador(String usuario, String password) throws IOException, ClassNotFoundException{
        return ctrld.loginOperador(usuario, password);
    }
    
    public ArrayList<String> verPaquetesOperador(String orden){
        return ctrld.verPaquetesOperador(orden);
    }
    public void anadirCiudad(String nombre, int n, ArrayList<String> nombreNodos, float[] distanciasNodos) throws ClassNotFoundException, IOException {
        ctrld.anadirCiudad(nombre, n, nombreNodos, distanciasNodos);
    }
    
    public void crearFichero(String nombreFichero) throws IOException{
        ctrld.crearFichero(nombreFichero);
    }
    
    public void leerCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
        ctrld.leerCiudad(nombreCiudad);
    }

    public void leerMapaFichero(String nomFichero, String nombreCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad) {
        ctrld.leerMapaFichero(nomFichero,nombreCiudad,nombres,ciudad);
    }
    
    public void pasarAObjeto(String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad) throws IOException, ClassNotFoundException{
        ctrld.pasarAObjeto(nomCiudad, nombres, ciudad);
    }
    
    public void eliminarCiudad(String nombreCiudad){
        ctrld.eliminarCiudad(nombreCiudad);
    }
    
    public void renombrarPunto(String nombre1, String nombre2) throws IOException, ClassNotFoundException {
        ctrld.renombrarPunto(nombre1, nombre2);
    }
    
    public void modificaDistancia(String nombre1, String nombre2, String dist) throws IOException, ClassNotFoundException{
       float dist2 =  Float.parseFloat(dist);
       ctrld.modificaDistancia(nombre1, nombre2, dist2);
    }
    
    public void eliminarPunto(String nombre1) throws IOException, ClassNotFoundException{
        ctrld.eliminarPunto(nombre1);
    }
    void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
