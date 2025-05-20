package com.ecotributario.controllers;

import com.ecotributario.database.Conexion;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrarAdminController {

    @FXML private TextField nombreField;
    @FXML private TextField correoField;
    @FXML private PasswordField contrasenaField;

    @FXML
    private void handleRegistro() {
        String nombre = nombreField.getText();
        String correo = correoField.getText();
        String contrasena = contrasenaField.getText();

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Todos los campos son obligatorios.");
            return;
        }

        if (!correo.matches("^[\\w\\.-]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            showAlert(Alert.AlertType.ERROR, "El correo electrónico no tiene un formato válido.");
            return;
        }

        if (contrasena.length() < 6) {
            showAlert(Alert.AlertType.ERROR, "La contraseña debe tener al menos 6 caracteres.");
            return;
        }

        try (Connection conn = Conexion.getConnection()) {
            if (conn == null) {
                showAlert(Alert.AlertType.ERROR, "Error al conectar con la base de datos.");
                return;
            }

            String sql = "INSERT INTO administradores (nombre, correo, contrasena) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contrasena);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Administrador registrado correctamente.");
                limpiarCampos();
            } else {
                showAlert(Alert.AlertType.ERROR, "No se pudo registrar el administrador.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error al registrar el administrador.");
        }
    }

    @FXML
    private void onVolver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ecotributario/views/inicio.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Inicio");
        stage.show();
    }

    private void showAlert(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(tipo == Alert.AlertType.INFORMATION ? "Éxito" : "Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        nombreField.clear();
        correoField.clear();
        contrasenaField.clear();
    }

    @FXML
    public void onRegistrarse(ActionEvent actionEvent) {
        handleRegistro();
    }
}
