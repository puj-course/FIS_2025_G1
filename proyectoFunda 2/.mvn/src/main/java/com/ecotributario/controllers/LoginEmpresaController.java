package com.ecotributario.controllers;

import com.ecotributario.MainApp;
import com.ecotributario.database.Conexion;
import com.ecotributario.utils.SesionEmpresa;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginEmpresaController {

    @FXML private TextField txtNIT;
    @FXML private PasswordField txtContrasena;

    @FXML
    private void onIngresar(ActionEvent event) {
        String nit = txtNIT.getText();
        String contrasena = txtContrasena.getText();

        if (nit.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Todos los campos son obligatorios.");
            return;
        }

        try (Connection conn = Conexion.getConnection()) {
            if (conn == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "No se pudo conectar a la base de datos.");
                return;
            }

            String sql = "SELECT * FROM empresas WHERE nit = ? AND contrasena = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nit);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                SesionEmpresa.setNit(nit);
                MainApp.cambiarVista("/com/ecotributario/views/inicioEmpresa.fxml", "Panel Empresa");
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "NIT o contraseña incorrectos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error durante el inicio de sesión.");
        }
    }

    @FXML
    private void onVolverInicio(ActionEvent event) {
        MainApp.cambiarVista("/com/ecotributario/views/inicio.fxml", "Ecotributario - Inicio");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
