package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class Mapa implements Serializable {
    private String nombreCiudad;
    private String[] nombres;
    private float[][] ciudad;

    /**
     * 
     * @return nombres
     */
    public String[] getNombres() {
        return nombres;
    }

    /**
     * 
     * @return ciudad
     */
    public float[][] getCiudad() {
        return ciudad;
    }
    
    /**
     * 
     * @param nombre 
     */
    private void setNombreCiudad(String nombre){
        this.nombreCiudad = nombre;
    }
    
    /**
     * 
     * @return nombreCiudad
     */
    public String getNombreCiudad(){
        return nombreCiudad;
    }

    /**
     * Crea una ciudad
     * @param
     */
    public void crearCiudad(){
        System.out.println("Escribe el nombre de la ciudad");
        Scanner sc3 = new Scanner(System.in);
        String nombre = sc3.nextLine();
        setNombreCiudad(nombre);
        System.out.println("Quants nodes hi ha?");
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        ciudad = new float[nodes][nodes];
        nombres = new String[nodes];
        for (int i = 0; i < nodes; ++i) {
            System.out.println("Entra el nombre de los nodos " + (i+1));
            String nombreNodo = sc.next();
            nombres[i] = nombreNodo;
            System.out.println("Ahora las distancias de los nodos [0....inf]");
            for (int j = 0; j < nodes; ++j) {
                ciudad[i][j] = sc.nextInt();
            }
        }  
    }
    

    /**
     * Muestra una ciudad
     * @param
     */
    public void imprimirCiudad() {
        System.out.println("la ciutat es " + ciudad.length);
        for (int j = 0; j < ciudad.length; ++j) {
            for (int i = 0; i < ciudad.length; ++i) {
                System.out.print(ciudad[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void infoModificarCiudad() {
        System.out.println("1 Modificar distancia entre dos punto");
        System.out.println("0 Salir de la modificacion de la ciudad manualmente");
    }
    
    /**
     * Modifica la ciudad
     * @param
     */
    public void modificarCiudad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Modificar ciudad con el fichero");
        System.out.println("2 Modificar ciudad manualmente");
        int op = sc.nextInt();
        if (op == 1) {
            System.out.println("Hasta que no tengamos hecha la Persistencia de Datos no lo podemos hacer");
            //Abrir y modifiar el fichero de la ciudad
        }
        if (op == 2) {
            infoModificarCiudad();
            int ord = sc.nextInt();
            while (ord != 0) {
                if (ord == 1) {
                    System.out.println("Necesitas ver los nombre? yes/no");
                    String necnom = sc.nextLine();
                    if (necnom.equals("yes")) {
                        for (int i = 0; i < nombres.length; ++i) {
                            System.out.println(nombres[i]);
                        }
                    }
                    System.out.println("Que dos puntos quieres modificar su distancia?");
                    String punto1 = sc.nextLine();
                    String punto2 = sc.nextLine();
                    System.out.println("Qual sera su nueva distancia?");
                    int distancia = sc.nextInt();
                    int punto1i, punto2i;
                    punto1i = punto2i = 0;
                    boolean encontrado1, encontrado2;
                    encontrado1 = encontrado2 = false;
                    for (int i = 0; i < nombres.length & (!encontrado1 & !encontrado2); ++i) {
                        if (!encontrado1 & nombres[i].equals(punto1)) {
                            punto1i = i;
                            encontrado1 = true;
                        }
                        if (!encontrado2 & nombres[i].equals(punto2)) {
                            punto2i = i;
                            encontrado2 = true;
                        }
                    }
                    ciudad[punto1i][punto2i] = distancia;
                    ciudad[punto2i][punto1i] = distancia;
                }
                infoModificarCiudad();
                ord = sc.nextInt();
            }
        }
    }
}