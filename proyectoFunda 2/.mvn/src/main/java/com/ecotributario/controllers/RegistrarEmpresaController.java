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

public class RegistrarEmpresaController {

    @FXML private TextField nombreEmpresaField;
    @FXML private TextField nitField;
    @FXML private TextField direccionField;
    @FXML private TextField contactoField;
    @FXML private TextField sectorField;
    @FXML private PasswordField contrasenaField;

    @FXML
    private void handleRegistro() {
        String nombre = nombreEmpresaField.getText();
        String nit = nitField.getText();
        String direccion = direccionField.getText();
        String contacto = contactoField.getText();
        String sector = sectorField.getText();
        String contrasena = contrasenaField.getText();

        if (nombre.isEmpty() || nit.isEmpty() || direccion.isEmpty()
                || contacto.isEmpty() || sector.isEmpty() || contrasena.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Todos los campos son obligatorios.");
            return;
        }

        if (!nit.matches("\\d+")) {
            showAlert(Alert.AlertType.ERROR, "El NIT debe ser un número.");
            return;
        }

        if (!contacto.matches("\\d{7,10}")) {
            showAlert(Alert.AlertType.ERROR, "El número de contacto debe tener entre 7 y 10 dígitos.");
            return;
        }

        if (contrasena.length() < 6) {
            showAlert(Alert.AlertType.ERROR, "La contraseña debe tener al menos 6 caracteres.");
            return;
        }

        try (Connection conn = Conexion.getConnection()) {
            if (conn == null) {
                showAlert(Alert.AlertType.ERROR, "No se pudo conectar a la base de datos.");
                return;
            }

            String sql = "INSERT INTO empresas (nombre, nit, direccion, contacto, sector, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, nit);
            stmt.setString(3, direccion);
            stmt.setString(4, contacto);
            stmt.setString(5, sector);
            stmt.setString(6, contrasena);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Empresa registrada correctamente.");
                limpiarCampos();
            } else {
                showAlert(Alert.AlertType.ERROR, "No se pudo registrar la empresa.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error al registrar la empresa.");
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
        alert.setTitle(tipo == Alert.AlertType.INFORMATION ? "Éxito" : "Error de validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        nombreEmpresaField.clear();
        nitField.clear();
        direccionField.clear();
        contactoField.clear();
        sectorField.clear();
        contrasenaField.clear();
    }

    @FXML
    public void onRegistrarse(ActionEvent actionEvent) {
        handleRegistro();
    }
}
