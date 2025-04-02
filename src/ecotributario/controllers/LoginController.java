package ecotributario.controllers;

import ecotributario.dao.UsuarioDAO;
import ecotributario.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin() {
        String email = txtUsuario.getText();
        String password = txtContrasena.getText();

        if (email.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, llena todos los campos.");
            return;
        }

        Usuario usuario = UsuarioDAO.autenticar(email, password);

        if (usuario != null) {
            mostrarAlerta("Bienvenido", "Hola " + usuario.getNombre() + " (" + usuario.getRol() + ")");
            // TODO: aquí podrías redirigir a otra vista
        } else {
            mostrarAlerta("Usuario no encontrado", "¿Deseas registrarte?");
            abrirVentanaRegistro();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void abrirVentanaRegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ecotributario/views/registro.fxml"));
            Scene scene = new Scene(loader.load(), 400, 350);
            Stage stage = new Stage();
            stage.setTitle("Registro de Usuario");
            stage.initModality(Modality.APPLICATION_MODAL); // bloquea la ventana anterior
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
