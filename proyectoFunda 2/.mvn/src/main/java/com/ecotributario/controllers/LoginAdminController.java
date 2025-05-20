package com.ecotributario.controllers;

import com.ecotributario.database.Conexion;
import com.ecotributario.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginAdminController {

    @FXML private TextField nombreField;
    @FXML private TextField correoField;
    @FXML private PasswordField contrasenaField;

    @FXML
    private void onIngresar(ActionEvent event) {
        String nombre = nombreField.getText();
        String correo = correoField.getText();
        String contrasena = contrasenaField.getText();

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Todos los campos son obligatorios.");
            return;
        }

        if (!correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            showAlert(Alert.AlertType.ERROR, "El correo no tiene un formato válido.");
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

            String sql = "SELECT * FROM administradores WHERE correo = ? AND contrasena = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login administrador exitoso: " + nombre);
                MainApp.cambiarVista("/com/ecotributario/views/inicioAdministrador.fxml", "Panel del Administrador");
            } else {
                showAlert(Alert.AlertType.ERROR, "Correo o contraseña incorrectos.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error durante el inicio de sesión.");
        }
    }

    @FXML
    private void volverAlInicio(ActionEvent event) {
        MainApp.cambiarVista("/com/ecotributario/views/inicio.fxml", "Ecotributario - Inicio");
    }

    private void showAlert(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
