package Dominio;
import java.util.Date;

/**
 *
 * @author Marc Garcia Roig
 */
public class Fecha {
    
    private Date date = new Date();
    
    /*Return true si el paramatro fecha es superior o igual a la fecha actual*/
    public boolean comprobarFecha(String fecha) {
        String ano = fecha.substring(6,fecha.length());
        String mes = fecha.substring(3, fecha.length()-3);
        String dia = fecha.substring(0, fecha.length()-6);
        if (ano.compareTo(String.valueOf(date.getYear()-100)) < 0){
            System.out.println("la fecha tiene que ser superior a la actual");
            return false;
        }
        else{
            if(mes.compareTo(String.valueOf(date.getMonth()+1)) < 0){
                System.out.println("la fecha tiene que ser superior a la actual");
                return false;
            }
            else{
                if(dia.compareTo(String.valueOf(date.getDate())) < 0){
                    System.out.println("la fecha tiene que ser superior a la actual");
                    return false;
                }
                else return true;
            }
        }
    }
    
    public String fechaActual() {
        String ano = String.valueOf(date.getYear()-100);
        String mes = String.valueOf(date.getMonth()+1);
        String dia = String.valueOf(date.getDate());
        String fechaActual = dia+"."+mes+"."+ano;
        return fechaActual;
    }
    
    public String mañanaTarde() {
        if (date.getHours() >= 9 & date.getHours() <= 15) return "mañana";
        else return "tarde";
    }
}
