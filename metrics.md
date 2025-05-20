# Métricas de Calidad y Cobertura para Proyecto Java Maven

## 1. Herramientas usadas

- **SonarQube**: Plataforma para análisis estático de código. Evalúa calidad, bugs, vulnerabilidades, duplicaciones, complejidad, etc.
- **Jacoco**: Plugin Maven para cobertura de pruebas unitarias en Java.
- **GitHub Actions**: Para ejecutar análisis y pruebas automáticamente en integración continua (CI).

---

## 2. Métricas aplicadas

| Métrica                   | Descripción                                                                                   |
|---------------------------|-----------------------------------------------------------------------------------------------|
| Cobertura de código        | Porcentaje de código ejecutado por las pruebas (líneas y ramas).                             |
| Complejidad ciclomática    | Medida de la complejidad de control del flujo (ifs, loops).                                 |
| Duplicación de código      | Porcentaje y bloques de código duplicado.                                                   |
| Bugs y vulnerabilidades   | Problemas detectados en el código que pueden causar fallos o vulnerabilidades de seguridad. |
| Código muerto             | Código que no se ejecuta o no es necesario.                                                 |

---

## 3. Cómo ejecutar localmente

### Requisitos

- Tener Java y Maven instalados.
- Tener SonarQube local o acceso a servidor SonarQube remoto (opcional).

### Comandos

```bash
# Ejecutar pruebas con cobertura
mvn clean test jacoco:report

# Ejecutar análisis SonarQube (requiere sonar-project.properties configurado y SonarQube activo)
mvn sonar:sonar

# Reporte cobertura generado en:
# target/site/jacoco/index.html

# En caso de SonarQube local, el análisis queda visible en el dashboard web.
