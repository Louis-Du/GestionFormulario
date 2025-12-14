
package com.mycompany.gestionformulario2;

/**
 * Clase principal del sistema de gestión de formularios.
 * Contiene el método main que inicia la aplicación mostrando la ventana de login.
 */
public class GestionFormulario2 {
    /**
     * Método principal que arranca la aplicación.
     * Crea e instancia la ventana de login (iLogin) y la hace visible al usuario.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crea una nueva instancia de la interfaz de login y la muestra
        new iLogin().setVisible(true);
    }
}

