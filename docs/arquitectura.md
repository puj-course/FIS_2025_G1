# Diagrama de Arquitectura MVC – Proyecto Ecotributario



## Descripción

Este diagrama representa la arquitectura del sistema **Ecotributario**, basada en el patrón **Modelo-Vista-Controlador (MVC)**. La estructura está compuesta por tres capas principales:

- **Vista (JavaFX):** Encargada de la interacción gráfica con el usuario. Incluye vistas como `LoginView`, `RegistroView`, `VerIncentivosView` y `ReporteView`.
- **Controlador:** Gestiona los eventos generados por la vista y los comunica con la lógica del modelo. Cada vista tiene su controlador correspondiente (`LoginController`, `RegistroController`, etc.).
- **Modelo:** Contiene las entidades de negocio (`Usuario`, `Empresa`, `Incentivo`, `Reporte`) y sus respectivos **Data Access Object (DAO)** que encapsulan la lógica de acceso a la base de datos.

La base de datos se aloja en **MySQL (AlwaysData)**, y es accedida exclusivamente por las clases DAO. Esto garantiza una clara **separación de responsabilidades**, bajo acoplamiento y alta cohesión.

Este diseño facilita la escalabilidad del sistema, el mantenimiento del código, y el cumplimiento de los principios **SOLID** y patrones como **DAO, Creator y Expert**.

![image](https://github.com/user-attachments/assets/23c692a5-07b3-4d09-a5c3-62240a0ec566)
