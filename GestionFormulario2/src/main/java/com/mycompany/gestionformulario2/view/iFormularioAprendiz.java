/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestionformulario2.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.mycompany.gestionformulario2.model.Registro;
import com.mycompany.gestionformulario2.service.GestorEventos;
import com.mycompany.gestionformulario2.service.GestorRegistros;

/**
 *
 * @author lukas
 */
public class iFormularioAprendiz extends javax.swing.JFrame {

  private static final java.util.logging.Logger logger = java.util.logging.Logger
      .getLogger(iFormularioAprendiz.class.getName());

  /**
   * Creates new form iFormularioAprendiz
   */
  public iFormularioAprendiz() {
    initComponents();

    // --- Configuración de la ventana ---
    setTitle("Formulario del Aprendiz");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    // --- VALIDACIÓN 1: Restringir Ficha a solo números ---
    txtFicha.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        // Si no es dígito y no es backspace, lo borramos (consumimos el evento)
        if (!Character.isDigit(c) && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this, "Solo se permiten números en el campo Ficha.",
              "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });

    // --- VALIDACIÓN 2: Restringir Celular a solo números ---
    txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this, "Solo se permiten números en el campo Celular.",
              "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });

    // (Opcional) También deberías hacer lo mismo para txtNumdocum si es solo
    // numérico
    txtNumdocum.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this,
              "Solo se permiten números en el campo Número de Documento.", "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });

    // --- VALIDACIÓN 3: Restringir Nombre y Apellido a solo letras y espacios ---
    txtNomapren.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this,
              "Solo se permiten letras y espacios en el campo Nombre y Apellido.", "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });

    // --- VALIDACIÓN 4: Restringir Programa a solo letras y espacios ---
    txtPrograma.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this,
              "Solo se permiten letras y espacios en el campo Programa.", "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });

    // --- VALIDACIÓN 5: Restringir Centro a solo letras y espacios ---
    txtCentro.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this,
              "Solo se permiten letras y espacios en el campo Centro.", "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });

    // --- VALIDACIÓN 6: Restringir Correo a letras, espacios, @ y . (básico) ---
    txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
      @Override
      public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '@' && c != '.' && c != '\b') {
          JOptionPane.showMessageDialog(iFormularioAprendiz.this,
              "Solo se permiten letras, espacios, @ y . en el campo Correo.", "Error", JOptionPane.ERROR_MESSAGE);
          evt.consume();
        }
      }
    });
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    txtNumdocum = new javax.swing.JTextField();
    txtPrograma = new javax.swing.JTextField();
    txtFicha = new javax.swing.JTextField();
    txtCentro = new javax.swing.JTextField();
    txtCelular = new javax.swing.JTextField();
    txtCorreo = new javax.swing.JTextField();
    cbTipodocum = new javax.swing.JComboBox<>();
    txtNomapren = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Nombre del aprendiz");

    jLabel2.setText("Tipo de documento");

    jLabel3.setText("Número de documento");

    jLabel4.setText("Programa de formación");

    jLabel5.setText("Ficha");

    jLabel6.setText("Centro");

    jLabel7.setText("Celular");

    jLabel8.setText("Correo");

    txtNumdocum.setMinimumSize(new java.awt.Dimension(20, 20));
    txtNumdocum.setPreferredSize(new java.awt.Dimension(50, 25));
    txtNumdocum.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtNumdocumActionPerformed(evt);
      }
    });

    txtPrograma.setMinimumSize(new java.awt.Dimension(20, 20));
    txtPrograma.setPreferredSize(new java.awt.Dimension(50, 25));
    txtPrograma.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtProgramaActionPerformed(evt);
      }
    });

    txtFicha.setMinimumSize(new java.awt.Dimension(20, 20));
    txtFicha.setPreferredSize(new java.awt.Dimension(50, 25));
    txtFicha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtFichaActionPerformed(evt);
      }
    });

    txtCentro.setMinimumSize(new java.awt.Dimension(20, 20));
    txtCentro.setPreferredSize(new java.awt.Dimension(50, 25));
    txtCentro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtCentroActionPerformed(evt);
      }
    });

    txtCelular.setMinimumSize(new java.awt.Dimension(20, 20));
    txtCelular.setPreferredSize(new java.awt.Dimension(50, 25));
    txtCelular.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtCelularActionPerformed(evt);
      }
    });

    txtCorreo.setMinimumSize(new java.awt.Dimension(20, 20));
    txtCorreo.setPreferredSize(new java.awt.Dimension(50, 25));
    txtCorreo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtCorreoActionPerformed(evt);
      }
    });

    cbTipodocum.setEditable(true);
    cbTipodocum.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[] { "Cédula de Ciudadania", "Tarjeta de Identidad", "Cédula de Extranjería" }));
    cbTipodocum.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbTipodocumActionPerformed(evt);
      }
    });

    txtNomapren.setMinimumSize(new java.awt.Dimension(20, 20));
    txtNomapren.setPreferredSize(new java.awt.Dimension(50, 25));
    txtNomapren.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtNomaprenActionPerformed(evt);
      }
    });

    jButton1.setText("Registrarse");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addComponent(jLabel8)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNumdocum, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrograma, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCentro, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(15, 15, 15))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbTipodocum, 0, 162, Short.MAX_VALUE)
                                .addComponent(txtNomapren, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButton1)))
                .addContainerGap(96, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomapren, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipodocum, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumdocum, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCentro, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(140, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void txtNomaprenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomaprenActionPerformed
  }// GEN-LAST:event_txtNomaprenActionPerformed

  private void txtNumdocumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNumdocumActionPerformed
  }// GEN-LAST:event_txtNumdocumActionPerformed

  private void cbTipodocumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbTipodocumActionPerformed

  }// GEN-LAST:event_cbTipodocumActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    // 1. Obtener los textos de los campos y quitar espacios en blanco (trim)
    String tipoVisitante = "Aprendiz"; // Por defecto, ya que es un formulario de aprendiz
    String nombre = txtNomapren.getText().trim();
    String apellidos = ""; // Campo vacío por ahora (se puede agregar al formulario después)
    String tipoDocumento = (String) cbTipodocum.getSelectedItem();
    String numDoc = txtNumdocum.getText().trim();
    String programa = txtPrograma.getText().trim();
    String ficha = txtFicha.getText().trim();
    String centro = txtCentro.getText().trim();
    String celular = txtCelular.getText().trim();
    String correo = txtCorreo.getText().trim();

    // 2. Verificar si ALGUNO está vacío
    if (nombre.isEmpty() || numDoc.isEmpty() || programa.isEmpty() ||
        ficha.isEmpty() || centro.isEmpty() || celular.isEmpty() || correo.isEmpty()) {

      // Mostrar mensaje de error
      JOptionPane.showMessageDialog(this,
          "Por favor, rellene todos los campos.",
          "Error de Validación",
          JOptionPane.ERROR_MESSAGE);

      // **SOLUCIÓN PARA EL FOCO/BLOQUEO:**
      // Devolver el foco al primer campo para que el usuario pueda escribir
      txtNomapren.requestFocusInWindow();

      return; // Detiene la ejecución, no sigue registrando
    }
    // 3. (Opcional) Validaciones extra
    // Aunque ya bloqueamos las letras con el KeyListener, es bueno tener doble
    // seguridad
    if (!celular.matches("[0-9]+")) {
      JOptionPane.showMessageDialog(this, "El celular solo debe contener números.");
      return;
    }

    // Validación del correo electrónico
    if (!correo.contains("@") || !correo.contains(".")) {
      JOptionPane.showMessageDialog(this, "Ingrese un correo electrónico válido.");
      return;
    }

    // 4. Si pasa todas las validaciones, crear el registro
    try {
      // Obtener el nombre del evento activo
      String nombreEvento = "";
      if (GestorEventos.getEventoActivo() != null) {
        nombreEvento = GestorEventos.getEventoActivo().getNombre();
      }

      // Obtener fecha y hora actual
      String fechaHoraActual = java.time.LocalDateTime.now()
          .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

      // Crear nuevo registro con todos los datos
      Registro nuevoRegistro = new Registro(
          tipoVisitante,
          nombre,
          apellidos,
          tipoDocumento,
          numDoc,
          programa,
          ficha,
          centro,
          celular,
          correo,
          nombreEvento,
          fechaHoraActual,
          "Registrado");

      // Agregar el registro al gestor
      GestorRegistros.agregarRegistro(nuevoRegistro);

      // Mostrar mensaje de éxito
      JOptionPane.showMessageDialog(this,
          "¡Registro Exitoso!\nAprendiz: " + nombre,
          "Éxito",
          JOptionPane.INFORMATION_MESSAGE);

      // Limpiar los campos del formulario
      txtNomapren.setText("");
      txtNumdocum.setText("");
      txtPrograma.setText("");
      txtFicha.setText("");
      txtCentro.setText("");
      txtCelular.setText("");
      txtCorreo.setText("");
      cbTipodocum.setSelectedIndex(0);

      // Cerrar la ventana
      this.dispose();

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this,
          "Error al guardar el registro: " + e.getMessage(),
          "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }// GEN-LAST:event_jButton1ActionPerformed

  private void txtProgramaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtProgramaActionPerformed
  }// GEN-LAST:event_txtProgramaActionPerformed

  private void txtFichaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFichaActionPerformed
  }// GEN-LAST:event_txtFichaActionPerformed

  private void txtCentroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCentroActionPerformed
  }// GEN-LAST:event_txtCentroActionPerformed

  private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCelularActionPerformed
  }// GEN-LAST:event_txtCelularActionPerformed

  private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCorreoActionPerformed
  }// GEN-LAST:event_txtCorreoActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default
     * look and feel.
     * For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
      logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> new iFormularioAprendiz().setVisible(true));
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> cbTipodocum;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JTextField txtCelular;
  private javax.swing.JTextField txtCentro;
  private javax.swing.JTextField txtCorreo;
  private javax.swing.JTextField txtFicha;
  private javax.swing.JTextField txtNomapren;
  private javax.swing.JTextField txtNumdocum;
  private javax.swing.JTextField txtPrograma;
  // End of variables declaration//GEN-END:variables

}
