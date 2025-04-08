# 📦 Diagrama de Despliegue - Sistema ECOTRIBUTARIO

Este diagrama representa la arquitectura física del sistema ECOTRIBUTARIO, mostrando cómo los distintos nodos (dispositivos o entornos de ejecución)
están conectados entre sí y qué componentes del sistema se ejecutan en cada uno.

## 🧩 Nodos y Componentes

### 1. <<device>> NavegadorWeb
- **Componente:** Cliente
- **Descripción:** Representa al usuario final accediendo al sistema desde un navegador web.
- **Tecnología:** Chrome, Firefox, Safari, etc.

### 2. <<device>> ServidorWeb
- **Componente:** Frontend
- **Descripción:** Contiene la capa de presentación del sistema, como HTML, CSS, JS, o frameworks tipo React, Angular, etc.
- **Comunicación:** HTTP/HTTPS

### 3. <<device>> ServidorAplicaciones
- **Componente:** ECOTRIBUTARIO
- **Descripción:** Contiene la lógica de negocio principal del sistema (backend).
- **Tecnología:** Node.js, Spring Boot, Django, etc.
- **Comunicación:** API REST con Frontend, conexión directa con Base de Datos.

### 4. <<device>> BaseDatos
- **Componente:** Notificaciones (datos almacenados)
- **Descripción:** Sistema de gestión de bases de datos donde se persisten todas las entidades del sistema (usuarios, evidencias, acciones, etc.).
- **Tecnología:** Sera usada MARIABD
- **Comunicación:** Directa con el servidor de aplicaciones (protocolo SQL/TCP).

### 5. <<device>> ServicioCorreo
- **Componente:** Notificaciones
- **Descripción:** Servicio encargado de enviar correos o SMS al usuario para confirmar acciones importantes (como subida de evidencia, cambios de estado, etc.).
- **Tecnología:** SMTP, Firebase, Twilio, SendGrid, etc.
- **Comunicación:** API con el backend del sistema.


## 🔗 Relaciones entre Nodos

| Origen | Destino | Tipo | Protocolo / Medio |
|--------|---------|------|--------------------|
| NavegadorWeb | ServidorWeb | Comunicación | HTTP/HTTPS |
| ServidorWeb | ServidorAplicaciones | Comunicación | API (REST/JSON) |
| ServidorAplicaciones | BaseDatos | Comunicación | SQL/TCP |
| ServidorAplicaciones | ServicioCorreo | Comunicación | API / Notificaciones |
| ServicioCorreo | BaseDatos | Comunicación (opcional) | Logs / Confirmaciones |


![Diagrama de despliegue](https://github.com/user-attachments/assets/93c2890e-2add-4b17-a54f-3f67c65c0b67)
