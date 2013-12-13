/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel Rierola Mora
 */
public class VistaClientePrincipal extends javax.swing.JFrame {
    public CtrlPresentacion ctrlp;
       
    /**
     * Creadora de la clase VistaClientePrincipal.
     */
    public VistaClientePrincipal() {
        initComponents();
    }
    
    /**
     * Creadora de la clase VistaClientePrincipal.
     */
    public VistaClientePrincipal(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        this.setTitle("Cliente");
        initComponents();
        final String[] enviados = ctrlp.getDominio().getPaquetesEnviados();
        
        listaEnviados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = enviados;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
        final String[] espera = ctrlp.getDominio().getPaquetesEspera();
        
        listaEspera.setModel(new javax.swing.AbstractListModel() {
            String[] strings = espera;
            public int getSize() { return strings.length; }
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

        panelEspera = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEspera = new javax.swing.JList();
        panelEnviados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEnviados = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        botonAnadir = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonEliminar1 = new javax.swing.JButton();
        botonEliminar2 = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(806, 561));

        panelEspera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paquetes en espera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(75, 75, 75)));
        panelEspera.setMinimumSize(new java.awt.Dimension(300, 500));
        panelEspera.setPreferredSize(new java.awt.Dimension(300, 500));

        listaEspera.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaEspera);

        javax.swing.GroupLayout panelEsperaLayout = new javax.swing.GroupLayout(panelEspera);
        panelEspera.setLayout(panelEsperaLayout);
        panelEsperaLayout.setHorizontalGroup(
            panelEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );
        panelEsperaLayout.setVerticalGroup(
            panelEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        panelEnviados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paquetes enviados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(75, 75, 75)));
        panelEnviados.setMinimumSize(new java.awt.Dimension(300, 500));
        panelEnviados.setPreferredSize(new java.awt.Dimension(300, 500));

        listaEnviados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaEnviados);

        javax.swing.GroupLayout panelEnviadosLayout = new javax.swing.GroupLayout(panelEnviados);
        panelEnviados.setLayout(panelEnviadosLayout);
        panelEnviadosLayout.setHorizontalGroup(
            panelEnviadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );
        panelEnviadosLayout.setVerticalGroup(
            panelEnviadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(75, 75, 75)));
        jPanel3.setMinimumSize(new java.awt.Dimension(113, 170));

        botonAnadir.setBackground(new java.awt.Color(75, 75, 75));
        botonAnadir.setForeground(new java.awt.Color(220, 220, 220));
        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(75, 75, 75));
        botonCancelar.setForeground(new java.awt.Color(220, 220, 220));
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(75, 75, 75));
        botonEliminar.setForeground(new java.awt.Color(220, 220, 220));
        botonEliminar.setText("Eliminar todos");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonEliminar1.setBackground(new java.awt.Color(75, 75, 75));
        botonEliminar1.setForeground(new java.awt.Color(220, 220, 220));
        botonEliminar1.setText("Cancelar todos");
        botonEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminar1MouseClicked(evt);
            }
        });
        botonEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminar1ActionPerformed(evt);
            }
        });

        botonEliminar2.setBackground(new java.awt.Color(75, 75, 75));
        botonEliminar2.setForeground(new java.awt.Color(220, 220, 220));
        botonEliminar2.setText("Eliminar");
        botonEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminar2ActionPerformed(evt);
            }
        });

        btnAyuda.setText("?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnAyuda)))
                .addGap(2, 2, 2))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAnadir, botonCancelar, botonEliminar, botonEliminar1, botonEliminar2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnAyuda)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonAnadir, botonCancelar, botonEliminar, botonEliminar1, botonEliminar2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(panelEspera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEnviados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEnviados, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEspera, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Añade un evento cuando se hace click sobre el botón Añadir.
     * El evento muestra una ventana para añadir un paquete y seleccionar el turno y destino.
     * @param evt el evento de click sobre el botón.
     */
    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        ctrlp.iniVentanaSecundaria("añadirPaquete");
    }//GEN-LAST:event_botonAnadirActionPerformed

    /**
     * Añade un evento cuando se hace click sobre el botón Eliminar.
     * El evento limpia la lista de paquetes enviados del cliente.
     * @param evt el evento de click sobre el botón.
     */
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // Limpiamos la lista de paquetes enviados
        listaEnviados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        // eliminar paquetes enviados del cliente
        ctrlp.getDominio().eliminarPaquetes();
        
    }//GEN-LAST:event_botonEliminarActionPerformed

    /**
     * Añade un evento cuando se hace click sobre el botón Cancelar.
     * El evento elimina el paquete seleccionado de la lista de paquetes pendientes del cliente.
     * @param evt el evento de click sobre el botón.
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        int idx = listaEspera.getSelectedIndex();      
        String name = (String) listaEspera.getSelectedValue();
        String idPaquete = name.substring(name.lastIndexOf('-') + 1);
        try {
            ctrlp.getDominio().cancelarPaquete(Integer.parseInt(idPaquete));
        } catch (IOException ex) {
            Logger.getLogger(VistaClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarlista();

    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminar1ActionPerformed

    private void botonEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminar1MouseClicked
        String[] listaPendientes = ctrlp.getDominio().getPaquetesEspera();
        for (int i = 0; i < listaPendientes.length; ++i) {
            String idPaquete = listaPendientes[i].substring(listaPendientes[i].lastIndexOf('-') + 1);
            try {
                ctrlp.getDominio().cancelarPaquete(Integer.parseInt(idPaquete));
            } catch (IOException ex) {
                Logger.getLogger(VistaClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        actualizarlista();
    }//GEN-LAST:event_botonEliminar1MouseClicked

    private void botonEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminar2ActionPerformed
        int idx = listaEnviados.getSelectedIndex();      
        String name = (String) listaEnviados.getSelectedValue();
        String idPaquete = name.substring(name.lastIndexOf('-') + 1);
        try {
            ctrlp.getDominio().eliminarPaquete(Integer.parseInt(idPaquete));
        } catch (IOException ex) {
            Logger.getLogger(VistaClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarListaEnviados();
    }//GEN-LAST:event_botonEliminar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaClientePrincipal v = new VistaClientePrincipal();
                v.setLocationRelativeTo(null);
                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminar1;
    private javax.swing.JButton botonEliminar2;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaEnviados;
    private javax.swing.JList listaEspera;
    private javax.swing.JPanel panelEnviados;
    private javax.swing.JPanel panelEspera;
    // End of variables declaration//GEN-END:variables

    void actualizarlista() {
        listaEspera.setModel(new javax.swing.AbstractListModel() {
            String[] strings = ctrlp.getDominio().getPaquetesEspera();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }

    private void actualizarListaEnviados() {
        listaEnviados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = ctrlp.getDominio().getPaquetesEnviados();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }
}
