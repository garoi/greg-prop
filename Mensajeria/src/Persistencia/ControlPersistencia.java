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
    PersistenciaRutas pr;
    
    public ControlPersistencia() {
        pm = new PersistenciaMapas();
        pr = new PersistenciaRutas();
    }
    
    public void guardarListaPaquetes(Object lp) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaPaquetes/ListaPaquetes.txt"))) {
            oos.writeObject(lp);
        }
    }
    
    public Object leerListaPaquetes() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaPaquetes/ListaPaquetes.txt"))) {
            Object lp = ois.readObject();
            return lp;
        }
    }
    
    public void guardarListaClientes(Object lc) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaClientes/ListaClientes.txt"))) {
            oos.writeObject(lc);
        }
    }
    
    public Object leerListaClientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaClientes/ListaClientes.txt"))) {
            Object lc = ois.readObject();
            return lc;
        }
    }
    
    public void guardarOperador(Object oper) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Operador.txt"))) {
            oos.writeObject(oper);
        }
    }
    
    public Object leerOperador() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Operador.txt"))) {
            Object oper = ois.readObject();
            return oper;
        }
    }
    
    public void guardarMapas(Object x, String nombreCiudad) throws IOException, ClassNotFoundException {
        pm.guardarMapa(x, nombreCiudad);
    }
    
    public ArrayList<String> listarCiudades() {
        return pm.listarCiudades();
    }
    public Object leerCiudad(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException{
        return pm.leerCiudad(nombre);
    }
    
    public ArrayList<String> listarRutas() {
        return pr.listarRutas();
    }
    
    public Object leerRuta(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException {
        return pr.leerRuta(nombre);
    }
    
    public void guardarRuta(Object x, String data, boolean verificada) throws IOException {
        pr.guardarRuta(x, data, verificada);
    }
    
    public void guardadoGeneral(Object lc, Object lp, Object oper) throws IOException {
        guardarListaClientes(lc);
        guardarListaPaquetes(lp);
        guardarOperador(oper);
    }
}
