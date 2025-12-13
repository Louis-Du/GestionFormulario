
package com.mycompany.gestionformulario2;

import java.util.List;
import java.util.ArrayList;

public class GestorEventos {
    
    private static List<Evento> eventos = new ArrayList<>();

    public static void registrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public static Evento getUltimoEvento() {
        if (eventos.isEmpty()) return null;
        return eventos.get(eventos.size() - 1);
    }

    public static List<Evento> getEventos() {
        return eventos;
    }
}
