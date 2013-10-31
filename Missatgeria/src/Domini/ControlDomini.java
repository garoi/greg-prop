package Domini;

/**
 *
 * @author ivich
 */
public class ControlDomini {
    ListaPaquetes lp = new ListaPaquetes();
    private static ControlDomini instance = null;
    
    public static ControlDomini getInstance(){
        if(instance == null){
            instance = new ControlDomini();
        }
        return instance;
    }
    
    public void anadirPaquete(){
        lp.AnadirPaquete(null);
    }
    
    public void save(){
        liada padre!!!
    }
        
}