# 🧩 Validación Automática de Actividades – Diseño Conceptual

## 🎯 Objetivo

Diseñar un módulo de validación automática que verifique si los datos ingresados en el sistema cumplen con ciertos criterios mínimos antes de ser aceptados como válidos. Este módulo se aplicará principalmente sobre los registros de la tabla `Reportes` del sistema **Ecotributario**, garantizando coherencia, integridad y automatización sin intervención manual.

> ⚠️ **Importante**:  
> Esta validación **no determina si una actividad es ambientalmente válida o si merece incentivo**.  
> **Solo valida que los datos estén bien formateados** y sean técnicamente correctos.  
> La revisión del contenido y la aprobación del incentivo **corresponde únicamente al rol de administrador**.

---

## 🧱 Validaciones Planeadas (Basadas en la Base de Datos)

| Tabla     | Campo           | Validación Planeada                                 |
|-----------|------------------|-----------------------------------------------------|
| Reportes  | `descripcion`    | Longitud mínima (ej. ≥ 15 caracteres, sin espacios) |
| Reportes  | `fecha_reporte`  | Fecha válida (formato correcto y no futura)         |
| Reportes  | `id_usuario`     | Usuario debe existir en la tabla `Usuarios`         |
| Reportes  | `id_incentivo`   | Incentivo debe existir en la tabla `Incentivos`     |

---

## ⚙️ Diseño del Módulo de Validación

El componente `ValidadorActividad` centralizará las reglas de validación. Este recibirá un DTO con los datos del reporte y devolverá un resultado booleano o lanzará una excepción personalizada con los errores encontrados.

El resultado de la validación:
- ✅ Si es correcto: el reporte se guarda y queda con estado `En revisión`.
- ❌ Si hay errores: se detiene el proceso y se muestran mensajes claros al usuario.

---

## 🧠 Aplicación de Principios SOLID

| Principio | Aplicación |
|----------|-------------|
| **S - Responsabilidad Única** | `ValidadorActividad` se enfocará exclusivamente en validar datos. No se encargará de persistencia, comunicación con la interfaz ni control de errores externos. |
| **O - Abierto/Cerrado** | Las reglas se podrán extender (añadir nuevas validaciones) sin modificar las existentes. Cada validación será una unidad modular. |
| **L - Sustitución de Liskov** | Las clases de validación implementarán una interfaz común y podrán sustituirse sin afectar el flujo de validación. |
| **I - Segregación de Interfaces** | Cada validador implementará únicamente los métodos que necesita, evitando interfaces genéricas forzadas. |
| **D - Inversión de Dependencias** | El sistema dependerá de una interfaz de validación, no de validadores concretos, permitiendo inyección dinámica para pruebas o nuevas reglas. |

---

## 🧪 Flujo Planeado de Validación

1. Usuario con rol **Empresa** ingresa los datos de una actividad mediante el formulario de reporte.
2. El backend recibe el DTO y lo pasa al módulo `ValidadorActividad`.
3. Se ejecutan todas las validaciones:
   - ✅ Si todas se cumplen: se guarda el reporte en estado `En revisión`.
   - ❌ Si alguna falla: se lanza una excepción con el detalle del error y no se guarda el reporte.
4. Posteriormente, un **Administrador** será responsable de revisar el contenido de ese reporte y validar o denegar su aprobación.

---

## 🔭 Consideraciones Futuras

- Posibilidad de configurar reglas desde un archivo externo (JSON/YAML) o una tabla de configuración.
- Traducción de mensajes de error para soporte multilenguaje.
- Implementación de pruebas unitarias automatizadas para cada regla.
- Posible uso del patrón Strategy o Chain of Responsibility para validar múltiples reglas en cadena.
- Implementación futura de notificaciones al cambiar estado (ej. validado/denegado por el admin).

---

📁 *Este archivo documenta la lógica planeada. Aún no se ha implementado en el código fuente.*
