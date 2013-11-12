package Dominio;

import java.util.ArrayList;
import java.util.*;
import Persistencia.ControlPersistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Marc Garcia Roig xD
 */
public class ControlDominio {
    ControlPersistencia cp = new ControlPersistencia();
    Mapa m = new Mapa();
    private String[] nombres;
    private float[][] ciudad;
        
    /*public ControlDominio() {
        //No funciona porque falta hacer la clase SeleccionarDestinos del operador
	InicializarControlDomini();
    }*/
        
    private void Crearsubgrafo(float[][] subgrafo, String[] nombresSubgrafo) {
        Operador o  = new Operador();
        ArrayList<Integer> paquetesSeleccionados = new ArrayList<Integer>();
        paquetesSeleccionados = o.SeleccionarPaquetes();
        subgrafo = new float[paquetesSeleccionados.size()][paquetesSeleccionados.size()];
        nombresSubgrafo = new String[paquetesSeleccionados.size()];
        for (int i = 0; i < paquetesSeleccionados.size(); ++i) {
            nombresSubgrafo[i] = nombres[paquetesSeleccionados.get(i)];
            for (int j = 0; j < paquetesSeleccionados.size(); ++j) {
                subgrafo[i][j] = ciudad[paquetesSeleccionados.get(i)][paquetesSeleccionados.get(j)];
            }
        }
    }

    private void InicializarControlDomini() {
        float[][] subgrafo = null;
        String[] nombresSubgrafo = null;
        Crearsubgrafo(subgrafo, nombresSubgrafo);
        Ruta r = new Ruta();
        r.setNombresSubgrafo(nombresSubgrafo);
        r.setSubgrafo(subgrafo);
        ArrayList< ArrayList<Pair> > ARM = new ArrayList<>();
        //S'utlitza abaix -> ARM = r.MSTK;
        
        Christofides chris = new Christofides();
        chris.setGrafo(ciudad);
        chris.setMST(r.MSTK);
        chris.setNombres(nombresSubgrafo);
        int[] PermutacionsNoOpt = chris.buscaPermutacion();
        
        //Llamar a la optimizacion
    }
    
    public void GuardaMapa(Mapa map, String nombreciudad) throws IOException, ClassNotFoundException{
        cp.GuardarMapas(map, nombreciudad);
    }
    public Object LeerCiudad() throws FileNotFoundException, IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades = cp.ListarCiudades();
        for(int i = 0; i < ciudades.size(); ++i){
            System.out.println(ciudades.get(i));
        }
        String nom = sc.nextLine();
        return cp.LeerCiudad(nom);
    }
}