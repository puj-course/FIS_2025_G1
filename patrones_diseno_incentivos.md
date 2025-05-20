# Documentación de Patrones de Diseño – Módulo de Incentivos

## Objetivo

Documentar los **patrones de diseño GoF** utilizados en el módulo de incentivos del sistema **Ecotributario**, relacionándolos con el flujo real de uso de la aplicación. En especial, se detalla la interacción diferenciada entre **Empresas** y **Administradores**, justificando el diseño bajo buenas prácticas de programación orientada a objetos.

---

### 2. Interacción desde el perfil **Empresa**

#### a. Calcular Incentivo Estimado
- El sistema solicita:
  - Tipo de actividad
  - Magnitud de impacto
- Se aplica una **estrategia de cálculo** para estimar el incentivo automáticamente.
- Se usan **patrones como Strategy y Factory** para aplicar la lógica según el tipo de actividad.
- El sistema ofrece dos opciones:
  - Visualizar solo el estimado.
  - **Generar reporte detallado** para formalizar la actividad.

#### b. Generar Reporte Detallado
- Se llena un formulario con datos detallados.
- El sistema realiza **validaciones automáticas** del formulario usando estrategias encapsuladas.
- Si es válido, se guarda con estado `En revisión`.

> *Nota: No se valida el impacto ambiental. Esa validación es función del Administrador.*

---

### 3. Interacción desde el perfil **Administrador**

#### a. Validar Reportes Subidos
- Visualiza reportes enviados.
- Puede cambiar su estado (`Validado`, `Denegado`, `En revisión`) y dejar comentarios.
- El sistema **envía una notificación por Telegram a la empresa** cuando hay cambio de estado.

---

## Patrones GoF Aplicados y Relación con el Flujo

### 1. **Factory Method** (Creacional)

**Uso en el sistema**: Creación de objetos de tipo `Incentivo` según el tipo de actividad seleccionada.

**Ubicación detectada**:
- `HistorialSolicitudesController.java`
- `InicioEmpresaController.java`

### 2. **Strategy** (Comportamiento)

**Uso en el sistema**: Validación de formularios usando diferentes estrategias (`ValidadorAdmin`, `ValidadorEmpresa`, etc.).

**Ubicación detectada**:
- `CampoValidador.java`
- `ValidadorAdmin.java`
- `ValidadorEmpresa.java`

Permite intercambiar validaciones en tiempo de ejecución, cumpliendo con el **principio abierto/cerrado**.

### 3. **Singleton** (Creacional)

**Uso en el sistema**: Control centralizado de conexiones y acceso a sesión o notificaciones.

**Ubicación detectada**:
- `Conexion.java`
- `TelegramBot.java`
- `SesionAdmin.java`
- `SesionEmpresa.java`
- También presente en controladores como `CrearSolicitudController.java`, `LoginAdminController.java`, entre otros.

---

## Clasificación de los Patrones

| Patrón      | Tipo según GoF           | Categoría     | Aplicación Detectada                      |
|-------------|---------------------------|---------------|-------------------------------------------|
| Factory     | Método de creación        | Creacional    | Creación de incentivos según tipo         |
| Strategy    | Encapsulamiento de lógica | Comportamiento| Validaciones dinámicas de formularios     |
| Singleton   | Instancia única compartida| Creacional    | Conexión a BD y servicios globales        |

---

## Beneficios del Diseño Actual

- Claridad en roles: separación Empresa vs. Administrador.
- Patrón **Strategy** permite validar formularios sin duplicar lógica.
- Uso de **Singleton** asegura eficiencia en manejo de conexiones.
- **Factory** permite extender nuevos tipos de incentivos fácilmente.

---

## Recomendaciones Futuras

- Aplicar el patrón **Observer** para notificar automáticamente cambios de estado.
- Evaluar uso de **Chain of Responsibility** para validaciones encadenadas de reportes.
- Incorporar principios **GRASP** para mejorar asignación de responsabilidades.

---
