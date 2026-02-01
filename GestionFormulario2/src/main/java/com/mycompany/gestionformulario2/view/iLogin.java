package com.mycompany.gestionformulario2.view;

// Importación de la clase iAdminEvento del mismo paquete
import com.mycompany.gestionformulario2.view.iAdminEvento;
// Importación de JOptionPane de javax.swing para mostrar cuadros de diálogo
import javax.swing.JOptionPane;

public class iLogin extends javax.swing.JFrame {

  public iLogin() {
    initComponents();

    this.setExtendedState(iLogin.MAXIMIZED_BOTH);
    this.setVisible(true);
  }

  /**
   * Suprime advertencias del compilador sobre operaciones no genéricas.
   * Este método fue generado automáticamente por el editor visual de
   * NetBeans/IntelliJ.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents

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
                            .addComponent(btnAdminEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInvitado, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdminEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInvitado, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnInvitadoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInvitadoActionPerformed

    iInvitado ventanaInvitado = new iInvitado();

    ventanaInvitado.setVisible(true);

    this.dispose();
  }// GEN-LAST:event_btnInvitadoActionPerformed

  private void btnAdminEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdminEventActionPerformed
    iAdminEvento iAdminEvents = new iAdminEvento();

    iAdminEvents.setVisible(true);
    this.dispose();
  }// GEN-LAST:event_btnAdminEventActionPerformed

  private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed

    int opcion = JOptionPane.showConfirmDialog(
        this, // Componente padre (esta ventana)
        "¿Deseas salir del programa?", // Mensaje a mostrar
        "Salir", // Título del cuadro de diálogo
        JOptionPane.YES_NO_OPTION, // Tipo de botones (Sí/No)
        JOptionPane.QUESTION_MESSAGE // Icono de pregunta
    );

    if (opcion == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }// GEN-LAST:event_btnSalirActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new iLogin().setVisible(true);
      }
    });
  }

  private javax.swing.JButton btnAdminEvent;

  private javax.swing.JButton btnInvitado;

  private javax.swing.JToggleButton btnSalir;

}
