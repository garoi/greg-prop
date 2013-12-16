package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 * Representa el mapa de una ciudad, así como su nombre.
 * @author Luis García Estrades https://github.com/lgarest
 */
public class Mapa implements Serializable {
    private static final long serialVersionUID = 9040177911315386368L;
    private String nombreCiudad;
    private ArrayList<String> nombres;
    private ArrayList<ArrayList<Float>> ciudad;
    private int tamCiudad;
    private String[] fechaMod;
    private float max;
    private float min;
    
    public Mapa(){
        nombres = new ArrayList<>();
    }

    public int getTamCiudad(){
        return tamCiudad;
    }
    
    public String[] getFechaMod() {
        return fechaMod;
    }
    public float getMax(){
        return max;
    }
    public float getMin(){
        return min;
    }
    
    private void setMax(float f){
        if(f >= 1f) max = f;
        if(getMin() == -1f) setMin(f);
    }
    private void setMin(float f){
        if(f >= 1f) min = f;
    }

    public void setFechaMod(String[] fechaMod) {
        this.fechaMod = fechaMod;
    }
    
    public void setCiudad(ArrayList<ArrayList<Float>> ciudad) {
        this.ciudad = ciudad;
    }
    
    public void setTamCiudad(int tamCiudad){
        this.tamCiudad = tamCiudad;
    }
    
    /**
     * Devuelve una lista con los nombres de los puntos de la ciudad.
     * @return una lista con los nombres de los puntos de la ciudad.
     */
    public ArrayList<String> getNombres() {
        return nombres;
    }
    
    /**
     * Devuelve las distancias entre los puntos de la ciudad.
     * @return la matriz de distancias entre los puntos de la ciudad.
     */
    public ArrayList<ArrayList<Float>> getCiudad() {
        return ciudad;
    }
    
    /**
     * Devuelve el nombre de la ciudad.
     * @return el nombre de la ciudad.
     */
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    
    /**
     * Atribuye a la ciudad un nombre.
     * @param nombre un nombre de ciudad.
     */
    public void setNombreCiudad(String nombre){
        nombreCiudad = nombre;
    }
 
    /**
     * Elimina las distancias entre todos los puntos de la ciudad.
     */
    private void inicializarCiudad(){
        ciudad = new ArrayList();
        min = -1f;
        max = 1f;
        nombres = new ArrayList();
        if(ciudad != null){
            for (int i = 0; i < tamCiudad; i++) {
                ciudad.add(i, new ArrayList());
                for (int j = 0; j < tamCiudad; j++) {
                    ((ArrayList)ciudad.get(i)).add(0f);
                }
            }
        }
    }
    
    /**
     * Devuelve la distancia desde un punto a otro.
     * @param i indice vertical de la matriz de distancias.
     * @param j indice horizontal de la matriz de distancias.
     * @return la distancia en float del punto i al j.
     */
    public float getD(int i, int j){
        if(i<0 || j<0) return -1f;
        if(i<tamCiudad && j<tamCiudad){
            float f = (Float)((ArrayList)ciudad.get(i)).get(j);
            return f;
        }
        return -1f;
    }
    
    /**
     * Atribuye la distancia f entre los puntos i y j
     * @param i indice vertical de la matriz de distancias.
     * @param j indice horizontal de la matriz de distancias.
     * @param f distancia a asignar entre el punto i y el j.
     * @return true si se ha podido asignar la distancia.
     */
    private boolean setD(int i, int j, float f){
        if(i<tamCiudad && j<tamCiudad){
            if (f >= getMax()) setMax(f);
            if (f < getMin()) setMin(f);
            ((ArrayList)ciudad.get(i)).set(j, f);
            return true;
        }
        return false;
    }
    
    /**
     * Modifica la distancia entre dos puntos.
     * @param nombre1 nombre del primer punto
     * @param nombre2 nombre del segundo punto
     * @param d distancia nueva que tendrán los puntos.
     */
    public void setDistancia(String nombre1, String nombre2, float distancia){
        
        if (!nombre1.equals(nombre2)) {
            // si los nombres son diferentes
            if (distancia > 0) {
                // si hemos introducido una distancia válida
                
                int punto1_idx, punto2_idx;
                punto1_idx = punto2_idx = 0;
                boolean encontrado1, encontrado2;
                encontrado1 = encontrado2 = false;

                for (int i = 0; i < tamCiudad && (!encontrado1 && !encontrado2); ++i) {
                    // buscamos los nombres de los puntos en el array
                    if (!encontrado1 & nombres.get(i).equals(nombre1)) {
                        punto1_idx = i;
                        encontrado1 = true;
                    }
                    if (!encontrado2 & nombres.get(i).equals(nombre2)) {
                        punto2_idx = i;
                        encontrado2 = true;
                    }
                }
                // y les asignamos la distancia nueva
                setD(punto1_idx,punto2_idx,distancia);
                setD(punto2_idx,punto1_idx,distancia);
            }
        }
    }
    
