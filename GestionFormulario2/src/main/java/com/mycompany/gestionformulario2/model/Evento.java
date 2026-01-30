package com.mycompany.gestionformulario2.model;

public class Evento {
  private String nombre;
  private String fechaHora;
  private String lugar;
  private String codigoAsistencia;

  /**
   * Constructor que inicializa un nuevo evento con todos sus datos.
   * 
   * Este constructor es utilizado por iAdminEvento cuando el administrador
   * crea un nuevo evento mediante el diálogo modal de creación.
   */
  public Evento(String nombre, String fechaHora, String lugar, String codigoAsistencia) {
    // Asignar cada parámetro al atributo correspondiente
    // Esto inicializa el estado interno del objeto Evento
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
