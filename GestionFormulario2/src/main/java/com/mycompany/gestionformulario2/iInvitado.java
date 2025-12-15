package com.mycompany.gestionformulario2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Interfaz gráfica para que los invitados visualicen eventos disponibles.
 * Permite seleccionar un evento y registrarse para asistir.
 */
public class iInvitado extends javax.swing.JFrame {

    private DefaultTableModel modeloEventos;

    /**
     * Constructor que inicializa la ventana de invitado.
     * Configura los componentes visuales y maximiza la ventana.
     */
    public iInvitado() {
        initComponents();
        this.setExtendedState(iInvitado.MAXIMIZED_BOTH);
        cargarEventosEnTabla();
        btnRegistrarme.setEnabled(false); // Deshabilitado hasta que seleccionen un evento
    }

    /**
     * Carga los eventos disponibles en la tabla desde GestorEventos.
     */
    private void cargarEventosEnTabla() {
        modeloEventos = (DefaultTableModel) tblEventos.getModel();
        modeloEventos.setRowCount(0); // Limpiar tabla
        
        // Obtener evento activo desde GestorEventos
        Evento eventoActivo = GestorEventos.getEventoActivo();
        
        if (eventoActivo != null) {
            Object[] fila = {
                eventoActivo.getNombre(),
                eventoActivo.getFechaHora(),
                eventoActivo.getLugar()
            };
            modeloEventos.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEventos = new javax.swing.JTable();
        btnRegistrarme = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEventos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del evento", "Fecha y hora", "Lugar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEventos.setRowHeight(30);
        tblEventos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEventos.getTableHeader().setReorderingAllowed(false);
        tblEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEventos);

        btnRegistrarme.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnRegistrarme.setText("Registrarme");
        btnRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarmeActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setText("Eventos Disponibles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarme, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarme, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventosMouseClicked
        // Habilitar el botón Registrarme cuando se selecciona un evento
        int filaSeleccionada = tblEventos.getSelectedRow();
        btnRegistrarme.setEnabled(filaSeleccionada >= 0);
    }//GEN-LAST:event_tblEventosMouseClicked

    private void btnRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarmeActionPerformed
        int filaSeleccionada = tblEventos.getSelectedRow();
        
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione un evento de la tabla",
                "Evento no seleccionado",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Obtener el evento activo
        Evento eventoSeleccionado = GestorEventos.getEventoActivo();
        
        if (eventoSeleccionado != null) {
            // Abrir el formulario de registro pasando el evento
            iFormularioInvitado formulario = new iFormularioInvitado(eventoSeleccionado);
            formulario.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this,
                "No hay eventos disponibles en este momento",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarmeActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Volver al login
        iLogin login = new iLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarme;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEventos;
    // End of variables declaration//GEN-END:variables
}
