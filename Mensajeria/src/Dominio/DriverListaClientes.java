package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marc Garcia Roig
 */
public class DriverListaClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        System.out.print("Selecciona funcion a probar" + "\n");
        System.out.print("1: anadirCliente" + "\n");
        System.out.print("2: getCliente" + "\n");
        System.out.print("3: anadirPaquete" + "\n");
        System.out.print("4: encontrarCliente" + "\n");
        System.out.print("5: packsCliente" + "\n");
        System.out.print("6: tamanoListaClientes" + "\n");
        System.out.print("0: Finalizar" + "\n");
        
        Scanner sc = new Scanner(System.in);
        ListaClientes lc = new ListaClientes();
        ListaPaquetes lp = new ListaPaquetes();
        int op = sc.nextInt();
        while(op != 0){
            if(op == 1){
                Cliente c = new Cliente();
                c.leerCliente();
                boolean existe;
                existe = lc.comprueba(c.getNombreCliente());
                if(!existe){
                    lc.anadirCliente(c);
                }
                else System.out.print("el cliente ya existe");
            }
            else if(op == 2){
                System.out.print("Introduce id del cliente" + "\n");
                int id = sc.nextInt();
                if(id < lc.tamanoListaClientes()){
                    System.out.print(lc.getCliente(id).getNombreCliente() + "\n");
                }
                else System.out.print("No existe un cliente con este id" + "\n");
            }
            else if(op == 3){
                System.out.println("Entra el id del cliente al que quieras anadir el paquete");
                int id = sc.nextInt();
                if(id > lc.tamanoListaClientes()-1)  System.out.println("el cliente no existe");
                else{
                    System.out.println("Entra el paquete que quieras anadir");
                    Paquete p = new Paquete();
                    System.out.println("Entra el nombre de la ciudad del paquete");
                    Scanner sc2 = new Scanner(System.in);
                    String nombreCiudad = sc2.nextLine();
                    p.leerPaquete(id, nombreCiudad);
                    lp.anadirPaquete(p);
                    lc.anadirPaquete(p, id);
                }
                
            }
            else if(op == 4){
                System.out.print("Entra el nombre del cliente que quieras encontrar" + "\n");
                Scanner sc4 = new Scanner(System.in);
                String s = sc4.nextLine();
                lc.encontrarCliente(s);
            }
            else if(op == 5){
                System.out.print("Entra el id del cliente");
                int idCliente = sc.nextInt();
                lc.packsCliente(idCliente);
            }
            else if(op == 6){
                System.out.print(lc.tamanoListaClientes() + "\n");
            }
            else System.out.print("Opcion Incorrecta vuelve seleccionar una opcion" + "\n");
            
            System.out.print("Selecciona funcion a probar" + "\n");
            op = sc.nextInt();
        }
    }
    
}