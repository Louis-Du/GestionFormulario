package com.mycompany.gestionformulario2.view;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.mycompany.gestionformulario2.model.Evento;
import com.mycompany.gestionformulario2.model.Registro;
import com.mycompany.gestionformulario2.service.GestorRegistros;

/**
 * Formulario único para registro de invitados (Aprendices y Personas Externas).
 * Permite capturar todos los datos necesarios para registrar la asistencia a un
 * evento.
 */
public class iFormularioInvitado extends javax.swing.JFrame {

  private Evento eventoSeleccionado;
  // Bandera para evitar cascada de mensajes
  private boolean mostrandoError = false;

  /**
   * Constructor que recibe el evento al cual se registrará el invitado.
   * 
   * @param evento Evento seleccionado desde iInvitado
   */
  public iFormularioInvitado(Evento evento) {
    this.eventoSeleccionado = evento;
    initComponents();
    this.setExtendedState(iFormularioInvitado.MAXIMIZED_BOTH);
    cargarDatosEvento();
    configurarValidacionTiempoReal();
  }

  /**
   * Carga los datos del evento en los campos de solo lectura.
   */
  private void cargarDatosEvento() {
    lblNombreEvento.setText(eventoSeleccionado.getNombre());
    lblFechaEvento.setText(eventoSeleccionado.getFechaHora());
    lblLugarEvento.setText(eventoSeleccionado.getLugar());
  }

  /**
   * Valida que el texto contenga solo letras y espacios.
   * Acepta caracteres acentuados.
   */
  private boolean esTextoValido(String texto) {
    if (texto == null || texto.trim().isEmpty())
      return false;
    return texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
  }

  /** Valida que el texto contenga solo números. */
  private boolean esNumeroValido(String texto) {
    if (texto == null || texto.trim().isEmpty())
      return false;
    return texto.matches("^[0-9]+$");
  }

  /** Celular: solo números y mínimo 10 dígitos. */
  private boolean esCelularValido(String celular) {
    if (celular == null || celular.trim().isEmpty())
      return false;
    if (!celular.matches("^[0-9]+$"))
      return false;
    return celular.length() >= 10;
  }

  /** Email con formato estándar. */
  private boolean esCorreoValido(String correo) {
    if (correo == null || correo.trim().isEmpty())
      return false;
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    return correo.matches(regex);
  }

  /**
   * Configura validación en tiempo real (al perder foco) para todos los campos.
   */
  private void configurarValidacionTiempoReal() {
    // TextFields
    agregarValidadorFocoTexto(txtNombre, "nombre", false);
    agregarValidadorFocoTexto(txtApellidos, "apellidos", false);
    agregarValidadorFocoTexto(txtNumeroDocumento, "número de documento", false);
    agregarValidadorFocoTexto(txtPrograma, "programa", false);
    agregarValidadorFocoTexto(txtFicha, "ficha", true); // Opcional
    agregarValidadorFocoTexto(txtCentro, "centro", false);
    agregarValidadorFocoTexto(txtCelular, "celular", false);
    agregarValidadorFocoTexto(txtCorreo, "correo", false);

    // ComboBox
    agregarValidadorFocoCombo(cmbTipoVisitante, "tipo de visitante");
    agregarValidadorFocoCombo(cmbTipoDocumento, "tipo de documento");

    // Acción inmediata opcional al cambiar selección
    agregarValidadorCombo(cmbTipoVisitante, "tipo de visitante");
    agregarValidadorCombo(cmbTipoDocumento, "tipo de documento");
  }

