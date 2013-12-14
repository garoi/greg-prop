package Presentacion;
import Dominio.Mensajeria;
/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class Main {
    static CtrlPresentacion ctrlp;
    
    public static void main(final String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ctrlp = new CtrlPresentacion();
            }
        });
    }
}