    /**
     * Añade un punto de nombre "nombre" a la ciudad con sus distancias respecto al resto de puntos.
     * @param nombre el nombre que se le dará al punto.
     * @param distancias las distancias al resto de puntos.
     * @return true si se ha añadido correctamente.
     */
    public boolean anadirPunto(String nombre, float[] distancias){
        if (nombres.contains(nombre)) return false;
        // Añadimos el nombre
        nombres.add(nombre);
        // Y espacio para el nuevo punto
        ciudad.add(tamCiudad, new ArrayList());
        for (int i = 0; i < tamCiudad; i++) {
            float distancia= distancias[i];
            // añadimos la distancia desde el otro punto al punto nuevo
            if (distancia >= getMax()) setMax(distancia);
            if (distancia < getMin()) setMin(distancia);
            ((ArrayList) ciudad.get(tamCiudad)).add(distancia);
            // añadimos la distancia desde el punto nuevo al otro
            ((ArrayList)ciudad.get(i)).add(distancia);
        }
        // añadimos la distancia a un mismo punto como 0
        ((ArrayList) ciudad.get(tamCiudad)).add(0.0f);
        // aumentamos el número de puntos de la ciudad
        tamCiudad += 1;
        return true;
    }

    /** 
     * Elimina un punto del mapa.
     * @param nombre del punto a borrar.
     */
    public boolean eliminarPunto(String nombre){
        if(!nombres.contains(nombre)) return false;
        int idx = nombres.indexOf(nombre);
        ciudad.remove(idx);
        for (int i = 0; i < tamCiudad-1; i++) ((ArrayList)ciudad.get(i)).remove(idx);
        // quitamos la fila de adyacencias vertical
        nombres.remove(nombres.indexOf(nombre));
        tamCiudad -= 1;
        
        return true;
    }

    public boolean ctrlCrearCiudad(String nombre, int n, ArrayList<String> nombreNodos, float[] distanciasNodos){
        if (!crearCiudad(nombre, n)) return false;
        if (!setNombrePuntos(nombreNodos)) return false;
        if (!setDistancias(distanciasNodos)) return false;
        return true;
    }
    
    /**
     * Creadora de la ciudad, se le atribuye un nombre a la ciudad, se introduce 
 el número de puntos que la forman, los nombres y distancias entre los puntos.
     * @param nombre el nombre que se le quiere dar a la ciudad.
     * @param n el número de puntos que tiene la ciudad
     * @return devuelve true si se ha creado correctamente la ciudad
     */
    public boolean crearCiudad(String nombre, int n){
        if (n >= 0 && nombre != null){
            setTamCiudad(n);
            setNombreCiudad(nombre);
            inicializarCiudad();
            return true;
        }
        else return false;
    }
    
    public boolean setNombrePuntos(ArrayList<String> nombresparam){
        if (tamCiudad == 0 || nombresparam == null || nombresparam.size() == 0) return false;
        for (int i=0; i<tamCiudad; i++) nombres.add(nombresparam.get(i));
        return true;
    }
    
    public boolean setDistancias(float[] distancias){
        if (tamCiudad == 0 || distancias == null || distancias.length == 0 || ciudad == null) return false;
        int idx = 0;
//        for (int i = 0; i < distancias.length; i++) System.out.println(distancias[i]);
//        for (int i = 0; i < distancias.length; i++) {
//            setD(i,i,0.0f);
//            for (int j = i+1; j < distancias.length; j++) {
//                if(getD(i,j) == -1.0f){
//                    System.out.println("idx: " + idx );
//                    float distancia = distancias[idx];
////                    System.out.print("")
//                    setD(i,j,distancia);
//                    setD(j,i,distancia);
//                    idx+=1;
//                }                
//            }
//        }
        int idxi = 0;
        int idxj = 1;
        for (int i = 0; i < distancias.length; i++) {
//            System.out.println(idxi + ", " + idxj);
            setD(idxi,idxi,0f);
            setD(idxi,idxj,distancias[i]);
            setD(idxj,idxi,distancias[i]);
            idxj+=1;
            if (idxj==tamCiudad){
                idxi += 1;
                idxj = idxi+1;
            }
        }
//        distancias[i] = auxDistancia;
//                nodoB += 1;
//                if (nodoB==nNodos){
//                    nodoA += 1;
//                    nodoB = nodoA+1;
//                }
        
        
//        for (int i = 0; i < tamCiudad; i++) {
//            for (int f = 0; f < tamCiudad; f++) {
//                System.out.print(getD(i,f) + " ");
//            }
//            System.out.print("\n");
//        }
        return true;
    }
    
    public void renombrarPunto(String nombre1, String nombre2){
        if(nombres.contains(nombre1)){
            int idx = nombres.indexOf(nombre1);
            nombres.set(idx, nombre2);
        }
    }
    
    public ArrayList<ArrayList<Float>> getDistanciasCiudad() {
        return ciudad;
    }

    Float getDistancia(String a, String b) {
        if (nombres != null && nombres.contains(a) && nombres.contains(b))
            return getD(nombres.indexOf(a), nombres.indexOf(b));
        else{
            if (nombres == null) System.out.println("[getDistancia] nombres es null");
            if (!nombres.contains(a)) System.out.println("[getDistancia] nombres no contiene a");
            if (!nombres.contains(b)) System.out.println("[getDistancia] nombres no contiene b");
        }
        return -1f;
    }
}
