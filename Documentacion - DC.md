# Diagrama de Clases del Sistema ECOTRIBUTARIO

Este documento describe la estructura y diseño del diagrama de clases del sistema **ECOTRIBUTARIO**, cuyo objetivo es facilitar la gestión de incentivos
fiscales para empresas que demuestran buenas prácticas ambientales a través de evidencias verificables.

## 📚 Descripción General del Diagrama de Clases

El sistema se compone de varias clases principales que cubren la autenticación, gestión de empresas, manejo de evidencias ambientales, generación de reportes,
descuentos fiscales, notificaciones y seguridad.

## 🧱 Clases y Relaciones

### 1. **Empresa**
Representa a cada organización registrada.

- Atributos:
  - `id_empresa`, `nombre_empresa`, `usuario`, `tipo_empresa`, `contraseña`, `correo_empresa`, `ganancias_empresa`, `telefono`
- Relación:
  - 1 empresa puede tener *muchas* evidencias.
  - Está conectada al portal web.
  - Se relaciona con autenticación.
- Funciones:
  - Centraliza la información general y económica de la empresa.

### 2. **Evidencias**
Contiene la información de cada evidencia ambiental cargada.

- Atributos:
  - `informacion_ambiental`, `tipo_evidencia`, `nivel_evidencia`, `fecha_subida`, `estado_validacion`, `descripcion`
- Métodos:
  - `+generar_evidencia()`, `+clasificar_evidencia()`, `+validar_evidencia()`
- Relación:
  - Asociada a una empresa y múltiples evidencias pueden formar parte de un historial.
  - Se conecta a los reportes.

### 3. **Reporte**
Representa informes generados tras analizar evidencias.

- Atributos:
  - `nombre`, `porcentaje_cumplimiento`, `tipo_formato`
- Métodos:
  - `+generar_reporte(void)`
- Subclases:
  - `Reporte PDF` → `+Generar_PDF()`
  - `Reporte Excel` → `+Generar_Excel()`
  - `Reporte PNG` → `+Generar_PNG()`
- Relación:
  - Se genera a partir de evidencias.
  - Forma parte del historial.
    
### 4. **Historial**
Almacena todas las acciones pasadas de una empresa.

- Atributos:
  - `evidencias_cargadas`, `reportes_realizados`, `usuario_responsable`
- Métodos:
  - `+agregar_evento()`, `+consultar_evento()`
- Relación:
  - Tiene lista de evidencias y reportes relacionados con una empresa.

### 5. **Descuento**
Gestiona los beneficios fiscales otorgados.

- Atributos:
  - `porcentaje_cumplimiento`, `cumplimiento`
- Métodos:
  - `+Generar_descuento(float)`, `+aceptar_incentivo()`, `+rechazar_incentivo()`
- Relación:
  - Se basa en los reportes para su cálculo.

### 6. **Autenticación**
Gestiona el acceso al sistema.

- Atributos:
  - `codigo_verificacion`
- Métodos:
  - `+encriptar_contraseña(float)`, `+validar_credenciales()`
- Relación:
  - Asociada a la empresa para validación segura.

### 7. **Seguridad**
Maneja eventos de seguridad y alertas.

- Atributos:
  - `registrar_intentos_fallidos`
- Métodos:
  - `+generar_alertas()`

### 8. **Notificaciones_empresa**
Envía alertas y mensajes a las empresas.

- Atributos:
  - `mensaje`, `mensaje_emergencia`, `codigo_verificacion`
- Métodos:
  - `+enviar_notificacion(String)`
- Relación:
  - Se conecta al portal web, y de ahí con las empresas.

### 9. **Portal Web**
Punto de acceso del sistema, conecta múltiples módulos.

- Relación:
  - Asociación con `Notificaciones_empresa`, `Empresa` y demás procesos.


- Rechazo o aprobación de incentivos.

## 🧠 Justificación del Diseño

- **Modularidad**: Cada clase cumple una responsabilidad específica.
- **Escalabilidad**: Se puede ampliar con nuevas funciones (por ejemplo, nuevos formatos de reporte).
- **Trazabilidad**: El historial garantiza que toda acción esté registrada.
- **Seguridad y confianza**: Autenticación robusta y alertas automáticas protegen la información.
- **Simplicidad**: Aunque el sistema es robusto, las relaciones entre clases se mantienen claras y lógicas.


