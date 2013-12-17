package Presentacion;

import java.awt.Container;
import javax.swing.SwingUtilities;
import Dominio.Cliente;
import Dominio.Operador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaLogin extends javax.swing.JFrame {
    private CtrlPresentacion ctrlp;
    private String modo;
    
    // Quitar en un futuro
    private String tipoUsuario;
    
    /**
     * Creates new form LoginVista
     */
    public VistaLogin() {
        this.modo = "login";
        initComponents();
    }
    
    public VistaLogin(CtrlPresentacion ctrlp, String usuario) {
        this.ctrlp = ctrlp;
        this.modo = "login";
        this.tipoUsuario = usuario;
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

        jPanel2 = new javax.swing.JPanel();
        fieldUsuario = new javax.swing.JTextField();
        fieldContrasena = new javax.swing.JPasswordField();
        labelContrasena = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 200));
        setPreferredSize(new java.awt.Dimension(350, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setMinimumSize(new java.awt.Dimension(325, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(325, 200));

        fieldContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContrasenaActionPerformed(evt);
            }
        });

        labelContrasena.setText("Contraseña:");

        labelUsuario.setText("Usuario:");

        btnLogin.setBackground(new java.awt.Color(75, 75, 75));
        btnLogin.setForeground(new java.awt.Color(220, 220, 220));
        btnLogin.setText("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(75, 75, 75));
        btnRegistro.setForeground(new java.awt.Color(220, 220, 220));
        btnRegistro.setText("Registro");
        btnRegistro.setFocusPainted(false);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelContrasena, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(fieldContrasena, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLogin, btnRegistro});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fieldContrasena, fieldUsuario});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContrasenaActionPerformed
        
    }//GEN-LAST:event_fieldContrasenaActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed

        System.out.println(modo);
        if (modo=="registro"){
            String usuario = fieldUsuario.getText();
            boolean correcto = true;
            if(usuario.isEmpty() || usuario.contains(" ")){
                fieldUsuario.setText("Por favor introduce un nombre válido");
                correcto = false;
            }
            usuario = fieldUsuario.getText();
            String contrasena = new String(fieldContrasena.getPassword());
            if(contrasena.isEmpty()){
                fieldContrasena.setText("Por favor introduce una contraseña válida");
                correcto = false;
            }
            contrasena = new String(fieldContrasena.getPassword());
            // if campos validos switch modo
            if(tipoUsuario=="Cliente") ctrlp.registroCliente(usuario, contrasena);
            else if(tipoUsuario=="Operador")ctrlp.registroOperador(usuario, contrasena);
            else System.out.println("Invalid class init call");
            this.cambiarModo();
            // else formatear campos y volver a probar
        }
        else{
            this.cambiarModo();
        }
        jPanel2.repaint();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO loguear para operador o para usuario
        
        String usuario = fieldUsuario.getText();
        while(usuario.isEmpty() || usuario.contains(" ")) usuario = fieldUsuario.getText();
        String contrasena = new String(fieldContrasena.getPassword());
        while(contrasena.isEmpty()) contrasena = new String(fieldContrasena.getPassword());
        if(tipoUsuario == "Cliente" && ctrlp.loginCliente(usuario, contrasena))
            ctrlp.setVentanaPrincipal("vistaCliente");
        else{
            if (ctrlp.loginOperador(usuario, contrasena)) 
            ctrlp.setVentanaPrincipal("vistaOperador");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables

    private void cambiarModo(){
        fieldUsuario.setText("");
        fieldContrasena.setText("");
        if (modo=="login"){
            jPanel2.remove(btnLogin);
            modo="registro";
        }
        else if(modo=="registro"){
            modo="login";
            jPanel2.add(btnLogin);
        }
        String output = modo.substring(0, 1).toUpperCase()+modo.substring(1);
        this.setTitle(output);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, output, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    }

}
