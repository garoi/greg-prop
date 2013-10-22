package Domini;
import java.util.*;
import java.lang.System;
/**
 *
 * @author ivich
 */
public class Missatgeria {

    /**
     * @param args the command line arguments
     */
    public static void info() {
        System.out.println("Entra una opcion\n" + "1 = Crear ciudad");
        System.out.println("2 = Añadir paquetes\n" + "3 = Calculo de la ruta");
        System.out.println("0 = Cerrar");
    }
    
    public static void main(String[] args) {
        ControlDomini cd = new ControlDomini();
        int op;
        Scanner sc = new Scanner(System.in);
        info();
        op = sc.nextInt();
        while(op != 0){
            if (op == 1){ 
                Ruta r = new Ruta();
                r.CrearCiudad();
                r.ImprimirCiudad();
            }
            else if (op == 2){
                ListaPaquetes lp = new ListaPaquetes();
                lp.AnadirPaquete();
            }
            else if (op == 3) {
            }
            info();
            op = sc.nextInt();
        }
    }
}