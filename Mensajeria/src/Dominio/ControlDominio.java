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
    private boolean existeOper = true;
    private Mapa map;
    
    public void iniControlDominio() throws IOException, FileNotFoundException, ClassNotFoundException {
        cp = new ControlPersistencia();
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
    
    public void registroLogin(boolean esCliente, boolean salir) throws IOException, ClassNotFoundException {
        ControlUsuario cu = new ControlUsuario();
        System.out.println("pulse 1 si es operador, pulse 2 si es cliente");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        if(op == 1) {
            if(!existeOper){
                System.out.println("No hay operador, vamos a registrarlo");
                cu.registroOperador(oper);
                existeOper = true;
                cp.guardarOperador(oper);
            }
            System.out.println("vamos a hacer login");
            cu.loginOperador(oper);
        }
        else if(op == 2){
                esCliente = true;
                Scanner sc2 = new Scanner(System.in);
                System.out.println("es un usuario nuevo? pulse 1 si, 2 no");
                int op2 = sc2.nextInt();
                if(op2 == 1){
                    Cliente cl = new Cliente();
                    cu.registroCliente(cl, lc);
                }
                System.out.println("vamos a proceder al login");
                int indice;
                indice = cu.loginCliente(lc);
                if(indice != -1){
                    cl = lc.getCliente(indice);

                }
            }
        System.out.println("boool esss:" + esCliente);
    }
        /*System.out.println("pulse 1 si es operador, pulse 2 si es cliente");
        int op = sc.nextInt();
        if(op == 1){       
            if(!oper.isCheckExistencia()){
                oper = cu.registroOperador();
                oper.setCheckExistencia(true);             
                System.out.println("pulse 1 si quiere logearse, pulse 2 si quiere salir");
                int op3 = sc.nextInt();
                if(op3 == 1){
                    cu.loginOperador();
                }
                else salir = true;
                
            }
            else {
                cu.loginOperador();
            }
        }
        else if(op == 2){
            System.out.println("pulse 1 registro, pulse 2 log");
            int op2 = sc.nextInt();
            if(op2 == 1){
                cl = cu.registroCliente();
                if(cl != null) lc.anadirCliente(cl);
                System.out.println("pulse 1 log, pulse 2 para salir");
                int op3 = sc.nextInt();
                if(op3 == 1){
                    cl = cu.loginCliente();
                    esCliente = true;
                }
                else salir = true;
            }
            else if(op2 == 2){
                cl = cu.loginCliente();
                esCliente = true;
            }
        }*/
    
 
    private void calcularRuta(ArrayList<Paquete> paquetesSeleccionados, String fecha, Ruta r) throws IOException {
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
        r.acceptarRuta();
        r.setFecha(fecha);
        if (r.isVerificada()) {
            cp.guardarRuta(r, fecha, true);
        }
        else {
            cp.guardarRuta(r, fecha, false);
        }
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
    
    public void anadirCiudad() throws ClassNotFoundException, IOException{
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
    
    public void opcionesOperador() throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("pulse 1 para calcular una ruta nueva, 2 para recalcular una ruta existente");
        int op = sc.nextInt();
        if(op == 1){
            String fecha = null;
            Ruta r = new Ruta();
            iniciarRuta(fecha, r);
        }
        else if (op == 2){
            recalcularRuta();
        }
    }
    
    private void recalcularRuta() throws IOException, FileNotFoundException, ClassNotFoundException{
        Ruta r = (Ruta) leerRuta();
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes = r.getListaPaquetesRuta();
        oper.modificaListaPaquetes(paquetes);
        Mapa map = new Mapa();
        map = r.getMapa();
        String nom = r.getFecha();
        System.out.println("Procedemos al recalculo de la ruta");
        calcularRuta(paquetes, nom, r);
        
   }
    
    public void iniciarRuta(String fecha, Ruta r) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres calcular la ruta de hoy y de este turno? s/n");
        String ord = sc.nextLine();
        Date date = new Date();
        String turno;
        if (ord.equals("s")) {
            if (date.getHours() > 9 & date.getHours()<15) turno = "-mañana";
            else turno = "-tarde";
            fecha = String.valueOf(date.getDate()+"."+(date.getMonth()+1)+"."+(date.getYear()-100));
            ArrayList <Paquete> paquetesSeleccionados = oper.seleccionarPaquetes();
            fecha = fecha + turno;
            calcularRuta(paquetesSeleccionados, fecha, r);     
        }
        else {
            System.out.println("Aun no implementado");
            /*System.out.println("Entra la fecha (dd.mm.aa)");
            fecha = sc.nextLine();
            String ano = fecha.substring(6, fecha.length());
            String mes = fecha.substring(3, fecha.length()-3);
            String dia = fecha.substring(0, fecha.length()-6);
            if(ano.compareTo(String.valueOf(date.getYear()-100)) < 0){
                System.out.println("la fecha tiene que ser superior a la actual");
            }
            else{
                if(mes.compareTo(String.valueOf(date.getMonth()+1)) < 0){
                    System.out.println("la fecha tiene que ser superior a la actual");
                }
                else{
                    if(dia.compareTo(String.valueOf(date.getDate())) < 0){
                        System.out.println("la fecha tiene que ser superior a la actual");
                    }
                    else {
                        System.out.println("Entra el turno (mañana/tarde)");
                        turno = "-"+sc.nextLine();
                        fecha = fecha + turno;
                        //ArrayList <Paquete> paquetesSeleccionados = oper.seleccionarPaquetes(fecha,turno);
                        //calcularRuta(paquetesSeleccionados, fecha, r);
                    }
                }
            }*/
        }
    }
    
    
    //FUNCIONES DEL CLIENTE!!!!

      
    public void anadirPaquete() throws FileNotFoundException, IOException, ClassNotFoundException{
        Paquete p = new Paquete();
        Mapa map = (Mapa) leerCiudad();
        String nombreCiudad = map.getNombreCiudad();
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
            }
            else{
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