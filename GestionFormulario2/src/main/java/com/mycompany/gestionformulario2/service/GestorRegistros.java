
package com.mycompany.gestionformulario2.service;

// Importaciones de Java Collections Framework
import java.util.ArrayList; // Implementación de lista dinámica basada en arreglos
import java.util.List; // Interfaz para listas ordenadas
import com.mycompany.gestionformulario2.model.Registro;

/**
 * Clase gestora (Manager/Repository) que administra todos los registros de
 * asistencia a eventos.
 * 
 * Esta clase implementa el patrón Singleton implícito mediante métodos y
 * atributos estáticos,
 * proporcionando un punto de acceso global y único a la colección de registros.
 * 
 * Responsabilidades:
 * - Almacenar centralizadamente todos los registros de asistentes
 * - Proporcionar operaciones de agregar y consultar registros
 * - Mantener la persistencia en memoria durante la ejecución de la aplicación
 * 
 * Uso en el sistema:
 * - iFormularioAprendiz e iFormularioInvitado llaman a agregarRegistro() al
 * confirmar un registro
 * - iAdminEvento llama a obtenerRegistros() para mostrar todos los registros en
 * la tabla
 * - ExportadorExcel recibe la lista filtrada para exportar a Excel
 * 
 * Limitaciones actuales:
 * - Los datos solo persisten en memoria (se pierden al cerrar la aplicación)
 * - No hay persistencia en base de datos o archivos
 * - No hay operaciones de edición o eliminación de registros
 * 
 * Patrón de diseño: Repository Pattern + Singleton (implícito)
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class GestorRegistros {

  // ========== ATRIBUTO ESTÁTICO: REPOSITORIO DE REGISTROS ==========

  /**
   * Lista estática que almacena todos los registros de asistentes del sistema.
   * 
   * Características:
   * - **static**: Compartida por todas las instancias (aunque la clase no se
   * instancia)
   * - **final**: La referencia a la lista no puede cambiar, pero el contenido sí
   * - **private**: Solo accesible mediante los métodos públicos de esta clase
   * 
   * Tipo: ArrayList<Registro>
   * - ArrayList de java.util es una implementación de List basada en arreglos
   * dinámicos
   * - Proporciona acceso rápido por índice O(1)
   * - Permite duplicados y mantiene el orden de inserción
   * - Es NO thread-safe (no segura para concurrencia sin sincronización)
   * 
   * Ciclo de vida:
   * - Se inicializa al cargar la clase (antes de cualquier uso)
   * - Persiste mientras la JVM esté ejecutando la aplicación
   * - Se destruye cuando se cierra la aplicación
   */
  private static final List<Registro> registros = new ArrayList<>();

  /**
   * Agrega un nuevo registro de asistente a la lista centralizada del sistema.
   * 
   * Este método es llamado desde los formularios de registro
   * (iFormularioAprendiz,
   * iFormularioInvitado) después de que el usuario completa y valida sus datos.
   * 
   * Flujo de uso:
   * 1. Usuario llena el formulario y presiona "Registrar"
   * 2. Se validan todos los campos (nombre, correo, celular, etc.)
   * 3. Se crea un nuevo objeto Registro con los datos validados
   * 4. Se llama a GestorRegistros.agregarRegistro(nuevoRegistro)
   * 5. El registro se agrega a la lista estática y queda disponible para
   * consultas
   * 
   * Nota: Este método no valida duplicados ni datos nulos. La validación debe
   * realizarse antes de llamar a este método.
   * 
   * @param registro Objeto Registro (de la clase Registro.java) que contiene
   *                 todos
   *                 los datos del asistente: nombre, apellidos, documento,
   *                 programa,
   *                 celular, correo, evento, fecha/hora y estado.
   */
  public static void agregarRegistro(Registro registro) {
    // Agregar el registro al final de la lista usando el método add() de ArrayList
    // add() de ArrayList tiene complejidad O(1) amortizado
    registros.add(registro);
  }

  /**
   * Obtiene la lista completa de todos los registros almacenados en el sistema.
   * 
   * Este método proporciona acceso de lectura a todos los registros y es
   * utilizado por:
   * - **iAdminEvento**: Para mostrar todos los registros en la tabla de
   * asistentes
   * - **iAdminEvento (filtrado)**: Para filtrar registros por evento específico
   * - **ExportadorExcel**: Para obtener los registros a exportar (después de
   * filtrar)
   * 
   * ADVERTENCIA: Este método retorna la referencia directa a la lista interna.
   * Las modificaciones externas afectarán directamente al repositorio.
   * Para mayor seguridad, se podría retornar una copia: new
   * ArrayList<>(registros)
   * 
   * Uso típico con filtrado:
   * ```java
   * List<Registro> todos = GestorRegistros.obtenerRegistros();
   * List<Registro> filtrados = todos.stream()
   * .filter(r -> r.getNombreEvento().equals("Evento X"))
   * .collect(Collectors.toList());
   * ```
   * 
   * @return List<Registro> - Lista con todos los objetos Registro del sistema.
   *         La lista está ordenada por orden de inserción (FIFO - First In First
   *         Out)
   */
  public static List<Registro> obtenerRegistros() {
    // Retornar la referencia directa a la lista estática
    // Esto permite tanto lectura como modificación externa
    return registros;
  }
}
