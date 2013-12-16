package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Object leerRuta(String nombre){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Rutas/"+nombre))) {
            Object m2 = ois.readObject();
            return m2;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PersistenciaRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void guardarRuta(Object x, String data, String coste, boolean verificada, String nombreCiudad) {
         File directorio = new File ("Data/Rutas/");
         System.out.println("LLEGO");
        File[] nombres = directorio.listFiles();
        String nombreFichero;
        System.out.println("Fitxer que hi han " + nombres.length);
        for(File file:nombres) {
            System.out.println("entro al for");
            nombreFichero = file.getName();
            //a data estem tenim en compte el cost, i no l'hem de tenir en compte
            boolean borrar = nombreFichero.startsWith(nombreCiudad + "-" + data);
            boolean borrar2 = nombreFichero.endsWith("-NO_verificada-ruta.txt");
            System.out.println("PASO POR AQUI");
            if (borrar && borrar2) {
                file.delete();
            }
        }
        if (verificada) {
            String nombreRuta = nombreCiudad + "-" + data + coste + "-Verificada-ruta.txt";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Rutas/"+nombreRuta))) {
                oos.writeObject(x);
            } catch (IOException ex) {
                Logger.getLogger(PersistenciaRutas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            String nombreRuta = nombreCiudad + "-" + data + coste + "-NO_verificada-ruta.txt";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Rutas/"+nombreRuta))) {
                oos.writeObject(x);
            } catch (IOException ex) {
                Logger.getLogger(PersistenciaRutas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void eliminarRuta(String ruta) {
        File fichero = new File("Data/Rutas/"+ruta);
        fichero.delete();
    }

    public ArrayList<String> leerRutasComparadas(String fecha, String nombreCiudad) {
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
                    ficheros.add(nombreFichero);
                }
                else if (nombreFichero.startsWith(nombreCiudad + "-" + fecha + "-" + "rapidamente")) {
                    ficheros.add(nombreFichero);
                }
                else if (nombreFichero.startsWith(nombreCiudad + "-" + fecha + "-" + "rapidaOptima")) {
                    ficheros.add(nombreFichero);
                }
            }
        }
        return ficheros;
    }

    void eliminarRutaComp(String inicioRuta, String nombreRuta) {
        File directorio = new File ("Data/Rutas/");
        File[] nombres = directorio.listFiles();
        String nombreFichero;
        for(File file:nombres) {
            nombreFichero = file.getName();
            boolean nombre2 = nombreFichero.startsWith(inicioRuta);
            boolean guion = nombreFichero.endsWith("-NO_verificada-ruta.txt");
            if (nombre2 && guion) {
                if (nombreRuta == null) {
                    file.delete();
                }
                else if (!nombreRuta.equals(nombreFichero)) {
                    file.delete();
                }
            }
        }
    }
}
