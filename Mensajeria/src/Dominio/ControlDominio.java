package Dominio;

import java.util.ArrayList;
import java.util.*;
import Persistencia.ControlPersistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Marc Garcia Roig
 */
public class ControlDominio {

    private ControlPersistencia cp;
    private ListaClientes lc;
    private Operador oper;
    private ListaPaquetes lp;
    private Cliente cl;
    private ControlUsuario cu;
    private boolean existeOper = true;
    private Mapa map;
    
    /**
     * Inicializa el controlador de dominio
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     * 
     */
    public void iniControlDominio() throws IOException, FileNotFoundException, ClassNotFoundException {
        cp = new ControlPersistencia();
        cu = new ControlUsuario();
        lc = (ListaClientes) leerListaClientes();
        if(lc == null) lc = new ListaClientes();
        
        oper = (Operador) leerOperador();
        if(oper == null) {
            oper = new Operador();
            existeOper = false;
        }     
        
        lp = (ListaPaquetes) leerListaPaquetes();
        if(lp == null) lp = new ListaPaquetes();
    }
    
    /**
     * Registramos o logeamos al cliente o al operador
     * @return retorna si se registra o se loguea
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public boolean registroLogin() throws IOException, ClassNotFoundException {
        System.out.println("pulse 1 si es operador, pulse 2 si es cliente");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        boolean resultado= false;
        if(op == 1) {
            if(!existeOper){
                System.out.println("No hay operador, vamos a registrarlo");
                cu.registroOperador(oper);
                existeOper = true;
                cp.guardarOperador(oper);
            }
            System.out.println("vamos a hacer login");
            cu.loginOperador(oper);
            return false;
        }
        else if (op == 2) {
                Scanner sc2 = new Scanner(System.in);
                boolean existeCliente = true;
                System.out.println("es un usuario nuevo? pulse 1 si, 2 no");
                int op2 = sc2.nextInt();
                if(op2 == 1){
                    Cliente cl = new Cliente();
                     existeCliente = cu.registroCliente(cl, lc);
                    if (existeCliente) cp.guardarListaClientes(lc);
                    else resultado = true;
                }
                if (existeCliente) {
                    System.out.println("vamos a proceder al login");
                    int indice;
                    indice = cu.loginCliente(lc);
                    if(indice != -1){
                        cl = lc.getCliente(indice);
                    }
                    return true;
                }
        }
        return resultado;
    }
    
    /**
     * Comprobamos si el cliente se ha logeado correctamente
     * @return Si es cliente
     */
    public boolean loginCliente() {
        return cu.isLoginCliente();
    }
    
    /**
     * Comprobamos si el operador se ha logeado correctamente
     * @return Si es operador
     */
    public boolean loginOper() {
        return cu.isLoginOper();
    }

    /**
     * Calcula el camino de una ruta
     * @param paquetesSeleccionados
     * @param fecha
     * @param r
     * @throws IOException 
     */
    private void calcularRuta(ArrayList<Paquete> paquetesSeleccionados, String fecha, String turno, Ruta r) throws IOException {
        Scanner sc = new Scanner(System.in);
        r.crearGrafo(paquetesSeleccionados, map);
        
        System.out.println("Quieres calcular una ruta rapidamente (poco eficaz) o lentamente (eficaz)");
        String raplent = sc.nextLine();
        if (raplent.equals("rapidamente")) {
            r.calcularRapida();
        }
        else {
            r.calcularMinSpaTree();
            r.calcularChristofides();
            //Llamar a la optimizacion
        }
        r.mostrarRuta();
        Fecha date = new Fecha();
        if (fecha.equals(date.fechaActual())) {
            if (turno.equals(date.mañanaTarde())) {
                r.acceptarRuta();
                r.setFecha(fecha);
                r.setTurno(turno);
                String nombreRuta = fecha+"-"+turno;
                cp.guardarRuta(r, nombreRuta, r.isVerificada(), r.getMapa().getNombreCiudad());
                if (r.isVerificada()) {
                    paquetesEnviados(r);
                }
            }
        }
        else {
            r.setFecha(fecha);
            String nombreRuta = fecha+"-"+turno;
            cp.guardarRuta(r, nombreRuta, r.isVerificada(), r.getMapa().getNombreCiudad());
        }
        
    }
    
