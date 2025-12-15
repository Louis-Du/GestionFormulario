package com.mycompany.gestionformulario2;

/**
 * Clase modelo que representa un evento dentro del sistema de gestión de formularios.
 * 
 * Esta clase es una estructura de datos (POJO - Plain Old Java Object) que encapsula
 * toda la información de un evento al cual los usuarios pueden registrarse.
 * 
 * Responsabilidades:
 * - Almacenar información básica del evento (nombre, fecha, lugar)
 * - Almacenar el código de asistencia para validar registros
 * - Proporcionar acceso de solo lectura a los datos mediante getters
 * 
 * Uso en el sistema:
 * - Objetos de esta clase son creados en iAdminEvento mediante el diálogo "Crear Evento"
 * - Son almacenados en GestorEventos (lista estática y evento activo)
 * - Son mostrados en el ComboBox de selección de eventos en iInvitado
 * - El código de asistencia es validado en iFormularioAprendiz e iFormularioInvitado
 * 
 * Patrón de diseño: Value Object / Data Transfer Object (DTO)
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class Evento {

    // ========== ATRIBUTOS DEL EVENTO ==========
    
    /**
     * Nombre descriptivo del evento.
     * Debe ser único y representativo para facilitar la identificación.
     * Validación: Mínimo 5 caracteres, no puede estar vacío (ver iAdminEvento.esNombreValido())
     * Ejemplo: "Conferencia de Inteligencia Artificial 2025"
     */
    private String nombre;
    
    /**
     * Fecha y hora en que se realizará el evento.
     * Formato generado por JDateChooser con JSpinner de tiempo.
     * Ejemplo: "15/12/2025 14:30"
     */
    private String fechaHora;
    
    /**
     * Ubicación física donde se llevará a cabo el evento.
     * Validación: Solo letras, números y espacios (ver iAdminEvento.esLugarValido())
     * Ejemplo: "Auditorio Principal - Edificio A"
     */
    private String lugar;
    
    /**
     * Código único alfanumérico para validar la asistencia al evento.
     * Los usuarios deben ingresar este código al registrarse para confirmar su asistencia.
     * Validación: Alfanumérico sin espacios, mínimo 4 caracteres (ver iAdminEvento.esCodigoValido())
     * Ejemplo: "CONF2025", "AI2025"
     */
    private String codigoAsistencia;

    /**
     * Constructor que inicializa un nuevo evento con todos sus datos.
     * 
     * Este constructor es utilizado por iAdminEvento cuando el administrador
     * crea un nuevo evento mediante el diálogo modal de creación.
     * 
     * Flujo de uso:
     * 1. Administrador llena el formulario en el JDialog de iAdminEvento
     * 2. Al presionar "Aceptar", se validan los datos
     * 3. Se crea un nuevo Evento con este constructor
     * 4. El evento se registra en GestorEventos mediante GestorEventos.registrarEvento()
     * 
     * @param nombre Nombre descriptivo del evento (validado, mínimo 5 caracteres)
     * @param fechaHora Fecha y hora programada del evento (obtenida de JDateChooser + JSpinner)
     * @param lugar Lugar donde se realizará el evento (validado, alfanumérico con espacios)
     * @param codigoAsistencia Código único para validar la asistencia (validado, alfanumérico sin espacios, mínimo 4 caracteres)
     */
    public Evento(String nombre, String fechaHora, String lugar, String codigoAsistencia) {
        // Asignar cada parámetro al atributo correspondiente
        // Esto inicializa el estado interno del objeto Evento
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
        this.codigoAsistencia = codigoAsistencia;
    }

    // ========== MÉTODOS GETTER (ACCESORES) ==========
    // Estos métodos permiten acceder a los atributos privados desde otras clases
    // Siguen el patrón JavaBean: get + NombreAtributo (con primera letra en mayúscula)
    // NO hay setters (mutadores) porque los eventos son inmutables después de creados
    // Son usados por:
    // - GestorEventos para gestionar eventos
    // - iInvitado para mostrar eventos en ComboBox
    // - iFormularioAprendiz/iFormularioInvitado para validar códigos de asistencia
    // - iAdminEvento para mostrar información de eventos
    
    /**
     * Obtiene el nombre del evento.
     * 
     * Este método es ampliamente utilizado en el sistema:
     * - En iInvitado para poblar el ComboBox de selección
     * - En GestorRegistros para filtrar registros por evento
     * - En ExportadorExcel para generar el nombre del archivo
     * 
     * @return String con el nombre del evento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la fecha y hora programada del evento.
     * 
     * @return String con la fecha y hora en el formato generado por JDateChooser
     *         Formato típico: "dd/MM/yyyy HH:mm"
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Obtiene el lugar donde se realizará el evento.
     * 
     * @return String con la ubicación física del evento
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Obtiene el código de asistencia del evento.
     * 
     * Este código es validado en los formularios de registro (iFormularioAprendiz,
     * iFormularioInvitado) mediante comparación con el código del evento activo.
     * 
     * @return String con el código de asistencia alfanumérico (sin espacios)
     */
    public String getCodigoAsistencia() {
        return codigoAsistencia;
    }
}
