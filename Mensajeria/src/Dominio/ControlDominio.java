package Dominio;

import java.util.ArrayList;

/**
 *
 * @author Marc Garcia Roig xD
 */
public class ControlDominio {
    Mapa m = new Mapa();
    private String[] Nombres;
    private float[][] Ciudad;
        
    public ControlDominio() {
        //No funciona porque falta hacer la clase SeleccionarDestinos del operador
	//InicializarControlDomini();
    }
        
    private void CrearSubgrafo(float[][] Subgrafo, String[] NombresSubgrafo) {
        Operador o = new Operador();
        int[] PaquetesSeleccionados = o.SeleccionarDestinos();
        Subgrafo = new float[PaquetesSeleccionados.length][PaquetesSeleccionados.length];
        NombresSubgrafo = new String[PaquetesSeleccionados.length];
        for (int i = 0; i < PaquetesSeleccionados.length; ++i) {
            NombresSubgrafo[i] = Nombres[PaquetesSeleccionados[i]];
            for (int j = 0; j < PaquetesSeleccionados.length; ++j) {
                Subgrafo[i][j] = Ciudad[PaquetesSeleccionados[i]][PaquetesSeleccionados[j]];
            }
        }
    }

    private void InicializarControlDomini() {
        float[][] Subgrafo = null;
        String[] NombresSubgrafo = null;
        CrearSubgrafo(Subgrafo, NombresSubgrafo);
        Ruta r = new Ruta();
        r.setNombresSubgrafo(NombresSubgrafo);
        r.setSubgrafo(Subgrafo);
        ArrayList< ArrayList<Pair> > ARM = new ArrayList<>();
        //S'utlitza abaix -> ARM = r.MSTK;
        
        Christofides chris = new Christofides();
        chris.setGrafo(Ciudad);
        chris.setMST(r.MSTK);
        chris.setNombres(NombresSubgrafo);
        int[] PermutacionsNoOpt = chris.buscaPermutacion();
        
        //Llamar a la optimizacion
    }
}