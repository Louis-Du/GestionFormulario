package com.mycompany.gestionformulario2;

import com.mycompany.gestionformulario2.iAdminEvento;
import javax.swing.JOptionPane;

/**
 * Interfaz gráfica de inicio de sesión del sistema.
 * Ventana principal que permite al usuario seleccionar su rol:
 * - Administrador de Eventos: Gestiona y crea eventos
 * - Invitado: Personas que asistirán a eventos (aprendices o externos)
 * Esta clase extiende JFrame para crear una ventana de aplicación de escritorio.
 */
public class iLogin extends javax.swing.JFrame {

    /**
     * Constructor que inicializa la ventana de login.
     * Configura los componentes visuales y maximiza la ventana.
     */
    public iLogin() {
        // Inicializa todos los componentes gráficos (botones, etiquetas, etc.)
        initComponents();
        // Maximiza la ventana para que ocupe toda la pantalla
        this.setExtendedState(iLogin.MAXIMIZED_BOTH);
        // Hace visible la ventana al usuario
        this.setVisible(true);
    }

    /**
     * Suprime advertencias del compilador sobre operaciones no genéricas.
     * Este método fue generado automáticamente por el editor visual de NetBeans/IntelliJ.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /**
     * Método generado automáticamente que inicializa todos los componentes de la interfaz.
     * Configura botones, layouts, listeners y propiedades visuales.
     * NO MODIFICAR MANUALMENTE - Usar el editor visual para cambios.
     */
    private void initComponents() {

        btnAdminEvent = new javax.swing.JButton();
        btnInvitado = new javax.swing.JButton();
        btnSalir = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdminEvent.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnAdminEvent.setText("Administrador de Eventos");
        btnAdminEvent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminEventActionPerformed(evt);
            }
        });

        btnInvitado.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnInvitado.setText("Invitado");
        btnInvitado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvitadoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdminEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInvitado, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdminEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInvitado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método llamado cuando se presiona el botón "Invitado".
     * Abre el formulario de registro para invitados (por implementar).
     */
    private void btnInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvitadoActionPerformed
        // TODO: Implementar apertura de formulario único para invitados
        JOptionPane.showMessageDialog(this, 
            "Formulario de invitado en desarrollo",
            "Información",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInvitadoActionPerformed

    /**
     * Método llamado cuando se presiona el botón "Administrador de Eventos".
     * Abre la ventana de administración de eventos y cierra la ventana actual.
     */
    private void btnAdminEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEventActionPerformed
        // Crea una nueva instancia de la ventana de administración de eventos
        iAdminEvento iAdminEvents = new iAdminEvento();
        // Muestra la ventana de administración
        iAdminEvents.setVisible(true);
        // Oculta la ventana de login actual
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminEventActionPerformed



    /**
     * Método llamado cuando se presiona el botón "Salir".
     * Muestra un cuadro de diálogo de confirmación antes de cerrar la aplicación.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Muestra un cuadro de diálogo con opciones Sí/No
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Deseas salir del programa?",
            "Salir",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario confirma, termina la ejecución del programa
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Método principal para ejecutar la aplicación de forma independiente.
     * Utiliza el Event Dispatch Thread (EDT) de Swing para crear la interfaz de forma segura.
     */
    public static void main(String args[]) {

        // invokeLater asegura que la interfaz se cree en el hilo correcto de Swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crea y muestra la ventana de login
                new iLogin().setVisible(true);
            }
        });
    }

    // Declaración de variables de componentes - NO MODIFICAR MANUALMENTE//GEN-BEGIN:variables
    // Estas variables representan los componentes visuales de la interfaz
    private javax.swing.JButton btnAdminEvent;      // Botón para acceder como administrador
    private javax.swing.JButton btnInvitado;        // Botón para acceder como invitado
    private javax.swing.JToggleButton btnSalir;     // Botón para salir de la aplicación
    // Fin de la declaración de variables//GEN-END:variables
}
