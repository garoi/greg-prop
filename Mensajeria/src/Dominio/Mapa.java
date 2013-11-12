package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Marc Garcia Roig
 */
public class Mapa implements Serializable {
    private String[] nombres;
    private float[][] ciudad;

    
    public String[] getNombres() {
        return nombres;
    }

    public float[][] getCiudad() {
        return ciudad;
    }

    public void CrearCiudad(){
        System.out.println("Quants nodes hi ha?");
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        ciudad = new float[nodes][nodes];
        nombres = new String[nodes];
        for (int i = 0; i < nodes; ++i) {
            System.out.println("Entra el nom del node " + (i+1));
            String nombreNodo = sc.next();
            nombres[i] = nombreNodo;
            System.out.println("Ara les distancies dels node [0....inf]");
            for (int j = 0; j < nodes; ++j) {
                ciudad[i][j] = sc.nextInt();
            }
        }  
    }
    

    public void ImprimirCiudad() {
        System.out.println("la ciutat es " + ciudad.length);
        for (int j = 0; j < ciudad.length; ++j) {
            for (int i = 0; i < ciudad.length; ++i) {
                System.out.print(ciudad[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void InfoModificarCiudad() {
        System.out.println("1 Modificar distancia entre dos punto");
        System.out.println("0 Salir de la modificacion de la ciudad manualmente");
    }
    
    public void ModificarCiudad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Modificar ciudad con el fichero");
        System.out.println("2 Modificar ciudad manualmente");
        int op = sc.nextInt();
        if (op == 1) {
            System.out.println("Hasta que no tengamos hecha la Persistencia de Datos no lo podemos hacer");
            //Abrir y modifiar el fichero de la ciudad
        }
        if (op == 2) {
            InfoModificarCiudad();
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
                InfoModificarCiudad();
                ord = sc.nextInt();
            }
        }
    }
}