package Dominio;

import java.util.*;

/**
 *
 * @author Angel Rierola Mora
 */
public class DriverFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Selecciona funcion a probar");
        System.out.println("1: Dar fecha actual");
        System.out.println("2: Decir turno actual");
        System.out.println("0: Salir");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        Fecha dat = new Fecha();
        while(op != 0){
            if(op == 1) {
                System.out.println("Nuestra fecha actual es: " + dat.fechaActual());
            }
            else if (op == 2) {
                System.out.println("Estamos en el turno: " + dat.mañanaTarde());
            }
            else System.out.println("Opcion Incorrecta, vuelve a introducir una opcion");
            System.out.println("Selecciona funcion a probar");
            op = sc.nextInt();
        }
    }
}
