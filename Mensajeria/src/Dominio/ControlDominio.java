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
    ControlPersistencia cp = new ControlPersistencia();
        
    public void calcularRuta(ArrayList<Paquete> paquetesSeleccionados, String fecha, Mapa mapa) throws IOException {
        Scanner sc = new Scanner(System.in);
        Ruta r = new Ruta();
        r.crearGrafo(paquetesSeleccionados, mapa);
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
        for(int i = 0; i < ciudades.size(); ++i){
            System.out.println(ciudades.get(i));
        }
        String nombre = sc.nextLine();
        return cp.leerCiudad(nombre);
    }
    
    public Object leerRuta() throws IOException, FileNotFoundException, ClassNotFoundException {
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
        return cp.leerListaPaquetes();
    }
    
    public Object leerListaClientes() throws IOException, FileNotFoundException, ClassNotFoundException {
        return cp.leerListaClientes();
    }
    
    public Object leerOperador() throws IOException, ClassNotFoundException {
        return cp.leerOperador();
    }
    
    public void guardadoGeneral(Object lc, Object lp, Object oper) throws IOException {
        cp.guardadoGeneral(lc, lp, oper);
    }
}