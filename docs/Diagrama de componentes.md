# 🧩 Diagrama de Componentes - Sistema ECOTRIBUTARIO

Este diagrama representa los principales componentes del sistema ECOTRIBUTARIO y sus respectivas interfaces. El componente central actúa como núcleo que se conecta
 con distintos módulos funcionales del sistema, cada uno de los cuales se encarga de una responsabilidad específica.

## 📌 Componente central

### <<component>> ECOTRIBUTARIO
Actúa como núcleo del sistema y coordina la interacción entre los distintos módulos funcionales conectados por interfaces.

## 🔐 Autenticación y Seguridad

### <<component>> Autenticación
- Login: Módulo de inicio de sesión.
- CifradoContraseña: Encargado del cifrado y manejo seguro de contraseñas.
- Verificación: Control de autenticidad del usuario.

### <<component>> Seguridad
- IntentosFallidos: Registro y control de intentos fallidos de autenticación.
- GeneradorAlertas: Emite alertas en caso de actividad sospechosa.

## 🏢 Registro de Empresa

### <<component>> RegistroEmpresa
- FormularioRegistro: Captura de datos de registro.
- ValidacionDatos: Validación de datos ingresados.
- GestionUsuarios: Administración de usuarios de empresa.

## 📂 Evidencias Ambientales

### `<<component>> Evidencias`
- CargarEvidencia: Subida de archivos/documentos.
- ValidacionManual: Revisión por parte del Jefe Ambiental.
- ClasificadorAutomatico: Clasificación inicial mediante criterios automáticos.

## 💸 Incentivos Fiscales

### `<<component>> Incentivos`
- CalculadorDescuento: Determina descuentos fiscales según cumplimiento ambiental.
- ValidacionCumplimiento: Revisa si se cumplen los requisitos de incentivo.
- CrearPNG: Exporta evidencia del incentivo aplicado.

## 📊 Reportes

### <<component>> Reportes`
- CrearPDF: Generación de reportes en PDF.
- CrearExcel: Exportación de datos a Excel.
- CrearPNG: Reportes visuales en formato de imagen.

## 📈 Historial del Sistema

### <<component>> Historial`
- GestorEventos: Registro de acciones del sistema.
- ConsultarEventos: Búsqueda y visualización de logs/eventos.

## ✉️ Notificaciones

### <<component>> Notificaciones`
- Email: Envío de correos electrónicos.
- SMS: Notificaciones por mensaje de texto.

## 🔌 Interfaces

Cada componente se conecta al núcleo `ECOTRIBUTARIO` mediante interfaces, permitiendo desacoplamiento y escalabilidad. Las interfaces permiten que los módulos 
interactúen sin estar directamente acoplados entre sí.



![Untitled (1)](https://github.com/user-attachments/assets/d037dbe7-c334-4f6d-aa26-38c7f0fe7170)
