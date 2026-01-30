
package com.mycompany.gestionformulario2.service;

// Importaciones de Java Collections Framework
import java.util.ArrayList; // Implementación de lista dinámica basada en arreglos
import java.util.List; // Interfaz para listas ordenadas
import com.mycompany.gestionformulario2.model.Evento;

public class GestorEventos {
  private static Evento eventoActivo;

  // Almacena todos los eventos para mostrarlos en ComboBox de iInvitado
  private static List<Evento> listaEventos = new ArrayList<>();

  public static void registrarEvento(Evento evento) {
    eventoActivo = evento;

    // Agregar el evento a la lista solo si no existe ya
    // contains() usa equals() para comparar objetos (comparación por referencia por
    // defecto)
    if (!listaEventos.contains(evento)) {
      listaEventos.add(evento);
    }
  }

  public static Evento getEventoActivo() {
    return eventoActivo;
  }

  public static List<Evento> obtenerEventos() {
    // Retornar una nueva ArrayList que es una copia de listaEventos
    // Constructor de ArrayList con Collection: ArrayList(Collection<? extends E> c)
    return new ArrayList<>(listaEventos);
  }
}