  /** Agrega validación por foco para JTextField. */
  private void agregarValidadorFocoTexto(JTextField campo, String nombreCampo, boolean esOpcional) {
    campo.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        // Evitar cascada de mensajes
        if (mostrandoError)
          return;
        // Validar al perder foco
        if (!validarCampo(campo, nombreCampo, esOpcional)) {
          mostrandoError = true;
          mostrarErrorCampo(campo, mensajeErrorParaCampo(campo, nombreCampo));
          mostrandoError = false;
        }
      }
    });
  }

  /** Agrega validación por foco para JComboBox. */
  private void agregarValidadorFocoCombo(JComboBox<String> combo, String nombreCampo) {
    combo.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        if (mostrandoError)
          return;
        if (combo.getSelectedIndex() == 0) {
          mostrandoError = true;
          mostrarErrorCampo(combo, "Debe seleccionar " + nombreCampo + ".");
          mostrandoError = false;
        }
      }
    });
  }

  /** Valida combo también al cambiar la selección. */
  private void agregarValidadorCombo(JComboBox<String> combo, String nombreCampo) {
    combo.addActionListener(e -> validarComboEnTiempoReal(combo, nombreCampo));
  }

  /** Valida un ComboBox en tiempo real. */
  private void validarComboEnTiempoReal(JComboBox<String> combo, String nombreCampo) {
    if (combo.getSelectedIndex() == 0) {
      if (!mostrandoError) {
        mostrandoError = true;
        combo.setBackground(new Color(255, 200, 200));
        JOptionPane.showMessageDialog(this,
            "Debe seleccionar " + nombreCampo + ".",
            "Error de validación",
            JOptionPane.WARNING_MESSAGE);
        mostrandoError = false;
      }
      combo.setSelectedIndex(0);
      combo.setBackground(Color.WHITE);
    } else {
      combo.setBackground(Color.WHITE);
    }
  }

  /** Muestra un error y devuelve el foco al componente. */
  private void mostrarErrorCampo(JComponent comp, String mensaje) {
    comp.setBackground(new Color(255, 200, 200));
    JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.WARNING_MESSAGE);
    comp.requestFocusInWindow();
    if (comp instanceof JTextField) {
      ((JTextField) comp).selectAll();
    }
    comp.setBackground(Color.WHITE);
  }

  /** Valida un campo sin mostrar mensajes. */
  private boolean validarCampo(JTextField campo, String nombreCampo, boolean esOpcional) {
    String texto = campo.getText().trim();
    if (esOpcional && texto.isEmpty())
      return true;
    switch (nombreCampo.toLowerCase()) {
      case "nombre":
      case "apellidos":
        return esTextoValido(texto);
      case "número de documento":
        return esNumeroValido(texto);
      case "celular":
        return esCelularValido(texto);
      case "correo":
        return esCorreoValido(texto);
      case "programa":
      case "centro":
        return !texto.isEmpty();
      case "ficha":
        return true; // opcional
      default:
        return true;
    }
  }

  /** Mensaje de error específico para cada campo. */
  private String mensajeErrorParaCampo(JTextField campo, String nombreCampo) {
    String texto = campo.getText().trim();
    switch (nombreCampo.toLowerCase()) {
      case "nombre":
        return "El nombre debe contener solo letras y espacios.";
      case "apellidos":
        return "Los apellidos deben contener solo letras y espacios.";
      case "número de documento":
        return "El número de documento debe contener solo números.";
      case "celular":
        if (texto.isEmpty())
          return "El celular es requerido.";
        if (!texto.matches("^[0-9]+$"))
          return "El celular debe contener solo números.";
        return "El celular debe tener mínimo 10 dígitos.";
      case "correo":
        return "El correo electrónico tiene un formato inválido.";
      case "programa":
        return "Debe ingresar el programa de formación.";
      case "centro":
        return "Debe ingresar el centro.";
      default:
        return "Campo inválido.";
    }
  }

  /**
   * Valida que todos los campos del formulario cumplan las reglas de validación.
   * 
   * @return true si todos los campos son válidos, false en caso contrario
   */
  private boolean validarCampos() {
    // Validar tipo de visitante
    if (cmbTipoVisitante.getSelectedIndex() == 0) {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de visitante", "Campo requerido",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar nombre
    String nombre = txtNombre.getText().trim();
    if (!esTextoValido(nombre)) {
      JOptionPane.showMessageDialog(this, "El nombre debe contener solo letras y espacios", "Nombre inválido",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar apellidos
    String apellidos = txtApellidos.getText().trim();
    if (!esTextoValido(apellidos)) {
      JOptionPane.showMessageDialog(this, "Los apellidos deben contener solo letras y espacios", "Apellidos inválidos",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar tipo de documento
    if (cmbTipoDocumento.getSelectedIndex() == 0) {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "Campo requerido",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar número de documento
    String numeroDocumento = txtNumeroDocumento.getText().trim();
    if (!esNumeroValido(numeroDocumento)) {
      JOptionPane.showMessageDialog(this, "El número de documento debe contener solo números", "Documento inválido",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar programa
    String programa = txtPrograma.getText().trim();
    if (programa.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Debe ingresar el programa de formación", "Campo requerido",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Ficha es opcional - no se valida (puede estar vacío)

    // Validar centro
    String centro = txtCentro.getText().trim();
    if (centro.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Debe ingresar el centro", "Campo requerido", JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar celular
    String celular = txtCelular.getText().trim();
    if (!esCelularValido(celular)) {
      JOptionPane.showMessageDialog(this, "El celular debe contener solo números y tener mínimo 10 dígitos",
          "Celular inválido", JOptionPane.WARNING_MESSAGE);
      return false;
    }

    // Validar correo
    String correo = txtCorreo.getText().trim();
    if (!esCorreoValido(correo)) {
      JOptionPane.showMessageDialog(this, "El correo electrónico tiene un formato inválido", "Correo inválido",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    return true;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    lblNombreEvento = new javax.swing.JLabel();
    lblFechaEvento = new javax.swing.JLabel();
    lblLugarEvento = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    cmbTipoVisitante = new javax.swing.JComboBox<>();
    jLabel9 = new javax.swing.JLabel();
    txtNombre = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    txtApellidos = new javax.swing.JTextField();
    jLabel11 = new javax.swing.JLabel();
    cmbTipoDocumento = new javax.swing.JComboBox<>();
    jLabel12 = new javax.swing.JLabel();
    txtNumeroDocumento = new javax.swing.JTextField();
    jLabel13 = new javax.swing.JLabel();
    txtPrograma = new javax.swing.JTextField();
    jLabel14 = new javax.swing.JLabel();
    txtFicha = new javax.swing.JTextField();
    jLabel15 = new javax.swing.JLabel();
    txtCentro = new javax.swing.JTextField();
    jLabel16 = new javax.swing.JLabel();
    txtCelular = new javax.swing.JTextField();
    jLabel17 = new javax.swing.JLabel();
    txtCorreo = new javax.swing.JTextField();
    btnEnviar = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
    jLabel1.setText("Formulario de Registro");

    jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
    jLabel2.setText("Evento:");

    jLabel3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
    jLabel3.setText("Fecha y hora:");

    lblNombreEvento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    lblNombreEvento.setText("...");

    lblFechaEvento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    lblFechaEvento.setText("...");

    lblLugarEvento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    lblLugarEvento.setText("...");

    jLabel7.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
    jLabel7.setText("Lugar:");

    jLabel8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel8.setText("Tipo de visitante *");

    cmbTipoVisitante.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    cmbTipoVisitante.setModel(
        new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Aprendiz", "Persona Externa" }));

    jLabel9.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel9.setText("Nombre *");

    txtNombre.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel10.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel10.setText("Apellidos *");

    txtApellidos.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel11.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel11.setText("Tipo de documento *");

    cmbTipoDocumento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    cmbTipoDocumento.setModel(
        new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "CC", "TI", "CE", "Pasaporte" }));

    jLabel12.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel12.setText("Número de documento *");

    txtNumeroDocumento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel13.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel13.setText("Programa de formación *");

    txtPrograma.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel14.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel14.setText("Ficha *");

    txtFicha.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel15.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel15.setText("Centro *");

    txtCentro.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel16.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel16.setText("Celular *");

    txtCelular.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    jLabel17.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    jLabel17.setText("Correo electrónico *");

    txtCorreo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

    btnEnviar.setBackground(new java.awt.Color(51, 153, 255));
    btnEnviar.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
    btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
    btnEnviar.setText("Enviar");
    btnEnviar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEnviarActionPerformed(evt);
      }
    });

    btnCancelar.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
    btnCancelar.setText("Cancelar");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(lblLugarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 700,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(cmbTipoVisitante, 0, 320, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(txtNombre)
                            .addComponent(jLabel10)
                            .addComponent(txtApellidos)
                            .addComponent(jLabel11)
                            .addComponent(cmbTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addComponent(txtNumeroDocumento))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(txtPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(jLabel14)
                            .addComponent(txtFicha)
                            .addComponent(jLabel15)
                            .addComponent(txtCentro)
                            .addComponent(jLabel16)
                            .addComponent(txtCelular)
                            .addComponent(jLabel17)
                            .addComponent(txtCorreo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(460, 460, 460)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombreEvento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblFechaEvento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblLugarEvento))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEnviarActionPerformed
    // Validar que todos los campos estén completos
    if (!validarCampos()) {
      return;
    }

    // Obtener los valores del formulario
    String tipoVisitante = cmbTipoVisitante.getSelectedItem().toString();
    String nombre = txtNombre.getText().trim();
    String apellidos = txtApellidos.getText().trim();
    String tipoDocumento = cmbTipoDocumento.getSelectedItem().toString();
    String numeroDocumento = txtNumeroDocumento.getText().trim();
    String programa = txtPrograma.getText().trim();
    String ficha = txtFicha.getText().trim();
    String centro = txtCentro.getText().trim();
    String celular = txtCelular.getText().trim();
    String correo = txtCorreo.getText().trim();

    // Obtener nombre del evento
    String nombreEvento = eventoSeleccionado.getNombre();

    // Obtener fecha y hora actual
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String fechaHoraRegistro = ahora.format(formatter);

    // Estado inicial del registro
    String estado = "Registrado";

    // Crear el objeto Registro
    Registro nuevoRegistro = new Registro(
        tipoVisitante,
        nombre,
        apellidos,
        tipoDocumento,
        numeroDocumento,
        programa,
        ficha,
        centro,
        celular,
        correo,
        nombreEvento,
        fechaHoraRegistro,
        estado);

    // Guardar el registro
    GestorRegistros.agregarRegistro(nuevoRegistro);

    // Mostrar mensaje de confirmación
    JOptionPane.showMessageDialog(this,
        "¡Registro exitoso!\n\nSu asistencia al evento ha sido registrada correctamente.",
        "Registro completado",
        JOptionPane.INFORMATION_MESSAGE);

    // Volver a la ventana de invitado
    iInvitado ventanaInvitado = new iInvitado();
    ventanaInvitado.setVisible(true);
    this.dispose();
  }// GEN-LAST:event_btnEnviarActionPerformed

  private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
    // Confirmar cancelación
    int opcion = JOptionPane.showConfirmDialog(this,
        "¿Está seguro que desea cancelar el registro?",
        "Confirmar cancelación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);

    if (opcion == JOptionPane.YES_OPTION) {
      // Volver a la ventana de invitado
      iInvitado ventanaInvitado = new iInvitado();
      ventanaInvitado.setVisible(true);
      this.dispose();
    }
  }// GEN-LAST:event_btnCancelarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCancelar;
  private javax.swing.JButton btnEnviar;
  private javax.swing.JComboBox<String> cmbTipoDocumento;
  private javax.swing.JComboBox<String> cmbTipoVisitante;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JLabel lblFechaEvento;
  private javax.swing.JLabel lblLugarEvento;
  private javax.swing.JLabel lblNombreEvento;
  private javax.swing.JTextField txtApellidos;
  private javax.swing.JTextField txtCelular;
  private javax.swing.JTextField txtCentro;
  private javax.swing.JTextField txtCorreo;
  private javax.swing.JTextField txtFicha;
  private javax.swing.JTextField txtNombre;
  private javax.swing.JTextField txtNumeroDocumento;
  private javax.swing.JTextField txtPrograma;
  // End of variables declaration//GEN-END:variables
}
