/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaCiudad extends javax.swing.JFrame {
    private CtrlPresentacion ctrlp;
    private String nombreCiudad;
    
    /**
     * Creates new form Mierdas
     */
     public VistaCiudad() {
        initComponents();
    }
    
     // <editor-fold defaultstate="collapsed" desc="public VistaCiudad(CtrlPresentacion ctrlp)"> 
    /**
     * Creates new form PrimeraVista
     * @param ctrlp
     */
    public VistaCiudad(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        nombreCiudad = ctrlp.getCiudadOperador();
        initComponents();
    }
    // </editor-fold> 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="public void paint (Graphics g)"> 
    public void paint (Graphics g) {
        ArrayList<String> nombresCiudad = null;
        int n = 0;
        try {
            nombresCiudad = ctrlp.getDominio().getNombresCiudad(nombreCiudad);
            n = nombresCiudad.size();
        } catch (IOException ex) {
            Logger.getLogger(VistaCiudad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaCiudad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        super.paint(g);
        g.setColor(Color.red);
        int maxWidth = this.getWidth();
        int maxHeight = this.getHeight();

        g.setColor (Color.black);
        float factor = maxWidth;
        float diametro = factor*0.8f;
        if(maxWidth<maxHeight) factor = maxHeight;
        int origx = Math.round(factor*0.1f) + Math.round(factor*0.4f) - 5;
        int origy = Math.round(factor*0.15f) - 5;

        double angulo = 360 / n;
        double radio = diametro / 2;
        int centrox = Math.round(factor*0.1f) + Math.round(factor*0.4f) - 5;
        int centroy = Math.round(factor*0.15f) + Math.round(factor*0.4f) - 5;
        
        ArrayList<int[]> puntos = new ArrayList();
        double auxAngulo = 0.0f;
        for(int i = 0; i < n; i++){
            int p1x = (int) (Math.cos(Math.toRadians(auxAngulo))*radio);
            int p1y = (int) (Math.sin(Math.toRadians(auxAngulo))*radio);

            if(auxAngulo > 240){
                p1x *= -1;
                p1x *= -1;
            }
            else if(auxAngulo > 180) p1y *= -1;
            else if(auxAngulo > 90) p1y *= -1;

            int auxx = p1x + centrox;
            int auxy = p1y + centroy;
            int[] auxPair = {auxx, auxy};
            puntos.add(auxPair);
            
            g.setColor (Color.black);
            g.drawString(nombresCiudad.get(i), auxx -5, auxy-5);
            
            g.fillOval(auxx,auxy,10,10);
            g.setColor (Color.blue);
            g.fillOval(auxx+2,auxy+2,6,6);
            auxAngulo += angulo;
        }

        g.setColor(Color.black);
        for (int i = 0; i < puntos.size(); ++i) {
            for (int j = i+1; j < puntos.size(); ++j) {
                int[] auxi = puntos.get(i);
                int xi = auxi[0]+3;
                int yi = auxi[1]+3;
                int[] auxj = puntos.get(j);
                int xj = auxj[0]+3;
                int yj = auxj[1]+3;
                g.drawLine(xi, yi, xj, yj);
            }
        }
    }
    // </editor-fold>  
    
    // <editor-fold defaultstate="collapsed" desc="private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt)"> 
    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        Graphics g = null;
    }//GEN-LAST:event_jPanel1AncestorAdded
    // </editor-fold> 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCiudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
