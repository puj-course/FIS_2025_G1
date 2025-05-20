# Postmortem – Proyecto Ecotributario

## Aciertos del Proyecto

- Se logró una arquitectura clara basada en el patrón **MVC**, que permitió separar las responsabilidades y mantener el código organizado.
- La integración con **Telegram** para el envío de notificaciones fue exitosa y añadió un valor diferencial al sistema.
- La base de datos fue diseñada con lógica coherente y permitió la persistencia de entidades como empresas y solicitudes.
- Se implementaron **pruebas unitarias básicas** y se integró **Jacoco** (aunque no funciono) para medir la cobertura.
- Se automatizó la calidad del código a través de **GitHub Actions**, aunque el acceso a SonarCloud estuvo limitado.

## Dificultades y Errores

- Al inicio del proyecto hubo dificultades para definir correctamente la conexión remota con SonarCloud, lo que limitó el análisis en la nube.
- La cobertura de pruebas no alcanzó el 70% deseado debido a la falta de tiempo y experiencia inicial en testing.
- Algunos flujos, como la gestión de usuarios y validaciones, se resolvieron tarde en la implementación, lo que dificultó las pruebas automatizadas.
- Se dedicó más tiempo al frontend con JavaFX que a consolidar pruebas y validaciones robustas.

## Aprendizajes

- La importancia de planear con anticipación las integraciones externas (como bases de datos y APIs de terceros).
- Lo valioso de los patrones de diseño para mantener la claridad del código.
- La necesidad de escribir pruebas desde el inicio para facilitar mantenimiento y control de calidad.
- Cómo integrar herramientas de calidad como Jacoco y GitHub Actions en un flujo real de desarrollo.

## Acciones para próximos proyectos

- Iniciar los proyectos con pruebas unitarias mínimas desde el Sprint 1.
- Implementar la integración con herramientas como SonarCloud o CodeCov desde el principio.
- Dividir claramente los roles técnicos del equipo (back, front, testing) desde el inicio.
- Reutilizar este repositorio como base para proyectos similares, dado que la arquitectura fue sólida.

---

### Participación del equipo

Todos los miembros del equipo participaron en este análisis retrospectivo, aportando su experiencia desde frontend, backend, testing y documentación.

