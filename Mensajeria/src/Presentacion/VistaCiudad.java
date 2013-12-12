/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Marc Garcia Roig
 */
public class VistaCiudad extends javax.swing.JFrame {
    private CtrlPresentacion ctrlp;
    
    /**
     * Creates new form Mierdas
     */
     public VistaCiudad() {
        initComponents();
    }
    
    /**
     * Creates new form PrimeraVista
     * @param ctrlp
     */
    public VistaCiudad(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
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

   
    public void paint (Graphics g) {
        System.out.println("Entra paint");
        /*ArrayList<String> nombresCiudad = ctrlp.getDominio().getNombresCiudad();
        int tamCiudad = nombresCiudad.size();
        ArrayList<ArrayList<Float>> distanciaCiudad = ctrlp.getDominio().getDistanciaCiudad();*/

        float longitudCirculototal = (float) ((Math.PI) * 740);

        super.paint(g);
        g.setColor(Color.red);
        int maxWidth = this.getWidth();
        int maxHeight = this.getHeight();

//        g.drawOval (20, 50, 630, 630);

        g.setColor (Color.black);
//        g.drawLine (0, 70, 100, 70);
//        g.drawRect (150, 70, 50, 70);
//        g.drawRoundRect (250, 70, 50, 70, 6, 6);
//        g.drawOval(esquina, esquina, anchox, anchoy);
//        g.drawOval (350, 70, 50, 70);
        float factor = maxWidth;
        float diametro = factor*0.8f;
        if(maxWidth<maxHeight) factor = maxHeight;
        // circunferencia
//        g.drawOval(Math.round(factor*0.1f), Math.round(factor*0.15f), Math.round(diametro), Math.round(diametro));
        int origx = Math.round(factor*0.1f) + Math.round(factor*0.4f) - 5;
        int origy = Math.round(factor*0.15f) - 5;
        // n=numero puntos
        int n = 12;
        double angulo = 360 / n;
        double radio = diametro / 2;
        int centrox = Math.round(factor*0.1f) + Math.round(factor*0.4f) - 5;
        int centroy = Math.round(factor*0.15f) + Math.round(factor*0.4f) - 5;
//        g.drawOval(centrox,centroy,10,10);
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
            g.fillOval(auxx,auxy,10,10);
            g.setColor (Color.white);
            g.fillOval(auxx+2,auxy+2,6,6);
            auxAngulo += angulo;
        }
//            g.drawOval(origx, origy, 10, 10);

//        g.drawOval(Math.round((float) p1x), Math.round((float)p1y), 5, 5);




//        int [] vx1 = {500, 550, 450};
//        int [] vy1 = {70, 120, 120};
//        g.drawPolygon (vx1, vy1, 3);

        g.setColor (Color.red);
//        g.fillRect (150, 270, 50, 70);
//        g.fillRoundRect (250, 270, 50, 70, 6, 6);
//        g.fillOval (350, 270, 50, 70);
//        int [] vx2 = {500, 550, 450};
//        int [] vy2 = {270, 320, 320};
//        g.fillPolygon (vx2, vy2, 3);
    }
    
    
    
    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        Graphics g = null;
//        paint(g);
    }//GEN-LAST:event_jPanel1AncestorAdded

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
