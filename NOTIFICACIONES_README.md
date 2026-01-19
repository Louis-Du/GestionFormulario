# Sistema de Notificaciones por Correo Electrónico

## 📧 Configuración del Sistema

El sistema ahora incluye envío automático de notificaciones por correo electrónico para eventos registrados.

### ✅ Componentes Implementados

1. **EmailService.java** - Servicio de envío SMTP Gmail
2. **NotificacionService.java** - Lógica de notificaciones automáticas
3. **SchedulerService.java** - Programador de tareas (cada 1 hora)
4. **Registro.java** (modificado) - Flags para control de duplicados
5. **GestionFormulario2.java** (modificado) - Inicialización automática

---

## 🔧 Configuración de Gmail

### Paso 1: Habilitar App Password en Gmail

1. Ir a [myaccount.google.com](https://myaccount.google.com)
2. Clic en **Seguridad** (menú lateral izquierdo)
3. Activar **Verificación en 2 pasos** (si no está activada)
4. Ir a **Contraseñas de aplicaciones**
5. Seleccionar:
   - Aplicación: **Correo**
   - Dispositivo: **Otro (nombre personalizado)** → escribir "Sistema Eventos"
6. Clic en **Generar**
7. Copiar el código de 16 caracteres (sin espacios)

### Paso 2: Configurar Variables de Entorno

#### En Linux:

Agregar al archivo `~/.bashrc` o `~/.profile`:

```bash
export EMAIL_USER="tu_correo@gmail.com"
export EMAIL_PASS="xxxx xxxx xxxx xxxx"  # App Password de 16 caracteres
```

Luego ejecutar:
```bash
source ~/.bashrc
```

#### En Windows:

Ejecutar en PowerShell como administrador:

```powershell
[System.Environment]::SetEnvironmentVariable('EMAIL_USER', 'tu_correo@gmail.com', 'User')
[System.Environment]::SetEnvironmentVariable('EMAIL_PASS', 'xxxx xxxx xxxx xxxx', 'User')
```

O configurar manualmente:
1. Buscar "Editar las variables de entorno del sistema"
2. Clic en **Variables de entorno**
3. En "Variables de usuario", clic en **Nueva**
4. Agregar:
   - Nombre: `EMAIL_USER` → Valor: `tu_correo@gmail.com`
   - Nombre: `EMAIL_PASS` → Valor: `xxxx xxxx xxxx xxxx`

**⚠️ IMPORTANTE:** Reiniciar NetBeans/IDE después de configurar las variables.

---

## 📅 Funcionamiento del Sistema

### Tipos de Notificaciones

1. **Recordatorio (3 días antes)**
   - Se envía automáticamente 3 días antes del evento
   - Incluye: nombre, fecha/hora, lugar del evento
   - Solo se envía una vez por registro

2. **Código de Asistencia (día del evento)**
   - Se envía el mismo día del evento
   - Incluye: código de asistencia para registrar presencia
   - Solo se envía una vez por registro

### Verificación Automática

- **Frecuencia:** Cada 1 hora
- **Inicio:** 30 segundos después de abrir la aplicación
- **Ejecución:** En segundo plano (no interfiere con la UI)
- **Sin duplicados:** Sistema de flags evita reenvíos

---

## 🧪 Pruebas

### Verificar Configuración

1. Abrir consola del IDE (NetBeans/IntelliJ)
2. Al iniciar la aplicación, buscar logs:
   ```
   INFO: Iniciando servicio de notificaciones automáticas...
   INFO: Scheduler iniciado exitosamente.
   ```

3. Si las credenciales están mal configuradas:
   ```
   WARNING: Variables de entorno EMAIL_USER y/o EMAIL_PASS no configuradas.
   ```

### Probar Envío Manual

Puedes agregar temporalmente en `iAdminEvento` un botón de prueba:

```java
// En btnAdminEventActionPerformed o crear nuevo botón
NotificacionService notifService = new NotificacionService();
boolean exito = notifService.enviarCorreoPrueba("tu_correo@gmail.com");
if (exito) {
    JOptionPane.showMessageDialog(this, "Correo de prueba enviado");
} else {
    JOptionPane.showMessageDialog(this, "Error al enviar correo");
}
```

---

## 📝 Formato de Fechas en Eventos

El sistema detecta automáticamente estos formatos:
- `yyyy-MM-dd HH:mm` (ejemplo: `2026-01-25 14:30`)
- `yyyy-MM-dd HH:mm:ss`
- `dd/MM/yyyy HH:mm`
- `dd/MM/yyyy HH:mm:ss`
- `yyyy-MM-dd`
- `dd/MM/yyyy`

**Recomendado:** Usar el formato generado por `JDateChooser` en `iAdminEvento` (`yyyy-MM-dd HH:mm`).

---

## 🛡️ Seguridad

- ✅ Credenciales **nunca** en código fuente
- ✅ Variables de entorno por usuario
- ✅ App Password (no contraseña real de Gmail)
- ✅ TLS habilitado para conexión segura
- ✅ Logs sin exponer credenciales

---

## 🐛 Resolución de Problemas

### Error: "Authentication failed"

**Causa:** Credenciales incorrectas o App Password no configurado

**Solución:**
1. Verificar que EMAIL_USER sea el correo completo
2. Verificar que EMAIL_PASS sea el App Password de 16 caracteres
3. Regenerar App Password si es necesario
4. Reiniciar IDE

### Error: "Connection timed out"

**Causa:** Firewall bloqueando puerto 587 o sin internet

**Solución:**
1. Verificar conexión a internet
2. Permitir conexión SMTP saliente (puerto 587)
3. Deshabilitar temporalmente antivirus/firewall para probar

### No se envían correos

**Causa:** Variables de entorno no configuradas o no visibles para la JVM

**Solución:**
1. Verificar con código de prueba:
   ```java
   System.out.println("USER: " + System.getenv("EMAIL_USER"));
   System.out.println("PASS: " + (System.getenv("EMAIL_PASS") != null ? "Configurado" : "No configurado"));
   ```
2. Reiniciar IDE después de configurar variables
3. Verificar logs en consola al iniciar aplicación

---

## 📚 Dependencias Agregadas

En `pom.xml`:

```xml
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>jakarta.mail</artifactId>
    <version>2.0.1</version>
</dependency>
```

Ejecutar para descargar:
```bash
mvn clean install
```

---

## 🎯 Próximos Pasos (Opcional)

- [ ] Agregar configuración de días de recordatorio en UI
- [ ] Permitir plantillas personalizables de correos
- [ ] Agregar logs visuales en interfaz de administración
- [ ] Implementar historial de correos enviados
- [ ] Agregar recordatorios múltiples (7, 3, 1 día antes)

---

**Desarrollado por:** Sistema de Gestión de Formularios v2.0  
**Última actualización:** Enero 2026
