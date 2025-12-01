
public class iLogin extends javax.swing.JFrame {

    public iLogin() {
        initComponents();
        this.setExtendedState(iLogin.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAprendiz = new javax.swing.JButton();
        btnAdminEvent = new javax.swing.JButton();
        btnPersonExterna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAprendiz.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnAprendiz.setText("Aprendiz");
        btnAprendiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAprendiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprendizActionPerformed(evt);
            }
        });

        btnAdminEvent.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnAdminEvent.setText("Administrador de Eventos");
        btnAdminEvent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminEventActionPerformed(evt);
            }
        });

        btnPersonExterna.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnPersonExterna.setText("Persona Externa");
        btnPersonExterna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonExternaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPersonExterna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAprendiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdminEvent))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAdminEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnAprendiz, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnPersonExterna, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAprendizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprendizActionPerformed

    }//GEN-LAST:event_btnAprendizActionPerformed

    private void btnAdminEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEventActionPerformed
        iAdminEvento iAdminEvents = new iAdminEvento();
        iAdminEvents.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminEventActionPerformed

    private void btnPersonExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonExternaActionPerformed

    }//GEN-LAST:event_btnPersonExternaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminEvent;
    private javax.swing.JButton btnAprendiz;
    private javax.swing.JButton btnPersonExterna;
    // End of variables declaration//GEN-END:variables
}
