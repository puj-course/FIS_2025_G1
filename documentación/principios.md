# Principios

## SOLID

### S: SRP (Responsabilidad Única)

Cada clase tiene una única responsabilidad:

- Las clases como `Reciclaje`, `EnergiaRenovables`, o las que describen el tipo de actividad encapsulan lógica de cálculo.

---

### O: OCP (Abierto / Cerrado)

A partir de la interfaz de `TipoAccion`, si con el tiempo se crea una nueva acción, solo basta que esta nueva clase implemente `TipoAccion`, y no se requiere modificar las clases existentes.

---

### D: DIP (Inversión de Dependencias)

Este principio establece que:

- Los módulos de alto nivel no deben depender de módulos de bajo nivel, ambos deben depender de abstracciones.
- Las abstracciones no deben depender de los detalles, los detalles deben depender de las abstracciones.

**Ejemplo:**  
En nuestro código, `IncentivoServicios` depende de la interfaz `TipoAccion`, no de clases concretas.

---

## GRASP

### Creador

La clase `UsuarioDAO` es responsable de crear instancias de `Usuario` al obtener datos de la base de datos. En nuestro proyecto cumple con el patrón respecto a la clase `Usuario` porque:

1. `UsuarioDAO` gestiona operaciones como crear, leer, actualizar y eliminar usuarios en la base de datos.
2. Usa instancias de `Usuario`, por ejemplo, en procesos como la autenticación.
3. Recibe los datos desde la base de datos y conoce los atributos necesarios para construir un `Usuario`.

---

### Experto

Según el patrón Experto, una responsabilidad debe asignarse a la clase que tiene la mayor cantidad de información necesaria para cumplirla.

La clase `Usuario` representa el modelo de datos de un usuario del sistema y cumple con este patrón por las siguientes razones:

1. Encapsula todos los atributos relacionados con la identidad y perfil de un usuario.
2. Si se implementan más métodos relacionados con el usuario en el futuro, no habrá problemas porque no depende de otras clases.

---

## GOF

### Patrón DAO (Data Access Object)

El patrón DAO pertenece a la capa de persistencia, separando la lógica de acceso a datos de la lógica de negocio.

En la clase `UsuarioDAO` se cumple por la siguiente razón:

1. `UsuarioDAO` se encarga exclusivamente de interactuar con la base de datos:
   - Ejecuta consultas SQL como `SELECT`, `INSERT`, y abre conexiones.
   - Otras clases como `LoginController` usan a `UsuarioDAO` sin saber nada de SQL.
