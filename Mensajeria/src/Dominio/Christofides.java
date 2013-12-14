package Dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Esta clase se encarga resolver una instancia del algoritmo de Christofides.
 * Dado un grafo y su árbol de expansión mínima correspondiente, devuelve una
 * permutación válida que puede ser una solución para un problema TSP sobre el
 * grafo.
 *
 * @author Grupo 3: Alberto Fernández Abellán 
 *                  Auger Casasnovas Planella 
 *                  Cristian Puig Guillen 
 *                  David Martín Alaminos
 *
 */
public class Christofides {
    private float[][] grafo;
    private String[] nombres;
    private ArrayList<ArrayList<Pair>> MST;
    private static final Float infinito = new Float(99999999.0);

    /**
     * Constructora.
     *
     */
    public Christofides() {

    }

    /**
     * Inicializa atributo Grafo.
     *
     * @param g representación de un grafo ponderado
     */
    public void setGrafo(float[][] g) {
        grafo = g;
    }

    /**
     * Inicializa atributo Nombres.
     *
     * @param n array con los nombres de todos los nodos de Grafo
     */
    public void setNombres(String[] n) {
        nombres = n;
    }

    /**
     * Inicializa atributo MST.
     *
     * @param mst árbol recubridor mínimo de Grafo
     */
    public void setMST(ArrayList<ArrayList<Pair>> mst) {
        MST = mst;
    }

    /**
     * Imprime el atributo grafo por pantalla. Útil para debug.
     * 
     */
    private void imprimeGrafo() {
        for (int i = 0; i < MST.size(); ++i) {
            for (int j = 0; j < MST.get(i).size(); ++j) {
                System.out.println("Nodo " + i + ": " + MST.get(i).get(j).first() + " " + MST.get(i).get(j).second());
            }
        }
    }
    
    /**
     * Devuelve la permutación resultante de aplicar el algoritmo de Christofides.
     * 
     * @return array de enteros ordenados
     */
    public Integer[] buscaPermutacion() {
        System.out.println("TAMANY despres de enviar " + MST.size());
        int tam = MST.size();
        if (tam > 2) {
            if (es_estrella() && centro_impar()) {
                convierte_no_estrella();
            }
            apareamientoPerfecto();
        }
        Integer[] CE = buscaCicloEuleriano();
        Integer[] CH = buscaCicloHamiltoniano(CE);
        
        return CH;
    }

