package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.lang.String;


/**
 *
 * @author Angel Rierola Mora
 */
public class PersistenciaMapas {
    
    public void guardarMapa(Object x, String nombreCiudad) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/Mapas/"+nombreCiudad+"-mapa.txt"))) {
            oos.writeObject(x);
        }
    }
    
    public Object leerCiudad(String nombreCiudad) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/Mapas/"+nombreCiudad+"-mapa.txt"))) {
            Object m2 = ois.readObject();
            return m2;
        }
    }
    
    public ArrayList<String> listarCiudades() {
        File directorio = new File ("Data/Mapas/");
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
    
    public void leerMapaFichero(String nomFichero, String nomCiudad, ArrayList<String> nombres, ArrayList<ArrayList<Float>> ciudad){
        InputStream is = null;
	BufferedReader br = null;
        String[] temp;
        String delimiter = " ";
        
        try{
            is = new FileInputStream("Data/Mapas/" + nomFichero);
            br = new BufferedReader(new InputStreamReader(is));
            String s;
            if((s = br.readLine())!= null){
                nomCiudad = s;
                System.out.println(nomCiudad);
            }
            if((s = br.readLine())!= null){
                temp = s.split(delimiter);
                for(int i = 0; i < temp.length; ++i) nombres.add(temp[i]);
            }
            
            /*ArrayList<Float> ll = new ArrayList<Float>();
            Float zero = new Float("0.0");
            
            for(int i = 0; i < nombres.size(); ++i) ll.add(zero);
            for(int i = 0; i < nombres.size(); ++i) ciudad.add(ll);*/
            
            for(int i = 0; i < nombres.size(); ++i){
                ciudad.add(i, new ArrayList<Float>());
                for(int j = 0; j < nombres.size(); ++j){
                    ((ArrayList)ciudad.get(i)).add(0.0);
                }
            }
            
            while((s = br.readLine()) != null){
                temp = s.split(delimiter);
                if(temp.length == 3){
                    try{
                        int origen = nombres.indexOf(temp[0]);
                        int destino = nombres.indexOf(temp[1]);
                        Float dist = new Float(temp[2]);
                        ciudad.get(origen).set(destino, dist);
                        ciudad.get(destino).set(origen, dist);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
            //for(int i = 0; i < nombres.size(); ++i) ciudad.get(i).set(i,zero);
        }
        catch(Exception e){
           System.out.println("Atencion: no se ha leido el archivo");
           System.out.println(e);
        }    
    }
    
    

}
