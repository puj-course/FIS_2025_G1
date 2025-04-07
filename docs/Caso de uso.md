# 😊 Diagrama de Casos de Uso - Sistema ECOTRIBUTARIO

Este diagrama ilustra las principales interacciones entre los actores del sistema ECOTRIBUTARIO y las funcionalidades que pueden ejecutar. 
Se representa gráficamente cómo cada tipo de usuario utiliza las funcionalidades ofrecidas por el sistema para cumplir sus objetivos.

## 🎭 Actores del sistema

- **Encargado de la empresa**: Usuario principal que representa a la empresa interesada en participar del sistema.
   Tiene acceso a funcionalidades como registro, autenticación y solicitudes de incentivos fiscales.
- **Administrador**: Responsable del control general del sistema. Tiene capacidad para recibir y verificar información subida por las empresas.
- **Jefe ambiental**: Encargado de validar y clasificar las evidencias ambientales.
- **Jefe fiscal**: Supervisa los historiales y aplica beneficios fiscales basados en el cumplimiento ambiental.

## ✅ Casos de uso principales

| Caso de uso | Descripción |
|-------------|-------------|
| **Diligenciar información general de la empresa** | Incluye los subprocesos de ingresar información ambiental y económica. |
| **Crear usuario** | Permite al encargado de la empresa crear credenciales para el acceso al sistema. |
| **Crear contraseña** | Parte del proceso de creación de usuario. |
| **Registrar empresa en el sistema** | Proceso general que incluye diligenciar información y crear usuario. |
| **Autenticarse con usuario y contraseña** | Validación de acceso al sistema. |
| **Solicitar descuento fiscal de impuestos** | Acción realizada por la empresa para aplicar a incentivos tributarios. |
| **Solicitar historial de acciones ambientales realizadas** | Permite visualizar las actividades realizadas por la empresa, también accedido por el jefe fiscal. |
| **Subir evidencia de cambio ambiental** | Funcionalidad del administrador para almacenar las evidencias enviadas por las empresas. |
| **Generar reporte de evidencias** | Elaborado por el jefe ambiental para documentación interna. |
| **Clasificar importancia de evidencias cargadas** | Permite asignar niveles de impacto a cada evidencia. |
| **Disminuir impuestos** | Resultado posterior a la verificación del historial y validación de evidencias. |

## 🔗 Relaciones importantes

- Los casos de uso **"Diligenciar información ambiental"** y **"Diligenciar información económica"** son incluidos dentro del proceso **"Diligenciar información general de la empresa"**.
- El caso de uso **"Registrar empresa en el sistema"** incluye la creación del usuario y contraseña.
- La funcionalidad **"Disminuir impuestos"** depende directamente de la revisión del historial de acciones ambientales realizadas por el **Jefe Fiscal**.


![image](https://github.com/user-attachments/assets/ea391e75-ea87-4c22-ab09-b22c55b4a788)
