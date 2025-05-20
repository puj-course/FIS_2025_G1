# Documentación de Patrones en el Proyecto Ecotributario

## 🎯 Relación con la rúbrica
> El código desarrollado responde a las historias de usuario y cumple con lo que debe proveer el aplicativo. Además, se evidencia la implementación activa de los patrones aprendidos en clase.

---

## 💠 Patrones identificados

### 1. MVC – Modelo Vista Controlador
**Tipo**: Patrón arquitectónico

#### ✔ Controladores (`src/main/java/com/ecotributario/controllers`)
- CrearSolicitudController.java
- HistorialSolicitudesController.java
- InicioAdministradorController.java
- InicioController.java
- InicioEmpresaController.java
- LoginAdminController.java
- LoginEmpresaController.java
- RegistrarAdminController.java
- RegistrarEmpresaController.java
- RevisarSolicitudesController.java

#### ✔ Modelo (`src/main/java/com/ecotributario/models`)
- Solicitud.java

**Justificación**:  
El proyecto separa claramente la lógica de presentación (controladores JavaFX), la vista (FXML) y el modelo de datos. Esto sigue el patrón MVC, permitiendo modularidad y facilitando pruebas y mantenimiento.

---

### 2. Singleton – Conexión única a la base de datos
**Clase**: Conexion.java

**Justificación**:  
Esta clase implementa una conexión estática (`static Connection`) que se reutiliza, evitando múltiples instancias de conexión a base de datos. Este comportamiento es típico del patrón Singleton, utilizado para acceso global controlado.

---

### 3. Utility – Clase de utilidad sin estado
**Clase**: TelegramBot.java

**Justificación**:  
TelegramBot es una clase con métodos estáticos, que actúa como helper sin mantener estado interno. Este tipo de clase sigue el patrón utilitario, facilitando tareas como el envío de mensajes.

---

### 4. Observer (Implícito) – Comunicación reactiva
**Clases**:
- TelegramBot.java
- RevisarSolicitudesController.java
- TelegramTest.java

**Justificación**:  
Aunque no se usó una interfaz formal de Observer, el comportamiento observado permite decir que el sistema reacciona al cambio del estado de solicitudes mediante el envío de mensajes a través del bot de Telegram, actuando como un canal de notificación reactivo.

---

## ✅ Conclusión
El código implementa efectivamente varios patrones vistos en clase, como MVC, Singleton, Utility y un patrón Observer simplificado, alineándose con las historias de usuario y facilitando escalabilidad y mantenibilidad.
