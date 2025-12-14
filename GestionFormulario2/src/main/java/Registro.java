
package com.mycompany.gestionformulario2;

public class Registro {
    
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String programa;
    private String ficha;
    private String centro;
    private String celular;
    private String correo;
    private String fechaHoraRegistro;
    private String estado;

    public Registro(String nombre, String tipoDocumento, String numeroDocumento,
                    String programa, String ficha, String centro,
                    String celular, String correo,
                    String fechaHoraRegistro, String estado) {

        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.programa = programa;
        this.ficha = ficha;
        this.centro = centro;
        this.celular = celular;
        this.correo = correo;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.estado = estado;
    }

    public String getNombre() { return nombre; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public String getPrograma() { return programa; }
    public String getFicha() { return ficha; }
    public String getCentro() { return centro; }
    public String getCelular() { return celular; }
    public String getCorreo() { return correo; }
    public String getFechaHoraRegistro() { return fechaHoraRegistro; }
    public String getEstado() { return estado; }
}
