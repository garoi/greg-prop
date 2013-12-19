package Dominio;
import java.util.Date;

/**
 *
 * @author Angel Rierola Mora
 */
public class Fecha {
    
    private Date date = new Date();
    
    private String normalizarDia() {
        String diaSistema = null;
        if (date.getDate() < 10) {
            diaSistema = '0' + String.valueOf(date.getDate());
        }
        else {
            diaSistema = String.valueOf(date.getDate());
        }
        return diaSistema;
    }
    
    private String normalizarMes() {
        String mesSistema = null;
        if ((date.getMonth() + 1) < 10) {
            mesSistema = '0' + String.valueOf(date.getMonth()+1);
        }
        else {
            mesSistema = String.valueOf(date.getMonth()+1);
        }
        return mesSistema;
    }
    
    private String normalizarAno() {
        String anoSistema = null;
        if ((date.getYear()-100) < 10) {
            anoSistema = '0' + String.valueOf((date.getYear()-100));
        }
        else {
            anoSistema = String.valueOf((date.getYear()-100));
        }
        return anoSistema;
    }

    /**
     * Comprobamos que la fecha se mayor o igual a nuestra fecha actual
     * @param fecha
     * @returntrue si el paramatro fecha es superior o igual a la fecha actual
     */   
    private boolean comprobarFecha(String fecha) {
        String ano = fecha.substring(6,fecha.length());
        String mes = fecha.substring(3, fecha.length()-3);
        String dia = fecha.substring(0, fecha.length()-6);
        
        String diaSistema = normalizarDia();
        String mesSistema = normalizarMes();
        String anoSistema = normalizarAno();
        
        System.out.println("LA FECHA DEL SISTEMA ES " + diaSistema + " " + mesSistema + " " + anoSistema);
        
        
        if (ano.compareTo(anoSistema) < 0){
            System.out.println("el año tiene que ser superior a la actual");
            return false;
        }
        if (ano.compareTo(anoSistema) > 0) return true;
        if (mes.compareTo(mesSistema) < 0){
            System.out.println("el mes tiene que ser superior a la actual");
            return false;
        }
        if (mes.compareTo(mesSistema) > 0) return true;
        if (dia.compareTo(diaSistema) < 0){
            System.out.println("la fecha tiene que ser superior a la actual");
            return false;
        }
        return true;
    }
    
    /**
     *
     * @return devuelve la fecha actual.
     */
    public String[] fechaDeHoy() {
        String[] fechaTurno = new String[4];
        fechaTurno[0] = normalizarDia();
        fechaTurno[1] = normalizarMes();
        fechaTurno[2] = normalizarAno();
        fechaTurno[3] = mananaTarde();
        return fechaTurno;
        
    }
    
    /**
     * Devuelve el dia mes y año al que estamos
     * @return una string con la fecha actual
     */
    private String fechaActual() {
        String ano = String.valueOf(date.getYear()-100);
        String mes = String.valueOf(date.getMonth()+1);
        String dia = String.valueOf(date.getDate());
        String fechaActual = dia+"."+mes+"."+ano;
        return fechaActual;
    }
    
    /**
     * Devuelve la franja horaria actual
     * @return string con la franja horaria actual
     */
    private String mananaTarde() {
        if (date.getHours() >= 9 && date.getHours() < 15) return "M";
        else return "T";
    }
}
