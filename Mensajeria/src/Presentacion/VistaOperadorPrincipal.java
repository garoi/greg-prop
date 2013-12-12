/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class VistaOperadorPrincipal extends javax.swing.JFrame {
    CtrlPresentacion ctrlp;
    private String nombreCiudad;
    private String fecha;
    private String fechaCD;
    private String nombreRuta = new String();
    private String anadir;
    private String[] fechaHoy;
    private ArrayList<String> listaPendientesS;
    private ArrayList<String> listaEnRutaS = new ArrayList<String>();
        
    /**
     * Creates new form VistaOperadorPrincipal
     */
    public VistaOperadorPrincipal() {
        initComponents();
        
    }
    
    /**
     * Creates new form VistaOperadorPrincipal
     */
    public VistaOperadorPrincipal(final CtrlPresentacion ctrlp) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.ctrlp = ctrlp;
        initComponents();
        fechaHoy = ctrlp.getDominio().fechaHoy();
        fecha = fechaHoy[0] + '/' + fechaHoy[1] + '/' + fechaHoy[2];
        fechaCD = fechaHoy[0] + '.' + fechaHoy[1] + '.' + fechaHoy[2];
        if (fechaHoy[3].equals("M")) {
            fecha = fecha + "-" + "M";
            fechaCD = fechaCD + "-" + "M";
        }
        else {
            fecha = fecha + "-" + "T";
            fechaCD = fechaCD + "-" + "T";
        }
        labelTurno.setText(fecha);
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
        listaRutas = new javax.swing.JList();
        btnModificarRuta = new javax.swing.JButton();
        btnVerRuta = new javax.swing.JButton();
        btnValidarRuta = new javax.swing.JButton();
        btnEliminarRuta = new javax.swing.JButton();
        panelProximaRuta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEnRuta = new javax.swing.JList();
        accionesPanel = new javax.swing.JPanel();
        btnAnadirPaquete = new javax.swing.JButton();
        eliminarPaquete = new javax.swing.JButton();
        btnRutaRapida = new javax.swing.JButton();
        btnVerPaquetes = new javax.swing.JButton();
        btnRutaOptima = new javax.swing.JButton();
        panelMapa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        panelTurno = new javax.swing.JPanel();
        labelTurno = new javax.swing.JLabel();
        panelCiudad = new javax.swing.JPanel();
        labelCiudad = new javax.swing.JLabel();
        panelPendientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPendientes = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rutas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        listaRutas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaRutas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRutasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaRutas);

        btnModificarRuta.setBackground(new java.awt.Color(75, 75, 75));
        btnModificarRuta.setForeground(new java.awt.Color(220, 220, 220));
        btnModificarRuta.setText("Mod");

        btnVerRuta.setBackground(new java.awt.Color(75, 75, 75));
        btnVerRuta.setForeground(new java.awt.Color(220, 220, 220));
        btnVerRuta.setText("Ver");
        btnVerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRutaActionPerformed(evt);
            }
        });

        btnValidarRuta.setBackground(new java.awt.Color(75, 75, 75));
        btnValidarRuta.setForeground(new java.awt.Color(220, 220, 220));
        btnValidarRuta.setText("Validar");
        btnValidarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarRutaActionPerformed(evt);
            }
        });

        btnEliminarRuta.setBackground(new java.awt.Color(75, 75, 75));
        btnEliminarRuta.setForeground(new java.awt.Color(220, 220, 220));
        btnEliminarRuta.setText("Eliminar");
        btnEliminarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEliminarRuta, btnModificarRuta, btnValidarRuta, btnVerRuta});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModificarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnValidarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
        );

        panelProximaRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paquetes en la ruta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        listaEnRuta.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaEnRuta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaEnRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEnRutaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaEnRuta);

        javax.swing.GroupLayout panelProximaRutaLayout = new javax.swing.GroupLayout(panelProximaRuta);
        panelProximaRuta.setLayout(panelProximaRutaLayout);
        panelProximaRutaLayout.setHorizontalGroup(
            panelProximaRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        panelProximaRutaLayout.setVerticalGroup(
            panelProximaRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProximaRutaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        accionesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnAnadirPaquete.setBackground(new java.awt.Color(75, 75, 75));
        btnAnadirPaquete.setForeground(new java.awt.Color(220, 220, 220));
        btnAnadirPaquete.setText(">");
        btnAnadirPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirPaqueteActionPerformed(evt);
            }
        });

        eliminarPaquete.setBackground(new java.awt.Color(75, 75, 75));
        eliminarPaquete.setForeground(new java.awt.Color(220, 220, 220));
        eliminarPaquete.setText("<");
        eliminarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPaqueteActionPerformed(evt);
            }
        });

        btnRutaRapida.setBackground(new java.awt.Color(75, 75, 75));
        btnRutaRapida.setForeground(new java.awt.Color(220, 220, 220));
        btnRutaRapida.setText("Ruta rap.");
        btnRutaRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaRapidaActionPerformed(evt);
            }
        });

        btnVerPaquetes.setBackground(new java.awt.Color(75, 75, 75));
        btnVerPaquetes.setForeground(new java.awt.Color(220, 220, 220));
        btnVerPaquetes.setText("Ver PKT");
        btnVerPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPaquetesActionPerformed(evt);
            }
        });

        btnRutaOptima.setBackground(new java.awt.Color(75, 75, 75));
        btnRutaOptima.setForeground(new java.awt.Color(220, 220, 220));
        btnRutaOptima.setText("Ruta opt.");
        btnRutaOptima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaOptimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accionesPanelLayout = new javax.swing.GroupLayout(accionesPanel);
        accionesPanel.setLayout(accionesPanelLayout);
        accionesPanelLayout.setHorizontalGroup(
            accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnVerPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutaOptima, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnadirPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        accionesPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAnadirPaquete, btnRutaOptima, btnRutaRapida, btnVerPaquetes, eliminarPaquete});

        accionesPanelLayout.setVerticalGroup(
            accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnadirPaquete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(eliminarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRutaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRutaOptima, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        accionesPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAnadirPaquete, btnRutaOptima, btnRutaRapida, btnVerPaquetes, eliminarPaquete});

        panelMapa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mapa de la ciudad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMapaMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/611px-Complete_graph_K6_300x300.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(663, 599));
        jLabel2.setMinimumSize(new java.awt.Dimension(663, 599));
        jLabel2.setPreferredSize(new java.awt.Dimension(663, 599));

        javax.swing.GroupLayout panelMapaLayout = new javax.swing.GroupLayout(panelMapa);
        panelMapa.setLayout(panelMapaLayout);
        panelMapaLayout.setHorizontalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMapaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelMapaLayout.setVerticalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Más información", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        panelTurno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTurnoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelTurnoLayout = new javax.swing.GroupLayout(panelTurno);
        panelTurno.setLayout(panelTurnoLayout);
        panelTurnoLayout.setHorizontalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnoLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(labelTurno)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelTurnoLayout.setVerticalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTurnoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelTurno)
                .addContainerGap())
        );

        panelCiudad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciudad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCiudadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCiudadLayout = new javax.swing.GroupLayout(panelCiudad);
        panelCiudad.setLayout(panelCiudadLayout);
        panelCiudadLayout.setHorizontalGroup(
            panelCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCiudadLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(labelCiudad)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelCiudadLayout.setVerticalGroup(
            panelCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCiudadLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelCiudad)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTurno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelPendientes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paquetes pendientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        listaPendientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPendientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaPendientes);

        javax.swing.GroupLayout panelPendientesLayout = new javax.swing.GroupLayout(panelPendientes);
        panelPendientes.setLayout(panelPendientesLayout);
        panelPendientesLayout.setHorizontalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        panelPendientesLayout.setVerticalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProximaRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, panelInfo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accionesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProximaRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private boolean comprobar(int idx){
        int cont = 0;
        char[] charsRuta = nombreRuta.toCharArray();
        boolean encontrado = false;
        for(int i = 0; i < charsRuta.length && !encontrado; ++i){
            if(cont == 3){
                if(charsRuta[i+1] == 'v'){
                    return false;
                }
                else encontrado = true;
            }
            if(charsRuta[i] == '-'){
                ++cont;
            }
        }
        for(int i = 0; i < listaEnRutaS.size();++i){
            if(listaPendientesS.get(idx).equals(listaEnRutaS.get(i))){
                return false;
            }
        }
        return true;
    }
    private void btnAnadirPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirPaqueteActionPerformed
        int idx = listaPendientes.getSelectedIndex();
        anadir = (String) listaPendientes.getSelectedValue();
        boolean noverificada = checkVerificada();
        boolean cambio = comprobar(idx);
        if(cambio && noverificada){
            listaPendientesS.remove(idx);
            listaEnRutaS.add(anadir);
        }
        listaPendientesS =ctrlp.getDominio().getPaquetesPendientes(nombreCiudad, fechaCD);
        actualizarListaPendientes();
        actualizarListaEnRuta();
        

    }//GEN-LAST:event_btnAnadirPaqueteActionPerformed

    private void panelMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMapaMouseClicked
        // TODO add your handling code here:
        if (ctrlp != null) ctrlp.iniVentanaSecundaria("verDibujoCiudad");
    }//GEN-LAST:event_panelMapaMouseClicked

    private void panelTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTurnoMouseClicked
        if (ctrlp != null){
            ctrlp.iniVentanaSecundaria("vistaTurno");
            nombreRuta = new String();
        }
    }//GEN-LAST:event_panelTurnoMouseClicked

    private void panelCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCiudadMouseClicked
        if (ctrlp != null) ctrlp.iniVentanaSecundaria("vistaCiudad");
        nombreRuta = new String();
    }//GEN-LAST:event_panelCiudadMouseClicked

    private void listaRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRutasMouseClicked
        int idx = listaRutas.getSelectedIndex();      
        nombreRuta = (String) listaRutas.getSelectedValue();
        listaPendientesS = ctrlp.getDominio().getPaquetesPendientes(nombreCiudad, fechaCD);
        actualizarListaPendientes();
        try {
            mostrarPaquetesEnRuta();
        } catch (IOException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listaRutasMouseClicked

    
    private boolean checkVerificada(){
        int cont = 0;
        if(nombreRuta.isEmpty()) return true;
        char[] charsRuta = nombreRuta.toCharArray();
        boolean encontrado = false;
        for(int i = 0; i < charsRuta.length && !encontrado; ++i){
            if(cont == 3){
                if(charsRuta[i] == 'v'){
                    return false;
                }
                else encontrado = true;
            }
            if(charsRuta[i] == '-'){
                ++cont;
            }
        }
        return true;
    }
    private boolean compruebaEliminar(int idx){
            for(int i = 0; i < listaPendientesS.size(); ++i){
                if(listaEnRutaS.get(idx).equals(listaPendientesS.get(i))){
                    return false;
                }
            }
        return true;
    }
    private void eliminarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPaqueteActionPerformed
        int idx = listaEnRuta.getSelectedIndex();      
        anadir = (String) listaEnRuta.getSelectedValue();
        boolean noverificada = checkVerificada();
        boolean cambio = compruebaEliminar(idx);
        if(cambio && noverificada){
            listaEnRutaS.remove(idx);
            listaPendientesS.add(anadir);
        }
        actualizarListaPendientes();
        actualizarListaEnRuta();
    }//GEN-LAST:event_eliminarPaqueteActionPerformed

    private void listaPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPendientesMouseClicked
        if (evt.getClickCount() == 2) {
            int idx = listaPendientes.getSelectedIndex();      
            anadir = (String) listaPendientes.getSelectedValue();
            boolean cambio = comprobar(idx);
            boolean noverificada = checkVerificada();
            if(cambio && noverificada){
                listaPendientesS.remove(idx);
                listaEnRutaS.add(anadir);
            }
            actualizarListaPendientes();
            actualizarListaEnRuta();
        }
    }//GEN-LAST:event_listaPendientesMouseClicked

    private void listaEnRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEnRutaMouseClicked
        if (evt.getClickCount() == 2) {
            int idx = listaEnRuta.getSelectedIndex();      
            anadir = (String) listaEnRuta.getSelectedValue();
            boolean cambio = compruebaEliminar(idx);
            boolean noverificada = checkVerificada();
            if(cambio && noverificada){
                listaEnRutaS.remove(idx);
                listaPendientesS.add(anadir);
            }
            actualizarListaPendientes();
            actualizarListaEnRuta();
        }
    }//GEN-LAST:event_listaEnRutaMouseClicked

    private void btnRutaRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaRapidaActionPerformed
        try {
            ctrlp.getDominio().calcularRuta(listaEnRutaS, fechaCD, nombreCiudad, "rapidamente");
        } catch (IOException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarRutas();
    }//GEN-LAST:event_btnRutaRapidaActionPerformed

    private void btnRutaOptimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaOptimaActionPerformed
        try {
            ctrlp.getDominio().calcularRuta(listaEnRutaS, fechaCD, nombreCiudad, "lentamente");
        } catch (IOException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarRutas();
    }//GEN-LAST:event_btnRutaOptimaActionPerformed

    private void btnValidarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarRutaActionPerformed
        int idx = listaRutas.getSelectedIndex();      
        String ruta = (String) listaRutas.getSelectedValue();
        actualizarListaPendientes();
        try {
            ctrlp.getDominio().paquetesEnviados(nombreRuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ctrlp.getDominio().acceptarRuta(ruta, fechaCD, nombreCiudad);
        } catch (IOException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaOperadorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaPendientesS = ctrlp.getDominio().getPaquetesPendientes(nombreCiudad, fechaCD);
        actualizarListaPendientes();
        actualizarRutas();
    }//GEN-LAST:event_btnValidarRutaActionPerformed

    private void btnEliminarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRutaActionPerformed
        int idx = listaRutas.getSelectedIndex();      
        String ruta = (String) listaRutas.getSelectedValue();
        actualizarListaPendientes();
        ctrlp.getDominio().eliminarRuta(ruta);
        actualizarRutas();
        listaPendientesS = ctrlp.getDominio().getPaquetesPendientes(nombreCiudad, fechaCD);
        actualizarListaPendientes();
        nombreRuta = new String();
        listaEnRutaS.removeAll(listaEnRutaS);
        actualizarListaEnRuta();
    }//GEN-LAST:event_btnEliminarRutaActionPerformed

    private void btnVerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRutaActionPerformed
        ctrlp.iniVentanaSecundaria("vistaRuta");
    }//GEN-LAST:event_btnVerRutaActionPerformed

    private void btnVerPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPaquetesActionPerformed
        ctrlp.iniVentanaSecundaria("vistaPaquetes");
    }//GEN-LAST:event_btnVerPaquetesActionPerformed

    public void actualizarCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
        labelCiudad.setText(nombreCiudad);
        
    //LISTAS DE MIERDA!!!!!
        
        actualizarRutas();
        mostrarPaquetesTurno();
    }
    
    public void actualizarRutas() {
        listaRutas.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = ctrlp.getDominio().getRutas(nombreCiudad);
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }
    
    public void actualizarDia(int dia, int mes, int ano, String Turno) {
        String dia1, mes1, ano1;
        if (dia < 10) {
            dia1 = '0' + Integer.toString(dia);
        }
        else dia1 = Integer.toString(dia);
        if (mes < 10) {
            mes1 = '0' + Integer.toString(mes);
        }
        else mes1 = Integer.toString(mes);
        if (ano < 10) {
            ano1 = '0' + Integer.toString(ano);
        }
        else ano1 = Integer.toString(ano);
        fecha = dia1 + '/' + mes + '/' + ano;
        fechaCD = dia1 + '.' + mes + '.' + ano;
        if (Turno.equals("M")) {
            fecha = fecha + "-" + "M";
            fechaCD = fechaCD + "-" + "M";
        }
        else {
            fecha = fecha + "-" + "T";
            fechaCD = fechaCD + "-" + "T";
        }
        labelTurno.setText(fecha);
        mostrarPaquetesTurno();
    }
    
    private void mostrarPaquetesEnRuta() throws IOException, FileNotFoundException, ClassNotFoundException {
        listaEnRutaS = ctrlp.getDominio().getPaquetesRuta(nombreRuta);
        actualizarListaEnRuta();
    }
    
    private void mostrarPaquetesTurno() {
        listaPendientesS = ctrlp.getDominio().getPaquetesPendientes(nombreCiudad, fechaCD);
        actualizarListaPendientes();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaOperadorPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accionesPanel;
    private javax.swing.JButton btnAnadirPaquete;
    private javax.swing.JButton btnEliminarRuta;
    private javax.swing.JButton btnModificarRuta;
    private javax.swing.JButton btnRutaOptima;
    private javax.swing.JButton btnRutaRapida;
    private javax.swing.JButton btnValidarRuta;
    private javax.swing.JButton btnVerPaquetes;
    private javax.swing.JButton btnVerRuta;
    private javax.swing.JButton eliminarPaquete;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelCiudad;
    private javax.swing.JLabel labelTurno;
    private javax.swing.JList listaEnRuta;
    private javax.swing.JList listaPendientes;
    private javax.swing.JList listaRutas;
    private javax.swing.JPanel panelCiudad;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelMapa;
    private javax.swing.JPanel panelPendientes;
    private javax.swing.JPanel panelProximaRuta;
    private javax.swing.JPanel panelTurno;
    // End of variables declaration//GEN-END:variables

    private void actualizarListaPendientes() {
        listaPendientes.setModel(new javax.swing.AbstractListModel() {
                ArrayList<String> strings = listaPendientesS;
                public int getSize() { return strings.size(); }
                public Object getElementAt(int i) { return strings.get(i); }
            });
    }

    private void actualizarListaEnRuta() {
        listaEnRuta.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = listaEnRutaS;
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
    }

    public String getCiudad() {
        return nombreCiudad;
    }
}
