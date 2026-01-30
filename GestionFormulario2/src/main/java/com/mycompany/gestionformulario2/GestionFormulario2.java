package com.mycompany.gestionformulario2;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.gestionformulario2.view.iLogin;
import com.mycompany.gestionformulario2.service.SchedulerService;

public class GestionFormulario2 {

  private static final Logger LOGGER = Logger.getLogger(GestionFormulario2.class.getName());

  private static SchedulerService schedulerService;

  public static void main(String[] args) {
    try {
      LOGGER.log(Level.INFO, "Iniciando Sistema de Gestión de Formularios...");

      iniciarServicioNotificaciones();

      new iLogin().setVisible(true);

      LOGGER.log(Level.INFO, "Sistema iniciado correctamente.");

      agregarShutdownHook();

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error al iniciar la aplicación", e);
    }
  }

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
              "La aplicación continuará sin funcionalidad de correos.",
          e);
    }
  }

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
