
package com.mycompany.gestionformulario2;

/**
 * Clase que representa el registro de un asistente a un evento.
 * Almacena toda la información personal y académica del asistente,
 * así como los datos de su registro (fecha, hora y estado de asistencia).
 */
public class Registro {
    
    // Datos personales del asistente
    private String tipoVisitante;     // Tipo de visitante (Aprendiz, Externo, etc.)
    private String nombre;
    private String apellidos;         // Apellidos del asistente
    private String tipoDocumento;     // Tipo de identificación (CC, TI, CE, etc.)
    private String numeroDocumento;   // Número del documento de identidad
    
    // Datos académicos/institucionales
    private String programa;          // Programa de formación o carrera
    private String ficha;             // Número de ficha o grupo
    private String centro;            // Centro de formación o institución
    
    // Datos de contacto
    private String celular;
    private String correo;
    
    // Datos del registro
    private String nombreEvento;      // Nombre del evento al que asiste
    private String fechaHoraRegistro; // Momento en que se registró la asistencia
    private String estado;            // Estado de la asistencia (Presente, Ausente, etc.)

    /**
     * Constructor que inicializa un nuevo registro con todos los datos del asistente.
     * @param tipoVisitante Tipo de visitante
     * @param nombre Nombre del asistente
     * @param apellidos Apellidos del asistente
     * @param tipoDocumento Tipo de documento de identificación
     * @param numeroDocumento Número del documento de identidad
     * @param programa Programa académico o de formación
     * @param ficha Número de ficha o grupo
     * @param centro Centro educativo o de formación
     * @param celular Número de teléfono celular
     * @param correo Dirección de correo electrónico
     * @param nombreEvento Nombre del evento al que se registra
     * @param fechaHoraRegistro Fecha y hora del registro de asistencia
     * @param estado Estado actual de la asistencia
     */
    public Registro(String tipoVisitante, String nombre, String apellidos,
                    String tipoDocumento, String numeroDocumento,
                    String programa, String ficha, String centro,
                    String celular, String correo, String nombreEvento,
                    String fechaHoraRegistro, String estado) {

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

    // Constructor de compatibilidad sin nombreEvento
    public Registro(String tipoVisitante, String nombre, String apellidos,
                    String tipoDocumento, String numeroDocumento,
                    String programa, String ficha, String centro,
                    String celular, String correo,
                    String fechaHoraRegistro, String estado) {
        this(tipoVisitante, nombre, apellidos, tipoDocumento, numeroDocumento,
             programa, ficha, centro, celular, correo, "", fechaHoraRegistro, estado);
    }

    // Métodos getter para acceder a todos los atributos del registro
    
    /** @return Tipo de visitante */
    public String getTipoVisitante() { return tipoVisitante; }
    
    /** @return Nombre del asistente */
    public String getNombre() { return nombre; }
    
    /** @return Apellidos del asistente */
    public String getApellidos() { return apellidos; }
    
    /** @return Tipo de documento de identificación */
    public String getTipoDocumento() { return tipoDocumento; }
    
    /** @return Número del documento de identidad */
    public String getNumeroDocumento() { return numeroDocumento; }
    
    /** @return Programa académico o de formación */
    public String getPrograma() { return programa; }
    
    /** @return Número de ficha o grupo */
    public String getFicha() { return ficha; }
    
    /** @return Centro educativo o de formación */
    public String getCentro() { return centro; }
    
    /** @return Número de teléfono celular */
    public String getCelular() { return celular; }
    
    /** @return Dirección de correo electrónico */
    public String getCorreo() { return correo; }
    
    /** @return Nombre del evento al que asiste */
    public String getNombreEvento() { return nombreEvento; }
    
    /** @return Fecha y hora del registro de asistencia */
    public String getFechaHoraRegistro() { return fechaHoraRegistro; }
    
    /** @return Estado actual de la asistencia */
    public String getEstado() { return estado; }
}
