# 🧠 Documentación de Patrones de Diseño – Módulo de Incentivos

## 🎯 Objetivo

Documentar los **patrones de diseño GoF** utilizados en el módulo de incentivos del sistema **Ecotributario**, relacionándolos con el flujo real de uso de la aplicación, en especial la interacción diferenciada entre Empresas y Administradores. Esta documentación busca facilitar la comprensión del diseño, justificar su estructura y garantizar buenas prácticas de desarrollo orientado a objetos.

---

## 🧩 Flujo General del Módulo

### 1. Ingreso de Usuario

Al ingresar a la aplicación, el sistema solicita al usuario que se identifique como:
- 👤 **Empresa**
- 🛠️ **Administrador**

---

### 2. Interacción desde el perfil **Empresa**

#### a. Calcular Incentivo Estimado
- El sistema solicita:
  - Tipo de actividad
  - Magnitud de impacto
- Se aplica una **estrategia de cálculo** para estimar el incentivo automáticamente.
- Se utilizan **patrones como Strategy y Factory** para aplicar la lógica dependiendo del tipo de actividad.
- Luego, el sistema ofrece dos opciones:
  - ✅ Visualizar solo el estimado (consulta rápida).
  - 📝 **Generar reporte detallado** → redirige al formulario para validar una actividad específica.

#### b. Generar Reporte Detallado
- Si el usuario elige esta opción, accede a una nueva pantalla donde:
  - Llena un formulario con datos detallados de la actividad realizada.
  - El sistema realiza una **validación automática de formato** (longitud, fechas, campos obligatorios, etc.).
  - Si todo es correcto, el reporte se guarda con estado `En revisión`.

> 💡 *Nota: En este punto, el sistema **no valida el contenido ambiental** de la actividad. Esa revisión es responsabilidad exclusiva del perfil administrador.*

---

### 3. Interacción desde el perfil **Administrador**

#### a. Validar Reportes Subidos
- El administrador accede a una interfaz (por ejemplo, con una lupa 🔍) para revisar los reportes enviados por empresas.
- Puede cambiar el estado del reporte a:
  - `Validado`
  - `Denegado`
  - `En revisión`
- Puede dejar un **comentario explicativo**.
- Al cambiar el estado, **se envía una notificación automática a la empresa** responsable del reporte.

---

## 🔧 Patrones GoF Aplicados y Relación con el Flujo

### 1. 🏗️ **Factory Method** (Creacional)

**Uso en el sistema**: Se emplea para crear objetos `Incentivo` según el tipo de actividad elegida por la empresa (ambiental, tributaria o mixta).

**Ubicación lógica**:
- Se invoca cuando la empresa selecciona la actividad y magnitud.
- El sistema delega la creación a una `IncentivoFactory`.

---

### 2. 🧠 **Strategy** (Comportamiento)

**Uso en el sistema**: Se define una **familia de estrategias** para calcular el valor estimado del incentivo.

**Ejemplos**:
- Estrategia de cálculo para actividades de reforestación.
- Estrategia diferente para gestión de residuos.

**Aplicación**:
- Permite intercambiar algoritmos **en tiempo de ejecución**.
- Fomenta el **principio abierto/cerrado**, ya que se pueden agregar nuevas estrategias sin modificar las existentes.

---

### 3. 🔒 **Singleton** (Creacional)

**Uso en el sistema**: Se garantiza que la conexión a la base de datos (por ejemplo, para acceder a reportes, cambiar estados o enviar notificaciones) sea **única y compartida** entre módulos.

---

## 📊 Clasificación de los Patrones

| Patrón      | Tipo según GoF   | Categoría       | Aplicación en el flujo |
|-------------|------------------|------------------|-------------------------|
| Factory     | Método de creación | Creacional       | Crear objetos incentivo según tipo |
| Strategy    | Encapsulamiento de algoritmos | Comportamiento | Cálculo de valor estimado del incentivo |
| Singleton   | Instancia única controlada | Creacional       | Acceso compartido a la base de datos |

---

## ✨ Beneficios del diseño actual

- **Separación clara de responsabilidades** entre usuarios (empresa/admin).
- Uso de **patrones de diseño probados** para extender funcionalidades sin romper el código.
- Aplicación práctica de **principios como bajo acoplamiento, alta cohesión y abierto/cerrado**.

---

## 📌 Recomendaciones Futuras

- Incorporar un patrón **Observer** para automatizar notificaciones.
- Considerar **Chain of Responsibility** para la validación modular de reportes.
- Aplicar principios **GRASP** como *Experto* o *Controlador* para mejorar la asignación de responsabilidades.

---


