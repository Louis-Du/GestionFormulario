# Gestión de Formulario 

---
**Gestión de Formulario** es un programa de escritorio que ayuda en el manejo y creación de formularios.

---
## Problematica
Nuestro sistema se basa en un problema real que se presenta en el _Servicio Nacional de Aprendizaje (Sena)_ el cual consiste en los largos tiempos que se necesitan para crear un formulario para los eventos, esto también incluye el registro de los participantes y toma de la asistencia el día del evento 

---
# Características clave
- Login con roles (Administrador/Invitado).
- Gestión de eventos y formularios.
- Registro de asistentes con datos completos.
- Marcado de asistencia (checkbox) y exportación a Excel.
- Recordatorio por correo 1 día antes (SMTP Gmail).

---
# Tecnologías utilizadas
- **Lenguaje:** Java 19
- **Build Tool:** Maven
- **Librería principal:** Apache POI (manipulación de Excel/Office)
- **Tipo:** Aplicación de escritorio (JAR)

---
# Arquitectura y módulos

- [Vista (Swing](#view): iLogin, iAdminEvento, iInvitado, iFormulario*.
- [Servicios](#service): GestorEventos, GestorRegistros, NotificacionService, SchedulerService, EmailService, ExportadorExcel.
- [Modelos](#model): Evento, Registro.
- Build: Maven, Java 19.
---
# Instalación y ejecución

```
git clone https://github.com/Louis-DU/GestionFormulario.git
mvn clean package
java -jar target/GestionFormulario2-*.jar
```
(Opcional) Ejecutar desde IDE.

## Uso rápido

Pasos: abrir app, login, crear evento, compartir formulario, marcar asistencia, exportar Excel.



---
## Colaboradores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/eljavi0">
        <img src="https://github.com/eljavi0.png" width="80" /><br />
        <sub><b>eljavi0</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Louis-Du">
        <img src="https://github.com/Louis-Du.png" width="80" /><br />
        <sub><b>Louis-Du</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/lukasa133">
        <img src="https://github.com/lukasa133.png" width="80" /><br />
        <sub><b>lukasa133</b></sub>
      </a>
    </td>
  </tr>
</table>
