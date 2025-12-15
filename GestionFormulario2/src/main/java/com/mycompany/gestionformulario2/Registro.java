
package com.mycompany.gestionformulario2;

/**
 * Clase modelo que representa un registro de asistencia a un evento.
 * 
 * Esta clase es una estructura de datos (POJO - Plain Old Java Object) que encapsula
 * toda la información de un asistente que se registra para un evento.
 * 
 * Responsabilidades:
 * - Almacenar datos personales del asistente (nombre, apellidos, documento)
 * - Almacenar datos de contacto (celular, correo)
 * - Almacenar datos académicos/institucionales (programa, ficha, centro)
 * - Almacenar datos del registro (evento, fecha/hora, estado)
 * 
 * Uso en el sistema:
 * - Objetos de esta clase son creados en iFormularioAprendiz e iFormularioInvitado
 * - Son almacenados en GestorRegistros (lista estática centralizada)
 * - Son mostrados en tablas de iAdminEvento
 * - Son exportados a Excel por ExportadorExcel
 * 
 * Patrón de diseño: Value Object / Data Transfer Object (DTO)
 * 
 * @author Sistema de Gestión de Formularios
 * @version 1.0
 */
public class Registro {
    
    // ========== ATRIBUTOS: DATOS PERSONALES DEL ASISTENTE ==========
    
    /**
     * Tipo de visitante: "Aprendiz" o "Externo"
     * Define si el asistente es un aprendiz de la institución o un visitante externo
     */
    private String tipoVisitante;
    
    /**
     * Nombre(s) del asistente
     */
    private String nombre;
    
    /**
     * Apellidos completos del asistente
     */
    private String apellidos;
    
    /**
     * Tipo de documento de identificación
     * Valores comunes: "CC" (Cédula de Ciudadanía), "TI" (Tarjeta de Identidad), 
     * "CE" (Cédula de Extranjería), "Pasaporte"
     */
    private String tipoDocumento;
    
    /**
     * Número del documento de identidad (sin puntos ni guiones)
     */
    private String numeroDocumento;
    
    // ========== ATRIBUTOS: DATOS ACADÉMICOS/INSTITUCIONALES ==========
    
    /**
     * Programa de formación o carrera académica del asistente
     * Ejemplo: "Tecnología en Análisis y Desarrollo de Software"
     */
    private String programa;
    
    /**
     * Número de ficha o grupo al que pertenece el asistente
     * Ejemplo: "2558346"
     */
    private String ficha;
    
    /**
     * Centro de formación o institución educativa
     * Ejemplo: "SENA CEAI - Centro de Electricidad, Automatización Industrial"
     */
    private String centro;
    
    // ========== ATRIBUTOS: DATOS DE CONTACTO ==========
    
    /**
     * Número de teléfono celular del asistente (solo dígitos)
     * Debe tener mínimo 10 dígitos según validación del sistema
     */
    private String celular;
    
    /**
     * Dirección de correo electrónico del asistente
     * Validado con formato email estándar (xxx@xxx.xxx)
     */
    private String correo;
    
    // ========== ATRIBUTOS: DATOS DEL REGISTRO ==========
    
    /**
     * Nombre del evento al que se registra el asistente
     * Obtenido de Evento.getNombre() o GestorEventos.getEventoActivo()
     */
    private String nombreEvento;
    
    /**
     * Fecha y hora exacta del momento en que se realizó el registro
     * Formato típico: "dd/MM/yyyy HH:mm:ss"
     */
    private String fechaHoraRegistro;
    
    /**
     * Estado actual de la asistencia del registro
     * Valores comunes: "Presente", "Ausente", "Pendiente"
     */
    private String estado;

