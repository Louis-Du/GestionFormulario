
package com.mycompany.gestionformulario2;

/**
 * Clase gestora que administra el evento activo del sistema.
 * Utiliza el patrón Singleton para mantener una única instancia del evento actual
 * que puede ser accedida desde cualquier parte de la aplicación.
 */
public class GestorEventos {
    
    // Variable estática que almacena el evento actualmente seleccionado en el sistema
    private static Evento eventoActivo;

    /**
     * Registra un evento como el evento activo del sistema.
     * @param evento El evento que se establecerá como activo
     */
    public static void registrarEvento(Evento evento) {
        eventoActivo = evento;
    }

    /**
     * Obtiene el evento actualmente activo en el sistema.
     * @return El evento activo, o null si no hay ninguno registrado
     */
    public static Evento getEventoActivo() {
        return eventoActivo;
    }
}
