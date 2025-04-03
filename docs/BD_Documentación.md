# Documentación de la Base de Datos (MySQL)

##  **Tabla: `Usuarios`**
| Campo            | Tipo         | Restricciones |
|-----------------|-------------|--------------|
| `id_usuario`    | INTEGER     | PRIMARY KEY AUTOINCREMENT |
| `nombre`        | TEXT        | NOT NULL |
| `email`         | TEXT        | UNIQUE, NOT NULL |
| `password`      | TEXT        | NOT NULL |
| `rol`           | TEXT        | CHECK(rol IN ('admin', 'empresa')), NOT NULL |
| `fecha_registro` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP |

**Descripción**:  
- Esta tabla almacena la información de los usuarios del sistema.  
- `rol` puede ser `admin` o `empresa`.  
- `email` es único para evitar duplicados.  

---

##  **Tabla: `Empresas`**
| Campo           | Tipo         | Restricciones |
|----------------|-------------|--------------|
| `id_empresa`   | INTEGER     | PRIMARY KEY AUTOINCREMENT |
| `id_usuario`   | INTEGER     | NOT NULL (FOREIGN KEY de `Usuarios`) |
| `nombre_empresa` | TEXT      | NOT NULL |
| `nit`          | TEXT        | UNIQUE, NOT NULL |
| `direccion`    | TEXT        | NULLABLE |

 **Descripción**:  
- Cada empresa está asociada a un usuario en `Usuarios`.  
- `nit` (Número de Identificación Tributaria) debe ser único.  
- `direccion` es opcional.  

---

##  **Flujo de validación**
###  **Registro de usuario**
1. El usuario envía `nombre`, `email`, `password`, `rol`.  
2. Se valida que `email` no esté registrado previamente.  
3. Se encripta `password` antes de guardarlo.  
4. Se guarda el usuario en `Usuarios`.  

### **Registro de empresa**
1. Un usuario con `rol=empresa` puede registrar una empresa.  
2. Se valida que el `nit` no exista en la tabla `Empresas`.  
3. Se guarda la empresa con `id_usuario` como referencia.  
