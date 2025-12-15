
package com.mycompany.gestionformulario2;

import com.mycompany.gestionformulario2.Evento;
import com.toedter.calendar.JDateChooser;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Interfaz gráfica de administración de eventos.
 * Permite al administrador:
 * - Crear nuevos eventos con formularios personalizados
 * - Visualizar la lista de registros de asistentes
 * - Gestionar la información de los eventos y sus participantes
 * Esta ventana muestra una tabla con todos los registros de asistencia.
 */
public class iAdminEvento extends javax.swing.JFrame {
    

    /**
     * Constructor que inicializa la ventana de administración de eventos.
     * Configura la tabla de registros con sus columnas y carga los datos existentes.
     */
    public iAdminEvento() {
        // Inicializa todos los componentes visuales
        initComponents();
        
    txtFechaHora.setEditable(false);

    txtFechaHora.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            abrirCalendario();
        }
    });

        // Crea el modelo de tabla con las columnas para los datos de registro
        modeloRegistros = new DefaultTableModel(
            new Object[]{
                "Nombre",           // Nombre completo del asistente
                "Tipo Documento",   // Tipo de documento (CC, TI, CE, etc.)
                "N° Documento",     // Número de identificación
                "Programa",         // Programa académico
                "Ficha",           // Número de ficha o grupo
                "Centro",          // Centro de formación
                "Celular",         // Teléfono de contacto
                "Correo",          // Email del asistente
                "Fecha y hora",    // Momento del registro
                "Estado"           // Estado de asistencia
            },
            0  // Inicia con 0 filas
        );

        // Asigna el modelo creado a la tabla visual
        tblRegistros.setModel(modeloRegistros);

        // Carga todos los registros existentes en la tabla
        cargarRegistrosEnTabla();

        // Maximiza la ventana
        this.setExtendedState(iLogin.MAXIMIZED_BOTH);
        // Hace visible la ventana
        this.setVisible(true);
    }
    
    // Modelo de datos para la tabla de registros
    private DefaultTableModel modeloRegistros;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogCrearEvento = new javax.swing.JDialog();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblNombreEvento = new javax.swing.JLabel();
        txtNombreEvento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFechaHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoAsistencia = new javax.swing.JTextField();
        btnAdminEvent = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblNombreEvento.setText("Nombre del evento:");

        jLabel1.setText("Fecha y hora:");

        jLabel2.setText("Lugar:");

        jLabel3.setText("Código de asistencia:");

        javax.swing.GroupLayout jDialogCrearEventoLayout = new javax.swing.GroupLayout(jDialogCrearEvento.getContentPane());
        jDialogCrearEvento.getContentPane().setLayout(jDialogCrearEventoLayout);
        jDialogCrearEventoLayout.setHorizontalGroup(
            jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCrearEventoLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCrearEventoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialogCrearEventoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogCrearEventoLayout.createSequentialGroup()
                        .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEvento)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLugar)
                            .addComponent(txtFechaHora)
                            .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(124, 124, 124))
            .addGroup(jDialogCrearEventoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jDialogCrearEventoLayout.setVerticalGroup(
            jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCrearEventoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEvento)
                    .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jDialogCrearEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdminEvent.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnAdminEvent.setText("Crear nuevo formulario");
        btnAdminEvent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminEventActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo Doc", "N° Doc", "Programa", "Ficha", "Centro", "Celular", "Correo", "Fecha/Hora", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tblRegistros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdminEvent)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdminEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Carga todos los registros de asistentes desde el gestor a la tabla visual.
     * Limpia la tabla actual y la vuelve a llenar con los datos actualizados.
     */
    private void cargarRegistrosEnTabla() {
        // Elimina todas las filas existentes en la tabla
        modeloRegistros.setRowCount(0);

        // Recorre todos los registros almacenados en el sistema
        for (Registro r : GestorRegistros.obtenerRegistros()) {
            // Agrega una nueva fila con todos los datos del registro
            modeloRegistros.addRow(new Object[]{
                r.getNombre(),
                r.getTipoDocumento(),
                r.getNumeroDocumento(),
                r.getPrograma(),
                r.getFicha(),
                r.getCentro(),
                r.getCelular(),
                r.getCorreo(),
                r.getFechaHoraRegistro(),
                r.getEstado()
            });
        }
    }
    
    private void abrirCalendario() {
        JDialog dialog = new JDialog(this, "Seleccionar fecha y hora", true);
        dialog.setSize(350, 250);
        dialog.setLocationRelativeTo(this);

        // 📅 Selector de fecha
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        // ⏰ Selector de hora (Spinner)
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        javax.swing.SpinnerDateModel timeModel =
                new javax.swing.SpinnerDateModel(calendar.getTime(), null, null, java.util.Calendar.MINUTE);

        javax.swing.JSpinner spinnerHora = new javax.swing.JSpinner(timeModel);
        javax.swing.JSpinner.DateEditor timeEditor =
                new javax.swing.JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(timeEditor);

        // ✅ Botón aceptar
        JButton btnOk = new JButton("Aceptar");
        btnOk.addActionListener(e -> {
            if (dateChooser.getDate() != null) {
                SimpleDateFormat fechaFmt = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat horaFmt = new SimpleDateFormat("HH:mm");

                String fecha = fechaFmt.format(dateChooser.getDate());
                String hora = horaFmt.format(spinnerHora.getValue());

                txtFechaHora.setText(fecha + " " + hora);
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Seleccione una fecha");
            }
        });

        // 🧱 Layout simple
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(3, 1, 10, 10));
        panel.add(dateChooser);
        panel.add(spinnerHora);
        panel.add(btnOk);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    /**
     * Método llamado al presionar el botón "Crear nuevo formulario".
     * Abre un cuadro de diálogo modal para configurar un nuevo evento.
     */
    private void btnAdminEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEventActionPerformed
        // Muestra el archivo Excel de plantilla en vista previa
        mostrarExcelEnVistaPrevia();
        // Configura el tamaño del diálogo
        jDialogCrearEvento.setSize(650, 750);
        // Centra el diálogo en la pantalla
        jDialogCrearEvento.setLocationRelativeTo(null);
        // Hace el diálogo modal (bloquea la ventana principal)
        jDialogCrearEvento.setModal(true);
        // Muestra el diálogo al usuario
        jDialogCrearEvento.setVisible(true);
    }//GEN-LAST:event_btnAdminEventActionPerformed

    /**
     * Carga y muestra un archivo Excel de plantilla dentro del diálogo de creación de eventos.
     * El archivo se carga desde los recursos del proyecto y se visualiza en una JTable.
     */
    private void mostrarExcelEnVistaPrevia() {
        // Carga el archivo Excel desde los recursos del proyecto
        InputStream inputStream = getClass().getResourceAsStream("/Formulario.xlsx");

        // Verifica si el archivo existe
        if (inputStream == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el archivo Excel.");
            return;
        }

        // Convierte el Excel a una JTable usando la clase utilitaria
        JTable tabla = ExcelViewer.cargarExcelEnTabla(inputStream);

        if (tabla != null) {
            // Coloca la tabla en el contenedor con scroll
            jScrollPane1.setViewportView(tabla);

            // Desactiva el ajuste automático de columnas
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // Establece la altura de las filas en píxeles
            tabla.setRowHeight(25);

            // Ajusta el ancho de las columnas según el contenido
            ajustarColumnas(tabla);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el Excel.");
        }
    }
    
    /**
     * Método llamado al presionar el botón "Volver".
     * Regresa a la ventana de login y cierra la ventana actual.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Crea una nueva instancia de la ventana de login
        iLogin iLogin = new iLogin();
        // Muestra la ventana de login
        iLogin.setVisible(true);
        // Oculta la ventana actual de administración
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Método llamado al presionar el botón "Cancelar" en el diálogo de creación.
     * Muestra un cuadro de confirmación antes de cancelar la creación del evento.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Muestra diálogo de confirmación con opciones OK/Cancelar
        int resultado = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cancelar la cración del formulario?", "Cancelación de formulario", JOptionPane.OK_CANCEL_OPTION);
        if(resultado == JOptionPane.OK_OPTION){
            // El usuario confirmó la cancelación

            // Cierra y libera recursos del diálogo de creación
            jDialogCrearEvento.dispose();

            // Registra en consola la acción realizada
            System.out.println("Creación de formulario CANCELADA por el usuario.");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método llamado al presionar el botón "Aceptar" en el diálogo de creación.
     * Valida los campos ingresados y crea un nuevo evento en el sistema.
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Obtiene y limpia los valores de los campos de texto
        String nombreEvento = txtNombreEvento.getText().trim();
        String fechaHora = txtFechaHora.getText().trim();
        String lugar = txtLugar.getText().trim();
        String codigoAsistencia = txtCodigoAsistencia.getText().trim();

        // Valida que todos los campos estén completos
        if (nombreEvento.isEmpty() || fechaHora.isEmpty() || lugar.isEmpty() || codigoAsistencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Crea un nuevo objeto Evento con los datos ingresados
        Evento evento = new Evento(
            nombreEvento,
            fechaHora,
            lugar,
            codigoAsistencia
        );

        // Registra el evento en el gestor del sistema
        GestorEventos.registrarEvento(evento);

        // Muestra mensaje de confirmación al usuario
        JOptionPane.showMessageDialog(
            this,
            "Evento creado correctamente.\nListo para recibir registros.",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Cierra el diálogo después de crear el evento
        jDialogCrearEvento.dispose(); 
    }//GEN-LAST:event_btnAceptarActionPerformed
            
    /**
     * Ajusta dinámicamente el ancho de las columnas de una tabla según su contenido.
     * Itera sobre todas las celdas para calcular el ancho óptimo de cada columna.
     * @param tabla La JTable cuyas columnas se ajustarán
     */
    private void ajustarColumnas(JTable tabla) {
        // Recorre todas las columnas de la tabla
        for (int col = 0; col < tabla.getColumnCount(); col++) {
            TableColumn column = tabla.getColumnModel().getColumn(col);
            // Ancho mínimo inicial en píxeles
            int width = 80;

            // Recorre todas las filas para encontrar el contenido más ancho
            for (int row = 0; row < tabla.getRowCount(); row++) {
                // Obtiene el renderizador de la celda actual
                TableCellRenderer renderer = tabla.getCellRenderer(row, col);
                // Prepara el componente visual de la celda
                Component comp = tabla.prepareRenderer(renderer, row, col);
                // Calcula el ancho máximo necesario (contenido + margen de 10px)
                width = Math.max(width, comp.getPreferredSize().width + 10);
            }

            // Establece el ancho calculado para la columna
            column.setPreferredWidth(width);
        }
    }

    /**
     * Método principal para ejecutar esta ventana de forma independiente.
     * Útil para pruebas y desarrollo de la interfaz.
     */
    public static void main(String args[]) {

        // Ejecuta la creación de la interfaz en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crea y muestra la ventana de administración de eventos
                new iAdminEvento().setVisible(true);
            }
        });
    }

    // Declaración de variables de componentes - NO MODIFICAR MANUALMENTE//GEN-BEGIN:variables
    // Botones de acción
    private javax.swing.JButton btnAceptar;           // Botón para confirmar creación de evento
    private javax.swing.JButton btnAdminEvent;        // Botón para abrir diálogo de nuevo evento
    private javax.swing.JButton btnCancelar;          // Botón para cancelar creación de evento
    private javax.swing.JButton btnVolver;            // Botón para regresar al login
    
    // Componentes del diálogo
    private javax.swing.JDialog jDialogCrearEvento;   // Ventana modal para crear eventos
    private javax.swing.JLabel jLabel1;               // Etiqueta "Fecha y hora"
    private javax.swing.JLabel jLabel2;               // Etiqueta "Lugar"
    private javax.swing.JLabel jLabel3;               // Etiqueta "Código de asistencia"
    private javax.swing.JScrollPane jScrollPane1;     // Contenedor con scroll para vista previa Excel
    private javax.swing.JScrollPane jScrollPane2;     // Contenedor con scroll para tabla de registros
    private javax.swing.JLabel lblNombreEvento;       // Etiqueta "Nombre del evento"
    
    // Componentes de datos
    private javax.swing.JTable tblRegistros;          // Tabla que muestra todos los registros
    private javax.swing.JTextField txtCodigoAsistencia;  // Campo de texto para código
    private javax.swing.JTextField txtFechaHora;      // Campo de texto para fecha y hora
    private javax.swing.JTextField txtLugar;          // Campo de texto para lugar
    private javax.swing.JTextField txtNombreEvento;   // Campo de texto para nombre del evento
    // Fin de la declaración de variables//GEN-END:variables
}

