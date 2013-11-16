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
    
    public boolean loginCliente() {
        return cu.isLoginCliente();
    }
    
    public boolean loginOper() {
        return cu.isLoginOper();
    }
 
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
                cp.guardarRuta(r, nombreRuta, r.isVerificada());
                if (r.isVerificada()) {
                    paquetesEnviados(r);
                }
            }
        }
        else {
            r.setFecha(fecha);
            String nombreRuta = fecha+"-"+turno;
            cp.guardarRuta(r, nombreRuta, r.isVerificada());
        }
        
    }
    
    private void paquetesEnviados(Ruta r) throws IOException {
        ArrayList<Paquete> paquetesEnviados = r.getListaPaquetesRuta();
        oper.cambiarEstadoPaquetes(paquetesEnviados);
        cl.cambiarEstadoPaquetes(paquetesEnviados);
        lp.cambiarEstadoPaquetes(paquetesEnviados);
        guardadoGeneral();
    }
    
    public void guardarMapa(Mapa map, String nombreciudad) throws IOException, ClassNotFoundException{
        cp.guardarMapas(map, nombreciudad);
    }
    
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
    
    private Object leerRuta() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> rutas = new ArrayList<>();
        rutas = cp.listarRutas();
        for(int i = 0; i < rutas.size(); ++i){
            System.out.println(rutas.get(i));
        }
        System.out.println("Elige la ciudad:");
        String nombre = sc.nextLine();
        return cp.leerRuta(nombre);
    }
    
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
    
    public Object leerOperador() throws IOException, ClassNotFoundException {
        try {
            return oper = (Operador) cp.leerOperador();
        }
        catch (IOException e) {
            return oper = null;
        }
    }
    
    public void guardadoGeneral() throws IOException {
        cp.guardadoGeneral(lc, lp, oper);
    }
    
    public void verPaquetesOperador(){
        oper.verPaquetes();
    }
    
    public void anadirCiudad() throws ClassNotFoundException, IOException {
        map = new Mapa();
        map = oper.anadirCiudad(map);
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
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
        opcionesOperador();
    }
    
    private void opcionesOperador() throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("pulse 1 para calcular una ruta nueva, 2 para recalcular una ruta existente pero no confirmada, 3 para modificar una ruta");
        int op = sc.nextInt();
        if(op == 1){
            Ruta r = new Ruta();
            iniciarRuta(r);
        }
        else if (op == 2){
            recalcularRuta();
        }
        else {
            System.out.println("Aun no implementado, no es necessario hasta la entrega 3");
        }
    }
    
    private void recalcularRuta() throws IOException, FileNotFoundException, ClassNotFoundException{
        Ruta r = (Ruta) leerRuta();
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes = r.getListaPaquetesRuta();
        paquetes = oper.modificaListaPaquetes(paquetes);
        map = r.getMapa();
        System.out.println("Procedemos al recalculo de la ruta");
        calcularRuta(paquetes, r.getFecha(), r.getTurno(), r);
        
   }
    
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
    
    
    //FUNCIONES DEL CLIENTE!!!!

      
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
            
    
    public void verPaquetesCliente(){
        cl.verLista();
    }
    
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
    
    public void elminarPaquete(){
        System.out.println("eliminaremos todos los paquetes enviados");
        cl.eliminarPaquetes();
    } 
}