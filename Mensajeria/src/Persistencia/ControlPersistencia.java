package Persistencia;

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
public class ControlPersistencia {
    
    PersistenciaMapas pm;
    
    public ControlPersistencia() {
        pm = new PersistenciaMapas();
    }
    
    public void guardarListaPaquetes(Object lp) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaPaquetes.txt"))) {
            oos.writeObject(lp);
        }
    }
    
    public Object leerListaPaquetes() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaPaquetes.txt"))) {
            Object lp = ois.readObject();
            return lp;
        }
    }
    
    public void guardarListaClientes(Object lc) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaClientes.txt"))) {
            oos.writeObject(lc);
        }
    }
    
    public Object leerListaClientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaClientes.txt"))) {
            Object lc = ois.readObject();
            return lc;
        }
    }
    
    public void guardarMapas(Object x, String nombreCiudad) throws IOException, ClassNotFoundException {
        pm.guardarMapa(x, nombreCiudad);
    }
    
    public ArrayList<String> listarCiudades() {
        return pm.listarCiudades();
    }
    public Object leerCiudad(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
        return pm.leerCiudad(nom);
    }
}
