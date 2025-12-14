package com.mycompany.gestionformulario2;

/**
 * Clase que representa un evento dentro del sistema de gestión de formularios.
 * Almacena la información básica de un evento como nombre, fecha, lugar y código de asistencia.
 */
public class Evento {

    // Nombre del evento
    private String nombre;
    // Fecha y hora en que se realizará el evento
    private String fechaHora;
    // Ubicación física donde se llevará a cabo el evento
    private String lugar;
    // Código único para registrar la asistencia al evento
    private String codigoAsistencia;

    /**
     * Constructor que inicializa un nuevo evento con todos sus datos.
     * @param nombre Nombre descriptivo del evento
     * @param fechaHora Fecha y hora programada del evento
     * @param lugar Lugar donde se realizará el evento
     * @param codigoAsistencia Código único para validar la asistencia
     */
    public Evento(String nombre, String fechaHora, String lugar, String codigoAsistencia) {
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
        this.codigoAsistencia = codigoAsistencia;
    }

    // Métodos getter para acceder a los atributos del evento
    
    /**
     * @return El nombre del evento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return La fecha y hora del evento
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * @return El lugar donde se realizará el evento
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @return El código de asistencia del evento
     */
    public String getCodigoAsistencia() {
        return codigoAsistencia;
    }
}
