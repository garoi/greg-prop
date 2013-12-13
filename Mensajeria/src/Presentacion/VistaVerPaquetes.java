/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaVerPaquetes extends javax.swing.JFrame {
    private CtrlPresentacion ctrlp;

    /**
     * Creates new form VistaVerPaquetes
     */
    public VistaVerPaquetes() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="public VistaVerPaquetes(CtrlPresentacion ctrlp)">    
    /**
     * Creates new form VistaOperadorPrincipal
     */
    public VistaVerPaquetes(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        initComponents();
    }// </editor-fold> 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VerPaquetes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPaquetes = new javax.swing.JList();
        idPaquete = new javax.swing.JButton();
        Fecha = new javax.swing.JButton();
        Destino = new javax.swing.JButton();
        Ciudad = new javax.swing.JButton();
        Estado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(75, 75, 75));
        jButton1.setForeground(new java.awt.Color(220, 220, 220));
        jButton1.setText("OK");
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        ListaPaquetes.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().verPaquetesOperador("idPaquete");
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
        ListaPaquetes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListaPaquetes);

        idPaquete.setBackground(new java.awt.Color(75, 75, 75));
        idPaquete.setForeground(new java.awt.Color(220, 220, 220));
        idPaquete.setText("idPaquete");
        idPaquete.setFocusPainted(false);
        idPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idPaqueteMouseClicked(evt);
            }
        });

        Fecha.setBackground(new java.awt.Color(75, 75, 75));
        Fecha.setForeground(new java.awt.Color(220, 220, 220));
        Fecha.setText("Fecha");
        Fecha.setFocusPainted(false);
        Fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FechaMouseClicked(evt);
            }
        });

        Destino.setBackground(new java.awt.Color(75, 75, 75));
        Destino.setForeground(new java.awt.Color(220, 220, 220));
        Destino.setText("Destino");
        Destino.setFocusPainted(false);
        Destino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DestinoMouseClicked(evt);
            }
        });

        Ciudad.setBackground(new java.awt.Color(75, 75, 75));
        Ciudad.setForeground(new java.awt.Color(220, 220, 220));
        Ciudad.setText("Ciudad");
        Ciudad.setFocusPainted(false);
        Ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CiudadMouseClicked(evt);
            }
        });

        Estado.setBackground(new java.awt.Color(75, 75, 75));
        Estado.setForeground(new java.awt.Color(220, 220, 220));
        Estado.setText("Estado");
        Estado.setFocusPainted(false);
        Estado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EstadoMouseClicked(evt);
            }
        });

        jLabel1.setText("Ordena por:");

        javax.swing.GroupLayout VerPaquetesLayout = new javax.swing.GroupLayout(VerPaquetes);
        VerPaquetes.setLayout(VerPaquetesLayout);
        VerPaquetesLayout.setHorizontalGroup(
            VerPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerPaquetesLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(VerPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addGroup(VerPaquetesLayout.createSequentialGroup()
                        .addComponent(idPaquete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Destino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ciudad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estado))
                    .addComponent(jScrollPane1)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        VerPaquetesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Ciudad, Destino, Estado, Fecha, idPaquete, jButton1});

        VerPaquetesLayout.setVerticalGroup(
            VerPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerPaquetesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPaquete)
                    .addComponent(Fecha)
                    .addComponent(Ciudad)
                    .addComponent(Estado)
                    .addComponent(Destino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VerPaquetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VerPaquetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="private void jButton1MouseClicked(java.awt.event.MouseEvent evt)">    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="private void idPaqueteMouseClicked(java.awt.event.MouseEvent evt)">    
    private void idPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idPaqueteMouseClicked
        ListaPaquetes.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().verPaquetesOperador("idPaquete");
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }//GEN-LAST:event_idPaqueteMouseClicked
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="private void FechaMouseClicked(java.awt.event.MouseEvent evt">    
    private void FechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FechaMouseClicked
        ListaPaquetes.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().verPaquetesOperador("fecha");
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }//GEN-LAST:event_FechaMouseClicked
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="private void DestinoMouseClicked(java.awt.event.MouseEvent evt">    
    private void DestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DestinoMouseClicked
        ListaPaquetes.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().verPaquetesOperador("destino");
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }//GEN-LAST:event_DestinoMouseClicked
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="private void CiudadMouseClicked(java.awt.event.MouseEvent evt)">    
    private void CiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CiudadMouseClicked
        ListaPaquetes.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().verPaquetesOperador("ciudad");
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }//GEN-LAST:event_CiudadMouseClicked
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="private void EstadoMouseClicked(java.awt.event.MouseEvent evt">    
    private void EstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstadoMouseClicked
        ListaPaquetes.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().verPaquetesOperador("estado");
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }//GEN-LAST:event_EstadoMouseClicked
    // </editor-fold> 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaVerPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVerPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVerPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVerPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaVerPaquetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ciudad;
    private javax.swing.JButton Destino;
    private javax.swing.JButton Estado;
    private javax.swing.JButton Fecha;
    private javax.swing.JList ListaPaquetes;
    private javax.swing.JPanel VerPaquetes;
    private javax.swing.JButton idPaquete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
