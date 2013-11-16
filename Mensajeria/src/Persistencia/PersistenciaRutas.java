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
public class PersistenciaRutas {
    
    public ArrayList<String> listarRutas(String nombreCiudad) {
        System.out.println("Las rutas guardadas son:");
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean nombre = nombreFichero.startsWith(nombreCiudad);
            boolean guion = nombreFichero.endsWith("-NO_verificada-ruta.txt");
            if (nombre & guion) {
                ficheros.add(nombreFichero.substring(0, (nombreFichero.length()-9)));
            }
        }
        return ficheros;
    }
    
    public Object leerRuta(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Rutas/"+nombre+"-ruta.txt"))) {
            Object m2 = ois.readObject();
            return m2;
        }
    }
    
    public void guardarRuta(Object x, String data, boolean verificada, String nombreCiudad) throws IOException {
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean borrar = nombreFichero.endsWith(data+"-NO_verificada-ruta.txt");
            if (borrar) {
                file.delete();
            }
        }
        if (verificada) {
            String nombreRuta = nombreCiudad + "-" + data + "-verificada-ruta.txt";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Rutas/"+nombreRuta))) {
                oos.writeObject(x);
            }
        }
        else {
            String nombreRuta = nombreCiudad + "-" + data + "-NO_verificada-ruta.txt";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Rutas/"+nombreRuta))) {
                oos.writeObject(x);
            }
        }
    }
}
