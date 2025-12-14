
package com.mycompany.gestionformulario2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase gestora que administra todos los registros de asistentes a eventos.
 * Mantiene una lista estática centralizada de todos los registros del sistema,
 * permitiendo agregar y consultar registros desde cualquier parte de la aplicación.
 */
public class GestorRegistros {
    // Lista estática que almacena todos los registros de asistentes
    // Se usa final para que la referencia a la lista no pueda cambiar
    private static final List<Registro> registros = new ArrayList<>();

    /**
     * Agrega un nuevo registro de asistente a la lista del sistema.
     * @param registro El objeto Registro que contiene los datos del asistente
     */
    public static void agregarRegistro(Registro registro) {
        registros.add(registro);
    }

    /**
     * Obtiene la lista completa de todos los registros almacenados.
     * @return Lista con todos los objetos Registro del sistema
     */
    public static List<Registro> obtenerRegistros() {
        return registros;
    }  
}
