/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class VistaModificarRuta extends javax.swing.JFrame {
    private CtrlPresentacion ctrlp;
    private String nombreCiudad;
    private String label;
    private String ruta;
    private boolean pintado;
    /**
     * Creates new form VistaModificarRuta
     */
    public VistaModificarRuta() {
        initComponents();
    }
    
    public VistaModificarRuta(CtrlPresentacion ctrlp){
        this.ctrlp = ctrlp;
        nombreCiudad = ctrlp.getCiudad();
        initComponents();
        this.ruta = ctrlp.getRuta();
        label = ctrlp.getDestinosRuta();
        fieldRuta.setText(label);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDibujoRuta = new javax.swing.JPanel();
        fieldRuta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnValidar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDibujoRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visualización de la ruta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout panelDibujoRutaLayout = new javax.swing.GroupLayout(panelDibujoRuta);
        panelDibujoRuta.setLayout(panelDibujoRutaLayout);
        panelDibujoRutaLayout.setHorizontalGroup(
            panelDibujoRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );
        panelDibujoRutaLayout.setVerticalGroup(
            panelDibujoRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        fieldRuta.setText("jTextField1");

        btnValidar.setBackground(new java.awt.Color(75, 75, 75));
        btnValidar.setForeground(new java.awt.Color(240, 240, 240));
        btnValidar.setText("Validar");
        btnValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidarMouseClicked(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(75, 75, 75));
        btnEliminar.setForeground(new java.awt.Color(240, 240, 240));
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(75, 75, 75));
        btnCancelar.setForeground(new java.awt.Color(240, 240, 240));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(75, 75, 75));
        btnModificar.setForeground(new java.awt.Color(240, 240, 240));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(4, 4, 4)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(180, 180, 180)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDibujoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fieldRuta, panelDibujoRuta});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDibujoRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String res = fieldRuta.getText();
        if (label.length() == res.length()) JOptionPane.showMessageDialog(rootPane, "!No has hecho ningun cambio!");
        if (label.length() > res.length()) JOptionPane.showMessageDialog(rootPane, "!No puedes quitar paquetes de una ruta");
        if (label.length() < res.length()) {
            if(!ctrlp.modificarRuta(ruta, res)) {
                JOptionPane.showMessageDialog(rootPane, "No puedes modificar una ciudad si antes has modificado la ciudad");
            }
        }        
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        if (ruta != null) {
            ctrlp.eliminarRuta(ruta);
            ctrlp.actualizarRutasOperador();
            ArrayList<String> listaEnRutaS = new ArrayList<>();
            ctrlp.setListaEnRutaS(listaEnRutaS);
            ctrlp.actualizarListaEnRuta();
        }
        this.dispose();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnValidarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidarMouseClicked
        ctrlp.setRuta(ruta);
        ctrlp.validarRuta(ruta);
        this.dispose();
    }//GEN-LAST:event_btnValidarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaModificarRuta().setVisible(true);
            }
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="public void paint (Graphics g)"> 
    @Override
    public void paint (Graphics g) {
        long ta = System.currentTimeMillis();
        ArrayList<String> nombresCiudad = ctrlp.getNombresCiudad(nombreCiudad);
        String pasosRuta = ctrlp.getDestinosRuta();
        String[] destinos = pasosRuta.split(" ");
        int n = nombresCiudad.size();

        super.paint(g);
        g.setColor(Color.red);
        int maxWidth = this.panelDibujoRuta.getWidth();
        int maxHeight = this.panelDibujoRuta.getHeight();

        g.setColor (Color.black);
        float factor = maxWidth;
        float diametro = factor*0.8f;
        if(maxWidth<maxHeight) factor = maxHeight;
        int origx = Math.round(factor*0.1f) + Math.round(factor*0.4f) - 5 + this.panelDibujoRuta.getX();
        int origy = Math.round(factor*0.15f) - 5 + this.panelDibujoRuta.getY();

        double angulo = 360f / n;
        double radio = diametro / 2;
        int centrox = Math.round(factor*0.1f) + Math.round(factor*0.4f) - 5 + this.panelDibujoRuta.getX();
        int centroy = Math.round(factor*0.15f) + Math.round(factor*0.4f) + this.panelDibujoRuta.getY();

        if (n == 1){
            g.fillOval(centrox,centroy,10,10);
            g.setColor (Color.blue);
            g.fillOval(centrox+2,centroy+2,6,6);
            g.setColor (Color.black);
            g.drawString(nombresCiudad.get(0), centrox, centroy);
        }
        else{

            ArrayList<int[]> puntos = new ArrayList();
            double auxAngulo = 0.0f;
            for(int i = 0; i < n; i++){
                double xcos = Math.cos(Math.toRadians(auxAngulo));
                double ysin = Math.sin(Math.toRadians(auxAngulo));
                int p1x = (int) (xcos*radio);
                int p1y = (int) (ysin*radio);
                int psx = (int) (xcos*(radio*1.065)) + centrox-1;
                int psy = (int) (-ysin*(radio*1.065)) + centroy+8;
                p1y *= -1;

                int auxx = p1x + centrox;
                int auxy = p1y + centroy;
                int[] auxPair = {auxx, auxy};
                puntos.add(auxPair);

                g.setColor (Color.black);
                g.drawString(nombresCiudad.get(i),psx,psy);

                g.fillOval(auxx,auxy,10,10);
                g.setColor (Color.blue);
                g.fillOval(auxx+2,auxy+2,6,6);
                auxAngulo += angulo;
            }

            g.setColor(Color.black);
            int idx1 = 0;
            int idx2 = 1;
            for (int i = 0; i < puntos.size(); ++i) {
                for (int j = i+1; j < puntos.size(); ++j) {
                    float fcolor = ctrlp.getDistancias(nombresCiudad.get(i), nombresCiudad.get(j));
//                            if(destinos != null) System.out.println("destinos" + destinos);
                    if(destinos != null && destinos.length >=2 && nombresCiudad.get(i).equals(destinos[idx1]) && nombresCiudad.get(j).equals(destinos[idx2])){
                        String a = "a";
                        String b = "b";
                        if (a.equals(b))
                        System.out.println("Entra");
                        g.setColor(ctrlp.getColorDistancia(fcolor));
                    }
                    int[] auxi = puntos.get(i);
                    int xi = auxi[0]+2;
                    int yi = auxi[1]+2;
                    int[] auxj = puntos.get(j);
                    int xj = auxj[0]+2;
                    int yj = auxj[1]+2;

                    g.drawLine(xi, yi, xj, yj);
                    g.setColor(Color.black);
                }
            }
        }
        long tb = System.currentTimeMillis()-ta;
        System.out.println("Tiempo de dibujo: " + tb);
    }
    // </editor-fold>  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JTextField fieldRuta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelDibujoRuta;
    // End of variables declaration//GEN-END:variables
}
