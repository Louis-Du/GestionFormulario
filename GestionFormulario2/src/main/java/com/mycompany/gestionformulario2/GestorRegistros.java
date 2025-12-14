
package com.mycompany.gestionformulario2;

import java.util.ArrayList;
import java.util.List;

public class GestorRegistros {
    private static final List<Registro> registros = new ArrayList<>();

    public static void agregarRegistro(Registro registro) {
        registros.add(registro);
    }

    public static List<Registro> obtenerRegistros() {
        return registros;
    }  
}