    private void paquetesEnviados(Ruta r) throws IOException {
        ArrayList<Paquete> paquetesEnviados = r.getListaPaquetesRuta();
        oper.cambiarEstadoPaquetes(paquetesEnviados);
        cl.cambiarEstadoPaquetes(paquetesEnviados);
        lp.cambiarEstadoPaquetes(paquetesEnviados);
        guardadoGeneral();
    }
    
    /**
     * Guarda un mapa en el disco
     * @param map
     * @param nombreciudad
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void guardarMapa(Mapa map, String nombreciudad) throws IOException, ClassNotFoundException{
        cp.guardarMapas(map, nombreciudad);
    }
    
    /**
     * Lee una ciudad
     * @return Mapa
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Object leerCiudad() throws FileNotFoundException, IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades = cp.listarCiudades();
        System.out.println("Escoger la ciudad :");
        for(int i = 0; i < ciudades.size(); ++i){
            System.out.println(ciudades.get(i));
        }
        String nombre = sc.nextLine();
        return cp.leerCiudad(nombre);
    }
    
    /**
     * Lee una ruta
     * @return Ruta
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    private Object leerRuta(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> rutas = new ArrayList<>();
        rutas = cp.listarRutas(nombreCiudad);
        for(int i = 0; i < rutas.size(); ++i) {
            System.out.println(rutas.get(i));
        }
        System.out.println("Elige la ruta:");
        String nombre = sc.nextLine();
        return cp.leerRuta(nombre);
    }
    
    /**
     * Lee una lista de paquetes
     * @returnListaPaquetes
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public Object leerListaPaquetes() throws IOException, FileNotFoundException, ClassNotFoundException {
        try {
            return lp = (ListaPaquetes) cp.leerListaPaquetes();
        }
        catch (FileNotFoundException e) {
            return lp = null;
        }
        catch (IOException e) {
            return lp = null;
        }
    }
    
    /**
     * Lee una lista de clientes
     * @return ListaClientes
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public Object leerListaClientes() throws IOException, FileNotFoundException, ClassNotFoundException {
        try {
            return lc = (ListaClientes) cp.leerListaClientes();
        }
        catch (FileNotFoundException e) {
            return lc = null;
        }
        catch (IOException e) {
            return lc = null;
        }
    }
    
    /**
     * Lee un operador
     * @return Operador
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Object leerOperador() throws IOException, ClassNotFoundException {
        try {
            return oper = (Operador) cp.leerOperador();
        }
        catch (IOException e) {
            return oper = null;
        }
    }
    
    /**
     * Guarda los clientes, los paquetes y el operador
     * @throws IOException 
     */
    public void guardadoGeneral() throws IOException {
        cp.guardadoGeneral(lc, lp, oper);
    }
    
    /**
     * Muestra los paquetes disponibles del operador
     */
    public void verPaquetesOperador(){
        oper.verPaquetes();
    }
    

