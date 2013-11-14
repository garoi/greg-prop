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
    Mapa m = new Mapa();
    private String[] nombres;
    private float[][] ciudad;
        
    public void calcularRuta(ArrayList<Paquete> paquetesSeleccionados, String fecha, Mapa mapa) throws IOException {
        Scanner sc = new Scanner(System.in);
        Ruta r = new Ruta();
        r.crearGrafo(paquetesSeleccionados);
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
        String nombre = sc.nextLine();
        return cp.leerRuta(nombre);
    }
    
    public void guardadoGeneral(Object lc, Object lp) throws IOException {
        cp.guardadoGeneral(lc, lp);
    }
    
}