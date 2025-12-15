
package com.mycompany.gestionformulario2;

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
 * 
 * Flujo de la aplicación:
 * 1. GestionFormulario2.main() -> Inicia la aplicación
 * 2. iLogin -> Usuario selecciona rol (Administrador o Invitado)
 * 3. iAdminEvento o iInvitado -> Según el rol seleccionado
 * 4. iFormularioAprendiz/iFormularioInvitado -> Formularios de registro
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class GestionFormulario2 {
    
    /**
     * Método principal que arranca la aplicación.
     * 
     * Este método es el punto de entrada de la aplicación Java.
     * Crea una instancia de la clase iLogin (ventana de inicio de sesión)
     * y la hace visible al usuario mediante setVisible(true).
     * 
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación)
     */
    public static void main(String[] args) {
        // Crear una nueva instancia de iLogin (clase que representa la ventana de login)
        // iLogin es un JFrame de javax.swing que extiende de javax.swing.JFrame
        // setVisible(true) es un método heredado de JFrame que hace visible la ventana
        new iLogin().setVisible(true);
    }
}

