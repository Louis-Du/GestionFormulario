
package com.mycompany.gestionformulario2;

public class GestorEventos {
    
    private static Evento eventoActivo;

    public static void registrarEvento(Evento evento) {
        eventoActivo = evento;
    }

    public static Evento getEventoActivo() {
        return eventoActivo;
    }
}
