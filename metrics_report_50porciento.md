# 📊 Reporte de Métricas de Calidad del Código (Simulación tipo SonarQube)

Este reporte fue generado manualmente a partir del análisis del código fuente y pruebas del proyecto **Ecotributario**.

---

## 🧮 Resumen General

- **Total de clases de producción**: 58
- **Total de clases de prueba**: 29
- ✅ **Clases con prueba unitaria**: 29
- ❌ **Clases sin prueba unitaria**: 29
- 📉 **Cobertura de clases**: 50.0%

---

## 📄 Análisis de Tamaño y Complejidad por Clase

- Se analizaron todas las clases `.java` de producción y prueba.
- Se midieron:
  - Líneas totales
  - Líneas vacías
  - Líneas de comentarios
  - Líneas efectivas
  - Número de métodos
  - Promedio de líneas por método

---

## 🧪 Observaciones clave

- Muchos archivos de prueba **no invocan métodos reales** o no están conectados con clases de producción (solo 2/58 clases cubiertas).
- Hay métodos con promedios superiores a **15 líneas**, lo que puede indicar oportunidad de **refactorización**.
- Ningún archivo tiene comentarios extensos (lo que puede afectar la mantenibilidad).

---

## ✅ Recomendaciones

- Aumentar cobertura unitaria priorizando clases con mayor número de líneas efectivas.
- Dividir métodos largos (>15 líneas promedio).
- Implementar pruebas automáticas con `Mockito`, `TestFX` o integraciones en `CI` como GitHub Actions + SonarCloud.

---

*Este reporte fue generado automáticamente desde archivos fuente sin SonarQube usando Python.*