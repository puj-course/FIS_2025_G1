package ecotributario.controllers;

import ecotributario.dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class RegistroController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cmbRol;

    @FXML
    private void initialize() {
        cmbRol.getItems().addAll("admin", "empresa");
    }

    @FXML
    private void registrarUsuario() {
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String rol = cmbRol.getValue();

        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty() || rol == null) {
            mostrarAlerta("Campos incompletos", "Por favor, completa todos los campos.");
            return;
        }

        boolean creado = UsuarioDAO.crearUsuario(nombre, email, password, rol);

        if (creado) {
            mostrarAlerta("Éxito", "Usuario creado correctamente.");
            limpiarFormulario();
        } else {
            mostrarAlerta("Error", "No se pudo registrar el usuario.");
        }
    }

    @FXML
    private void volverAlInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ecotributario/views/inicio.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Inicio - Ecotributario");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtEmail.clear();
        txtPassword.clear();
        cmbRol.setValue(null);
    }
}
