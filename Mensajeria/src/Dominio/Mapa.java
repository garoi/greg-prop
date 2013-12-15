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
    
    public Mapa(){
        nombres = new ArrayList<>();
    }

    public int getTamCiudad(){
        return tamCiudad;
    }
    
    public String[] getFechaMod() {
        return fechaMod;
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
        nombres = new ArrayList<String>();
        if(ciudad != null){
            for (int i = 0; i < tamCiudad; i++) {
                ciudad.add(i, new ArrayList());
                for (int j = 0; j < tamCiudad; j++) {
                    ((ArrayList)ciudad.get(i)).add(-1f);
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
        if (!nombres.contains(nombre)) return false;
        // Añadimos el nombre
        nombres.add(nombre);
        // Y espacio para el nuevo punto
        ciudad.add(tamCiudad, new ArrayList());
        for (int i = 0; i < tamCiudad; i++) {
//            System.out.printf("Distancia del punto \"%s\" al punto \"%s\": ",
//                              nombres.get(i), nombres.get(nombres.size()-1));
            float distancia= distancias[i];
            // añadimos la distancia desde el otro punto al punto nuevo
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
        System.out.println(idx);

        ciudad.remove(idx);
        for (int i = 0; i < tamCiudad-1; i++) {
            ((ArrayList)ciudad.get(i)).remove(idx);
        }
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
        System.out.println("crearCiudad");
        if (n >= 0 && nombre != null){
            setTamCiudad(n);
            setNombreCiudad(nombre);
            inicializarCiudad();
            return true;
        }
        else return false;
    }
    
    public boolean setNombrePuntos(ArrayList<String> nombresparam){
        System.out.println("setNombrePuntos");
        if (tamCiudad == 0 || nombresparam == null || nombresparam.size() == 0) return false;
        for (int i=0; i<tamCiudad; i++){
            nombres.add(nombresparam.get(i));
        }
        return true;
    }
    
    public boolean setDistancias(float[] distancias){
        System.out.println("entra setDistancias");
//        System.out.println(distancias.length);
//        System.out.println(tamCiudad);
//        System.out.println(ciudad);
        if (tamCiudad == 0 || distancias == null || distancias.length == 0 || ciudad == null) return false;
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Escribe el nombre del punto %d:\n", i+1);
//            String nombreNodo = sc.next();
//            nombres.add(nombreNodo);
//        }
        setD(0,0,0.0f);
        for (int i = 0; i < distancias.length; i++) {
            float distancia = distancias[i];
            for (int j = i; j < distancias.length; j++) {
                setD(i,i,0.0f);
                if(getD(i,j) == -1.0f){
                    setD(i,j,distancia);
                    setD(j,i,distancia);
                }                
            }
        }
        return true;
    }
    
    /**
     * Imprime las distancias entre los puntos de la ciudad.
     */
    public void imprimirCiudad() {
        if(ciudad != null && tamCiudad > 0){
            System.out.printf("La ciudad \"%s\" tiene %d puntos.\n", nombreCiudad, tamCiudad);
            for (int j = 0; j < tamCiudad; ++j) {
                for (int i = 0; i < tamCiudad; ++i) {
                    System.out.print(getD(i,j) + " ");
                }
                System.out.println();
            }
        }
        else System.out.println("No se han definido puntos para la ciudad.");
    }
    
    /**
     * Muestra las opciones disponibles a la hora de modificar la ciudad.
     */
    private void infoModificarCiudad() {
        System.out.println("1: Modificar distancia entre dos puntos.");
        System.out.println("2: Añadir un punto a la ciudad.");
        System.out.println("3: Eliminar un punto de la ciudad.");
        System.out.println("4: Renombrar un punto de la ciudad.");
        System.out.println("0: Salir de la modificacion de la ciudad manualmente.");
    }
    
//    /**
//     * Permite modificar la ciudad:
//     *  - modificar la distancia entre dos puntos.
//     *  - añadir puntos.
//     *  - eliminar puntos.
//     *  - renombrar puntos.
//     */
//    public void modificarCiudad() {
//        if (ciudad!=null){
//            Scanner sc = new Scanner(System.in);
//            System.out.println("1 Modificar ciudad manualmente.");
//            System.out.println("2 Modificar ciudad con los datos de un fichero.");
//            int op = sc.nextInt();
//            if (op == 2) {
//                System.out.println("Hasta que no tengamos esta parte de la Persistencia de Datos no lo podemos hacer");
//                //Abrir y modifiar el fichero de la ciudad
//            }
//            if (op == 1) {
//                infoModificarCiudad();
//                int ord = sc.nextInt();
//                while (ord != 0) {
//                    switch (ord){
//                        case 1:
////                            "1: Modificar la distancia entre dos puntos."
//                            System.out.println("Necesitas ver los nombres? si/no");
//                            String necnom = sc.next();
//                            if (necnom.equals("si")) {
//                                for (int i = 0; i < tamCiudad; ++i) {
//                                    System.out.println(nombres.get(i));
//                                }
//                            }
//                            if (nombres.size()>1){
//                                System.out.println("¿Entre qué dos puntos quieres modificar la distancia?");
//                                System.out.println("Introduce el nombre del primer punto:");
//                                String punto1 = sc.next();
//                                System.out.println("Introduce el nombre del segundo punto:");
//                                String punto2 = sc.next();
//                                System.out.println("Introduce la nueva distancia entre los puntos:");
//                                float distancia = sc.nextFloat();
//                                setDistancia(punto1, punto2, distancia);
//                            }
//                        break;
//                        case 2:
//    //                      "2: Añadir un punto a la ciudad."
//                            System.out.println("Escribe el nombre del punto a añadir:");
//                            String addNombreNodo = sc.next();
//                            if (anadirPunto(addNombreNodo))
//                                System.out.println("El punto se ha añadido correctamente.");
//                            else System.out.println("El punto ya existe.");
//                        break;
//                        case 3:
//    //                      "3: Eliminar un punto de la ciudad."
//                            System.out.println("Escribe el nombre del punto a eliminar:");
//                            String remNombreNodo = sc.next();
//                            if(!nombres.contains(remNombreNodo))
//                                System.out.println("El punto no existe.");
//                            else eliminarPunto(remNombreNodo);
//                        break;
//                        case 4:
//    //                      "4: Renombrar un punto de la ciudad."
//                            System.out.println("Escribe el nombre del punto a renombrar:");
//                            System.out.println("Los puntos son:");
//                            for (int i = 0; i < tamCiudad; ++i) {
//                                    System.out.println(nombres.get(i));
//                            }
//                            String renNombreNodo = sc.next();
//                            if(nombres.contains(renNombreNodo)){
//                                int idx = nombres.indexOf(renNombreNodo);
//                                System.out.println("Escribe el nombre que tendrá el punto:");
//                                String ren2NombreNodo = sc.next();
//                                nombres.set(idx, ren2NombreNodo);
//                            }
//                            else{
//                                System.out.println("El punto no existe.");
//                            }
//                        default:
//                        break;
//
//                    }
//                    infoModificarCiudad();
//                    ord = sc.nextInt();
//                }
//            }
//            else System.out.println("La ciudad no ha sido creada todavía");
//        }
//    }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
