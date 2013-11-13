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
        
    private void crearSubgrafo(float[][] subgrafo, String[] nombresSubgrafo, ArrayList<Integer> paquetesSeleccionados) {
        subgrafo = new float[paquetesSeleccionados.size()][paquetesSeleccionados.size()];
        nombresSubgrafo = new String[paquetesSeleccionados.size()];
        for (int i = 0; i < paquetesSeleccionados.size(); ++i) {
            nombresSubgrafo[i] = nombres[paquetesSeleccionados.get(i)];
            for (int j = 0; j < paquetesSeleccionados.size(); ++j) {
                subgrafo[i][j] = ciudad[paquetesSeleccionados.get(i)][paquetesSeleccionados.get(j)];
            }
        }
    }

    public void calcularRuta(ArrayList<Integer> paquetesSeleccionados) {
        float[][] subgrafo = null;
        String[] nombresSubgrafo = null;
        crearSubgrafo(subgrafo, nombresSubgrafo, paquetesSeleccionados);
        Scanner sc = new Scanner(System.in);
        Ruta r = new Ruta();
        r.setGrafo(subgrafo);
        r.setNombres(nombres);
        System.out.println("Quieres calcular una ruta rapidamente (poco eficaz) o lentamente (eficaz)");
        String raplent =sc.nextLine();
        if (raplent.equals("rapidamente")) {
            r.calcularRapida();
        }
        else {
            r.calcularMinSpaTree();
            r.calcularChristofides();
            //Llamar a la optimizacion
        }
        cp.guardarRuta(r);
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