    /**
     * Anade una ciudad al sistema
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void anadirCiudad() throws ClassNotFoundException, IOException{
        map = oper.anadirCiudad(map);
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
    /**
     * Selecciona una ciudad del sistema
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void seleccionarCiudad() throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        ArrayList <String> nombresciudades = cp.listarCiudades();
        System.out.println("Estas son las Ciudades que puede seleccionar");
        for(int i = 0; i < nombresciudades.size(); ++i){
            System.out.println(nombresciudades.get(i));
        }
        System.out.println("Escriba la ciudad que quiera seleccionar");
        String nombre = sc.nextLine();
        map = (Mapa) cp.leerCiudad(nombre);
        opcionesOperador(nombre);
    }

    /**
     * Una vez el operador ha seleccionado la ciudad podemos escoger varias 
     * opciones, para trabajar sobre la ciudad escogida
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
   private void opcionesOperador(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("pulse 1 para calcular una ruta nueva, 2 para recalcular una ruta existente pero no confirmada, 3 para modificar una ruta");
        int op = sc.nextInt();
        if(op == 1){
            Ruta r = new Ruta();
            iniciarRuta(r);
        }
        else if (op == 2){
            recalcularRuta(nombre);
        }
        else {
            System.out.println("Aun no implementado, no es necessario hasta la entrega 3");
        }
    }
    
    /**
     * Recalcula una ruta ya guardada previamente
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    private void recalcularRuta(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException{
        Ruta r = (Ruta) leerRuta(nombre);
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes = r.getListaPaquetesRuta();
        System.out.println("PAquetes de recalculo");
        paquetes = oper.modificaListaPaquetes(paquetes);
        map = r.getMapa();
        System.out.println("Procedemos al recalculo de la ruta");
        calcularRuta(paquetes, r.getFecha(), r.getTurno(), r);
        
   }
    
    /**
     * Inialicializa el proceso de creacion de una ruta
     * @param fecha
     * @param r
     * @throws IOException 
     */
    private void iniciarRuta(Ruta r) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres calcular la ruta de hoy y de este turno? s/n");
        String ord = sc.nextLine();
        Fecha date = new Fecha();
        if (ord.equals("s")) {
            ArrayList <Paquete> paquetesSeleccionados = oper.seleccionarPaquetes(map.getNombreCiudad(), date.fechaActual(), date.mañanaTarde());;
            String fechaactual = date.fechaActual();
            String turno = date.mañanaTarde();
            calcularRuta(paquetesSeleccionados, fechaactual, turno, r);     
        }
        else {
            System.out.println("Entra la fecha (dd.mm.aa)");
            String fecharuta = sc.nextLine();
            if (date.comprobarFecha(fecharuta)) {
                System.out.println("Entra el turno (mañana/tarde)");
                String turno = sc.nextLine();
                ArrayList <Paquete> paquetesSeleccionados = oper.seleccionarPaquetes(map.getNombreCiudad(), fecharuta, turno);
                calcularRuta(paquetesSeleccionados, fecharuta, turno, r);
            }
        }
    }
    
    
    /**
     * El cliente añade un paquete para enviar
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    
      
    public void anadirPaquete() throws FileNotFoundException, IOException, ClassNotFoundException{
        Paquete p = new Paquete();
        Mapa map = (Mapa) leerCiudad();;
        String nombreCiudad = map.getNombreCiudad();
        p.leerPaquete(cl.getIdCliente(), nombreCiudad);
        String[] nombresNodo = map.getNombres();
        boolean encontrado = false;
        String destino = p.getDestino();
        int idDestino = -1;
        for(int i = 0; i < nombresNodo.length & !encontrado; ++i){
            if(nombresNodo[i].equals(destino)){
                encontrado = true;
                idDestino = i;
            }
        }
        if(encontrado){
            p.setIdDestino(idDestino);
            lp.anadirPaquete(p);
            lc.anadirPaquete(p, cl.getIdCliente());
            oper.anadirPaquete(p);
            guardadoGeneral();
        }
        else {
            System.out.println("El destino no existe en la base de datos");
        }
   }

    /**
     * Se muestran los paquetes del cliente
     */
    public void verPaquetesCliente(){
        cl.verLista();
    }
    
    /**
     * El cliente cancela un paquete que aun no se ha enviado
     */
    public void cancelarPaquete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("puede cancelar los siguientes paquetes");
        verPaquetesCliente();
        System.out.println("Introduzca el ID del paquete que desea cancelar");
        int idPaquete = sc.nextInt();
        boolean cancelado = cl.cancelarPaquete(idPaquete);
        if(cancelado){
            lp.cancelarPaquete(idPaquete);
        }
        else{
            System.out.println("El paquete no ha podido ser cancelado");
        }
    }
    
    /**
     * El cliente elimina todos los paquetes que ya se han enviado
     */
    public void elminarPaquete(){
        System.out.println("eliminaremos todos los paquetes enviados");
        cl.eliminarPaquetes();
    } 
}