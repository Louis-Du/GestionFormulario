package com.mycompany.gestionformulario2;

public class Evento {

    private String nombre;
    private String fechaHora;
    private String lugar;
    private String codigoAsistencia;

    public Evento(String nombre, String fechaHora, String lugar, String codigoAsistencia) {
    this.nombre = nombre;
    this.fechaHora = fechaHora;
    this.lugar = lugar;
    this.codigoAsistencia = codigoAsistencia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public String getCodigoAsistencia() {
        return codigoAsistencia;
    }
}
