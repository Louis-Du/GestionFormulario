package com.mycompany.gestionformulario2;

// Importación de la clase iAdminEvento del mismo paquete
import com.mycompany.gestionformulario2.iAdminEvento;
// Importación de JOptionPane de javax.swing para mostrar cuadros de diálogo
import javax.swing.JOptionPane;

/**
 * Interfaz gráfica de inicio de sesión del sistema de gestión de formularios.
 * 
 * Esta ventana es el punto de entrada visual de la aplicación después del main().
 * Presenta tres opciones principales al usuario:
 * 
 * 1. **Administrador de Eventos**: 
 *    - Permite crear nuevos eventos con códigos de asistencia
 *    - Visualizar y exportar registros de asistentes
 *    - Navega a la clase iAdminEvento
 * 
 * 2. **Invitado**: 
 *    - Permite seleccionar un evento y registrarse como asistente
 *    - Puede ser aprendiz o visitante externo
 *    - Navega a la clase iInvitado
 * 
 * 3. **Salir**: 
 *    - Cierra completamente la aplicación con confirmación
 * 
 * Extiende javax.swing.JFrame para crear una ventana de aplicación de escritorio.
 * Usa el sistema de layouts de Swing (GroupLayout) para organizar los componentes.
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class iLogin extends javax.swing.JFrame {

    /**
     * Constructor que inicializa la ventana de login.
     * 
     * Realiza tres operaciones principales:
     * 1. Inicializa todos los componentes gráficos (botones y layouts)
     * 2. Maximiza la ventana a pantalla completa
     * 3. Hace visible la ventana al usuario
     */
    public iLogin() {
        // Llama al método generado automáticamente que configura todos los componentes visuales
        // Este método fue creado por el editor visual de NetBeans y configura botones, eventos, etc.
        initComponents();
        
        // Maximiza la ventana para que ocupe toda la pantalla
        // MAXIMIZED_BOTH es una constante de java.awt.Frame que indica maximización horizontal y vertical
        // setExtendedState() es un método heredado de java.awt.Frame
        this.setExtendedState(iLogin.MAXIMIZED_BOTH);
        
        // Hace visible la ventana al usuario
        // setVisible() es un método heredado de javax.swing.JFrame
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
     * Manejador de evento (ActionListener) para el botón "Invitado".
     * 
     * Se ejecuta automáticamente cuando el usuario hace clic en el botón "Invitado".
     * Realiza la navegación desde la pantalla de login hacia la pantalla de selección
     * de eventos para invitados (iInvitado).
     * 
     * @param evt Objeto ActionEvent de java.awt.event que contiene información del evento de clic
     */
    private void btnInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvitadoActionPerformed
        // Crear una nueva instancia de la clase iInvitado (ventana de selección de eventos)
        // iInvitado es otra clase JFrame del paquete com.mycompany.gestionformulario2
        iInvitado ventanaInvitado = new iInvitado();
        
        // Hacer visible la ventana de invitados
        ventanaInvitado.setVisible(true);
        
        // Cerrar la ventana de login
        this.dispose();
    }//GEN-LAST:event_btnInvitadoActionPerformed

    /**
     * Manejador de evento (ActionListener) para el botón "Administrador de Eventos".
     * 
     * Se ejecuta automáticamente cuando el usuario hace clic en el botón "Administrador de Eventos".
     * Realiza la navegación desde la pantalla de login hacia la pantalla de administración
     * de eventos (iAdminEvento), donde se pueden crear eventos y gestionar registros.
     * 
     * @param evt Objeto ActionEvent de java.awt.event que contiene información del evento de clic
     */
    private void btnAdminEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEventActionPerformed
        // Crear una nueva instancia de la clase iAdminEvento (ventana de administración)
        // iAdminEvento es otra clase JFrame del paquete com.mycompany.gestionformulario2
        iAdminEvento iAdminEvents = new iAdminEvento();
        
        // Hacer visible la ventana de administración llamando a setVisible(true)
        // setVisible() es un método heredado de JFrame (javax.swing.JFrame)
        iAdminEvents.setVisible(true);
        
        // Cerrar la ventana actual de login usando dispose()
        // dispose() es un método de JFrame que libera los recursos de la ventana
        // No cierra la aplicación completa, solo esta ventana específica
        this.dispose();
    }//GEN-LAST:event_btnAdminEventActionPerformed

    /**
     * Manejador de evento (ActionListener) para el botón "Salir".
     * 
     * Se ejecuta automáticamente cuando el usuario hace clic en el botón "Salir".
     * Muestra un cuadro de diálogo de confirmación antes de cerrar completamente
     * la aplicación para evitar cierres accidentales.
     * 
     * @param evt Objeto ActionEvent de java.awt.event que contiene información del evento de clic
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Mostrar un cuadro de diálogo modal de confirmación usando JOptionPane de javax.swing
        // showConfirmDialog() muestra una ventana con botones Sí/No y devuelve la opción seleccionada
        int opcion = JOptionPane.showConfirmDialog(
            this,                                    // Componente padre (esta ventana)
            "¿Deseas salir del programa?",           // Mensaje a mostrar
            "Salir",                                 // Título del cuadro de diálogo
            JOptionPane.YES_NO_OPTION,               // Tipo de botones (Sí/No)
            JOptionPane.QUESTION_MESSAGE             // Icono de pregunta
        );

        // Verificar si el usuario hizo clic en "Sí"
        // YES_OPTION es una constante de JOptionPane que representa la opción afirmativa
        if (opcion == JOptionPane.YES_OPTION) {
            // Terminar la ejecución de la JVM (Java Virtual Machine)
            // System.exit(0) cierra la aplicación completamente
            // El parámetro 0 indica terminación exitosa (status code)
            System.exit(0);
        }
        // Si el usuario hace clic en "No", el método termina sin hacer nada y la ventana permanece abierta
    }//GEN-LAST:event_btnSalirActionPerformed
    /**
     * Método principal para ejecutar la aplicación de forma independiente.
     * 
     * Este método permite iniciar la ventana de login directamente sin pasar
     * por GestionFormulario2.main(). Útil para pruebas y desarrollo.
     * 
     * Usa el Event Dispatch Thread (EDT) de Swing para garantizar la seguridad
     * de los hilos al crear componentes gráficos. Swing no es thread-safe, por lo que
     * todas las operaciones de UI deben ejecutarse en el EDT.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String args[]) {

        // invokeLater() de EventQueue programa la creación de la UI en el EDT
        // EventQueue es una clase de java.awt que gestiona eventos de la interfaz gráfica
        // Recibe un objeto Runnable (interfaz funcional con el método run())
        java.awt.EventQueue.invokeLater(new Runnable() {
            /**
             * Método run() de la interfaz Runnable que se ejecutará en el EDT.
             * Crea y muestra la ventana de login de forma segura para Swing.
             */
            public void run() {
                // Crear una nueva instancia de iLogin y hacerla visible
                // Esto es equivalente a lo que hace GestionFormulario2.main()
                new iLogin().setVisible(true);
            }
        });
    }

    // ========== DECLARACIÓN DE VARIABLES DE COMPONENTES - GENERADO AUTOMÁTICAMENTE ==========
    // ADVERTENCIA: NO MODIFICAR MANUALMENTE - Usar el editor visual de NetBeans
    //GEN-BEGIN:variables
    
    /**
     * Botón para acceder al módulo de administración de eventos.
     * Tipo: javax.swing.JButton
     * Al hacer clic ejecuta: btnAdminEventActionPerformed()
     * Navega a: iAdminEvento
     */
    private javax.swing.JButton btnAdminEvent;
    
    /**
     * Botón para acceder al módulo de invitados (asistentes a eventos).
     * Tipo: javax.swing.JButton
     * Al hacer clic ejecuta: btnInvitadoActionPerformed()
     * Navega a: iInvitado
     */
    private javax.swing.JButton btnInvitado;
    
    /**
     * Botón toggle para salir de la aplicación con confirmación.
     * Tipo: javax.swing.JToggleButton
     * Al hacer clic ejecuta: btnSalirActionPerformed()
     * Acción: Muestra diálogo de confirmación y cierra la aplicación
     */
    private javax.swing.JToggleButton btnSalir;
    
    // Fin de la declaración de variables - NO MODIFICAR MANUALMENTE
    //GEN-END:variables
}
