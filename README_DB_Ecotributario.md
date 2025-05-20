# Base de Datos – Ecotributario

Este script define la estructura de la base de datos utilizada en el sistema **Ecotributario**, diseñada para gestionar usuarios, empresas, incentivos ambientales y reportes.

## 🗂 Archivo

- `base_datos_ecotributario.sql`: contiene el esquema completo de la base de datos, listo para ejecutarse en SQLite.

## 🔌 Conexión

La conexión a esta base de datos se gestiona desde la clase `DBConnection.java`, utilizando la siguiente ruta:

```java
String url = "jdbc:sqlite:ecotributario.db";
```

## 📋 Tablas creadas

1. **Usuarios**
   - Campos: `id_usuario`, `nombre`, `email`, `password`, `rol`, `fecha_registro`

2. **Empresas**
   - Relacionada con `Usuarios`
   - Campos: `id_empresa`, `id_usuario`, `nombre_empresa`, `nit`, `direccion`, `telefono`, `sector`, `fecha_registro`

3. **Incentivos**
   - Relacionada con `Empresas`
   - Campos: `id_incentivo`, `id_empresa`, `tipo_incentivo`, `monto`, `descripcion`, `fecha_aplicacion`

4. **Reportes**
   - Relacionada con `Incentivos` y `Usuarios`
   - Campos: `id_reporte`, `id_incentivo`, `id_usuario`, `fecha_generacion`, `detalle`

## 🧪 Estado actual

✅ Script funcional  
✅ Conectividad probada desde JavaFX  
✅ Datos de prueba insertados opcionalmente en los formularios del sistema
