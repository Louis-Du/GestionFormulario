
package com.mycompany.gestionformulario2.service;

// Importaciones de Java Collections Framework
import java.util.ArrayList; // Implementación de lista dinámica basada en arreglos
import java.util.List; // Interfaz para listas ordenadas
import com.mycompany.gestionformulario2.model.Registro;

public class GestorRegistros {

  private static final List<Registro> registros = new ArrayList<>();

  public static void agregarRegistro(Registro registro) {
    registros.add(registro);
  }

  public static List<Registro> obtenerRegistros() {
    return registros;
  }
}
