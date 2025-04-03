#  Guía para contribuir al proyecto

## 🚀 Flujo de trabajo con Git
Para mantener el código organizado y evitar conflictos, seguimos estas reglas:

1. **Crear una rama** para cada nueva funcionalidad o corrección de errores:
   ```sh
Para crear una rama se usa: git checkout -b feature/nombre-de-la-funcionalidad

   git checkout -b feature/nombre-de-la-funcionalidad

2. **Crear un commit**
   Para especificar cada cambio que se haya realizado y explicar el por que de su cambio dependiendo de su tipo
|    Tipo     |                                       Uso                                        |
|    `feat:`  |                     Para agregar una nueva funcionalidad.                        |
|    `fix:`   |                        Para corregir un error o bug.                             |
|    `docs:`  |         Para cambios en la documentación (README, comentarios, etc.).            |
|    `style:` | Para cambios de formato (espacios, puntos y comas, etc.), sin afectar la lógica. |
| `refactor:` |             Para mejorar el código sin cambiar la funcionalidad.                 |
|    `test:`  |                         Para agregar o modificar pruebas.                        |

Para realizar un commit se tiene que empezar con: 
```sh
git commit -m "tipo: ..."

3. **Crear un push**

Para evitar errores y conflictos en el código:
- **No hagas `push` directamente a `main` ni `develop`.**  
- **Asegúrate de estar en la rama correcta antes de hacer `push`** con:
   ```sh
   git branch  # Esto te muestra en qué rama estás.

Para asegurar que los cambios los hayas hecho verificas asi:
- git checkout develop
- git pull origin develop
- git checkout feature/nombre-de-la-funcionalidad
- git merge develop  # Trae los últimos cambios de develop a tu rama.

Finalmente para realizar el push se hace lo siguiente:
 git push origin feature/nombre-de-la-funcionalidad

4. **Crear un push request**
Realizar un push request en la rama de develop

