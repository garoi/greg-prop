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
    public static void main(String[] args) {
        ControlDomini cd = new ControlDomini();
        int op;
        Scanner sc = new Scanner(System.in);
        op = sc.nextInt();
        while(op != 0){
            System.out.println("Entra una opcion\n" + "1 = Añadir puntos de la ciudad\n");
            System.out.println("2 = Añadir paquetes\n" + "3 = Calculo de la ruta\n");
            System.out.println("0 = Cerrar\n");
            if (op == 1){       
            }
            else if (op == 2){
            }
            else if (op == 3) {
            }
        }
    }
}