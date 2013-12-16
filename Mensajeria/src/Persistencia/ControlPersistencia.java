package Persistencia;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
    
    private void guardarListaPaquetes(Object lp){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaPaquetes/ListaPaquetes.txt"))) {
            oos.writeObject(lp);
        } catch (IOException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object leerListaPaquetes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaPaquetes/ListaPaquetes.txt"))) {
            Object lp = ois.readObject();
            return lp;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void guardarListaClientes(Object lc){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/ListaClientes/ListaClientes.txt"))) {
            oos.writeObject(lc);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object leerListaClientes(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/ListaClientes/ListaClientes.txt"))) {
            Object lc = ois.readObject();
            return lc;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void guardarOperador(Object oper){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Operador.txt"))) {
            oos.writeObject(oper);
        }
        catch(Exception e){
        }
    }
    
    public Object leerOperador(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Operador.txt"))) {
            Object oper = ois.readObject();
            return oper;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public void guardarMapas(Object x, String nombreCiudad) {
        pm.guardarMapa(x, nombreCiudad);
    }
    
    public ArrayList<String> listarCiudades() {
        return pm.listarCiudades();
    }
    public Object leerCiudad(String nombre){
        return pm.leerCiudad(nombre);
    }
    
    public ArrayList<String> listarRutasNoVerificadas(String nombreCiudad) {
        return pr.listarRutasNoVerificadas(nombreCiudad);
    }
    
    public ArrayList<String> listarRutasVerificadas(String nombreCiudad) {
        return pr.listarRutasVerificadas(nombreCiudad);
    }
    
    public Object leerRuta(String nombre){
        return pr.leerRuta(nombre);
    }
    
    public void guardarRuta(Object x, String data, boolean verificada, String nombreCiudad){
        pr.guardarRuta(x, data, verificada, nombreCiudad);
    }
    
    public void guardadoGeneral(Object lc, Object lp, Object oper){
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
    
    public Object getPuntosMapa(String nombre){
            ArrayList<String> ciudades = listarCiudades();
            for(int i = 0; i < ciudades.size(); ++i)
                if(ciudades.get(i).equals(nombre))
                    return leerCiudad(nombre);
        return null;
    }

    public void eliminarRuta(String ruta) {
        pr.eliminarRuta(ruta);
    }
    
    public void pasarAFichero(String nomFichero, String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("Data/Mapas/" + nomFichero);
            //pw = new PrintWriter(fichero);
            BufferedWriter escribir_buffer = new BufferedWriter(fichero);
            escribir_buffer.write(nomCiudad);
            escribir_buffer.newLine();
            for(int i = 0; i < nombres.size(); ++i){
                if(i == 0) escribir_buffer.write(nombres.get(i));
                else escribir_buffer.write(" " + nombres.get(i));
            }
            escribir_buffer.newLine();
            //boolean b = false; //para no duplicar los datos
            for(int i = 0; i < ciudad.size() - 1; ++i){
                for(int j = i+1; j < ciudad.get(i).size(); ++j){
                    /*if(b){
                        escribir_buffer.write(nombres.get(i) + " " + nombres.get(j) + " " + ciudad.get(i).get(j));
                    }
                    if(ciudad.get(i).get(j).equals(0.0)) b = true;*/
                    escribir_buffer.write(nombres.get(i) + " " + nombres.get(j) + " " + ciudad.get(i).get(j));
                    escribir_buffer.newLine();
                }
                //b = false;
               // escribir_buffer.newLine();
            }
            escribir_buffer.flush(); 
            escribir_buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void abrirFichero(String nomFichero){
        try{
            File file = new File("Data/Mapas/" + nomFichero);
            Desktop.getDesktop().open(file);
        }
        catch(Exception e){
            
        }
    }
    
    public void crearFichero(String nomFichero){
        try{
            File file = new File("Data/Mapas/" + nomFichero + "-mapa.txt");
            if(file.createNewFile()) System.out.print("Fichero creado correctamente");
            else System.out.print("No se ha creado el fichero");
        }catch(Exception e){
            
        }
        abrirFichero(nomFichero + "-mapa.txt");
    }

    public ArrayList<String> leerRutasComparadas(String fecha, String nombreCiudad) {
        return pr.leerRutasComparadas(fecha, nombreCiudad);
    }

    public void eliminarRutaComp(String inicioRuta, String nombreRuta) {
        pr.eliminarRutaComp(inicioRuta, nombreRuta);
    }
    
    public void leerMapaFichero(String nomFichero, String nomCiudad, ArrayList<String> nombre, ArrayList<Float> ciudad) {
        pm.leerMapaFichero(nomFichero, nomCiudad, nombre, ciudad);
    }
    
    public void eliminarCiudad(String nombreCiudad){
        pm.eliminarCiudad(nombreCiudad);
    }
}
