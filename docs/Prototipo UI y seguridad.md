# 📔 **Introduccion**

- A continuación se presentaran los requisitos de seguridad mas relevantes en el tratamiento de datos, asi como un prototipo de la interfaz de usuario.
  El objetivo es garantizar que todas las funcionaldiades del sistema esten listas para su futura implementación, con especial atención a la proteccion
  de información.

## **Requisitos del sistema**
- Para los requisitos de seguridad se planifica:
  
### ℹ️ **Implementar un cifrado de datos.**
- El sistema debe implementar transformar información legible en información no legible.
- El sistema debe permitir conservar informacion ilegible en la base de datos(MySql).
- El sistema debe permitir aceptar letras en la BD.
- El sistema debe permitir aceptar simbolos en la BD.
- El sistema debe permitir aceptar numeros en la BD.
  
### 🔒 **Controlar el acceso y autenticación.**
- El sistema debe permitir ingresar información confidencial.
- El sistema no debe permitir nombres en la contraseña.
- El sistema debe permitir realizar un CAPTCHA.
- El sistema debe permitir autenticacion multifactor.
- El sistema debe permitir ingresar letras en la UI.
- El sistema debe permitir ingresar numeros en la UI.
- El sistema debe permitir ingresar simbolos en la UI.
- El sistema debe permitir mostrar un mensaje en la UI para autentificarse en el sistema.
- El sistema debe permitir mandar un mensaje de numeros al celular para ponerlo en la UI.
- El sistema debe permitir aceptar usuario correctamente en la BD.
- El sistema debe permitir aceptar contraseña correctamente en la BD.
- El sistema debe permitir negar el acceso si el usuario esta incorrecto.
- El sistema debe permitir negar el acceso si la contraseña esta incorrecta.
- El sistema debe permitir enviar un mensaje al correo para recuperar contraseña.
- El sistema debe permitir cambiar contraseña en la BD.
- El sistema debe permitir borrar contraseña en la BD.
- El sistema debe permitir expiriar sesiones tras 2 horas inactiva.
- El sistema debe permitir negar el acceso.

  
### ⚠️ **Registrar intentos fallidos.**
- El sistema debe permitir conservar intentos de un usuario para entrar a la app por cada semana.
- El sistema debe registrar fecha de intentos fallidos.
- El sistema debe registrar Ip de intentos fallidos.
- El sistema debe permitir conservar intentos fallidos de inicio de sesion.
- El sistema debe permitir negar el acceso a usuarios con mas de 5 intentos fallidos.
- El sistema debe permitir tener un tiempo se espera de 3 minutos para volver a ingresar tras haber tenido 5 intentos fallidos.
- El sistema debe permitir negar el acceso por 1 hora despues de tener mas de 10 intentos fallidos.
  

### 💬 **Mensaje de seguridad como alertas.**
- El sistema debe permitir enviar un mensaje de inicio de sesion al correo electronico.
- El sistema debe permitir enviar un mensaje si se inicio sesion desde otra direccion Ip, al correo electronico.
- El sistema debe permitir enviar un mensaje si se ha intentado iniciar sesión.
- El sistema debe permitir enviar un mensaje de "Soy yo" para responder si verdaderamente el usuario es correcto.
- El sistema debe permitir enviar un mensaje de "No soy yo" para responder que no es el usuario correcto quien ha iniciado sesion.

#### **A continucacion se presentaran capturas de nuestro prototipo UI de las partes mas relevantes**

  