    // Ops apareamientoPerfecto
    /**
     * Comprueba que el grafo MST sea estrella.
     *
     * @return booleano que indica si es estrella.
     */
    private boolean es_estrella() {
        for (int i = 0; i < MST.size(); ++i) {
            if (MST.get(i).size() == MST.size() - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba que en el grafo MST, el nodo central es impar.
     *
     * pre: El grafo MST es estrella.
     *
     * @return booleano que indica si el nodo central tiene un numero impar de
     * nodos adyacentes a él.
     */
    private boolean centro_impar() {
        int i = 0;
        while (MST.get(i).size() == 1) {
            ++i;
        }
        return (MST.get(i).size() % 2 == 1);
    }

    /**
     * Modifica el grafo, añadiendo un nodo hoja, a otro nodo hoja, para evitar
     * que el MST sea del tipo estrella.
     *
     */
    private void convierte_no_estrella() {
        int central = 0;
        int v[] = new int[2];
        v[0] = 0;
        v[1] = 1;
        while (MST.get(central).size() == 1) {
            ++central;
        }
        if (v[0] == central) {
            ++v[0];
            ++v[1];
        } else if (v[1] == central) {
            ++v[1];
        }
        for (int i = v[1] + 1; i < MST.size(); ++i) {
            if (i != central) {
                if (MST.get(i).get(0).second() < MST.get(imax(v)).get(0).second()) {
                    v[imax(v)] = i;
                }
            }
        }
        MST.get(v[0]).add(new Pair(v[1], grafo[v[0]][v[1]]));
        MST.get(v[1]).add(new Pair(v[0], grafo[v[0]][v[1]]));

        int i = 0;
        while (MST.get(central).get(i).first() != v[1]) {
            ++i;
        }
        while (i < MST.get(central).size() - 1) {
            MST.get(central).set(i, MST.get(central).get(i + 1));
            ++i;
        }

        MST.get(central).remove(i);
        MST.get(central).trimToSize();
        i = 0;
        while (MST.get(v[1]).get(i).first() != central) {
            ++i;
        }
        while (i < MST.get(v[1]).size() - 1) {
            MST.get(v[1]).set(i, MST.get(v[1]).get(i + 1));
            ++i;
        }
        MST.get(v[1]).remove(i);
        MST.get(v[1]).trimToSize();

    }

    /**
     * Devuelve el indice del nodo, segun su posicion en v, que tiene mayor
     * grado de adyacencia.
     *
     * @return entero que indica donde se encuentra el nodo con mayor grado de
     * adyacencia.
     */
    private int imax(int v[]) {
        if (MST.get(v[0]).get(0).second() > MST.get(v[1]).get(0).second()) {
            return 0;
        }
        return 1;
    }

    /**
     * Modifica el MST para que todos sus nodos tengan grado par.
     *
     */
    private void apareamientoPerfecto() {
        boolean nodos[] = new boolean[MST.size()];
        int impares = encuentra_y_devuelve_impares(nodos);
        int nodos_ord[] = new int[impares];
        guarda_nodos(nodos, nodos_ord);
        calcula_orden(nodos_ord, 0, impares - 1);

        for (int i = 0; i < impares; ++i) {
            if (i < impares && nodos[nodos_ord[i]] == true) {
                float dist = infinito;
                int dest = 0;
                for (int j = i + 1; j < impares; ++j) {
                    if (nodos[nodos_ord[j]] && !adyacentes(nodos_ord[i], nodos_ord[j]) && grafo[nodos_ord[i]][nodos_ord[j]] < dist) {
                        dist = grafo[nodos_ord[i]][nodos_ord[j]];
                        dest = nodos_ord[j];

                    }
                }
                nodos[nodos_ord[i]] = false;
                nodos[dest] = false;
                MST.get(nodos_ord[i]).add(new Pair(dest, dist));
                MST.get(dest).add(new Pair(nodos_ord[i], dist));
            }
        }
    }

    /**
     * Guarda en un array de booleanos, cuales de ellos tienen grado impar, y
     * devuelve el numero de nodos impares.
     *
     * @param nodos array de booleanos vacio.
     * @return numero de nodos de grado impar y array modificado.
     */
    private int encuentra_y_devuelve_impares(boolean nodos[]) {
        int impares = 0;
        for (int i = 0; i < MST.size(); ++i) {
            nodos[i] = (MST.get(i).size() % 2 == 1);
            if (MST.get(i).size() % 2 == 1) {
                ++impares;
            }
        }
        return impares;
    }

    /**
     * Ordena los nodos impares de mayor a menor adyacencia.
     *
     * @param nodos array de enteros con los identificadores de los nodos
     * impares.
     * @param ini entero identificador del inicio del segmento del array a
     * ordenar.
     * @param end entero identificador del final del segmento del array a
     * ordenar.
     */
    private void calcula_orden(int nodos[], int ini, int end) { //com mergesort
        if (end - ini < 50) { // talla critica
            ordenaXinsercion(nodos, ini, end);
        } else {
            int m = (ini + end) / 2;
            calcula_orden(nodos, ini, m);
            calcula_orden(nodos, m + 1, end);
            fusion(nodos, ini, m, end);
        }
    }

    /**
     * Fusiona los dos arrays que le pasa, calcula_orden.
     *
     * @param ini entero identificador del inicio de la primera parte del array
     * a ordenar.
     * @param m entero identificador del final de la primera parte del array a
     * ordenar.
     * @param end entero identificador del final del segundo segmento del array
     * a ordenar.
     * @return devuelve el array ordenado desde ini hasta end.
     */
    private void fusion(int nodos[], int ini, int m, int end) {
        int aux[] = new int[end - ini + 1];
        int i = ini;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= end) {
            if (MST.get(nodos[i]).size() <= MST.get(nodos[j]).size()) {
                aux[k++] = nodos[j++];
            } else {
                aux[k++] = nodos[i++];
            }
        }
        while (i <= m) {
            aux[k++] = nodos[i++];
        }
        while (j <= end) {
            aux[k++] = nodos[j++];
        }
        for (k = 0; k <= end - ini; ++k) {
            nodos[ini + k] = aux[k];
        }
    }

    /**
     * Ordena por insercion el array.
     *
     * @param ini entero identificador del inicio del array a ordenar.
     * @param end entero identificador del final del array a ordenar.
     * @return devuelve el array ordenado desde ini hasta end.
     */
    private void ordenaXinsercion(int nodos[], int ini, int end) {
        for (int i = ini + 1; i <= end; ++i) {
            int x = nodos[i];
            int j;
            for (j = i; j > 0 && MST.get(nodos[j - 1]).size() < MST.get(x).size(); --j) {
                nodos[j] = nodos[j - 1];
            }
            nodos[j] = x;
        }
    }

    /**
     * Añade al array nodos, los nodos impares.
     *
     * @param tots array de booleanos que indica que nodos tienen grado impar.
     * @param nodos array vacio donde guardaremos los nodos de grado impar.
     */
    private void guarda_nodos(boolean tots[], int nodos[]) {
        int j = 0;
        for (int i = 0; i < MST.size(); ++i) {
            if (tots[i]) {
                nodos[j] = i;
                ++j;
            }
        }
    }

    /**
     * Devuelve si dos nodos son adyacentes entre ellos en el MST.
     *
     * @param a entero que identifica a uno de los nodos.
     * @param b entero que identifica a uno de los nodos.
     * @return devuelve cierto si los nodos son adyacentes entre ellos.
     */
    private boolean adyacentes(int a, int b) {
        for (int i = 0; i < MST.get(a).size(); ++i) {
            if (MST.get(a).get(i).first() == b) {
                return true;
            }
        }
        return false;
    }

    // Ops buscaCicloEuleriano
    /**
     * Añade una arista a la lista de adyacencia de un nodo.
     *
     * @param p arista a añadir; el primer campo representa el nodo destino y el
     * segundo la ponderación de la arista
     * @param u nodo origen
     */
    private void nuevaArista(Pair p, int u) {
        MST.get(u).add(p);
    }

    /**
     * Quita una arista de la lista de adyacencia de un nodo.
     *
     * @param u nodo origen del que se quitará una arista con v de su lista de
     * adyacencia
     * @param v nodo destino
     * @return arista eliminada; el primer campo es v y el segundo la
     * ponderación de la arista
     */
    private Pair quitaArista(int u, int v) {
        Pair q = new Pair(-1,-1);
        for (int i = 0; i < MST.get(u).size(); ++i) {
            if (MST.get(u).get(i).first() == v) {
                Pair p = MST.get(u).remove(i);
                return p;
            }
        }
        return q;
    }

    /**
     * Búsqueda en profundidad (DFS) sobre MST que cuenta el número de nodos
     * accesibles desde un determinado nodo.
     *
     * @param v nodo desde el que aplicamos un DFS
     * @param visitados array que informa para cada nodo si ya ha sido visitado
     * @return número de nodos accesibles desde v
     */
    private Integer DFSn(int v, boolean visitados[]) {
        visitados[v] = true;
        int cont = 1;
        for (int i = 0; i < MST.get(v).size(); ++i) {
            int cand = MST.get(v).get(i).first();
            if (!visitados[cand]) {
                cont += DFSn(cand, visitados);
            }
        }
        return cont;
    }

    /**
     * Indica si podemos viajar de u a v.
     *
     * @param u nodo origen
     * @param v nodo destino
     * @return falso si (u,v) es arista puente o de corte, cierto en otro caso
     */
    private boolean esValido(int u, int v) {
        if (MST.get(u).size() == 1) {
            return true;
        }

        boolean visitados[] = new boolean[MST.size()];
        Arrays.fill(visitados, false);
        int c1 = DFSn(u, visitados);

        Pair p1 = quitaArista(u, v);
        Pair p2 = quitaArista(v, u);

        Arrays.fill(visitados, false);
        int c2 = DFSn(u, visitados);

        nuevaArista(p1, u);
        nuevaArista(p2, v);

        return (c1 <= c2);
    }

    /**
     * Busca recursivamente el siguiente nodo para construir un ciclo euleriano.
     *
     * @param v recorrido actual del ciclo euleriano; contiene los nodos
     * ordenados que formarán el ciclo
     * @param nodoIni nodo inicial a partir del que se busca el siguiente nodo
     */
    private void buscaSigNodo(Vector<Integer> v, int nodoIni) {
        for (int i = 0; i < MST.get(nodoIni).size(); ++i) {
            int nodoAct = MST.get(nodoIni).get(i).first();
            if (esValido(nodoIni, nodoAct)) {
                v.add(nodoAct);
                quitaArista(nodoIni, nodoAct);
                quitaArista(nodoAct, nodoIni);
                buscaSigNodo(v, nodoAct);
            }
        }
    }

    /**
     * Busca un ciclo euleriano que pase por todas las aristas de MST.
     *
     * @return nodos ordenados que forman un ciclo euleriano
     */
    private Integer[] buscaCicloEuleriano() {
        int nodoIni = (int) (Math.random() * MST.size());
        Vector<Integer> vCE = new Vector<>();
        vCE.add(nodoIni);
        buscaSigNodo(vCE, nodoIni);
        Integer[] CE = vCE.toArray(new Integer[vCE.size()]);
        return CE;
    }

    // Ops buscaCicloHamiltoniano
    /**
     * Busca un ciclo hamiltoniano a partir de un ciclo euleriano mediante la
     * técnica de shortcutting.
     * 
     * @param CE ciclo euleriano representado con un array de enteros
     * @return ciclo hamiltoniano representado con un array de enteros
     */
    private static Integer[] buscaCicloHamiltoniano(Integer CE[]) {
        int i, j;
        int elements = CE.length;
        for (i = 0; i < CE.length - 1; ++i) {
            boolean esta = false;
            for (j = i - 1; j >= 0; --j) {
                if (CE[j] == CE[i]) {
                    esta = true;
                }
            }
            if (esta == true) {
                CE[i] = -1;
                elements--;
            }
        }
        Integer cicleH[];
        cicleH = new Integer[elements];
        j = 0;
        for (i = 0; i < cicleH.length;) {
            int e = CE[j];
            if (CE[j] != -1) {
                cicleH[i] = e;
                ++i;
            }
            ++j;
        }
        return cicleH;
    }
}


