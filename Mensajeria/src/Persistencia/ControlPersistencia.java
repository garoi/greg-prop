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
    
    public void GuardarListaPaquetes(Object lp) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaPaquetes.txt"))) {
            oos.writeObject(lp);
        }
    }
    
    public Object LeerListaPaquetes() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaPaquetes.txt"))) {
            Object lp = ois.readObject();
            return lp;
        }
    }
    
    public void GuardarListaClientes(Object lc) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaClientes.txt"))) {
            oos.writeObject(lc);
        }
    }
    
    public Object LeerListaClientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaClientes.txt"))) {
            Object lc = ois.readObject();
            return lc;
        }
    }
    
    public void GuardarMapas(Object x, String nombreCiudad) throws IOException, ClassNotFoundException {
        pm.GuardarMapa(x, nombreCiudad);
    }
    
    public ArrayList<String> ListarCiudades() {
        return pm.ListarCiudades();
    }
    public Object LeerCiudad(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
        return pm.LeerCiudad(nom);
    }
}
