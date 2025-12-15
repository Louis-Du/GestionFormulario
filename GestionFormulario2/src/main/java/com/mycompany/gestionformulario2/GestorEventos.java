
package com.mycompany.gestionformulario2;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase gestora que administra los eventos del sistema.
 * Mantiene una lista de todos los eventos creados y el evento activo actual.
 */
public class GestorEventos {
    
    // Variable estática que almacena el evento actualmente seleccionado en el sistema
    private static Evento eventoActivo;
    
    // Lista estática que almacena todos los eventos creados en el sistema
    private static List<Evento> listaEventos = new ArrayList<>();

    /**
     * Registra un evento como el evento activo del sistema y lo agrega a la lista.
     * @param evento El evento que se establecerá como activo
     */
    public static void registrarEvento(Evento evento) {
        eventoActivo = evento;
        // Agregar a la lista solo si no existe ya
        if (!listaEventos.contains(evento)) {
            listaEventos.add(evento);
        }
    }

    /**
     * Obtiene el evento actualmente activo en el sistema.
     * @return El evento activo, o null si no hay ninguno registrado
     */
    public static Evento getEventoActivo() {
        return eventoActivo;
    }

    /**
     * Obtiene la lista completa de todos los eventos creados.
     * @return Lista de eventos
     */
    public static List<Evento> obtenerEventos() {
        return new ArrayList<>(listaEventos);
    }
}
