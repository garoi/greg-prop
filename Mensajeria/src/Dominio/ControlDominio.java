package Dominio;

import java.util.ArrayList;
import java.util.*;
import Persistencia.ControlPersistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Albert Gili Zaragoza
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
        cu = new ControlUsuario();
        cp = new ControlPersistencia();
        lc = (ListaClientes) leerListaClientes();
        if(lc == null) lc = new ListaClientes();
        
        oper = (Operador) leerOperador();
        if(oper == null) {
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
    public boolean registroCliente(String usuario, String password) throws IOException{
        cl = new Cliente();
        cl.setNombre(usuario);
        cl.setPassword(password);
        boolean reg = cu.registroCliente(usuario, password, cl, lc);
        if(reg){
            cp.guardarListaClientes(lc);
            return true;
        }
        else return false;
    }
    
    public boolean loginCliente(String usuario, String password){
        //HA DE RETORNAR UN CLIENT
        int login =  cu.loginCliente(usuario, password, lc, cl);
        if(login == -1){
            return false;
        }
        else {
            cl = new Cliente();
            cl = lc.getCliente(login);
            return true;
        }
    }
    
    public boolean registroOperador(String usuario, String password) throws IOException, ClassNotFoundException{
        boolean reg = false;
        if (!existeOper) {
            oper = new Operador();
            reg = cu.registroOperado(usuario, password, oper);
        }
        if(reg){
            cp.guardarOperador(oper);
            existeOper = true;
            return true;
        }
        else return false;
    }
    
    public boolean loginOperador(String usuario, String password) throws IOException, ClassNotFoundException{
        return cu.loginOperador(usuario, password, oper);
    }

    /**
     * Calcula el camino de una ruta
     * @param paquetesSeleccionados
     * @param fecha
     * @param r
     * @throws IOException 
     */
    private void calcularRuta(ArrayList<Paquete> paquetesSeleccionados, String fecha, String turno, Ruta r, String tipo) throws IOException {
        r.crearGrafo(paquetesSeleccionados, map);
        
        if (tipo.equals("rapidamente")) {
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
            if (turno.equals(date.mananaTarde())) {
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
        for(int i =0; i < paquetesEnviados.size();++i){
            lc.cambiarEstadoPaquetes(paquetesEnviados.get(i));
            lp.cambiarEstadoPaquetes(paquetesEnviados);
            guardadoGeneral();
        }
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
    
    public String[] getNombresCiudades(){
        ArrayList<String> ciudades = new ArrayList <String>();
        ciudades = cp.listarCiudades();
        String[] cities = new String[ciudades.size()];
        for(int i = 0; i < ciudades.size(); ++i){
            cities[i] = ciudades.get(i);
        }
        return cities;
    }
    
    public String[] getDestinosCiudad(String nombreCiudad) throws IOException{
        Mapa prov = new Mapa();
        prov = (Mapa) cp.getPuntosMapa(nombreCiudad);
        ArrayList <String> destinos = new ArrayList <String>();
        destinos = prov.getNombres();
        String[] puntos = new String[destinos.size()];
        for(int i = 0; i < destinos.size(); ++i){
            puntos[i] = destinos.get(i);
        }
        return puntos;
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
        rutas = cp.listarRutasNoVerificadas(nombreCiudad);
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
            return cp.leerOperador();
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
    public String[][] verPaquetesOperador(){
        return oper.verPaquetes();
    }
    
    /**
     * Anade una ciudad al sistema
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void anadirCiudad() throws ClassNotFoundException, IOException{
        map = new Mapa();
        map = oper.anadirCiudad(map);
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
    private void modificarCiudad() {
       oper.modificarCiudad(map);
   }
   
    private void modificarRuta(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Ruta r = (Ruta) leerRuta(nombre);
        Mapa maptem = r.getMapa();
        ArrayList<String> nombresCiu = maptem.getNombres();
        Integer[] puntosRuta = r.getPermutacion();
        ArrayList<Paquete> listaPaquetesRutaTemp= new ArrayList<>();
        listaPaquetesRutaTemp = r.getListaPaquetesRuta();
        System.out.println("Por que puntos de la ciudad te gustaria pasar?");
        for (int i = 0; i < nombresCiu.size(); ++i) {
            System.out.println(i + " " + nombresCiu.get(i));
        }
        System.out.println("Para indicar que ya no quieres añadir mas puntos pulsa -1");
        System.out.println("entra el id destino");
        int nuevoPunto = sc.nextInt();
        while (nuevoPunto > -1) {
            Paquete p = new Paquete();
            p.setDestino(nombresCiu.get(nuevoPunto));
            p.setIdDestino(nuevoPunto);
            listaPaquetesRutaTemp.add(p);
            nuevoPunto = sc.nextInt();
        }
        r.setListaPaquetesRuta(listaPaquetesRutaTemp);
        r.crearGrafo(listaPaquetesRutaTemp, map);
        r.calcularRapida();
        r.mostrarRuta();
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
        System.out.println("Paquetes de recalculo");
        paquetes = oper.modificaListaPaquetes(paquetes);
        map = r.getMapa();
        System.out.println("Procedemos al recalculo de la ruta");
        calcularRuta(paquetes, r.getFecha(), r.getTurno(), r, null);
        
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
            ArrayList <Paquete> paquetesSeleccionados = oper.seleccionarPaquetes(map.getNombreCiudad(), date.fechaActual(), date.mananaTarde());;
            String fechaactual = date.fechaActual();
            String turno = date.mananaTarde();
            calcularRuta(paquetesSeleccionados, fechaactual, turno, r, null);     
        }
        else {
            System.out.println("Entra la fecha (dd.mm.aa)");
            String fecharuta = sc.nextLine();
            if (date.comprobarFecha(fecharuta)) {
                System.out.println("Entra el turno (manana/tarde)");
                String turno = sc.nextLine();
                ArrayList <Paquete> paquetesSeleccionados = oper.seleccionarPaquetes(map.getNombreCiudad(), fecharuta, turno);
                calcularRuta(paquetesSeleccionados, fecharuta, turno, r, null);
            }
        }
    }
    
    
    /**
     * El cliente añade un paquete para enviar
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
   public void anadirPaquete(String nombreCiudad, String destino, String fecha, String turno) throws IOException{
       Paquete p = new Paquete();
       int idCliente = cl.getIdCliente();
       Mapa provisional = new Mapa();
       provisional = (Mapa) cp.getPuntosMapa(nombreCiudad);
       ArrayList <String> destinos = new ArrayList <String> ();
       destinos = provisional.getNombres();
       int idDestino = destinos.indexOf(destino);
       if(idDestino != -1){
            p.leerPaquete(idCliente, nombreCiudad, destino, fecha, turno, idDestino);
            lp.anadirPaquete(p);
            lc.anadirPaquete(p, idCliente);
            oper.anadirPaquete(p);
            ArrayList <String> puntosCiudad = new ArrayList <String>();
       }
       cp.guardadoGeneral(lc, lp, oper);
    }
    
    /**
     * El cliente cancela un paquete que aun no se ha enviado
     */
    public boolean cancelarPaquete(int idPaquete) throws IOException{
        boolean cancelado = cl.cancelarPaquete(idPaquete);
        if(cancelado){
            lp.cancelarPaquete(idPaquete);
            boolean ok = oper.cancelarPaquete(idPaquete);
            cp.guardadoGeneral(lc, lp, oper);
            return true;
        }
        else return false;
    }
    
    /**
     * El cliente elimina todos los paquetes que ya se han enviado
     */
    public void eliminarPaquetes(){
        cl.eliminarPaquetes();
    }
    
    /**
     * Devuelve un vector con el dia mes año y turno actual
     * @return vector de String[]
     */
    public String[] fechaHoy() {
        Fecha date = new Fecha();
        return date.fechaDeHoy();
    }
    
    /**
     * Devuelve los paquetes en espera del cliente seleccionado
     * @param idCliente
     * @return los paquetes en espera del cliente seleccionado
     */
    public String[] getPaquetesEspera(){
        int idCliente = cl.getIdCliente();
        return lc.getPaquetesEspera(idCliente);
    }
    
    /**
     * Devuelve los paquetes enviados del cliente seleccionado
     * @param idCliente
     * @return los paquetes enviados del cliente seleccionado
     */
    public String[] getPaquetesEnviados(){
        int idCliente = cl.getIdCliente();
        return lc.getPaquetesEnviados(idCliente);
    }
    
    public ArrayList<String> getRutas(String nombreCiudad) {
        ArrayList<String> rutasNoVerificadas = new ArrayList<>();
        rutasNoVerificadas = cp.listarRutasNoVerificadas(nombreCiudad);
        ArrayList<String> rutasVerificadas = new ArrayList<>();
        rutasVerificadas = cp.listarRutasVerificadas(nombreCiudad);
        //ORDENAR ELS VECTORS DE STRING
        Collections.sort(rutasNoVerificadas);
        Collections.sort(rutasVerificadas);

        rutasNoVerificadas.addAll(rutasVerificadas);
        return rutasNoVerificadas;
    }

    public ArrayList<String> getPaquetesRuta(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);

        ArrayList<Paquete> listaPaquetesRuta = new ArrayList<>();
        listaPaquetesRuta = r.getListaPaquetesRuta();
        ArrayList<String>  result = new ArrayList<String>(); 
        for (int i = 0; i < listaPaquetesRuta.size(); ++i) {
            result.add(listaPaquetesRuta.get(i).getDestino() + " " + listaPaquetesRuta.get(i).getIdPaquete());
        }
        return result;
    }
    
    private String saberTurno(String fecha) {
        String turno;
        if (fecha.endsWith("M")) {
            turno = "manana";
        }
        else turno = "tarde";
        return turno;
    }
    
    public ArrayList<String> getPaquetesPendientes(String nombreCiudad, String fecha) {
        ArrayList<Paquete> paquetesPendientes = new ArrayList<Paquete>();
        String turno = saberTurno(fecha);
        String fecha2 = fecha.substring(0,fecha.length()-2);
        paquetesPendientes = oper.seleccionarPaquetes(nombreCiudad, fecha2, turno);
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < paquetesPendientes.size(); ++i) {
            result.add(paquetesPendientes.get(i).getDestino() + " " + paquetesPendientes.get(i).getIdPaquete());
        }
        return result;
    }

    public void calcularRuta(ArrayList<String> listaEnRutaS, String fecha, String nombreCiudad, String tipo) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta r = new Ruta();
        String turno = saberTurno(fecha);
        String fecha2 = fecha.substring(0,fecha.length()-2);
        ArrayList<Paquete> paquetesSeleccionados = new ArrayList<Paquete>();
        map = (Mapa) cp.leerCiudad(nombreCiudad);
        for (int i = 0; i < listaEnRutaS.size(); ++i) {
            StringTokenizer tokens = new StringTokenizer(listaEnRutaS.get(i));
            tokens.nextToken();
            int idPaquete = Integer.valueOf(tokens.nextToken());
            Paquete p = new Paquete();
            p = oper.buscarPaquete(idPaquete);
            paquetesSeleccionados.add(p);
        }
        calcularRuta(paquetesSeleccionados, fecha2, turno, r, tipo);
    }

    public void acceptarRuta(String ruta, String fecha, String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta rval = (Ruta) cp.leerRuta(ruta);
        rval.acceptarRuta();
        cp.guardarRuta(rval, fecha, rval.isVerificada(), nombreCiudad);
    }

    public void eliminarRuta(String ruta) {
        cp.elimnarRuta(ruta);
    }
}