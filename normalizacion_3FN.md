1FN - Primera Forma Normal
Criterios:

Cada columna contiene valores atómicos (no listas ni conjuntos).
Cada fila tiene un valor único en la llave primaria.
Cada columna contiene datos del mismo tipo.
Validación:

Todas las tablas tienen atributos atómicos.
No hay atributos multivaluados (por ejemplo, tipo_incentivo usa ENUM, lo cual es aceptable).
Se han definido llaves primarias en cada tabla.
✅ Cumple con 1FN.

2FN - Segunda Forma Normal
Criterios:

Cumple con 1FN.
No debe haber dependencias parciales (los atributos no clave deben depender completamente de la clave primaria).
Validación:

En la tabla Empresas, id_empresa es clave primaria y todos los atributos dependen completamente de ella.
En la tabla Incentivos, id_incentivo es clave primaria y los atributos dependen completamente de esta.
En la tabla Reportes, id_reporte es clave primaria y los demás atributos dependen de ella.
En la tabla Usuarios, id_usuario es clave primaria y los demás atributos dependen de ella.
✅ Cumple con 2FN.

3FN - Tercera Forma Normal
Criterios:

Cumple con 2FN.
No debe haber dependencias transitivas (un atributo no clave no debe depender de otro atributo no clave).
Validación:

En la tabla Empresas, el sector podría estar normalizado en otra tabla si se quiere evitar redundancia, pero no es obligatorio si no hay muchas repeticiones.
En la tabla Usuarios, rol es un ENUM, lo cual es aceptable para simplificación.
En la tabla Incentivos, tipo_incentivo podría normalizarse en una tabla separada si hay crecimiento en tipos, pero actualmente no es un problema.
No hay dependencias transitivas identificadas.
✅ Cumple con 3FN.