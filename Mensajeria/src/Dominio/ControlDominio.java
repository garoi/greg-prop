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
    private void calculaRuta(ArrayList<Paquete> copia, String fecha, String turno, Ruta r, String tipo, ArrayList<Paquete> paquetesSeleccionados) throws IOException {
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
        String nombreRuta = fecha + "-" + turno + "-" + tipo + "-Coste-" + Float.toString(r.getCosteRuta());
        cp.guardarRuta(r, nombreRuta, r.isVerificada(), r.getMapa().getNombreCiudad());
    }
    
    public void paquetesEnviados(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);
        ArrayList<Paquete> paquetesEnviados = r.getListaPaquetesRuta();
        oper.cambiarEstadoPaquetes(paquetesEnviados);
        for(int i =0; i < paquetesEnviados.size();++i){
            lc.cambiarEstadoPaquetes(paquetesEnviados.get(i));
            lp.cambiarEstadoPaquetes(paquetesEnviados);
            guardadoGeneral();
        }
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
     * Lee una lista de paquetes
     * @returnListaPaquetes
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    private Object leerListaPaquetes() throws IOException, FileNotFoundException, ClassNotFoundException {
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
    private Object leerListaClientes() throws IOException, FileNotFoundException, ClassNotFoundException {
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
    private Object leerOperador() throws IOException, ClassNotFoundException {
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
    private void guardadoGeneral() throws IOException {
        cp.guardadoGeneral(lc, lp, oper);
    }
    
    /**
     * Muestra los paquetes disponibles del operador
     */
    public ArrayList<String> verPaquetesOperador(String orden){
        return lp.verPaquetes(orden);
    }
    
    /**
     * Anade una ciudad al sistema
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void anadirCiudad(String nombre, int n, ArrayList<String> nombreNodos, float[] distanciasNodos) throws ClassNotFoundException, IOException{
        map = new Mapa();
        Fecha f = new Fecha();
        map.setFechaMod(f.fechaDeHoy());
        System.out.println("[ctrlD anadirCiudad]");
        for (int i = 0; i < distanciasNodos.length; i++) {
            System.out.print(distanciasNodos[i] + ", ");
        }
        System.out.print("\n");
        map.ctrlCrearCiudad(nombre, n, nombreNodos, distanciasNodos);
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
    public void anadirPunto(String nombre, float[] distanciasNodos) throws IOException, ClassNotFoundException{
        if (map != null){
            map.anadirPunto(nombre, distanciasNodos);
            cp.guardarMapas(map, map.getNombreCiudad());
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
    
    public boolean eliminarPaquete(int idPaquete) throws IOException{
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
            turno = "M";
        }
        else turno = "T";
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
        calculaRuta(copia, fecha2, turno, r, tipo, paquetesSeleccionados);
    }

    public void acceptarRuta(String ruta, String fecha, String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta rval = (Ruta) cp.leerRuta(ruta);
        rval.acceptarRuta();
        String nombreRuta = fecha + "-" + rval.getTipo() + "-Coste-" + Float.toString(rval.getCosteRuta());
        cp.guardarRuta(rval, nombreRuta, rval.isVerificada(), nombreCiudad);
    }

    public void eliminarRuta(String ruta) {
        cp.eliminarRuta(ruta);
    }
    
    public ArrayList<String> getNombresCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException {
        map = (Mapa) cp.leerCiudad(nombreCiudad);
        return map.getNombres();
    }
    
//    public ArrayList<ArrayList<Float>> pesosAristas(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException {
//        map = (Mapa) cp.leerCiudad(nombreCiudad);
//        return map.getCiudad();
//    }
    public Float getDistancia(String ciudad, String a, String b) throws FileNotFoundException, IOException, ClassNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (map == null) map = (Mapa) cp.leerCiudad(ciudad);
        else System.out.println("[getDistancia] " + map.getDistancia(a,b));
        if (map != null) return map.getDistancia(a,b);
        return 1f;
    }
    
    public Float getMax(String ciudad) throws FileNotFoundException, IOException, ClassNotFoundException{
        System.out.println("ciudad: " + map);
        if (map == null) map = (Mapa) cp.leerCiudad(ciudad);
        System.out.println("[getMax] max" + map.getMax());
        if (map != null) return map.getMax();
        return 1f;
    }
    public Float getMin(String ciudad) throws FileNotFoundException, IOException, ClassNotFoundException{
        if (map == null) map = (Mapa) cp.leerCiudad(ciudad);
        System.out.println("[getMin] min" + map.getMin());
        if (map != null) return map.getMin();
        return 1f;
    }

    public ArrayList<String> rutasComparadas(String fecha, String nombreCiudad) {
        return cp.leerRutasComparadas(fecha, nombreCiudad);
    }
    
    private Integer[] getRuta(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);
        return r.getPermutacion();
    }
    private String[] getNombresRuta(String nombreRuta) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta r = (Ruta) cp.leerRuta(nombreRuta);
        return r.getNombres();
    }

    public void eliminarRutaComp(String inicioRuta, String nombreRuta) {
        cp.eliminarRutaComp(inicioRuta, nombreRuta);
    }
    
    public void crearFichero(String nombreFichero) throws IOException{
        cp.crearFichero(nombreFichero);
    }
    
     public Object leerCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
       return cp.leerCiudad(nombreCiudad);
    }
    
    public void leerMapaFichero(String nomFichero, String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad){      
        cp.leerMapaFichero(nomFichero, nomCiudad, nombres, ciudad);
    }
    
    public void pasarAObjeto(String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad) throws IOException, ClassNotFoundException{
        Mapa m = new Mapa();
        Fecha f = new Fecha();
        m.setFechaMod(f.fechaDeHoy());
        m.setTamCiudad(nombres.size());
        m.setNombreCiudad(nomCiudad);
        m.setNombrePuntos(nombres);
        m.setCiudad(ciudad);
        cp.guardarMapas(m, nomCiudad);
    }
       
    public void eliminarCiudad(String nombreCiudad) throws IOException, FileNotFoundException, ClassNotFoundException{
        cp.eliminarCiudad(nombreCiudad);
        ArrayList<String> rutas = this.getRutas(nombreCiudad);
        for (int i = 0; i < rutas.size(); i++) {
            this.lp.eliminarPaquetesDeCiudad(nombreCiudad);
            cp.eliminarRuta(rutas.get(i));
        }
        // Eliminar todas las rutas de la ciudad.
    }
    
    public void renombrarPunto(String nombre1, String nombre2) throws IOException, IOException, ClassNotFoundException{
        map.renombrarPunto(nombre1, nombre2);
        Fecha f = new Fecha();
        map.setFechaMod(f.fechaDeHoy());
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
    public void modificaDistancia(String nombre1, String nombre2, float dist) throws IOException, ClassNotFoundException{
        map.setDistancia(nombre1, nombre2, dist);
        Fecha f = new Fecha();
        map.setFechaMod(f.fechaDeHoy());
        cp.guardarMapas(map, map.getNombreCiudad());
    }
    
    public void eliminarPunto(String nombre1) throws IOException, ClassNotFoundException{
        map.eliminarPunto(nombre1);
        Fecha f = new Fecha();
        map.setFechaMod(f.fechaDeHoy());
        cp.guardarMapas(map, map.getNombreCiudad());
    }

    public String getDestinosRuta(String ruta) throws IOException, FileNotFoundException, ClassNotFoundException {
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
    
    public void modificarCiudad(String ciudad) throws IOException, FileNotFoundException, ClassNotFoundException { 
        Mapa m = (Mapa) cp.leerCiudad(ciudad); 
        String nombreFichero = m.getNombreCiudad() + "-mapa.txt"; 
        String nombreCiudad = m.getNombreCiudad(); 
        ArrayList<String> nombres = m.getNombres(); 
        ArrayList<ArrayList<Float>> city = m.getDistanciasCiudad();
        int tamany = m.getTamCiudad(); 
        cp.pasarAFichero(nombreFichero, nombreCiudad, nombres, city); 
        cp.abrirFichero(nombreFichero); 
    }

    public boolean modificarRuta(String ruta, String res) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ruta r = (Ruta) cp.leerRuta(ruta);
        String[] fechaMod = map.getFechaMod();
        String fecha = r.getFecha();
        String ano = fecha.substring(6,fecha.length());
        String mes = fecha.substring(3, fecha.length()-3);
        String dia = fecha.substring(0, fecha.length()-6);
        if (Integer.parseInt(fechaMod[2]) >= Integer.parseInt(ano)) {
            if (Integer.parseInt(fechaMod[1]) >= Integer.parseInt(mes)) {
                if (Integer.parseInt(fechaMod[0]) > Integer.parseInt(dia)) {
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
                    String nombresRuta = r.getFecha() + "-" + r.getTurno() + "-" + r.getTipo() + "-Coste-" + Float.toString(r.getCosteRuta());
                    cp.guardarRuta(r, nombresRuta, r.isVerificada(), r.getMapa().getNombreCiudad());
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }
}