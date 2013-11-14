package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Marc Garcia
 */
public class Operador implements Serializable {
    private String nombreOperador;
    private String password;
    private ArrayList<Paquete> listaPaquetesParaEntregar = new ArrayList<Paquete>();
    private Mapa mapa;
    private ListaPaquetes lp;
    
    public String getNombreOperador() {
        return nombreOperador;
    }

    public String getPassword() {
        return password;
    }
     
    public void anadirPaquete(Paquete p) {
        System.out.println("OINK");
        listaPaquetesParaEntregar.add(p);
        System.out.println("SIZE :" + listaPaquetesParaEntregar.size());
    }
    public void ordenarPorIdPaquete() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.IdPaqueteComparator());
    }
    
    public void ordenarPorDestino() {
        Collections.sort(listaPaquetesParaEntregar, new Paquete.DestinoComparator());
    }
    
    public void verPaquetes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Para ver segun idCliente");
        System.out.println("2 Para ver segun Destino");
        int op = sc.nextInt();
        if (op == 1) {
            ordenarPorIdPaquete();
        }
        else if (op == 2) {
            ordenarPorDestino();
        }
        else {
            System.out.println("Mal escrito");
        }
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
            System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
            System.out.println("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
        }
    }
    
    public Paquete buscarPaquete(int idPaquete) {
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                return listaPaquetesParaEntregar.get(i);
            }
        }
        return null;
    }
    
    //Devuelve un vector con el identificador de los destinos de los paquetes seleccionados
    public ArrayList<Paquete> seleccionarPaquetes() {
        ArrayList<Paquete> paquetesDestino = new ArrayList<Paquete>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el idPaquete de los paquetes de la siguiente lista:");
        for (int i = 0; i < listaPaquetesParaEntregar.size(); ++i) {
            System.out.print("ID Paquete " + listaPaquetesParaEntregar.get(i).getIdPaquete() + " ");
            System.out.print("ID Cliente " + listaPaquetesParaEntregar.get(i).getIdCliente() + " ");
            System.out.println("Destino " + listaPaquetesParaEntregar.get(i).getDestino() + " ");
        }
        System.out.println("Para parar de entrar/seleccionar, paquetes pulsa 9"); 
        int idPaquete = sc.nextInt();
        paquetesDestino.add(buscarPaquete(idPaquete));
        while (idPaquete != 9) {
            idPaquete = sc.nextInt();
            paquetesDestino.add(buscarPaquete(idPaquete));
        }
        paquetesDestino.remove(paquetesDestino.size() - 1);
        return paquetesDestino;
    }
    
    public void calcularRuta(ControlDominio cd) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quieres calcular la ruta de hoy y de este turno? s/n");
        String ord = sc.nextLine();
        Date date = new Date();
        String turno;
        if (ord.equals("s")) {
            if (date.getHours() > 9 & date.getHours()<15) turno = "-mañana";
            else turno = "-tarde";
            String fecha = String.valueOf(date.getDate()+"."+(date.getMonth()+1)+"."+(date.getYear()-100));
            fecha = fecha + turno;
                cd.calcularRuta(seleccionarPaquetes(), fecha, mapa);
            }
        else {
            System.out.println("Entra la fecha (dd.mm.aa)");
            String fecha = sc.nextLine();
            String ano = fecha.substring(6, fecha.length());
            String mes = fecha.substring(3, fecha.length()-3);
            String dia = fecha.substring(0, fecha.length()-6);
            if (ano.compareTo(String.valueOf(date.getYear()-100)) > 0) {
                System.out.println("La fecha tiene que ser superios a la fecha actual");
            }
            else {
                if (mes.compareTo(String.valueOf(date.getMonth()+1)) > 0) {
                    System.out.println("La fecha tiene que ser superios a la fecha actual");
                }
                else {
                    if (dia.compareTo(String.valueOf(date.getDate())) > 0) {
                        System.out.println("La fecha tiene que ser superios a la fecha actual");
                    }
                    else {
                        System.out.println("Entra el turno (mañana/tarde)");
                        turno = "-"+sc.nextLine();
                        fecha = fecha + turno;
                        cd.calcularRuta(seleccionarPaquetes(), fecha, mapa);
                    }
                }
            }
        }
    }
    
    public void leerOperador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anadir el nombre del operador");
        nombreOperador = sc.next();
        System.out.println("Anadir el password del operador");
        password = sc.next();
    }
    
    public void cancelarPaquete(int idPaquete) {
        boolean encontrado = false;
        int i = 0;
        while (i < listaPaquetesParaEntregar.size() && !encontrado) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetesParaEntregar.get(i).getEstado().equals("para enviar")) {
                    listaPaquetesParaEntregar.remove(i);
                    encontrado = true;
                }
            }
            else {
                ++i;
            }
        }
        if (!encontrado) {
            System.out.println("Paquete no encontrado para este cliente");
        }
    }
    
    public void eliminarPaquete(int idPaquete) {
        boolean encontrado = false;
        int i = 0;
        while (i < listaPaquetesParaEntregar.size() && !encontrado) {
            if (listaPaquetesParaEntregar.get(i).getIdPaquete() == idPaquete) {
                if (listaPaquetesParaEntregar.get(i).getEstado().equals("enviado")) {
                    listaPaquetesParaEntregar.remove(i);
                    encontrado = true;
                }
                else {
                    System.out.println("El paquete aun no se ha enviado, lo tienes que cancelar");
                    encontrado = true;
                }
            }
            else {
                ++i;
            }
        }
        if (!encontrado) {
            System.out.println("Paquete no encontrado para este cliente");
        }
    }
    
    public void anadirCiudad(ControlDominio cd) throws IOException, ClassNotFoundException{
        Mapa map = new Mapa();
        map.crearCiudad();
        String name = map.getNombreCiudad();
        cd.guardarMapa(map, name);
        
    }
    
    public void cargarCiudad(ControlDominio cd) throws FileNotFoundException, IOException, ClassNotFoundException{
        mapa = (Mapa) cd.leerCiudad();
    }
    
    private void ordenaPaquetes(ArrayList<Paquete> paquetes){
        
        //MERGESORT!!!! PRO AHORA ME DA PALO IMPLEMENTAR!!!!!!
        //PUES MIRAQUE ES FACIL; SOLO TIENES QUE LLAMAR A UNA PUTA FUNCION; YA LO HICE TODO YO
        //HIJOPUTA!!! xD
    }
    
    private void buscayElimina(ArrayList<Paquete> paquetes, int idpaquete){
        
        //HAURIA DE SER UNA BINARY SEARCH PRO NECESSITEM EL VECTOR ORDENAT
        for(int i = 0; i < paquetes.size(); ++i){
            if(idpaquete == paquetes.get(i).getIdPaquete()){
                paquetes.remove(i);
            }
        }
    }
    
    private void buscayAgrega(ArrayList <Paquete> paquetes, int idagregado){
        for(int i = 0; i < listaPaquetesParaEntregar.size(); ++i){
            if(listaPaquetesParaEntregar.get(i).getIdPaquete() == idagregado){
                
                paquetes.add(listaPaquetesParaEntregar.get(i));
            }
        }
    }
    
    private void modificaListaPaquetes(ArrayList<Paquete> paquetes){
        System.out.println("cuantos paquetes quiere eliminar de la lista?");
        Scanner sc = new Scanner(System.in);
        int numeliminados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea eliminar");
        ordenaPaquetes(paquetes);
        for(int i = 0; i < numeliminados; ++i){
            int idpaquete = sc.nextInt();
            buscayElimina(paquetes, idpaquete);
        }
        //ArrayList <Paquete> nuevospaquetes = new ArrayList<>();
        System.out.println("cuantos paquetes quiere agregar de la lista?");
        int numagregados = sc.nextInt();
        System.out.println("Indique los ID de los paquetes que desea agregar");
        for(int i = 0; i < numagregados; ++i){
            int idagregado = sc.nextInt();
            buscayAgrega(paquetes, idagregado);
        }
        
    }
    
    public void modificarRuta(ControlDominio cd) throws IOException, FileNotFoundException, ClassNotFoundException{
        Ruta r = new Ruta();
        r = (Ruta) cd.leerRuta();
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes = r.getListaPaquetesRuta();
        System.out.println("SIZE1 :"+paquetes.size());
        modificaListaPaquetes(paquetes);
        Mapa map = new Mapa();
        map = r.getMapa();
        String nom = map.getNombreCiudad();
        System.out.println("Procedemos al recalculo de la ruta");
        String fecha = r.getFecha();
        cd.calcularRuta(paquetes, fecha, map);
        for(int i = 0; i < paquetes.size(); ++i){
            System.out.println(paquetes.get(i).getidDestino()+" ");
        }
        cd.calcularRuta(paquetes, nom, map);
   }
    
}