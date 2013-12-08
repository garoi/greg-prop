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
        catch(Exception e){
            System.out.printf("Catch");
        }
    }
    
    public Object leerOperador() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Operador.txt"))) {
            Object oper = ois.readObject();
            return oper;
        }
        catch (Exception e) {
            return null;
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
    
    public ArrayList<String> listarRutasNoVerificadas(String nombreCiudad) {
        return pr.listarRutasNoVerificadas(nombreCiudad);
    }
    
    public ArrayList<String> listarRutasVerificadas(String nombreCiudad) {
        return pr.listarRutasVerificadas(nombreCiudad);
    }
    
    public Object leerRuta(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException {
        return pr.leerRuta(nombre);
    }
    
    public void guardarRuta(Object x, String data, boolean verificada, String nombreCiudad) throws IOException {
        pr.guardarRuta(x, data, verificada, nombreCiudad);
    }
    
    public void guardadoGeneral(Object lc, Object lp, Object oper) throws IOException {
        guardarListaClientes(lc);
        guardarListaPaquetes(lp);
        guardarOperador(oper);
    }
    
    public void crearDirectorios(){
        File folderData = new File("./Data");
        if(!folderData.exists()) folderData.mkdirs();
        File folderListaClientes = new File("./Data/ListaClientes");
        File folderListaPaquetes = new File("./Data/ListaPaquetes");
        File folderMapas = new File("./Data/Mapas");
        File folderRutas = new File("./Data/Rutas");
        if(!folderListaClientes.exists()) folderListaClientes.mkdirs();
        if(!folderListaPaquetes.exists()) folderListaPaquetes.mkdirs();
        if(!folderMapas.exists()) folderMapas.mkdirs();
        if(!folderRutas.exists()) folderRutas.mkdirs();
    }
    
    public Object getPuntosMapa(String nombre) throws IOException, FileNotFoundException {
        try{
            ArrayList<String> ciudades = listarCiudades();
            for(int i = 0; i < ciudades.size(); ++i)
                if(ciudades.get(i).equals(nombre))
                    return leerCiudad(nombre);
        }
        catch(Exception e){
            System.out.printf("Catch");
        }
        return null;
    }
}
