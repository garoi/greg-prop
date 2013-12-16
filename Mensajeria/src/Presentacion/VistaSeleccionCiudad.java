package Presentacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaSeleccionCiudad extends javax.swing.JFrame {

    CtrlPresentacion ctrlp;
    private String nombreCiudad;
    private String[] ciudades;
    int idx;
    
    /**
     * Creates new form VistaSeleccionarCiudad
     */
    public VistaSeleccionCiudad() {
        initComponents();
    }
    
    /**
     * Creates new form VistaSeleccionarCiudad
     */
    public VistaSeleccionCiudad(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        initComponents();
        actualizarListaCiudades();
    }
    
    public void actualizarListaCiudades(){
        ciudades = ctrlp.getNombresCiudades();
        listaCiudades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = ciudades;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public Object getElementAt(int i) { return strings[i]; }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCiudades = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        btnAnadir = new javax.swing.JButton();
        btnFichero = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Ciudad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        listaCiudades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaCiudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCiudadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaCiudades);

        btnAnadir.setBackground(new java.awt.Color(75, 75, 75));
        btnAnadir.setForeground(new java.awt.Color(220, 220, 220));
        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnFichero.setBackground(new java.awt.Color(75, 75, 75));
        btnFichero.setForeground(new java.awt.Color(220, 220, 220));
        btnFichero.setText("Añadir desde fichero");
        btnFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFicheroActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(75, 75, 75));
        btnModificar.setForeground(new java.awt.Color(220, 220, 220));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(75, 75, 75));
        btnSeleccionar.setForeground(new java.awt.Color(220, 220, 220));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(75, 75, 75));
        btnEliminar.setForeground(new java.awt.Color(220, 220, 220));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(75, 75, 75));
        btnCerrar.setForeground(new java.awt.Color(220, 220, 220));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFichero, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAnadir, btnCerrar, btnEliminar, btnFichero, btnModificar, btnSeleccionar});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int idx = listaCiudades.getSelectedIndex();      
        String nombreCiudad = (String) listaCiudades.getSelectedValue();
        if(nombreCiudad != null){
            this.setVisible(false);
            ctrlp.setCiudad(nombreCiudad);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * Añade un evento cuando se hace click sobre el botón Modificar.
     * El evento muestra una ventana para seleccionar las opciones de modificación de la ciudad.
     * @param evt el evento de click sobre el botón.
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
            int idx = listaCiudades.getSelectedIndex();   
            String nombreCiudad = (String) listaCiudades.getSelectedValue();
            if(nombreCiudad != null){
                ctrlp.setCiudad(nombreCiudad);
                ctrlp.setVentanaSecundaria("vistaModificarCiudad");
            }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        ArrayList<String> nombreNodos = new ArrayList();
        String nombreCiudad = JOptionPane.showInputDialog("Introduce el nombre de la ciudad:");
        while(nombreCiudad.isEmpty() || nombreCiudad.contains(" "))nombreCiudad = JOptionPane.showInputDialog("¡Introduce un nombre de la ciudad válido!");
        nombreCiudad = nombreCiudad;
        String strnNodos = JOptionPane.showInputDialog("Introduce el número de puntos:");
        while(strnNodos.isEmpty() || strnNodos.contains(" ")) strnNodos = JOptionPane.showInputDialog("¡Introduce un número válido!");
        int nNodos = 1;
        try{
            nNodos = Integer.parseInt(strnNodos);
            int auxdistancias = (nNodos*(nNodos-1))/2;
            float[] distancias = new float[auxdistancias];
            for(int i = 0; i < nNodos; i++){
                String mensaje = String.format("Introduce el nombre del punto %d (%d restantes):", i+1, nNodos - i - 1);
                String nombreNodo = JOptionPane.showInputDialog(mensaje);
                while(nombreNodos.contains(nombreNodo) || nombreNodo == "")nombreNodo = JOptionPane.showInputDialog("Introduce un nombre que no hayas introducido:");
                nombreNodos.add(nombreNodo);
            }
            int nodoA = 0;
            int nodoB = 1;
            for (int i = 0; i < auxdistancias; i++) {
                String distanciaEntreNodos = JOptionPane.showInputDialog(String.format("Introduce la distancia entre el punto %s y el punto %s:", nombreNodos.get(nodoA), nombreNodos.get(nodoB)));
                while(distanciaEntreNodos.isEmpty() || distanciaEntreNodos.contains(" ")) distanciaEntreNodos = JOptionPane.showInputDialog("Por favor, introduce un natural.");
                float auxDistancia = Float.parseFloat(distanciaEntreNodos);
                while(auxDistancia <= 0.0f){
                    distanciaEntreNodos = JOptionPane.showInputDialog(String.format("Introduce una distancia válida:"));
                    auxDistancia = Float.parseFloat(distanciaEntreNodos);
                }
                distancias[i] = auxDistancia;
                nodoB += 1;
                if (nodoB==nNodos){
                    nodoA += 1;
                    nodoB = nodoA+1;
                }
            }
            ctrlp.anadirCiudad(nombreCiudad, nNodos, nombreNodos, distancias);
            ctrlp.actualizarVistaSelCiudades();
            ctrlp.actualizarVentanaSecundaria();
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "Has introducido un formato inválido. Tiene que ser un natural.");
            this.dispose();
        }
        
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminar una ciudad de la lista.
        int idx = listaCiudades.getSelectedIndex();
        String nombreCiudad = (String) listaCiudades.getSelectedValue();
        if(!ctrlp.getRutas(nombreCiudad).isEmpty()) JOptionPane.showMessageDialog(rootPane, "Borrar una ciudad implica borrar todas las rutas que transcurren por ella!");
        ctrlp.eliminarCiudad(nombreCiudad);
        actualizarListaCiudades();
        ctrlp.actualizarRutasOperador();
        if(nombreCiudad == ctrlp.getCiudad()) ctrlp.setCiudad(null);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFicheroActionPerformed
        nombreCiudad = JOptionPane.showInputDialog("Introduce un nombre para la ciudad:");
        ctrlp.crearFichero(nombreCiudad);
        String accep = JOptionPane.showInputDialog("Has terminado de guardar la ciudad? si/no:");
        if (accep.equals("si")) {
            ciudadAnadidaFichero();
        }
        else ctrlp.eliminarCiudad(nombreCiudad);
    }//GEN-LAST:event_btnFicheroActionPerformed

    private void listaCiudadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCiudadesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int idx = listaCiudades.getSelectedIndex();      
            String nombreCiudad = (String) listaCiudades.getSelectedValue();
            this.setVisible(false);
            ctrlp.setCiudad(nombreCiudad);
        }
        //idx = ciudades.getSelectedIndex();
    }//GEN-LAST:event_listaCiudadesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSeleccionCiudad().setVisible(true);
            }
        });
    }
    
    public void ciudadAnadidaFichero() {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<ArrayList<Float>> ciudad = new ArrayList<>();
        float max = (float) 0.0;
        float min = (float) 0.0;
        ctrlp.leerMapaFichero(nombreCiudad+"-mapa.txt", nombreCiudad,nombres,ciudad,max,min);
        ctrlp.pasarAObjeto(nombreCiudad, nombres, ciudad);
        ctrlp.leerCiudad(nombreCiudad);
        actualizarListaCiudades();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFichero;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaCiudades;
    // End of variables declaration//GEN-END:variables
}
