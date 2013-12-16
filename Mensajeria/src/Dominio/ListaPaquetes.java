package Dominio;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Albert Gili Zaragoza
 */
public class ListaPaquetes implements Serializable {
    private static final long serialVersionUID = 9040177911315386368L;
     ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
     int idPaquete = 0;
    private ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }
     
    /**
     * Añade un paquete a la lista
     * @param p 
     */
    public void anadirPaquete(Paquete p){
        p.setIdPaquete(idPaquete);
        ++idPaquete;
        listaPaquetes.add(p);    
    }
    
    /**
     * Muestra los paquetes del cliente con identificador idCliente
     * @param idCliente 
     * 
     */
    private void packsCliente(int idCliente){
        for(int i = 0; i < listaPaquetes.size(); ++i){
            if(listaPaquetes.get(i).getIdCliente() == idCliente){
                escribirPaquete(i);
            }
        }
    }
    
    /**
     * Devuelve el tamaño de la lista de paquetes
     * @return tamano de la lista de paquetes
     */
    private int tamanoListaPaquetes(){
        return listaPaquetes.size();
    }
    
    /**
     * Escribe el paquete con identificador idPaquete
     * @param idPaquete 
     * 
     */
    private void escribirPaquete(int idPaquete){
        if(idPaquete > tamanoListaPaquetes()){
            System.out.print("El paquete no existe");
        }
        else{
            Paquete p = listaPaquetes.get(idPaquete);
            System.out.print(p.getIdPaquete() + "\n");
            System.out.print(p.getIdCliente() + "\n");
            System.out.print(p.getCiudad() + "\n");
            System.out.print(p.getDestino() + "\n");
            System.out.print(p.getEstado() + "\n");
            System.out.print(p.getFecha() + "\n");
            System.out.print(p.getTurno() + "\n");
        }
    }
    
    /**
     * Cancela el paquete con identificador idPaquete
     * @param idPaquete 
     * 
     */
    public void cancelarPaquete(int idPaquete){
        listaPaquetes.get(idPaquete).setEstado("cancelado");
    }
    
    public void eliminarPaquete(int idPaquete){
        listaPaquetes.get(idPaquete).setEstado("eliminado");
    }
    
    /**
     * Una vez confirmada la ruta cambia el estado de los paquetes enviados
     * @param paquetesEnviados
     */
    public void cambiarEstadoPaquetes(ArrayList<Paquete>paquetesEnviados) {
        for (int i = 0; i < paquetesEnviados.size(); ++i) {
            boolean encontrado = false;
            for (int j = 0; j < listaPaquetes.size() & !encontrado; ++j) {
                if (listaPaquetes.get(j).getIdPaquete() == (paquetesEnviados.get(i).getIdPaquete())) {
                    listaPaquetes.get(j).setEstado("enviado");
                    encontrado = true;
                }
            }
        }
    }
    
    /**
     * Ordena los paquetes por identificador.
     */
    private void ordenarPorIdPaquete() {
        Collections.sort(listaPaquetes, new Paquete.IdPaqueteComparator());
    }
    
    /**
     * Ordena por paquetes por destino.
     */
    private void ordenarPorDestino() {
        Collections.sort(listaPaquetes, new Paquete.DestinoComparator());
    }
    
    /**
     * Ordena los paquetes por fecha y turno.
     */
    private void ordenarPorFechaTurno() {
        Collections.sort(listaPaquetes, new Paquete.FechaTurnoComparator());
    }
    
    private void ordenarPorCiudad() {
        Collections.sort(listaPaquetes, new Paquete.CiudadComparator());
    }
    
    private void ordenarPorEstado() {
        Collections.sort(listaPaquetes, new Paquete.EstadoComparator());
    }
    
     /**
     * Muestra los paquetes por pantalla segun el criterio que se pida.
     */
    public ArrayList<String> verPaquetes(String orden) {
        if (orden.equals("idPaquete")) {
            ordenarPorIdPaquete();
        }
        else if (orden.equals("destino")) {
            ordenarPorDestino();
        }
        else if (orden.equals("fecha")) {
            ordenarPorFechaTurno();
        }
        else if (orden.equals("ciudad")){
            ordenarPorCiudad();
        }
        else if (orden.equals("estado")){
            ordenarPorEstado();
        }
        ArrayList<String> paquetes = new ArrayList<>();
        for (int i = 0; i < listaPaquetes.size(); ++i) {
            String paqs = String.valueOf(listaPaquetes.get(i).getIdPaquete()) + "    " ;
            paqs = paqs + listaPaquetes.get(i).getFecha() + "    ";
            paqs = paqs + listaPaquetes.get(i).getDestino() + "    ";
            paqs = paqs + listaPaquetes.get(i).getCiudad() + "    ";
            paqs = paqs + listaPaquetes.get(i).getEstado() + "    ";
            paquetes.add(paqs);
        }
        return paquetes;
    }

    void eliminarPaquetesDeCiudad(String nombreCiudad) {
        ArrayList<Paquete> paquetes = getListaPaquetes();
        for (int i = 0; i < paquetes.size(); i++) {
            if (paquetes.get(i).getCiudad()==nombreCiudad)
            this.eliminarPaquete(paquetes.get(i).getIdPaquete());
        }
    }
}
