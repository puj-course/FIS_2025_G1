# 📦 Módulo de Incentivos – Ecotributario

El módulo de **incentivos** permite registrar, calcular y almacenar recompensas económicas para los usuarios (ciudadanos o empresas) que reportan acciones ambientales positivas.

---

## 🧠 ¿Qué hace?

- Calcula el **monto del incentivo** automáticamente según:
  - Tipo de acción ambiental
  - Frecuencia de la acción
  - Categoría del usuario (empresa o admin)
- Guarda ese incentivo en la base de datos asociándolo al usuario correspondiente.

---

## 🧱 Arquitectura del módulo

```
[Vista JavaFX] → [Controlador JavaFX] → [IncentivoCalculator] → [IncentivoDAO] → [Base de Datos]
```

---

## 📁 Archivos clave

| Archivo                    | Descripción                                                                 |
|---------------------------|-----------------------------------------------------------------------------|
| `Incentivo.java`          | Modelo que representa un incentivo (frecuencia, acción, monto, usuario)     |
| `IncentivoCalculator.java`| Clase que implementa la lógica de cálculo de incentivos                     |
| `IncentivoDAO.java`       | Acceso a datos: inserta incentivos en la tabla `Incentivos`                 |

---

## ⚙️ Lógica de cálculo (`IncentivoCalculator`)

Ejemplo básico:

```java
double monto = frecuencia * pesoAccion * factorUsuario;
```

- `frecuencia`: número de veces que se hizo la acción
- `pesoAccion`: cada acción tiene un peso (ej. reciclar: 1.5, plantar: 3.0)
- `factorUsuario`: si es empresa o admin puede cambiar el valor (ej. empresa = 1.2, admin = 1.0)

---

## 🗄️ Estructura de la tabla `Incentivos`

```sql
CREATE TABLE Incentivos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    tipo_accion VARCHAR(100),
    frecuencia INT,
    categoria_usuario VARCHAR(50),
    monto DOUBLE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);
```

---

## ✅ Flujo completo

1. El usuario reporta una acción
2. Se calcula el incentivo
3. Se construye un objeto `Incentivo`
4. Se guarda en la base de datos vía `IncentivoDAO`