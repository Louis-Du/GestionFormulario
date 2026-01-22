package com.mycompany.gestionformulario2;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.gestionformulario2.view.iLogin;
import com.mycompany.gestionformulario2.service.SchedulerService;

/**
 * Clase principal del sistema de gestión de formularios y eventos.
 * 
 * Esta es la clase de entrada (entry point) de la aplicación de escritorio.
 * Su única responsabilidad es inicializar y mostrar la ventana de inicio de sesión (iLogin).
 * 
 * El sistema permite:
 * - Gestionar eventos (crear, administrar, ver registros)
 * - Registrar asistentes a eventos (aprendices y externos)
 * - Exportar datos de asistencia a Excel
 * - Enviar notificaciones automáticas por correo electrónico
 * 
 * Flujo de la aplicación:
 * 1. GestionFormulario2.main() -> Inicia la aplicación
 * 2. iLogin -> Usuario selecciona rol (Administrador o Invitado)
 * 3. iAdminEvento o iInvitado -> Según el rol seleccionado
 * 4. iFormularioAprendiz/iFormularioInvitado -> Formularios de registro
 * 
 * Servicios en segundo plano:
 * - SchedulerService: Verificación automática cada hora para envío de notificaciones
 * 
 * @author Sistema de Gestión de Formularios
 * @version 2.0
 */
public class GestionFormulario2 {
    
    private static final Logger LOGGER = Logger.getLogger(GestionFormulario2.class.getName());
    
    // Instancia del servicio de programación de tareas
    private static SchedulerService schedulerService;
    
    /**
     * Método principal que arranca la aplicación.
     * 
     * Este método es el punto de entrada de la aplicación Java.
     * Crea una instancia de la clase iLogin (ventana de inicio de sesión)
     * y la hace visible al usuario mediante setVisible(true).
     * 
     * Además, inicializa el servicio de notificaciones automáticas que se ejecuta
     * en segundo plano para enviar recordatorios y códigos de asistencia.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación)
     */
    public static void main(String[] args) {
        try {
            LOGGER.log(Level.INFO, "Iniciando Sistema de Gestión de Formularios...");
            
            // Iniciar servicio de notificaciones automáticas
            iniciarServicioNotificaciones();
            
            // Crear y mostrar la ventana de login
            // iLogin es un JFrame de javax.swing que extiende de javax.swing.JFrame
            // setVisible(true) es un método heredado de JFrame que hace visible la ventana
            new iLogin().setVisible(true);
            
            LOGGER.log(Level.INFO, "Sistema iniciado correctamente.");
            
            // Agregar shutdown hook para detener el scheduler al cerrar la aplicación
            agregarShutdownHook();
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al iniciar la aplicación", e);
        }
    }
    
    /**
     * Inicializa y arranca el servicio de notificaciones por correo.
     * Se ejecuta en segundo plano de forma automática.
     */
    private static void iniciarServicioNotificaciones() {
        try {
            LOGGER.log(Level.INFO, "Iniciando servicio de notificaciones automáticas...");
            
            schedulerService = new SchedulerService();
            schedulerService.iniciar();
            
            LOGGER.log(Level.INFO, 
                "Servicio de notificaciones iniciado. " +
                "Las verificaciones se ejecutarán automáticamente cada hora.");
            
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, 
                "Error al iniciar servicio de notificaciones. " +
                "La aplicación continuará sin funcionalidad de correos.", e);
        }
    }
    
    /**
     * Agrega un shutdown hook para detener ordenadamente el scheduler
     * cuando la JVM se cierre.
     */
    private static void agregarShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.log(Level.INFO, "Cerrando aplicación...");
            
            if (schedulerService != null && schedulerService.estaActivo()) {
                LOGGER.log(Level.INFO, "Deteniendo servicio de notificaciones...");
                schedulerService.detener();
            }
            
            LOGGER.log(Level.INFO, "Aplicación cerrada correctamente.");
        }, "ShutdownHook"));
    }
}

