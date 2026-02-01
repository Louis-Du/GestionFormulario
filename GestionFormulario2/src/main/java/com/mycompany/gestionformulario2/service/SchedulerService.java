package com.mycompany.gestionformulario2.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchedulerService {

  private static final Logger LOGGER = Logger.getLogger(SchedulerService.class.getName());

  // Intervalo de ejecución en minutos (1 hora)
  private static final long INTERVALO_MINUTOS = 60;

  // Delay inicial en segundos antes de la primera ejecución
  private static final long DELAY_INICIAL_SEGUNDOS = 5;

  private final ScheduledExecutorService scheduler;
  private final NotificacionService notificacionService;

  public SchedulerService() {
    // Crear executor con un solo hilo
    this.scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
      Thread thread = new Thread(r);
      thread.setName("NotificacionScheduler");
      thread.setDaemon(true); // Thread daemon no impide el cierre de la JVM
      return thread;
    });

    this.notificacionService = new NotificacionService();

    LOGGER.log(Level.INFO, "SchedulerService inicializado correctamente.");
  }

  /**
   * Inicia la ejecución programada del procesamiento de notificaciones.
   * 
   * La primera ejecución ocurre después del delay inicial (30 segundos),
   * y luego se repite cada hora de forma indefinida.
   */
  public void iniciar() {
    LOGGER.log(Level.INFO,
        "Iniciando scheduler de notificaciones. " +
            "Primera ejecución en {0} segundos, luego cada {1} minutos.",
        new Object[] { DELAY_INICIAL_SEGUNDOS, INTERVALO_MINUTOS });

    // Programar tarea recurrente
    scheduler.scheduleAtFixedRate(
        this::ejecutarTarea, // Tarea a ejecutar
        DELAY_INICIAL_SEGUNDOS, // Delay inicial en segundos
        INTERVALO_MINUTOS, // Intervalo en minutos
        TimeUnit.MINUTES // Unidad de tiempo para el intervalo
    );

    LOGGER.log(Level.INFO, "Scheduler iniciado exitosamente.");
  }

  /**
   * Ejecuta la tarea de procesamiento de notificaciones.
   */
  private void ejecutarTarea() {
    try {
      LOGGER.log(Level.INFO, "=== Iniciando ciclo de verificación de notificaciones ===");

      // Procesar notificaciones
      notificacionService.procesarNotificaciones();

      LOGGER.log(Level.INFO, "=== Ciclo de verificación completado ===");

    } catch (Exception e) {
      // Capturar cualquier excepción para evitar que el scheduler se detenga
      LOGGER.log(Level.SEVERE,
          "Error durante el procesamiento de notificaciones. El scheduler continuará ejecutándose.", e);
    }
  }

  /**
   * Detiene el scheduler de forma ordenada.
   * Espera hasta 5 segundos para que las tareas en ejecución terminen.
   */
  public void detener() {
    LOGGER.log(Level.INFO, "Deteniendo scheduler de notificaciones...");

    try {
      scheduler.shutdown();

      // Esperar hasta 5 segundos para que termine
      if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
        LOGGER.log(Level.WARNING, "El scheduler no terminó en el tiempo esperado. Forzando detención...");
        scheduler.shutdownNow();
      }

      LOGGER.log(Level.INFO, "Scheduler detenido correctamente.");

    } catch (InterruptedException e) {
      LOGGER.log(Level.WARNING, "Interrupción durante la detención del scheduler.");
      scheduler.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Verifica si el scheduler está activo.
   * 
   * @return true si el scheduler está ejecutándose, false si está detenido
   */
  public boolean estaActivo() {
    return !scheduler.isShutdown() && !scheduler.isTerminated();
  }

  /**
   * Ejecuta una verificación inmediata de notificaciones.
   * Útil para pruebas o ejecución manual desde la interfaz.
   */
  public void ejecutarAhora() {
    LOGGER.log(Level.INFO, "Ejecutando verificación inmediata de notificaciones...");

    scheduler.submit(() -> {
      try {
        notificacionService.procesarNotificaciones();
      } catch (Exception e) {
        LOGGER.log(Level.SEVERE, "Error en ejecución inmediata de notificaciones.", e);
      }
    });
  }
}
