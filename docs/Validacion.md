# **Validacion de actividades**
- Este documento describe como se realizara el flujo de trabajo en la validadción de evidencias suministradas por las empresas
  e interesadas en el descuento de incentivos.

## 🧳 **Flujo general**
- El objetivo es permitir a las empresas subir las evidencias del cumplimeinto de los 3 factores para cumplir con el descuento
  de los incentivos, para esto constara de 4 etapas:
  
  - ⏫ Subida de evidencia.
  - ✅ Confirmacion de recepción.
  - 🔩 Revisión Tecnica.
  - 🟰 Resultado.
    
### ⏫ **Subida de evidencia**
- La empresa debe de cargar su evidencia a travez de la app "Ecotributario", una vez se haya inciaido sesion se debera de dar click
  en la pestaña donde dice: "Subir Evidencias" alli se habilitara una pestaña en la cual se recibira archivos de tipo:
  
   - ✅ PDF
   - ✅ PNG
     
  -Estos archivos deben de estar legibles y ordenados.
  
### ✅ **Confirmacion de recepción**
- Una vez se haya subida toda aquella informacion que evidencien el cumplimiento de los 3 factores, el sistema analizara esta información
  y verificara si fue subida correctamente.
- Cuando la informacion este subida correctamente, se enviara una notificacion al correo de la empresa con el mensaje "Se ha enviado
  correctamente su evidencia".
- Estado: **pendiente**

### 🔩 **Revisión Tecnica**
- Cuando la información este en la app, se realizaran los respetivos procedimientos y formulas para verificar que la empresa haya cumplido
  satisfactoriamente con los 3 factores a su 100% para obtener el descuento.
- Cuando se hayan realizado los respectivos calculos, un experto ambiental corrobora estos resultados y dara su ultimatum para ofrecer
  el descuento de incentivos.
- Estado medio: **En proceso**

### 🟰 **Resultados**
- En 5 dias habiles dara su respectiva respuesta y notificara si ha cumplido con los 3 factores. Si ha cumplido satisfactoriamente se enviará
  un mensaje diciendo "Felicidades has sido la empresa ecosostenible 🎂 ".
- En 5 dias habiles dara su respectiva respuesta y notificara si ha cumplido con los 3 factores. Si no cumplio satisfactoriamente se enviará
  un mensaje diciendo "Lo siento, no has cumplido satisfactoriamente, pero aun te podemos ofrecer un pequeño descuento 😊 "
  Y despues se le enviara su reporte indicando en que falló.
- Estado final: **Validada**

#### 📋**Base de datos**

#### **Estructura de la tabla en la base de datos**

| Campo              | Tipo            | Descripción                                                                |
|--------------------|-----------------|----------------------------------------------------------------------------|
| `id_validacion`    | INT (PK)        | Identificador único de la validación.                                      |
| `id_empresa`       | INT (FK)        | Relación con la empresa que sube la evidencia.                             |
| `tipo_evidencia`   | VARCHAR         | Tipo de criterio: "Huella de carbono", "Agua", "Gas natural", etc.         |
| `archivo_url`      | TEXT            | Ruta del archivo PDF cargado.                                              |
| `estado`           | VARCHAR         | Estado de la validación: `pendiente`, `validada`, `rechazada`, `por corregir`. |
| `fecha_subida`     | DATETIME        | Fecha y hora en que se subió la evidencia.                                 |
| `fecha_validacion` | DATETIME (NULL) | Fecha de validación (si ya fue revisada).                                  |
| `comentarios`      | TEXT (NULL)     | Observaciones del validador si aplica rechazo o se requiere corrección.    |

  
