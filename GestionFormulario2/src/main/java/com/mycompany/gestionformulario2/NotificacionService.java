package com.mycompany.gestionformulario2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de notificaciones por correo electrónico para eventos.
 * 
 * Responsabilidades:
 * - Verificar eventos próximos y enviar recordatorios N días antes
 * - Enviar código de asistencia el día del evento
 * - Evitar envío de correos duplicados mediante flags en Registro
 * - Registrar todas las acciones en el log
 * 
 * Lógica de notificaciones:
 * 1. Recordatorio: Se envía 3 días antes del evento (configurable)
 * 2. Código: Se envía el mismo día del evento
 * 
 * Formato de fechas esperado en Evento:
 * - "yyyy-MM-dd HH:mm" (ejemplo: "2026-01-25 14:30")
 * - Compatible con el formato generado por JDateChooser en iAdminEvento
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class NotificacionService {
    
    private static final Logger LOGGER = Logger.getLogger(NotificacionService.class.getName());
    
    // Días de anticipación para enviar recordatorio
    private static final int DIAS_RECORDATORIO = 3;
    
    private final EmailService emailService;
    
    /**
     * Constructor que inicializa el servicio con un EmailService.
     */
    public NotificacionService() {
        this.emailService = new EmailService();
        
        if (!emailService.estaConfigurado()) {
            LOGGER.log(Level.WARNING, 
                "EmailService no está configurado. Las notificaciones no se enviarán.");
        }
    }
    
    /**
     * Procesa todas las notificaciones pendientes.
     * Verifica todos los eventos y registros para determinar qué correos enviar.
     * 
     * Este método debe ser llamado periódicamente por el SchedulerService.
     */
    public void procesarNotificaciones() {
        LOGGER.log(Level.INFO, "Iniciando procesamiento de notificaciones...");
        
        if (!emailService.estaConfigurado()) {
            LOGGER.log(Level.WARNING, 
                "EmailService no configurado. Saltando procesamiento de notificaciones.");
            return;
        }
        
        // Obtener fecha actual
        LocalDate hoy = LocalDate.now();
        
        // Obtener todos los eventos
        List<Evento> eventos = GestorEventos.obtenerEventos();
        
        if (eventos == null || eventos.isEmpty()) {
            LOGGER.log(Level.INFO, "No hay eventos registrados. Finalizando procesamiento.");
            return;
        }
        
        LOGGER.log(Level.INFO, "Procesando {0} evento(s)...", eventos.size());
        
        // Procesar cada evento
        for (Evento evento : eventos) {
            try {
                procesarEvento(evento, hoy);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, 
                    "Error al procesar evento: " + evento.getNombre(), e);
            }
        }
        
        LOGGER.log(Level.INFO, "Procesamiento de notificaciones finalizado.");
    }
    
    /**
     * Procesa un evento específico para enviar notificaciones.
     * 
     * @param evento Evento a procesar
     * @param hoy Fecha actual
     */
    private void procesarEvento(Evento evento, LocalDate hoy) {
        // Obtener fecha del evento
        LocalDate fechaEvento = parsearFechaEvento(evento.getFechaHora());
        
        if (fechaEvento == null) {
            LOGGER.log(Level.WARNING, 
                "No se pudo parsear la fecha del evento: {0} | Fecha: {1}", 
                new Object[]{evento.getNombre(), evento.getFechaHora()});
            return;
        }
        
        // Calcular fecha de recordatorio
        LocalDate fechaRecordatorio = fechaEvento.minusDays(DIAS_RECORDATORIO);
        
        // Obtener todos los registros del evento
        List<Registro> registros = GestorRegistros.obtenerRegistros();
        
        int recordatoriosEnviados = 0;
        int codigosEnviados = 0;
        
        for (Registro registro : registros) {
            // Filtrar solo registros de este evento
            if (registro.getNombreEvento() == null || 
                !registro.getNombreEvento().equals(evento.getNombre())) {
                continue;
            }
            
            // Enviar recordatorio si corresponde
            if (hoy.equals(fechaRecordatorio) && !registro.isRecordatorioEnviado()) {
                if (enviarRecordatorio(registro, evento, fechaEvento)) {
                    registro.setRecordatorioEnviado(true);
                    recordatoriosEnviados++;
                }
            }
            
            // Enviar código si corresponde
            if (hoy.equals(fechaEvento) && !registro.isCodigoEnviado()) {
                if (enviarCodigoAsistencia(registro, evento)) {
                    registro.setCodigoEnviado(true);
                    codigosEnviados++;
                }
            }
        }
        
        if (recordatoriosEnviados > 0 || codigosEnviados > 0) {
            LOGGER.log(Level.INFO, 
                "Evento: {0} | Recordatorios: {1} | Códigos: {2}", 
                new Object[]{evento.getNombre(), recordatoriosEnviados, codigosEnviados});
        }
    }
    
    /**
     * Envía correo de recordatorio a un asistente.
     * 
     * @param registro Registro del asistente
     * @param evento Evento al que está registrado
     * @param fechaEvento Fecha del evento
     * @return true si el envío fue exitoso
     */
    private boolean enviarRecordatorio(Registro registro, Evento evento, LocalDate fechaEvento) {
        String destinatario = registro.getCorreo();
        String asunto = "Recordatorio evento: " + evento.getNombre();
        
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Estimado/a ").append(registro.getNombre()).append(" ").append(registro.getApellidos()).append(",\n\n");
        mensaje.append("Le recordamos que está registrado/a para el siguiente evento:\n\n");
        mensaje.append("📅 Evento: ").append(evento.getNombre()).append("\n");
        mensaje.append("📆 Fecha y hora: ").append(evento.getFechaHora()).append("\n");
        mensaje.append("📍 Lugar: ").append(evento.getLugar()).append("\n\n");
        mensaje.append("El día del evento recibirá un correo con el código de asistencia para registrar su presencia.\n\n");
        mensaje.append("¡Esperamos contar con su asistencia!\n\n");
        mensaje.append("Saludos cordiales,\n");
        mensaje.append("Sistema de Gestión de Eventos");
        
        return emailService.enviarCorreo(destinatario, asunto, mensaje.toString());
    }
    
    /**
     * Envía correo con código de asistencia a un asistente.
     * 
     * @param registro Registro del asistente
     * @param evento Evento al que está registrado
     * @return true si el envío fue exitoso
     */
    private boolean enviarCodigoAsistencia(Registro registro, Evento evento) {
        String destinatario = registro.getCorreo();
        String asunto = "Código de asistencia – " + evento.getNombre();
        
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Estimado/a ").append(registro.getNombre()).append(" ").append(registro.getApellidos()).append(",\n\n");
        mensaje.append("¡Hoy es el día del evento!\n\n");
        mensaje.append("📅 Evento: ").append(evento.getNombre()).append("\n");
        mensaje.append("📆 Fecha y hora: ").append(evento.getFechaHora()).append("\n");
        mensaje.append("📍 Lugar: ").append(evento.getLugar()).append("\n\n");
        mensaje.append("🔑 Su código de asistencia es: ").append(evento.getCodigoAsistencia()).append("\n\n");
        mensaje.append("IMPORTANTE:\n");
        mensaje.append("- Presente este código al momento del registro de asistencia\n");
        mensaje.append("- Ingrese el código exactamente como se muestra (sin espacios)\n");
        mensaje.append("- El código es válido únicamente para este evento\n\n");
        mensaje.append("¡Le deseamos una excelente experiencia en el evento!\n\n");
        mensaje.append("Saludos cordiales,\n");
        mensaje.append("Sistema de Gestión de Eventos");
        
        return emailService.enviarCorreo(destinatario, asunto, mensaje.toString());
    }
    
    /**
     * Parsea la fecha/hora del evento al formato LocalDate.
     * Soporta múltiples formatos comunes.
     * 
     * @param fechaHoraStr String con fecha y hora
     * @return LocalDate o null si no se pudo parsear
     */
    private LocalDate parsearFechaEvento(String fechaHoraStr) {
        if (fechaHoraStr == null || fechaHoraStr.trim().isEmpty()) {
            return null;
        }
        
        // Formatos soportados
        String[] formatos = {
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd HH:mm:ss",
            "dd/MM/yyyy HH:mm",
            "dd/MM/yyyy HH:mm:ss",
            "yyyy-MM-dd",
            "dd/MM/yyyy"
        };
        
        for (String formato : formatos) {
            try {
                if (formato.contains("HH:mm")) {
                    // Formato con hora
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
                    LocalDateTime dateTime = LocalDateTime.parse(fechaHoraStr.trim(), formatter);
                    return dateTime.toLocalDate();
                } else {
                    // Formato solo fecha
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
                    return LocalDate.parse(fechaHoraStr.trim(), formatter);
                }
            } catch (DateTimeParseException e) {
                // Intentar siguiente formato
                continue;
            }
        }
        
        return null;
    }
    
    /**
     * Método de utilidad para probar el servicio de notificaciones.
     * Envía un correo de prueba al destinatario especificado.
     * 
     * @param destinatario Email de destino
     * @return true si el envío fue exitoso
     */
    public boolean enviarCorreoPrueba(String destinatario) {
        String asunto = "Prueba del Sistema de Notificaciones";
        String mensaje = "Este es un correo de prueba del Sistema de Gestión de Eventos.\n\n" +
                         "Si recibe este mensaje, la configuración de correo está funcionando correctamente.\n\n" +
                         "Saludos,\nSistema de Gestión de Eventos";
        
        return emailService.enviarCorreo(destinatario, asunto, mensaje);
    }
}
