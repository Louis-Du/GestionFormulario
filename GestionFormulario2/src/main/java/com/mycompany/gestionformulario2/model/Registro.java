
package com.mycompany.gestionformulario2.model;

public class Registro {
  private String tipoVisitante;
  private String nombre;
  private String apellidos;
  private String tipoDocumento;
  private String numeroDocumento;
  private String programa;
  private String ficha;
  private String centro;
  private String celular;
  private String correo;
  private String nombreEvento;
  private String fechaHoraRegistro;
  private String estado;

  // ========== ATRIBUTOS: CONTROL DE NOTIFICACIONES ==========
  private boolean recordatorioEnviado;
  private boolean codigoEnviado;

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

    // Inicializar flags de notificaciones en false
    this.recordatorioEnviado = false;
    this.codigoEnviado = false;
  }

  public String getTipoVisitante() {
    return tipoVisitante;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public String getPrograma() {
    return programa;
  }

  public String getFicha() {
    return ficha;
  }

  public String getCentro() {
    return centro;
  }

  public String getCelular() {
    return celular;
  }

  public String getCorreo() {
    return correo;
  }

  public String getNombreEvento() {
    return nombreEvento;
  }

  public String getFechaHoraRegistro() {
    return fechaHoraRegistro;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  // ========== MÉTODOS GETTER/SETTER PARA CONTROL DE NOTIFICACIONES ==========
  public boolean isRecordatorioEnviado() {
    return recordatorioEnviado;
  }

  public void setRecordatorioEnviado(boolean recordatorioEnviado) {
    this.recordatorioEnviado = recordatorioEnviado;
  }

  public boolean isCodigoEnviado() {
    return codigoEnviado;
  }

  public void setCodigoEnviado(boolean codigoEnviado) {
    this.codigoEnviado = codigoEnviado;
  }
}
