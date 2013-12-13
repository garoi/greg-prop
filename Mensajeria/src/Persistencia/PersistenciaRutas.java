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
 * @author Angel Rierola Mora
 */
public class PersistenciaRutas {
    
    public ArrayList<String> listarRutasNoVerificadas(String nombreCiudad) {
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean nombre = nombreFichero.startsWith(nombreCiudad);
            boolean guion = nombreFichero.endsWith("-NO_verificada-ruta.txt");
            if (nombre && guion) {
                ficheros.add(nombreFichero);
            }
        }
        return ficheros;
    }
    
    public ArrayList<String> listarRutasVerificadas(String nombreCiudad) {
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean nombre = nombreFichero.startsWith(nombreCiudad);
            boolean guion = nombreFichero.endsWith("-Verificada-ruta.txt");
            if (nombre & guion) {
                ficheros.add(nombreFichero);
            }
        }
        return ficheros;
    }
    
    public Object leerRuta(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Rutas/"+nombre))) {
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
            boolean borrar = nombreFichero.endsWith(nombreCiudad + "-" + data+"-NO_verificada-ruta.txt");
            if (borrar) {
                file.delete();
            }
        }
        if (verificada) {
            String nombreRuta = nombreCiudad + "-" + data + "-Verificada-ruta.txt";
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

    void eliminarRuta(String ruta) {
        File fichero = new File("Data/Rutas/"+ruta);
        fichero.delete();
        System.out.println("La ruta eliminada "+ ruta);
    }

    public ArrayList<String> leerRutasComparadas(String fecha, String nombreCiudad) {
        System.out.println("MARICONES TODOS");
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean nombre = nombreFichero.startsWith(nombreCiudad);
            boolean guion = nombreFichero.endsWith("-NO_verificada-ruta.txt");
            if (nombre && guion) {
                if (nombreFichero.startsWith(nombreCiudad + "-" + fecha + "-" + "lentamente")) {
                    System.out.println("MARICONES TODOS1");
                    ficheros.add(nombreFichero);
                }
                else if (nombreFichero.startsWith(nombreCiudad + "-" + fecha + "-" + "rapidamente")) {
                    System.out.println("MARICONES TODOS2");
                    ficheros.add(nombreFichero);
                }
                else if (nombreFichero.startsWith(nombreCiudad + "-" + fecha + "-" + "rapidaOptima")) {
                    System.out.println("MARICONES TODOS3");
                    ficheros.add(nombreFichero);
                }
            }
        }
        return ficheros;
    }

    void eliminarRutaComp(String inicioRuta, String nombreRuta) {
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        ArrayList<String> ficheros = new ArrayList<>();
        String nombreFichero;
        for(File file:nombres) {
            System.out.println("BOOOOOROROROEWRORSDOQWAR");
            nombreFichero = file.getName();
            boolean nombre2 = nombreFichero.startsWith(inicioRuta);
            boolean guion = nombreFichero.endsWith("-NO_verificada-ruta.txt");
            System.out.println(nombre2 + " ");
            if (nombre2 && guion) {
                if (nombreRuta == null) {
                    System.out.println("BORAR 22222");
                    file.delete();
                }
                else if (!nombreRuta.equals(nombreFichero)) {
                    System.out.println("ENTRO " + nombreRuta + " " + nombreFichero);
                    file.delete();
                }
            }
        }
    }
}
