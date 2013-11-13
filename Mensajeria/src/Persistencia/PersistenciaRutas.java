package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marc Garcia Roig
 */
public class PersistenciaRutas {
    
    public ArrayList<String> listarRutas() {
        System.out.println("Las rutas guardadas son:");
        File directorio = new File ("Data/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean guion = nombreFichero.endsWith("-ruta.txt");
            if (guion) {
                ficheros.add(nombreFichero.substring(0, (nombreFichero.length()-9)));
            }
        }
        return ficheros;
    }
    
    public Object leerRuta(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/"+nombre+"-ruta.txt"))) {
            Object m2 = ois.readObject();
            return m2;
        }
    }
    
    public void guardarRuta(Object x) throws IOException {
        Date fecha = new Date();
        String nombreRuta = null;// = new String(fecha.getDate()); +fecha.getHours()
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/"+nombreRuta+"-mapa.txt"))) {
            oos.writeObject(x);
        }
    }
}
