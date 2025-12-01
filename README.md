# GeneradorFormularios

Problema
--------
En los eventos actualmente se registra a los asistentes con formularios digitales (por ejemplo Google Forms) pero la asistencia se toma en papel el día del evento. Esto provoca trabajo duplicado, procesos lentos y errores al generar informes (cantidad de asistentes, tipo de asistentes, programas y fichas de aprendices SENA, etc.).

Qué resolvemos
--------------
Desarrollamos una aplicación para centralizar el registro y el control de asistencia de eventos:

- El organizador crea el evento (nombre, fecha, lugar y código de asistencia).
- Se generan formularios para aprendices SENA y para personas externas.
- Los participantes se registran desde los formularios y reciben correo de confirmación.
- El día del evento los asistentes confirman su asistencia mediante un enlace protegido con el código del organizador.
- Se envían recordatorios 1 día antes y se pueden exportar registros y asistencias a hojas de cálculo (CSV/XLSX).

Beneficios
---------
- Elimina la doble captura (digital + papel).
- Acelera la validación de asistencia.
- Facilita la generación de reportes por programa, ficha y tipo de asistente.
- Reduce errores y el tiempo de procesamiento para la oficina de bienestar.

Flujo básico
-----------
1. El organizador crea el evento y genera un código de asistencia.
2. Los participantes (aprendices o externos) completan su registro mediante el formulario correspondiente.
3. El día del evento, con el código, se confirma la asistencia desde el enlace enviado.
4. Los datos se pueden exportar para generar informes.

Siguiente paso
--------------
Implementar la aplicación (backend, frontend, envío de correos y exportación CSV/XLSX) según el stack elegido.

Contacto
--------
Abre un issue en el repositorio para comentar o proponer cambios.
