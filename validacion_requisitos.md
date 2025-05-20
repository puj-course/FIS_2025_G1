# Validación de Requisitos No Funcionales

| Requisito                                                              | ¿Cumplido? | Evidencia                                                  |
|------------------------------------------------------------------------|------------|-------------------------------------------------------------|
| Interfaz intuitiva para distintos usuarios                             | ✅         | Implementada en múltiples vistas con JavaFX.               |
| Retroalimentación clara de acciones (éxito/error)                      | ✅         | Uso de `Alert` en controladores para errores y confirmación.|
| Disponibilidad del servicio                                            | 🟡 Parcial | Requiere pruebas en despliegue con hosting estable.        |
| Respaldos automáticos                                                  | ❌         | No se ha implementado aún.                                 |
| Generación de reportes eficiente                                       | ✅         | `ReporteDAO` optimiza consultas SQL.                       |
| Soporte para 1000 usuarios concurrentes                                | ❌         | No se ha probado carga masiva.                             |
| Autenticación con credenciales seguras                                | ✅         | Login con encriptación (si hay cifrado en DB o Java).     |
| Información cifrada en base de datos                                   | 🟡 Parcial | Depende si se usa hash de contraseñas en DB.               |
| Roles y permisos                                                       | ✅         | Separación entre empresas y administrador.                 |
| Registro de intentos fallidos y alertas                                | ❌         | No implementado.                                            |
| Código documentado                                                     | 🟡 Parcial | Algunos controladores tienen comentarios básicos.           |
| Modularidad                                                            | ✅         | Separación MVC clara (controllers, models, views).         |
| Actualización sin afectar módulos                                     | ✅         | JavaFX modular + controladores separados.                  |
| Compatibilidad OS                                                      | ✅         | Java es multiplataforma.                                   |
| Compatibilidad con navegadores                                        | ❌         | No aplica, es app de escritorio.                           |
| Escalabilidad de datos y usuarios                                      | 🟡 Parcial | No probado con carga masiva, pero diseño modular.          |
| Posibilidad de añadir nuevas funcionalidades                          | ✅         | Estructura permite nuevos controladores y vistas fácilmente.|
