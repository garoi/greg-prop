package Presentacion;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaSeleccionTurno extends javax.swing.JFrame {
    private CtrlPresentacion ctrlp;
    private int dia;
    private int mes;
    private int ano;
    private String turno;
    private int diaahora;
    private int mesahora;
    private int anoahora;
    private String turnoahora;
    
    /**
     * Creates new form VistaSeleccionTurno
     */
    public VistaSeleccionTurno() {
        initComponents();
    }

    VistaSeleccionTurno(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        initComponents();
        
        String[] data = ctrlp.getFechaAhora();
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelMes1 = new javax.swing.JLabel();
        labelMes = new javax.swing.JLabel();
        labelAno = new javax.swing.JLabel();
        labelDia = new javax.swing.JLabel();
        btnMenosDia = new javax.swing.JButton();
        btnMasAno = new javax.swing.JButton();
        btnMasMes = new javax.swing.JButton();
        btnMasDia = new javax.swing.JButton();
        btnToggleTurno = new javax.swing.JButton();
        labelMes2 = new javax.swing.JLabel();
        labelTurno = new javax.swing.JLabel();
        btnMenosAno = new javax.swing.JButton();
        btnMenosMes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelMes1.setText("/");

        labelMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMes.setText("01");

        labelAno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAno.setText("01");

        labelDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDia.setText("01");

        btnMenosDia.setBackground(new java.awt.Color(75, 75, 75));
        btnMenosDia.setForeground(new java.awt.Color(220, 220, 220));
        btnMenosDia.setText("v");
        btnMenosDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosDiaActionPerformed(evt);
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

        btnMasMes.setBackground(new java.awt.Color(75, 75, 75));
        btnMasMes.setForeground(new java.awt.Color(220, 220, 220));
        btnMasMes.setText("^");
        btnMasMes.setToolTipText("");
        btnMasMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasMesActionPerformed(evt);
            }
        });

        btnMasDia.setBackground(new java.awt.Color(75, 75, 75));
        btnMasDia.setForeground(new java.awt.Color(220, 220, 220));
        btnMasDia.setText("^");
        btnMasDia.setToolTipText("");
        btnMasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasDiaActionPerformed(evt);
            }
        });

        btnToggleTurno.setBackground(new java.awt.Color(75, 75, 75));
        btnToggleTurno.setForeground(new java.awt.Color(220, 220, 220));
        btnToggleTurno.setText("*");
        btnToggleTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleTurnoActionPerformed(evt);
            }
        });

        labelMes2.setText("/");

        labelTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTurno.setText("M");
        labelTurno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnMenosAno.setBackground(new java.awt.Color(75, 75, 75));
        btnMenosAno.setForeground(new java.awt.Color(220, 220, 220));
        btnMenosAno.setText("v");
        btnMenosAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosAnoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelDia)
                    .addComponent(btnMenosDia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMasDia))
                .addGap(2, 2, 2)
                .addComponent(labelMes1)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMenosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMes)
                    .addComponent(btnMasMes))
                .addGap(2, 2, 2)
                .addComponent(labelMes2)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMenosAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAno)
                    .addComponent(btnMasAno))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnToggleTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMasAno, btnMasDia, btnMasMes, btnMenosAno, btnMenosDia, btnMenosMes, btnToggleTurno, labelDia});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMasAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToggleTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenosDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton1.setBackground(new java.awt.Color(75, 75, 75));
        jButton1.setForeground(new java.awt.Color(220, 220, 220));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenosDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosDiaActionPerformed
        if (dia > 1)
        dia -= 1;
        String s = "";
        if (dia<10) s = "0";
        labelDia.setText(s + Integer.toString(dia));
    }//GEN-LAST:event_btnMenosDiaActionPerformed

    private void btnMasAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasAnoActionPerformed
        if (ano <= 99)
        ano += 1;
        String s = "";
        if (ano<10) s = "0";
        labelAno.setText(s + Integer.toString(ano));
    }//GEN-LAST:event_btnMasAnoActionPerformed

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

    private void btnToggleTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleTurnoActionPerformed
        if (turno.equals("T")){
            turno = "M";
        }
        else{
            turno = "T";
        }
        labelTurno.setText(turno);
    }//GEN-LAST:event_btnToggleTurnoActionPerformed

    private void btnMenosAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosAnoActionPerformed
        if (ano > 0)
        ano -= 1;
        String s = "";
        if (ano<10) s = "0";
        labelAno.setText(s + Integer.toString(ano));
    }//GEN-LAST:event_btnMenosAnoActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        ctrlp.actualizarDia(dia, mes, ano, turno);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSeleccionTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMasAno;
    private javax.swing.JButton btnMasDia;
    private javax.swing.JButton btnMasMes;
    private javax.swing.JButton btnMenosAno;
    private javax.swing.JButton btnMenosDia;
    private javax.swing.JButton btnMenosMes;
    private javax.swing.JButton btnToggleTurno;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelDia;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelMes1;
    private javax.swing.JLabel labelMes2;
    private javax.swing.JLabel labelTurno;
    // End of variables declaration//GEN-END:variables
}
