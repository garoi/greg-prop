/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.awt.MenuComponent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaMapa extends javax.swing.JFrame {
    CtrlPresentacion ctrlp;
    private int dia;
    private int mes;
    private int ano;
    private String turno;
    private String ciudad;
    private int diaahora;
    private int mesahora;
    private int anoahora;
    private String turnoahora;
    private String destino;
    
    /**
     * Creadora de la clase VistaMapa
     */
    public VistaMapa() {
        initComponents();
    }
    
    /**
     * Creadora de la clase VistaMapa
     */
    public VistaMapa(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        initComponents();
        
        // cogemos la fecha y horas del sistema
        String[] data = ctrlp.getDominio().fechaHoy();
        dia = Integer.parseInt(data[0]);
        mes = Integer.parseInt(data[1]);
        ano = Integer.parseInt(data[2]);
        turno = data[3];
        
        diaahora = dia;
        mesahora = mes;
        anoahora = ano;
        turnoahora = turno;
        
        // inicializamos las labels
        labelDia.setText(data[0]);
        labelMes.setText(data[1]);
        labelAno.setText(data[2]);
        labelTurno.setText(data[3]);
        
        // Cogemos las ciudades del sistema
        String [] ciudades = ctrlp.getDominio().getNombresCiudades();
        if (ciudades.length >0){
            try {
                ciudad = ciudades[0];
                // inicializamos el combobox de ciudad con la primera ciudad (por defecto)
                comboCiudad.setModel(new javax.swing.DefaultComboBoxModel(ciudades));
                
                // Cogemos los nombres de los destinos de la ciudad
                String[] destinos = ctrlp.getDominio().getDestinosCiudad(ciudad);
                // inicializamos el combobox de destino con los destinos
                comboDestino.setModel(new javax.swing.DefaultComboBoxModel(
//                    ctrlp.getDominio().getDestinosCiudad(ciudad)
                    destinos
                ));
                destino = destinos[0];
            } catch (IOException ex) {
                Logger.getLogger(VistaMapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        sidebar1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        comboDestino = new javax.swing.JComboBox();
        labelDia = new javax.swing.JLabel();
        labelMes = new javax.swing.JLabel();
        labelAno = new javax.swing.JLabel();
        btnMasDia = new javax.swing.JButton();
        btnMasMes = new javax.swing.JButton();
        btnMasAno = new javax.swing.JButton();
        btnMenosDia = new javax.swing.JButton();
        btnMenosMes = new javax.swing.JButton();
        btnMenosAno = new javax.swing.JButton();
        labelTurno = new javax.swing.JLabel();
        btnToggleTurno = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        comboCiudad = new javax.swing.JComboBox();
        labelMes1 = new javax.swing.JLabel();
        labelMes2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Añadir paquete", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Destino:");

        jLabel3.setText("Turno:");

        btnOk.setBackground(new java.awt.Color(75, 75, 75));
        btnOk.setForeground(new java.awt.Color(220, 220, 220));
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(75, 75, 75));
        btnCancel.setForeground(new java.awt.Color(220, 220, 220));
        btnCancel.setText("Cancel");

        comboDestino.setBackground(new java.awt.Color(75, 75, 75));
        comboDestino.setForeground(new java.awt.Color(220, 220, 220));
        comboDestino.setModel(new javax.swing.DefaultComboBoxModel(
            //ctrlp.getDominio().getDestinos();
            new String[] {"pene"}
        ));
        comboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDestinoActionPerformed(evt);
            }
        });

        labelDia.setText("01");

        labelMes.setText("01");

        labelAno.setText("01");

        btnMasDia.setBackground(new java.awt.Color(75, 75, 75));
        btnMasDia.setForeground(new java.awt.Color(220, 220, 220));
        btnMasDia.setText("^");
        btnMasDia.setToolTipText("");
        btnMasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasDiaActionPerformed(evt);
            }
        });

        btnMasMes.setBackground(new java.awt.Color(75, 75, 75));
        btnMasMes.setForeground(new java.awt.Color(220, 220, 220));
        btnMasMes.setText("^");
        btnMasMes.setToolTipText("");
        btnMasMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasMesActionPerformed(evt);
            }
        });

        btnMasAno.setBackground(new java.awt.Color(75, 75, 75));
        btnMasAno.setForeground(new java.awt.Color(220, 220, 220));
        btnMasAno.setText("^");
        btnMasAno.setToolTipText("");
        btnMasAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasAnoActionPerformed(evt);
            }
        });

        btnMenosDia.setBackground(new java.awt.Color(75, 75, 75));
        btnMenosDia.setForeground(new java.awt.Color(220, 220, 220));
        btnMenosDia.setText("v");
        btnMenosDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosDiaActionPerformed(evt);
            }
        });

        btnMenosMes.setBackground(new java.awt.Color(75, 75, 75));
        btnMenosMes.setForeground(new java.awt.Color(220, 220, 220));
        btnMenosMes.setText("v");
        btnMenosMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosMesActionPerformed(evt);
            }
        });

        btnMenosAno.setBackground(new java.awt.Color(75, 75, 75));
        btnMenosAno.setForeground(new java.awt.Color(220, 220, 220));
        btnMenosAno.setText("v");
        btnMenosAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosAnoActionPerformed(evt);
            }
        });

        labelTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTurno.setText("M");

        btnToggleTurno.setBackground(new java.awt.Color(75, 75, 75));
        btnToggleTurno.setForeground(new java.awt.Color(220, 220, 220));
        btnToggleTurno.setText("*");
        btnToggleTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleTurnoActionPerformed(evt);
            }
        });

        jLabel8.setText("Ciudad:");

        comboCiudad.setBackground(new java.awt.Color(75, 75, 75));
        comboCiudad.setForeground(new java.awt.Color(220, 220, 220));
        comboCiudad.setModel(new javax.swing.DefaultComboBoxModel(
            //ctrlp.getDominio().getDestinos();
            new String[] {"pene", "pene2"}
        ));
        comboCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCiudadActionPerformed(evt);
            }
        });

        labelMes1.setText("/");

        labelMes2.setText("/");

        javax.swing.GroupLayout sidebar1Layout = new javax.swing.GroupLayout(sidebar1);
        sidebar1.setLayout(sidebar1Layout);
        sidebar1Layout.setHorizontalGroup(
            sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebar1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMenosDia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDia)
                    .addComponent(btnMasDia))
                .addGap(2, 2, 2)
                .addComponent(labelMes1)
                .addGap(2, 2, 2)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMenosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMes)
                    .addComponent(btnMasMes))
                .addGap(2, 2, 2)
                .addComponent(labelMes2)
                .addGap(2, 2, 2)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMenosAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAno)
                    .addComponent(btnMasAno)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToggleTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(sidebar1Layout.createSequentialGroup()
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(sidebar1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel8))
                    .addGroup(sidebar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebar1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        sidebar1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMasAno, btnMasDia, btnMasMes, btnMenosAno, btnMenosDia, btnMenosMes, btnToggleTurno});

        sidebar1Layout.setVerticalGroup(
            sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMasAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToggleTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenosDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(212, 212, 212)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        sidebar1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancel, btnOk});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mapa de la ciudad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/611px-Complete_graph_K6.svg.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(663, 599));
        jLabel2.setMinimumSize(new java.awt.Dimension(663, 599));
        jLabel2.setPreferredSize(new java.awt.Dimension(663, 599));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidebar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidebar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Recoge la opción seleccionada del combox de ciudades.
     * El evento actualiza el combox de destinos.
     * @param evt el evento de click sobre el combox.
     */
    private void comboCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCiudadActionPerformed
        Object selectedItem = comboCiudad.getSelectedItem();
        if (selectedItem != null) ciudad = selectedItem.toString();
        try {
            comboDestino.setModel(new javax.swing.DefaultComboBoxModel(
                ctrlp.getDominio().getDestinosCiudad(ciudad)
            ));
        } catch (IOException ex) {
            Logger.getLogger(VistaMapa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboCiudadActionPerformed
    
    /**
     * Recoge la opción seleccionada del combox de destinos.
     * @param evt el evento de click sobre el combox.
     */
    private void comboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDestinoActionPerformed
        Object selectedItem = comboDestino.getSelectedItem();
        if (selectedItem != null) destino = selectedItem.toString();
    }//GEN-LAST:event_comboDestinoActionPerformed

    /**
     * Añade un evento cuando se hace click sobre el botón Ok.
     * El evento comprueba que todos los campos del formulario son válidos.
     * En ese caso añade el paquete al cliente.
     * @param evt el evento de click sobre el botón.
     */
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        boolean do_it = false;
        if (ano == anoahora){
            if (mes == mesahora){
                if (dia == diaahora)
                    if (turno.equals(turnoahora)) do_it = true;
                else if (dia > diaahora) do_it = true;
            }
            else if (mes > mesahora ) do_it = true;
        }
        else if (ano > anoahora) do_it = true;
        if (do_it){
            String fecha = Integer.toString(dia) + "." + Integer.toString(mes) + "." + Integer.toString(ano);
            try {
                ctrlp.getDominio().anadirPaquete(ciudad, destino, fecha, turno);
            } catch (IOException ex) {
                Logger.getLogger(VistaMapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnMasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasDiaActionPerformed
        int limit = 31;
        if (mes == 2) limit = 28;
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) limit = 30;
        if (dia < limit)
            dia += 1;
        String s = "";
        if (dia<10) s = "0";
        labelDia.setText(s + Integer.toString(dia));
    }//GEN-LAST:event_btnMasDiaActionPerformed

    private void btnMenosDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosDiaActionPerformed
        if (dia > 1)
            dia -= 1;
        String s = "";
        if (dia<10) s = "0";
        labelDia.setText(s + Integer.toString(dia));
    }//GEN-LAST:event_btnMenosDiaActionPerformed

    private void btnMasMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasMesActionPerformed
        if (mes <= 11){
            mes += 1;
            int limit = 31;
            if (mes == 2) limit = 28;
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) limit = 30;
            if (dia>limit){
                dia = limit;
                labelDia.setText(Integer.toString(dia));
            }
        }
        String s = "";
        if (mes<10) s = "0";
        labelMes.setText(s + Integer.toString(mes));
    }//GEN-LAST:event_btnMasMesActionPerformed

    private void btnMenosMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosMesActionPerformed
        if (mes > 1){
            mes -= 1;
            int limit = 31;
            if (mes == 2) limit = 28;
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) limit = 30;
            if (dia>limit){
                dia = limit;
                labelDia.setText(Integer.toString(dia));
            }
        }
        String s = "";
        if (mes<10) s = "0";
        labelMes.setText(s + Integer.toString(mes));
    }//GEN-LAST:event_btnMenosMesActionPerformed

    private void btnMasAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasAnoActionPerformed
        if (ano <= 99)
            ano += 1;
        String s = "";
        if (ano<10) s = "0";
        labelAno.setText(s + Integer.toString(ano));
    }//GEN-LAST:event_btnMasAnoActionPerformed

    private void btnMenosAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosAnoActionPerformed
        if (ano > 0)
            ano -= 1;
        String s = "";
        if (ano<10) s = "0";
        labelAno.setText(s + Integer.toString(ano));
    }//GEN-LAST:event_btnMenosAnoActionPerformed

    private void btnToggleTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleTurnoActionPerformed
        if (turno.equals("tarde")){
            turno = "manana";
        }
        else{
            turno = "tarde";
        }
        labelTurno.setText(turno);
    }//GEN-LAST:event_btnToggleTurnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMapa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnMasAno;
    private javax.swing.JButton btnMasDia;
    private javax.swing.JButton btnMasMes;
    private javax.swing.JButton btnMenosAno;
    private javax.swing.JButton btnMenosDia;
    private javax.swing.JButton btnMenosMes;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnToggleTurno;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboCiudad;
    private javax.swing.JComboBox comboDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelDia;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelMes1;
    private javax.swing.JLabel labelMes2;
    private javax.swing.JLabel labelTurno;
    private javax.swing.JPanel sidebar1;
    // End of variables declaration//GEN-END:variables

    javax.swing.JPanel getSidebar() {
        return sidebar1;
    }

    
}
