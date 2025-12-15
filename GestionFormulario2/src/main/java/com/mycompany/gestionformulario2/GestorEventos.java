
package com.mycompany.gestionformulario2;

// Importaciones de Java Collections Framework
import java.util.ArrayList;  // Implementación de lista dinámica basada en arreglos
import java.util.List;       // Interfaz para listas ordenadas

/**
 * Clase gestora (Manager/Repository) que administra los eventos del sistema.
 * 
 * Esta clase implementa el patrón Singleton implícito mediante métodos y atributos estáticos,
 * proporcionando un punto de acceso global a la colección de eventos y al evento activo.
 * 
 * Responsabilidades:
 * - Almacenar centralizadamente todos los eventos creados
 * - Mantener referencia al evento actualmente activo (usado para registros)
 * - Proporcionar operaciones para registrar, consultar y obtener eventos
 * - Evitar duplicación de eventos en la lista
 * 
 * Concepto de "Evento Activo":
 * El evento activo es el evento seleccionado actualmente por el administrador,
 * y es el que se usará por defecto para nuevos registros de asistentes.
 * 
 * Uso en el sistema:
 * - iAdminEvento llama a registrarEvento() al crear un nuevo evento
 * - iInvitado llama a obtenerEventos() para mostrar eventos en ComboBox
 * - iFormularioAprendiz/iFormularioInvitado llaman a getEventoActivo() para validar código
 * - iAdminEvento usa getEventoActivo() para preseleccionar eventos en el ComboBox
 * 
 * Limitaciones actuales:
 * - Los datos solo persisten en memoria (se pierden al cerrar la aplicación)
 * - No hay persistencia en base de datos o archivos
 * - No hay operaciones de edición o eliminación de eventos
 * 
 * Patrón de diseño: Repository Pattern + Singleton (implícito) + State Pattern (evento activo)
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class GestorEventos {
    
    // ========== ATRIBUTOS ESTÁTICOS ==========
    
    /**
     * Variable estática que almacena el evento actualmente seleccionado/activo en el sistema.
     * 
     * Características:
     * - **static**: Compartida globalmente, accesible desde cualquier parte del sistema
     * - **private**: Solo modificable mediante registrarEvento()
     * - **Puede ser null**: Si no se ha creado ningún evento aún
     * 
     * Uso:
     * - Se establece cuando el administrador crea un nuevo evento en iAdminEvento
     * - Se consulta en formularios de registro para validar el código de asistencia
     * - Se usa para asociar nuevos registros al evento correcto
     * 
     * Ciclo de vida:
     * - Inicia como null (no hay evento activo)
     * - Se actualiza cada vez que se crea un nuevo evento
     * - Siempre apunta al último evento creado
     */
    private static Evento eventoActivo;
    
    /**
     * Lista estática que almacena todos los eventos creados en el sistema.
     * 
     * Características:
     * - **static**: Repositorio global compartido
     * - **private**: Solo modificable mediante métodos públicos
     * - **ArrayList**: Implementación de List de java.util
     * 
     * Diferencia con 'registros' en GestorRegistros:
     * - Esta lista NO es final, su referencia puede cambiar (aunque no se hace en la práctica)
     * - Se inicializa con new ArrayList<>() directamente
     * 
     * Uso:
     * - Almacena todos los eventos para mostrarlos en ComboBox de iInvitado
     * - Permite seleccionar eventos existentes para filtrar registros
     * - Mantiene el historial de eventos creados
     * 
     * Nota: Se previene la duplicación mediante contains() antes de agregar
     */
    private static List<Evento> listaEventos = new ArrayList<>();

    // ========== MÉTODOS PÚBLICOS ESTÁTICOS ==========

    /**
     * Registra un nuevo evento en el sistema, estableciéndolo como evento activo.
     * 
     * Este método realiza dos operaciones:
     * 1. Establece el evento como el evento activo actual del sistema
     * 2. Lo agrega a la lista de eventos si no existe ya (previene duplicados)
     * 
     * Es llamado desde iAdminEvento después de que el administrador:
     * 1. Completa el formulario de creación de evento en el JDialog
     * 2. Valida todos los campos (nombre, fecha, lugar, código)
     * 3. Presiona "Aceptar"
     * 4. Se crea el objeto Evento
     * 5. Se llama a GestorEventos.registrarEvento(evento)
     * 
     * Flujo de uso:
     * ```java
     * Evento nuevoEvento = new Evento(nombre, fechaHora, lugar, codigo);
     * GestorEventos.registrarEvento(nuevoEvento);
     * // Ahora nuevoEvento es el evento activo y está en la lista
     * ```
     * 
     * @param evento Objeto Evento (de la clase Evento.java) que contiene todos
     *               los datos del evento: nombre, fecha/hora, lugar y código de asistencia
     */
    public static void registrarEvento(Evento evento) {
        // Establecer este evento como el evento activo del sistema
        // Esto sobrescribe cualquier evento activo anterior
        eventoActivo = evento;
        
        // Agregar el evento a la lista solo si no existe ya
        // contains() usa equals() para comparar objetos (comparación por referencia por defecto)
        // Esto previene que el mismo evento se agregue múltiples veces
        if (!listaEventos.contains(evento)) {
            listaEventos.add(evento);
        }
    }

    /**
     * Obtiene el evento actualmente activo en el sistema.
     * 
     * El evento activo es el último evento registrado mediante registrarEvento().
     * Este método es fundamental para:
     * 
     * - **Formularios de registro**: Obtener el evento al cual el asistente se está registrando
     * - **Validación de código**: Comparar el código ingresado con evento.getCodigoAsistencia()
     * - **Preselección**: Mostrar el evento activo preseleccionado en ComboBox de iAdminEvento
     * 
     * Ejemplo de uso:
     * ```java
     * Evento eventoActual = GestorEventos.getEventoActivo();
     * if (eventoActual != null) {
     *     String codigoEsperado = eventoActual.getCodigoAsistencia();
     *     // Validar código ingresado contra codigoEsperado
     * }
     * ```
     * 
     * IMPORTANTE: Siempre verificar si es null antes de usar, especialmente
     * al inicio cuando no se ha creado ningún evento.
     * 
     * @return Objeto Evento que representa el evento activo, o null si no hay ningún
     *         evento registrado en el sistema todavía
     */
    public static Evento getEventoActivo() {
        return eventoActivo;
    }

    /**
     * Obtiene una copia de la lista completa de todos los eventos creados.
     * 
     * Este método es utilizado por:
     * - **iInvitado**: Para poblar el ComboBox de selección de eventos
     * - **iAdminEvento**: Para poblar el ComboBox de filtrado de registros por evento
     * - **Consultas**: Para iterar sobre todos los eventos disponibles
     * 
     * Nota de seguridad:
     * Este método retorna una COPIA de la lista (new ArrayList<>(listaEventos)),
     * no la referencia directa. Esto previene modificaciones externas accidentales
     * al repositorio de eventos.
     * 
     * Diferencia con GestorRegistros.obtenerRegistros():
     * - GestorRegistros retorna la referencia directa (menos seguro pero más eficiente)
     * - GestorEventos retorna una copia (más seguro pero menos eficiente)
     * 
     * Ejemplo de uso:
     * ```java
     * List<Evento> eventos = GestorEventos.obtenerEventos();
     * for (Evento e : eventos) {
     *     comboBox.addItem(e.getNombre());
     * }
     * ```
     * 
     * Complejidad: O(n) donde n es el número de eventos (por la copia)
     * 
     * @return List<Evento> - Nueva lista (copia) con todos los eventos del sistema.
     *         La lista original no se ve afectada por modificaciones a la lista retornada.
     */
    public static List<Evento> obtenerEventos() {
        // Retornar una nueva ArrayList que es una copia de listaEventos
        // Constructor de ArrayList con Collection: ArrayList(Collection<? extends E> c)
        return new ArrayList<>(listaEventos);
    }
}
