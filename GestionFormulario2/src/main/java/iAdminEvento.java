
package com.mycompany.gestionformulario2;

import com.mycompany.gestionformulario2.Evento;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.io.InputStream;

public class iAdminEvento extends javax.swing.JFrame {
    

    public iAdminEvento() {
        initComponents();

        modeloRegistros = new DefaultTableModel(
            new Object[]{
                "Nombre",
                "Tipo Documento",
                "N° Documento",
                "Programa",
                "Ficha",
                "Centro",
                "Celular",
                "Correo",
                "Fecha y hora",
                "Estado"
            },
            0
        );

        tblRegistros.setModel(modeloRegistros);

        cargarRegistrosEnTabla();

        this.setExtendedState(iLogin.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    
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

    private void cargarRegistrosEnTabla() {
        modeloRegistros.setRowCount(0);

        for (Registro r : GestorRegistros.obtenerRegistros()) {
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

    private void btnAdminEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEventActionPerformed
        mostrarExcelEnVistaPrevia();
        jDialogCrearEvento.setSize(650, 750);
        jDialogCrearEvento.setLocationRelativeTo(null);
        jDialogCrearEvento.setModal(true);
        jDialogCrearEvento.setVisible(true);
    }//GEN-LAST:event_btnAdminEventActionPerformed

    private void mostrarExcelEnVistaPrevia() {
        InputStream inputStream = getClass().getResourceAsStream("/Formulario.xlsx");

        if (inputStream == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el archivo Excel.");
            return;
        }

        JTable tabla = ExcelViewer.cargarExcelEnTabla(inputStream);

        if (tabla != null) {
            jScrollPane1.setViewportView(tabla);

            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabla.setRowHeight(25);

            ajustarColumnas(tabla);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el Excel.");
        }
    }
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        iLogin iLogin = new iLogin();
        iLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cancelar la cración del formulario?", "Cancelación de formulario", JOptionPane.OK_CANCEL_OPTION);
        if(resultado == JOptionPane.OK_OPTION){
            // El usuario presionó ACEPTAR en el JOptionPane

            // Ocultar y cerrar el JDialog 'dialogoCreacionFormulario'
            jDialogCrearEvento.dispose();

            // Opcional: mostrar un mensaje o realizar otra acción
            System.out.println("Creación de formulario CANCELADA por el usuario.");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombreEvento = txtNombreEvento.getText().trim();
        String fechaHora = txtFechaHora.getText().trim();
        String lugar = txtLugar.getText().trim();
        String codigoAsistencia = txtCodigoAsistencia.getText().trim();

        // Validaciones simples
        if (nombreEvento.isEmpty() || fechaHora.isEmpty() || lugar.isEmpty() || codigoAsistencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Evento evento = new Evento(
            nombreEvento,
            fechaHora,
            lugar,
            codigoAsistencia
        );

        GestorEventos.registrarEvento(evento);

        JOptionPane.showMessageDialog(
            this,
            "Evento creado correctamente.\nListo para recibir registros.",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Opcional: cerrar o limpiar
        jDialogCrearEvento.dispose(); 
    }//GEN-LAST:event_btnAceptarActionPerformed
            
    private void ajustarColumnas(JTable tabla) {
        for (int col = 0; col < tabla.getColumnCount(); col++) {
            TableColumn column = tabla.getColumnModel().getColumn(col);
            int width = 80;

            for (int row = 0; row < tabla.getRowCount(); row++) {
                TableCellRenderer renderer = tabla.getCellRenderer(row, col);
                Component comp = tabla.prepareRenderer(renderer, row, col);
                width = Math.max(width, comp.getPreferredSize().width + 10);
            }

            column.setPreferredWidth(width);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iAdminEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAdminEvent;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JDialog jDialogCrearEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombreEvento;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtCodigoAsistencia;
    private javax.swing.JTextField txtFechaHora;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNombreEvento;
    // End of variables declaration//GEN-END:variables
}

