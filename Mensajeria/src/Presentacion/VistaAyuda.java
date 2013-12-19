/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author Luis
 */
public class VistaAyuda extends javax.swing.JFrame {
    CtrlPresentacion ctrlp;
    
    /**
     * Creates new form VistaAyuda
     */
    public VistaAyuda() {
        initComponents();
    }
    
    public VistaAyuda(CtrlPresentacion ctrlp) {
        this.ctrlp = ctrlp;
        initComponents();
        jTextArea1.setText("Este documento pretende ser una pequeña guía básica para los usuarios del programa.\n" +
"\n" +
"Primero nos centraremos en la interfície del cliente, y luego en la del \n" +
"operador que es un poco más compleja.\n" +
"\n" +
"Al ejecutar el programa la primera ventana que nos aparecerá será la de si el \n" +
"usuario que está utilizando el programa es un cliente o el operador, una vez \n" +
"escogidos tendremos que ingresar el nombre de usuario y la contraseña, el operador \n" +
"solo se puede registrar una vez, ya que solo hay uno, mientras que clientes pueden haber muchos.\n" +
"\n" +
"Cliente:\n" +
"\n" +
"En un primer momento al entrar como cliente se nos presenta una interfaz \n" +
"con 5 botones a la izquierda y dos listas, una que será la de los paquetes \n" +
"en espera (que aún no han sido enviados por el operador) y otra que \n" +
"será la de los paquetes enviados.\n" +
"\n" +
"Funcionalidades de los 5 botones del cliente:\n" +
"\n" +
"\n" +
"Añadir: Este boton sirve para añadir un paquete a la lista de espera. \n" +
"Al pulsar este boton nos aparecerá una nueva ventana en la que nos saldra el \n" +
"mapa de la ciudad ocupando más de la mitad de la ventana, y a la derecha las opciones, \n" +
"estas opciones son las que nos permiten dar de alta un paquete, de arriba abajo \n" +
"son los siguientes parametros, la ciudad a la que va el paquete, su destino dentro \n" +
"de esta ciudad y en que turno, por defecto el turno siempre estara inicializado como \n" +
"el turno actual en el que nos encontremos. Luego abajo tenemos dos botones, \n" +
"OK para verificar y CANCELAR para no añadir el paquete a la lista de paquetes en espera.\n" +
"\n" +
"Cancelar: Si seleccionamos un paquete de la lista de paquetes en espera \n" +
"y pulsamos en este boton, el paquete sera eliminado de la lista.\n" +
"\n" +
"Cancelar todos: Cancela todos lo paquetes que el cliente tenga en la lista de espera.\n" +
"\n" +
"Eliminar: Si seleccionamos un paquete de la lista de paquetes enviados \n" +
"y pulsamos en este boton, el paquete será eliminado de la lista.\n" +
"\n" +
"Eliminar todos: Elimina todos los paquetes que el cliente tenga \n" +
"en la lista de paquetes enviados.\n" +
"\n" +
"\n" +
"Operador:\n" +
"\n" +
"En un primer momento al entrar en la vista principal del operador nos \n" +
"encontramos con el espacio de ciudad vacio, y el turno por defecto va a \n" +
"ser el actual del dia en el que estemos y será tarde o mañana en función \n" +
"del rango horario en el que nos encontremos.\n" +
"\n" +
"Lo primero que debemos hacer es pulsar sobre el espacio debajo de donde \n" +
"pone “ciudad” para elegir la ciudad con la que queremos trabajar. \n" +
"Una vez pulsemos se nos abrirá una ventana emergente donde podremos \n" +
"elegir entre todas las ciudades que tengamos añadidas en el sistema, \n" +
"en esta misma ventana también podremos añadir una ciudad nueva o modificar una ciudad ya \n" +
"existente en el sistema. Si se añaden o modifican por fichero, aparecerá una pantalla \n" +
"preguntando si hemos terminado de modificar o añadir una ciudad, cuando terminemos de \n" +
"añadir o modificar, primero debemos guardar el fichero, y luego indicar al programa que hemos terminado.\n" +
"\n" +
"Cuando cargamos una ciudad en el programa, el apartado rutas se rellenará con \n" +
"todas las rutas que hayamos calculado para esta ciudad, ya sean verificadas o no, \n" +
"el campo paquetes pendientes también se rellenará con los paquetes que aún no se hayan enviado, \n" +
"todos los paquetes que salgan en la lista tendrán como ciudad la ciudad seleccionada.\n" +
"\n" +
"Cuando carguemos una ruta el campo de paquetes en la ruta se rellenará con los paquetes \n" +
"que haya para la ruta seleccionada, siempre y cuando la ruta no esté verificada \n" +
"se podrán añadir y quitar paquetes para calcular rutas nuevas.\n" +
"\n" +
"\n" +
"\n" +
"Turno: por defecto tendremos la fecha y el turno que corresponde al dia y hora actuales. \n" +
"Clicando sobre el podremos modificar la fecha y el turno (fechas posteriores) para poder calcular \n" +
"rutas de camion de otros turnos.\n" +
"\n" +
"\n" +
"Botones del apartado rutas:\n" +
"\n" +
"MOD: con una ruta seleccionada podemos modificar esta ruta, escogiendo puntos por los que queramos pasar.\n" +
"\n" +
"Validar: verifica una ruta que no esté verificada, de esta manera los paquetes que \n" +
"haya en la ruta cambian su estado a enviados.\n" +
"\n" +
"Ver: se abre una ventana emergente con los puntos por los que pasará una \n" +
"ruta seleccionada dentro de la ciudad.\n" +
"\n" +
"Comparar: ejecuta los distintos algoritmos y calcula las distancias totales.\n" +
"\n" +
"Eliminar: elimina la ruta seleccionada.\n" +
"\n" +
"\n" +
"\n" +
"Botones del apartado acciones:\n" +
"\n" +
"> : añade un paquete de la lista de paquetes pendientes a la lista de paquetes \n" +
"en ruta(con doble click sobre el paquete también se añade).\n" +
"\n" +
"< : Elimina un paquete de la lista de paquetes en ruta a la lista de \n" +
"pendientes(con doble click sobre el paquete también se elimina).\n" +
"\n" +
"Estas dos acciones se podrán llevar a cabo también sobre una ruta \n" +
"ya existente SÓLO SI LA RUTA NO ESTA VERIFICADA.\n" +
"\n" +
"Ruta rap. : Con este botón creamos una ruta con el algoritmo fácil (solvegreedy).\n" +
"\n" +
"Ruta rap.opt. : Con este botón creamos una ruta con el algoritmo fácil optimizado.\n" +
"\n" +
"Ruta opt : creamos una ruta con el algoritmo complejo.\n" +
"\n" +
"ver PKT: Se abre una ventana emergente donde podemos ver todos los paquetes que \n" +
"el operador tiene asignados. los podemos ordenar en función de cualquiera de sus parámetros.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(75, 75, 75));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Cerrar");
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
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(282, 282, 282))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAyuda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
