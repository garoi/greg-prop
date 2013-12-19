package Dominio;

import java.util.ArrayList;
import java.util.*;
import Persistencia.ControlPersistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String nombreCiudad;
    private Mapa provisional;
    
    /**
     * Inicializa el controlador de dominio
     */
    public void iniControlDominio() {
        cu = new ControlUsuario();
        cp = new ControlPersistencia();
        cp.crearDirectorios();
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
     */
    public boolean registroCliente(String usuario, String password){
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
    
    /**
     *
     * @param usuario
     * @param password
     * @return retorna true en caso de que el username y el password coincidan, 
     * false en el caso de que no.
     */
    public boolean loginCliente(String usuario, String password){
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
    
    /**
     *
     * @param usuario
     * @param password
     * @return Registra un operador, en el caso de que el operador no exista se 
     * registra y retorna true, en el caso de que ya exista returna false
     */
    public boolean registroOperador(String usuario, String password){
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
    
    /**
     *
     * @param usuario
     * @param password
     * @return llamada a la funcion del control de usuario para ver si el 
     * operador es valido, si es valido retornara true, si no retornara false
     */
    public boolean loginOperador(String usuario, String password){
        return cu.loginOperador(usuario, password, oper);
    }

    /**
     * Calcula el camino de una ruta
     * @param paquetesSeleccionados
     * @param fecha
     * @param r
     */
    private void calculaRuta(ArrayList<Paquete> copia, String fecha, String turno, Ruta r, String tipo, ArrayList<Paquete> paquetesSeleccionados, boolean compara) {
        r.crearGrafo(copia, map);
        if (tipo.equals("rapidamente")) {
            r.calcularRapida();
        }
        else if (tipo.equals("rapidaOptima")) {
            r.rapidaOptimizada();
        }
        else {
            r.calcularMinSpaTree();
            r.calcularChristofides();
        }
        r.distanciaRuta();
        r.setFecha(fecha);
        r.setTurno(turno);
        r.setTipo(tipo);
        r.setListaPaquetesRuta(paquetesSeleccionados);
        String nombreRuta = fecha + "-" + turno + "-";
        String coste = tipo + "-Coste-" + Float.toString(r.getCosteRuta());
        cp.guardarRuta(r, nombreRuta, coste, r.isVerificada(), r.getMapa().getNombreCiudad(), compara);
    }
    
    /**
     *  Cambia el estado de los paquetes de una ruta una vez esta esta 
     * verificada
     * @param nombreRuta
     */
    public void paquetesEnviados(String nombreRuta){
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);
        ArrayList<Paquete> paquetesEnviados = r.getListaPaquetesRuta();
        oper.cambiarEstadoPaquetes(paquetesEnviados);
        for(int i =0; i < paquetesEnviados.size();++i){
            lc.cambiarEstadoPaquetes(paquetesEnviados.get(i));
            lp.cambiarEstadoPaquetes(paquetesEnviados);
            guardadoGeneral();
        }
    }
    
    /**
     *
     * @return devuelve un array de Strings con todos los nombres de las 
     * ciudades entradaes en sistema.
     */
    public String[] getNombresCiudades(){
        ArrayList<String> ciudades = new ArrayList <String>();
        ciudades = cp.listarCiudades();
        String[] cities = new String[ciudades.size()];
        for(int i = 0; i < ciudades.size(); ++i){
            cities[i] = ciudades.get(i);
        }
        return cities;
    }
    
    /**
     *
     * @param nombreCiudad
     * @return retorna todos los nombres de los destinos de la ciudad con 
     * nombre nombreCiudad
     */
    public String[] getDestinosCiudad(String nombreCiudad) {
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
     * Lee una lista de paquetes
     * @returnListaPaquetes
     */
    private Object leerListaPaquetes(){
        return lp = (ListaPaquetes) cp.leerListaPaquetes();
    }
    
    /**
     * Lee una lista de clientes
     * @return ListaClientes
     */
    private Object leerListaClientes() {
        return lc = (ListaClientes) cp.leerListaClientes();
    }
    
    /**
     * Lee un operador
     * @return Operador
     */
    private Object leerOperador() {
        return cp.leerOperador();
    }
    

    private void guardadoGeneral() {
        cp.guardadoGeneral(lc, lp, oper);
    }
    
    /**
     * Muestra los paquetes disponibles del operador
     * @param orden
     * @return
     */
    public ArrayList<String> verPaquetesOperador(String orden){
        return lp.verPaquetes(orden);
    }
    

    /**
     * Anade una ciudad al sistema
     * @param nombre
     * @param n
     * @param nombreNodos
     * @param distanciasNodos
     */
    public void anadirCiudad(String nombre, int n, ArrayList<String> nombreNodos, float[] distanciasNodos) {
        map = new Mapa();
        map.ctrlCrearCiudad(nombre, n, nombreNodos, distanciasNodos);
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
    /**
     *  Añade un punto a la ciudad con nombre nombre.
     * @param nombre
     * @param distanciasNodos
     */
    public void anadirPunto(String nombre, float[] distanciasNodos) {
        if (map != null){
            map.anadirPunto(nombre, distanciasNodos);
            cp.guardarMapas(map, map.getNombreCiudad());
        }
    }
    
   
    /**
     * El cliente añade un paquete para enviar
     * @param nombreCiudad
     * @param destino
     * @param fecha
     * @param turno
     * @param lock
     */
    public void anadirPaquete(String nombreCiudad, String destino, String fecha, String turno, boolean lock) {
       Paquete p = new Paquete();
       int idCliente = cl.getIdCliente();
       if (provisional == null || !this.nombreCiudad.equals(nombreCiudad)){
           if (provisional == null) provisional = new Mapa();
           provisional = (Mapa) cp.getPuntosMapa(nombreCiudad);
           this.nombreCiudad = nombreCiudad;
       }
       ArrayList <String> destinos = new ArrayList();
       destinos = provisional.getNombres();
       int idDestino = destinos.indexOf(destino);
       if(idDestino != -1){
            p.leerPaquete(idCliente, nombreCiudad, destino, fecha, turno, idDestino);
            lp.anadirPaquete(p);
            lc.anadirPaquete(p, idCliente);
            oper.anadirPaquete(p);
       }
       if (lock) cp.guardadoGeneral(lc, lp, oper);
    }
    
    
    /**
     *
     * @param idPaquete
     * @return El cliente cancela un paquete que aun no se ha enviado
     */
    public boolean cancelarPaquete(int idPaquete) {
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
     *
     * @param idPaquete
     * @return elimina un paquete con el numero de identificador idPaquete
     * del cliente al que pertenece, de la lista de paquetes y de la lista
     * de paquetes del operador
     * si lo elimina devuelve true, si no puede eliminarlo devuelve false
     */
    public boolean eliminarPaquete(int idPaquete) {
        boolean eliminado = cl.eliminarPaquete(idPaquete);
        if(eliminado){
            lp.eliminarPaquete(idPaquete);
            boolean ok = oper.eliminarPaquete(idPaquete);
            cp.guardadoGeneral(lc, lp, oper);
            return true;
        }
        else return false;
    }
    

    /**
     *  El cliente elimina todos los paquetes que ya se han enviado
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
    
    /**
     *
     * @param nombreCiudad
     * @return ArrayList con todos los nombres de las rutas de una ciudad
     * con nombre nombreCiudad
     */
    public ArrayList<String> getRutas(String nombreCiudad) {
        ArrayList<String> rutasNoVerificadas = new ArrayList<>();
        rutasNoVerificadas = cp.listarRutasNoVerificadas(nombreCiudad);
        ArrayList<String> rutasVerificadas = new ArrayList<>();
        rutasVerificadas = cp.listarRutasVerificadas(nombreCiudad);
        Collections.sort(rutasNoVerificadas);
        Collections.sort(rutasVerificadas);

        rutasNoVerificadas.addAll(rutasVerificadas);
        return rutasNoVerificadas;
    }

    /**
     *
     * @param nombreRuta
     * @return ArayList de strings con todos los paquetes de la ruta con nombre
     * nombreRuta
     */
    public ArrayList<String> getPaquetesRuta(String nombreRuta){
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
            turno = "M";
        }
        else turno = "T";
        return turno;
    }
    
    /**
     *
     * @param nombreCiudad
     * @param fecha
     * @return retorna un ArrayList de strings con todos los paquetes que hay 
     * pendientes para entregar en una ciudad
     */
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

    /**
     *  Calcula una ruta para una ciudad t una fecha indicados.
     * @param listaEnRutaS
     * @param fecha
     * @param nombreCiudad
     * @param tipo
     * @param compara
     */
    public void calcularRuta(ArrayList<String> listaEnRutaS, String fecha, String nombreCiudad, String tipo, boolean compara){
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
        Collections.sort(paquetesSeleccionados, new Paquete.DestinoComparator());
        ArrayList<Paquete> copia = new ArrayList<>();
        String nom = paquetesSeleccionados.get(0).getDestino();
        copia.add(paquetesSeleccionados.get(0));
        for (int i = 1; i < paquetesSeleccionados.size(); ++i) {
            if(!paquetesSeleccionados.get(i).getDestino().equals(nom)){
                copia.add(paquetesSeleccionados.get(i));
                nom = paquetesSeleccionados.get(i).getDestino();
            }
        }
        calculaRuta(copia, fecha2, turno, r, tipo, paquetesSeleccionados, compara);
    }

    /**
     *  Verifica una ruta que esta en el sistema
     * @param ruta
     * @param fecha
     * @param nombreCiudad
     */
    public void acceptarRuta(String ruta, String fecha, String nombreCiudad){
        Ruta rval = (Ruta) cp.leerRuta(ruta);
        rval.acceptarRuta();
        String nombreRuta = fecha + "-";
        String coste = rval.getTipo()+ "-Coste-" + Float.toString(rval.getCosteRuta());
        cp.guardarRuta(rval, nombreRuta, coste, rval.isVerificada(), nombreCiudad, false);
    }

    /**
     * Elimina una ruta que esta en el sistema
     * @param ruta
     */
    public void eliminarRuta(String ruta) {
        cp.eliminarRuta(ruta);
    }
    
    /**
     * Obtiene todos los nombres de los puntos de una ciudad con un nombre
     * determinado
     * @param nombreCiudad
     * @return
     */
    public ArrayList<String> getNombresCiudad(String nombreCiudad) {
        map = (Mapa) cp.leerCiudad(nombreCiudad);
        return map.getNombres();
    }
    
    /**
     *
     * @param ciudad
     * @param a
     * @param b
     * @return retorna la distancia entre dos puntos de un mapa con nombre
     * ciudad
     */
    public Float getDistancia(String ciudad, String a, String b) {
        if (map == null) map = (Mapa) cp.leerCiudad(ciudad);
        if (map != null) return map.getDistancia(a,b);
        return 1f;
    }
    
    /**
     *
     * @param ciudad
     * @return Float
     */
    public Float getMax(String ciudad) {
        if (map == null) map = (Mapa) cp.leerCiudad(ciudad);
        if (map != null) return map.getMax();
        return 1f;
    }
    /**
     *
     * @param ciudad
     * @return Float
     */
    public Float getMin(String ciudad) {
        if (map == null) map = (Mapa) cp.leerCiudad(ciudad);
        if (map != null) return map.getMin();
        return 1f;
    }

    /**
     *
     * @param fecha
     * @param nombreCiudad
     * @return retorna el nombre de las rutas comparadas con los distintos 
     * tipos de algoritmos que hay
     */
    public ArrayList<String> rutasComparadas(String fecha, String nombreCiudad) {
        return cp.leerRutasComparadas(fecha, nombreCiudad);
    }
    
    private Integer[] getRuta(String nombreRuta) {
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);
        return r.getPermutacion();
    }
    private String[] getNombresRuta(String nombreRuta) {
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);
        return r.getNombres();
    }

    /**
     * Elimina rutas comparadas
     * @param inicioRuta
     * @param nombreRuta
     */
    public void eliminarRutaComp(String inicioRuta, String nombreRuta) {
        cp.eliminarRutaComp(inicioRuta, nombreRuta);
    }
    
    /**
     * Crea un fichero
     * @param nombreFichero
     */
    public void crearFichero(String nombreFichero) {
        cp.crearFichero(nombreFichero);
    }
    
     /**
     * carga la ciudad con el nombre de nombreCiudad
     * @param nombreCiudad
     * @return
     */
    public Object leerCiudad(String nombreCiudad){
        return cp.leerCiudad(nombreCiudad);
    }
    
    /**
     *
     * @param nomFichero
     * @param nomCiudad
     * @param nombres
     * @param ciudad
     */
    public void leerMapaFichero(String nomFichero, String nomCiudad, ArrayList<String> nombres, ArrayList<Float> ciudad){      
        cp.leerMapaFichero(nomFichero, nomCiudad, nombres, ciudad);
    }
       
    /**
     *
     * @param nomCiudad
     * @param nombres
     * @param ciudad
     */
    public void pasarAObjeto(String nomCiudad, ArrayList<String> nombres, float[] ciudad){
        Mapa m = new Mapa();
        m.ctrlCrearCiudad(nomCiudad, nombres.size(), nombres, ciudad);
        cp.guardarMapas(m, nomCiudad);
    }
       
    /**
     * Elimina una ciudad del mapa
     * @param nombreCiudad
     */
    public void eliminarCiudad(String nombreCiudad){
        cp.eliminarCiudad(nombreCiudad);
        ArrayList<String> rutas = this.getRutas(nombreCiudad);
        for (int i = 0; i < rutas.size(); i++) {
            this.lp.eliminarPaquetesDeCiudad(nombreCiudad);
            cp.eliminarRuta(rutas.get(i));
        }
        cp.eliminarRutar(nombreCiudad);
        guardadoGeneral();
    }
    
    /**
     * Renombra un punto del parametro implícito
     * @param nombre1
     * @param nombre2
     */
    public void renombrarPunto(String nombre1, String nombre2){
        map.renombrarPunto(nombre1, nombre2);
        cp.guardarMapas(map, map.getNombreCiudad());
        cp.eliminarRutar(map.getNombreCiudad());
    }
    
    /**
     *
     * @param nombre1
     * @param nombre2
     * @param dist
     */
    public void modificaDistancia(String nombre1, String nombre2, float dist){
        map.setDistancia(nombre1, nombre2, dist);
        cp.guardarMapas(map, map.getNombreCiudad());
        cp.eliminarRutar(map.getNombreCiudad());
    }
    
    /**
     * elimina un punto.
     * @param nombre1
     */
    public void eliminarPunto(String nombre1){
        map.eliminarPunto(nombre1);
        cp.guardarMapas(map, map.getNombreCiudad());
        cp.eliminarRutar(map.getNombreCiudad());
    }

    /**
     * 
     * @param ruta
     * @return
     */
    public String getDestinosRuta(String ruta){
        Ruta r = (Ruta) cp.leerRuta(ruta);
        String[] nombres = r.getNombres();
        Integer[] permutacion = r.getPermutacion();
        String rutaNombres = null;
        for (int i = 0; i < permutacion.length; ++i) {
            if (rutaNombres == null) {
                rutaNombres = nombres[permutacion[i]] + " ";
            }
            else {
                rutaNombres = rutaNombres + nombres[permutacion[i]] + " ";
            }
        }
        return rutaNombres;
    }
    
    /**
     * modifica una ciudad con el nombre de la ciudad igual a ciudad.
     * @param ciudad
     */
    public void modificarCiudad(String ciudad){ 
        Mapa m = (Mapa) cp.leerCiudad(ciudad); 
        String nombreFichero = m.getNombreCiudad() + "-mapa.txt"; 
        String nombreCiudad = m.getNombreCiudad(); 
        ArrayList<String> nombres = m.getNombres(); 
        ArrayList<ArrayList<Float>> city = m.getDistanciasCiudad();
        int tamany = m.getTamCiudad(); 
        cp.pasarAFichero(nombreFichero, nombreCiudad, nombres, city); 
        cp.abrirFichero(nombreFichero); 
        cp.eliminarRutar(m.getNombreCiudad());
    }

    /**
     *
     * @param ruta
     * @param res
     * @return si la urta ha sido modificada retorna true, si no retorna false
     */
    public boolean modificarRuta(String ruta, String res) {
        Ruta r = (Ruta) cp.leerRuta(ruta);
        String nombreRutaAnterior = r.getFecha() + "-" + r.getTurno() + "-" + r.getTipo() + "-Coste-" + Float.toString(r.getCosteRuta());
        ArrayList<String> nombreRuta = new ArrayList<>();
        StringTokenizer tokens = new StringTokenizer(res);
        for (int i = 0; tokens.hasMoreTokens(); ++i) {
            nombreRuta.add(tokens.nextToken());
        }
        String[]nombreRutaS = new String[nombreRuta.size()];
        for (int i = 0; i < nombreRuta.size(); ++i) {
            nombreRutaS[i] = nombreRuta.get(i);
        }
        r.setNombres(nombreRutaS);
        r.crearGrafoMod(map);
        String nombresRuta = r.getFecha() + "-" + r.getTurno() + "-";
        String coste = r.getTipo() + "-Coste-" + Float.toString(r.getCosteRuta());
        cp.guardarRuta(r, nombresRuta, coste, r.isVerificada(), r.getMapa().getNombreCiudad(), false);
        cp.eliminarRuta(nombreRutaAnterior+"-ruta.txt");
        return true;
    }
}