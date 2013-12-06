/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

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
        
        
        // BORRAR
        String[] paq = ctrlp.getDominio().getPaquetesEspera();
        System.out.println(paq.length);
        for (int i = 0; i < paq.length; i++) {
            System.out.println(paq[i]);
        }
        // BORRAR
        
        listaEnviados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = enviados;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
        final String[] espera = ctrlp.getDominio().getPaquetesEspera();
        
        // BORRAR
        System.out.println(espera.length);
        for (int i = 0; i < espera.length; i++) {
            System.out.println(espera[i]);
        }
        // BORRAR
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(806, 561));

        panelEspera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paquetes en espera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        panelEsperaLayout.setVerticalGroup(
            panelEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        panelEnviados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paquetes enviados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        panelEnviadosLayout.setVerticalGroup(
            panelEnviadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setMinimumSize(new java.awt.Dimension(113, 170));

        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(botonAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(botonAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(379, 379, 379))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(panelEspera, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEnviados, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEnviados, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEspera, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
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
        System.out.println(idx);
        listaEspera.remove(idx);
//        ctrlp.getDominio().cancelarPaquete(idx);
    }//GEN-LAST:event_botonCancelarActionPerformed

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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaEnviados;
    private javax.swing.JList listaEspera;
    private javax.swing.JPanel panelEnviados;
    private javax.swing.JPanel panelEspera;
    // End of variables declaration//GEN-END:variables
}
