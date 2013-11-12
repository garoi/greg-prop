package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Marc Garcia Roig
 */
public class PersistenciaMapas {
    
    public void guardarMapa(Object x, String nombreCiudad) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/"+nombreCiudad+"-mapa.txt"))) {
            oos.writeObject(x);
        }
    }
    
    public Object leerCiudad(String nombreCiudad) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/"+nombreCiudad+"-mapa.txt"))) {
            Object m2 = ois.readObject();
            return m2;
        }
    }
    
    public ArrayList<String> listarCiudades() {
        System.out.println("Las ciudades guardadas son:");
        File directorio = new File ("Data/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean guion = nombreFichero.endsWith("-mapa.txt");
            if (guion) {
                ficheros.add(nombreFichero.substring(0, (nombreFichero.length()-9)));
            }
        }
        return ficheros;
    }
}
