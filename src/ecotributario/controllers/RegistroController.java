package ecotributario.controllers;

import ecotributario.dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistroController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ChoiceBox<String> choiceRol;

    @FXML
    private void handleRegistro() {
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String rol = choiceRol.getValue();

        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty() || rol == null) {
            mostrarAlerta("Campos vacíos", "Por favor, llena todos los campos.");
            return;
        }

        boolean creado = UsuarioDAO.crearUsuario(nombre, email, password, rol);

        if (creado) {
            mostrarAlerta("¡Registro exitoso!", "Ya puedes iniciar sesión.");
            cerrarVentana(); // opcional: cerrar y volver a login
        } else {
            mostrarAlerta("Error", "No se pudo crear el usuario. Intenta con otro correo.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
}
