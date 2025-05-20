# Reporte de Métricas de Calidad del Código (Simulación tipo SonarQube)

Este reporte fue generado manualmente a partir del análisis del código fuente y pruebas del proyecto **Ecotributario**.

---

## Resumen General

- **Total de clases de producción**: 58
- **Total de clases de prueba**: 29
-  **Clases con prueba unitaria**: 29
-  **Clases sin prueba unitaria**: 29
-  **Cobertura de clases**: 50.0%

---

## Análisis de Tamaño y Complejidad por Clase

- Se analizaron todas las clases `.java` de producción y prueba.
- Se midieron:
  - Líneas totales
  - Líneas vacías
  - Líneas de comentarios
  - Líneas efectivas
  - Número de métodos
  - Promedio de líneas por método

---

## Observaciones clave

- Muchos archivos de prueba **no invocan métodos reales** o no están conectados con clases de producción (solo 2/58 clases cubiertas).
- Hay métodos con promedios superiores a **15 líneas**, lo que puede indicar oportunidad de **refactorización**.
- Ningún archivo tiene comentarios extensos (lo que puede afectar la mantenibilidad).

---

## Recomendaciones

- Aumentar cobertura unitaria priorizando clases con mayor número de líneas efectivas.
- Dividir métodos largos (>15 líneas promedio).
- Implementar pruebas automáticas con `Mockito`, `TestFX` o integraciones en `CI` como GitHub Actions + SonarCloud.

---

# Métricas del Código Fuente

Este análisis corresponde al proyecto contenido en el archivo `proyectoFunda 3.zip`. Se calcularon dos métricas básicas de calidad del código: la longitud del código y la complejidad ciclomatica.

## Resumen General

| Métrica                    | Valor |
|----------------------------|-------|
| Líneas de código (LOC)  | 1.987 |
|  Complejidad ciclomatica | 144   |

##  Explicación

- **Líneas de Código (LOC)**: Se refiere al total de líneas presentes en los archivos `.java`, incluyendo líneas de declaración, lógica, y estructura. Este número puede incluir comentarios y líneas en blanco si no se filtran explícitamente.

- **Complejidad Ciclomática**: Mide la cantidad de caminos lógicos independientes que existen en el código. Se calculó sumando puntos de decisión (estructuras como `if`, `for`, `while`, `case`, etc.) y agregando 1. Un valor más alto indica mayor complejidad, lo que puede implicar mayor esfuerzo para pruebas y mantenimiento.

##  Observaciones

- Un proyecto con una complejidad ciclomatica de **144** sugiere que tiene muchos puntos de decisión, por lo tanto sería recomendable asegurar una buena cobertura de pruebas.
- La cantidad de **1.987 líneas de código** indica un tamaño mediano, lo que indica un proyecto bien estructurado con lógica en capas.


*Este reporte fue generado automáticamente desde archivos fuente sin SonarQube usando Python.*
