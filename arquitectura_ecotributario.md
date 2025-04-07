# 🧱 Documentación Técnica – Modelo Conceptual y Arquitectura General del Sistema Ecotributario

## 🎯 Objetivo

Explicar de manera clara y estructurada cómo está compuesto el sistema **Ecotributario** a nivel de arquitectura, incluyendo sus componentes principales (base de datos, lógica, interfaz), las decisiones técnicas tomadas, la organización actual del proyecto, y su proyección a futuro.

---

## 1. 🧩 Modelo Conceptual y Arquitectura General

### 🧱 Componentes Principales

- **Base de datos**: gestionada en un servidor remoto a través de AlwaysData y phpMyAdmin (MySQL).
- **Interfaz gráfica**: desarrollada con JavaFX, con pantallas para empresas y administradores.
- **Lógica de negocio**: implementada en Java, encargada de aplicar reglas de validación, cálculo de incentivos, gestión de autenticación y flujo general del sistema.

### 🧰 Arquitectura en Capas

```
┌─────────────────────┐
│     Presentación    │ ← JavaFX (pantallas empresa/admin)
├─────────────────────┤
│   Lógica de negocio │ ← Validaciones, cálculos, control de flujos
├─────────────────────┤
│ Persistencia de datos│ ← Conexión remota a AlwaysData (MySQL vía JDBC)
└─────────────────────┘
```

### 📊 Diagramas sugeridos
- Diagrama de **casos de uso** para visualizar perfiles (empresa/admin).
- Diagrama de **clases** para mostrar los componentes principales.
- Diagrama de **secuencia** para ilustrar flujos como: creación de reporte, validación, cálculo del incentivo.

---

## 2. ⚙️ Demostración Técnica

### 📂 Organización de la Base de Datos

- **Servidor remoto**: base de datos hospedada en **AlwaysData**, gestionada mediante **phpMyAdmin**.
- **Motor de base de datos**: MySQL.
- Tablas clave: `Usuarios`, `Empresas`, `Incentivos`, `Reportes`.
- Relaciones:
  - `Empresa` ↔ `Reportes` (1:N)
  - `Incentivo` ↔ `Reportes` (1:N)
- Consultas clave:
  - Selección de incentivos por tipo
  - Validación por ID
  - Conteo de reportes por estado

### 🎨 Interfaz Inicial

- Pantalla de ingreso: elección entre Empresa o Administrador.
- Pantalla de Empresa: permite calcular incentivo y generar reporte.
- Pantalla de Admin: permite revisar reportes y cambiar su estado.

> Todas las acciones en interfaz están conectadas con la lógica de negocio y esta a su vez con la base de datos remota usando JDBC.

### 🔄 Comunicación entre módulos

- La capa de presentación invoca funciones en los controladores.
- Los controladores validan datos y llaman a servicios de cálculo o persistencia.
- La base de datos remota responde mediante consultas SQL a través de JDBC.

---

## 3. 🚀 Viabilidad y Evolución del Sistema

### 🔁 Escalabilidad y Adaptabilidad

- La arquitectura basada en capas permite separar responsabilidades.
- El uso de patrones como **Strategy**, **Factory** y **Singleton** permite escalar sin romper el código existente.
- Ya se cuenta con una base de datos **remota** y **disponible desde distintos dispositivos**, lo que facilita la colaboración en equipo y la integración futura con servicios externos.

### 💡 Justificación de Tecnologías Elegidas

| Componente     | Tecnología elegida | Justificación |
|----------------|--------------------|----------------|
| Frontend       | JavaFX             | UI clara, conectividad con base de datos y código modular. |
| Backend        | Java               | Robusto, OOP, fácil de probar y mantener. |
| Base de Datos  | AlwaysData + MySQL | Accesible remotamente, gestión vía phpMyAdmin, ideal para pruebas y desarrollo compartido. |
| Gestión        | GitHub Projects + Scrum | Organización por sprints, issues y control de avances. |

### 🛣️ Roadmap Futuro

- 🔐 Incorporar roles avanzados con más permisos (superadmin, entidades fiscalizadoras).
- 🛰️ Conectar el sistema a fuentes externas de datos ambientales (open APIs).
- 📈 Panel visual con gráficas de impacto y reportes.
- 📦 Integración con servicios en la nube para almacenamiento de evidencia multimedia.

---

📁 Este archivo responde al **Issue #44**  
📌 Rama sugerida: `docs/arquitectura-ecotributario`
