package com.mycompany.gestionformulario2.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio para el envío de correos electrónicos mediante SMTP de Gmail.
 * 
 * Características:
 * - Configuración SMTP para Gmail (smtp.gmail.com:587)
 * - TLS habilitado para seguridad
 * - Credenciales obtenidas desde variables de entorno
 * - Sin lógica de negocio, solo responsabilidad de envío
 * 
 * Requisitos:
 * - Variables de entorno configuradas:
 * * EMAIL_USER: dirección Gmail completa
 * * EMAIL_PASS: App Password de Gmail (no la contraseña normal)
 * 
 * Para generar App Password:
 * 1. Ir a myaccount.google.com
 * 2. Seguridad → Verificación en 2 pasos (debe estar activada)
 * 3. Contraseñas de aplicaciones → Generar nueva
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class EmailService {

  private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

  // Credenciales obtenidas desde variables de entorno
  private final String emailUser;
  private final String emailPass;

  // Configuración SMTP de Gmail
  private final Properties properties;

  public EmailService() {
    this.emailUser = "correodepruebadenotificacion@gmail.com"; // Tu correo Gmail
    this.emailPass = "ihot yxqs abfu wewp"; // Tu App Password (16 caracteres)

    if (emailUser == null || emailPass == null || emailUser.trim().isEmpty() || emailPass.trim().isEmpty() ||
        emailUser.equals("correodepruebadenotificacion@gmail.com") || emailPass.equals("ihot yxqs abfu wewp")) {
      LOGGER.log(Level.WARNING,
          "Credenciales no configuradas. Por favor, modifica EmailService.java con tus credenciales.");
    }

    // Configurar propiedades SMTP para Gmail
    this.properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    properties.put("mail.smtp.connectiontimeout", "10000");
    properties.put("mail.smtp.timeout", "10000");
  }

  public boolean enviarCorreo(String destinatario, String asunto, String mensaje) {
    // Validar parámetros de entrada
    if (destinatario == null || destinatario.trim().isEmpty()) {
      LOGGER.log(Level.WARNING, "Destinatario vacío o nulo. No se enviará correo.");
      return false;
    }

    if (asunto == null || asunto.trim().isEmpty()) {
      LOGGER.log(Level.WARNING, "Asunto vacío o nulo. No se enviará correo.");
      return false;
    }

    if (mensaje == null || mensaje.trim().isEmpty()) {
      LOGGER.log(Level.WARNING, "Mensaje vacío o nulo. No se enviará correo.");
      return false;
    }

    // Validar credenciales
    if (emailUser == null || emailPass == null || emailUser.trim().isEmpty() || emailPass.trim().isEmpty()) {
      LOGGER.log(Level.SEVERE,
          "Credenciales no configuradas. Configure EMAIL_USER y EMAIL_PASS como variables de entorno.");
      return false;
    }

    try {
      // Crear sesión con autenticación
      Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(emailUser, emailPass);
        }
      });

      // Habilitar debug en desarrollo (comentar en producción)
      // session.setDebug(true);

      // Crear mensaje
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailUser));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
      message.setSubject(asunto);
      message.setText(mensaje);

      // Enviar mensaje
      Transport.send(message);

      LOGGER.log(Level.INFO,
          "Correo enviado exitosamente a: {0} | Asunto: {1}",
          new Object[] { destinatario, asunto });

      return true;

    } catch (MessagingException e) {
      LOGGER.log(Level.SEVERE,
          "Error al enviar correo a " + destinatario + ": " + e.getMessage(), e);
      return false;
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE,
          "Error inesperado al enviar correo: " + e.getMessage(), e);
      return false;
    }
  }

  /**
   * Verifica si el servicio de email está correctamente configurado.
   * 
   * @return true si las credenciales están configuradas, false en caso contrario
   */
  public boolean estaConfigurado() {
    return emailUser != null && emailPass != null
        && !emailUser.trim().isEmpty() && !emailPass.trim().isEmpty();
  }
}
