package ecotributario.controllers;

import ecotributario.dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistroController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private ComboBox<String> cbTipoUsuario;

    @FXML
    private Button btnRegistrar;

    @FXML
    private void initialize() {
        // Llenar ComboBox con los únicos valores válidos según tu base de datos
        cbTipoUsuario.getItems().addAll("admin", "empresa");
        cbTipoUsuario.setValue("empresa"); // Valor por defecto VÁLIDO
    }

    @FXML
    private void handleRegistro() {
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = cbTipoUsuario.getValue();

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || tipoUsuario == null) {
            mostrarAlerta("Campos incompletos", "Por favor completa todos los campos.");
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        boolean registrado = dao.crearUsuario(nombre, correo, contrasena, tipoUsuario);

        if (registrado) {
            mostrarAlerta("Éxito", "Usuario registrado correctamente.");
            cerrarVentana();
        } else {
            mostrarAlerta("Error", "No se pudo registrar el usuario. Verifica si el correo ya está en uso.");
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
        Stage stage = (Stage) btnRegistrar.getScene().getWindow();
        stage.close();
    }
}
