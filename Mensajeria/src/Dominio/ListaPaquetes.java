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
    public ArrayList<Paquete> getListaPaquetes() {
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
    public void packsCliente(int idCliente){
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
    public int tamanoListaPaquetes(){
        return listaPaquetes.size();
    }
    
    /**
     * Escribe el paquete con identificador idPaquete
     * @param idPaquete 
     * 
     */
    public void escribirPaquete(int idPaquete){
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
}