    /**
     * Constructor principal que inicializa un nuevo registro con todos los datos del asistente.
     * 
     * Este constructor es utilizado por las clases de formulario (iFormularioAprendiz,
     * iFormularioInvitado) para crear un nuevo objeto Registro con los datos ingresados
     * por el usuario.
     * 
     * Flujo de uso:
     * 1. Usuario llena el formulario en iFormularioAprendiz o iFormularioInvitado
     * 2. Al presionar "Registrar", se validan los datos
     * 3. Se crea un nuevo Registro con este constructor
     * 4. El registro se agrega a GestorRegistros mediante GestorRegistros.agregarRegistro()
     * 
     * @param tipoVisitante Tipo de visitante ("Aprendiz" o "Externo")
     * @param nombre Nombre del asistente (validado, mínimo 3 caracteres)
     * @param apellidos Apellidos del asistente (validado, mínimo 3 caracteres)
     * @param tipoDocumento Tipo de documento de identificación (CC, TI, CE, Pasaporte)
     * @param numeroDocumento Número del documento de identidad (solo dígitos)
     * @param programa Programa académico o de formación
     * @param ficha Número de ficha o grupo
     * @param centro Centro educativo o de formación
     * @param celular Número de teléfono celular (validado, mínimo 10 dígitos)
     * @param correo Dirección de correo electrónico (validado con formato email)
     * @param nombreEvento Nombre del evento al que se registra (obtenido de Evento)
     * @param fechaHoraRegistro Fecha y hora del registro de asistencia (generado con SimpleDateFormat)
     * @param estado Estado actual de la asistencia ("Presente", "Ausente", etc.)
     */
    public Registro(String tipoVisitante, String nombre, String apellidos,
                    String tipoDocumento, String numeroDocumento,
                    String programa, String ficha, String centro,
                    String celular, String correo, String nombreEvento,
                    String fechaHoraRegistro, String estado) {

        // Asignar cada parámetro al atributo correspondiente
        // Esto inicializa el estado interno del objeto Registro
        this.tipoVisitante = tipoVisitante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.programa = programa;
        this.ficha = ficha;
        this.centro = centro;
        this.celular = celular;
        this.correo = correo;
        this.nombreEvento = nombreEvento;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.estado = estado;
    }
    
    // ========== MÉTODOS GETTER (ACCESORES) ==========
    // Estos métodos permiten acceder a los atributos privados desde otras clases
    // Siguen el patrón JavaBean: get + NombreAtributo (con primera letra en mayúscula)
    // Son usados por:
    // - iAdminEvento para mostrar datos en la tabla
    // - ExportadorExcel para escribir datos en el archivo Excel
    // - Filtros y búsquedas en el sistema
    
    /**
     * Obtiene el tipo de visitante del registro.
     * @return String con el tipo: "Aprendiz" o "Externo"
     */
    public String getTipoVisitante() { return tipoVisitante; }
    
    /**
     * Obtiene el nombre del asistente.
     * @return String con el nombre del asistente
     */
    public String getNombre() { return nombre; }
    
    /**
     * Obtiene los apellidos del asistente.
     * @return String con los apellidos completos
     */
    public String getApellidos() { return apellidos; }
    
    /**
     * Obtiene el tipo de documento de identificación.
     * @return String con el tipo de documento (CC, TI, CE, Pasaporte)
     */
    public String getTipoDocumento() { return tipoDocumento; }
    
    /**
     * Obtiene el número del documento de identidad.
     * @return String con el número del documento (solo dígitos)
     */
    public String getNumeroDocumento() { return numeroDocumento; }
    
    /**
     * Obtiene el programa académico o de formación.
     * @return String con el nombre del programa
     */
    public String getPrograma() { return programa; }
    
    /**
     * Obtiene el número de ficha o grupo.
     * @return String con el número de ficha
     */
    public String getFicha() { return ficha; }
    
    /**
     * Obtiene el centro educativo o de formación.
     * @return String con el nombre del centro
     */
    public String getCentro() { return centro; }
    
    /**
     * Obtiene el número de teléfono celular.
     * @return String con el número de celular (mínimo 10 dígitos)
     */
    public String getCelular() { return celular; }
    
    /**
     * Obtiene la dirección de correo electrónico.
     * @return String con el correo electrónico en formato válido
     */
    public String getCorreo() { return correo; }
    
    /**
     * Obtiene el nombre del evento al que se registra el asistente.
     * Este valor proviene de Evento.getNombre() o GestorEventos.getEventoActivo().getNombre()
     * @return String con el nombre del evento
     */
    public String getNombreEvento() { return nombreEvento; }
    
    /**
     * Obtiene la fecha y hora del registro de asistencia.
     * Este valor es generado al momento del registro usando SimpleDateFormat
     * @return String con la fecha y hora en formato "dd/MM/yyyy HH:mm:ss"
     */
    public String getFechaHoraRegistro() { return fechaHoraRegistro; }
    
    /**
     * Obtiene el estado actual de la asistencia.
     * @return String con el estado ("Presente", "Ausente", "Pendiente", etc.")
     */
    public String getEstado() { return estado; }
}
