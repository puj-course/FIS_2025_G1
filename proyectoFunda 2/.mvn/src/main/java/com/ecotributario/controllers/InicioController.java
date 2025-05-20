package com.ecotributario.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;

import java.io.IOException;

public class InicioController {

    @FXML
    private void onIngresarAdministrador(ActionEvent event) {
        cargarVista(event, "/com/ecotributario/views/loginAdmin.fxml", "Login Administrador");
    }

    @FXML
    private void onIngresarEmpresa(ActionEvent event) {
        cargarVista(event, "/com/ecotributario/views/loginEmpresa.fxml", "Login Empresa");
    }

    @FXML
    private void onRegistrarAdmin(ActionEvent event) {
        cargarVista(event, "/com/ecotributario/views/registrarAdmin.fxml", "Registro Administrador");
    }

    @FXML
    private void onRegistrarEmpresa(ActionEvent event) {
        cargarVista(event, "/com/ecotributario/views/registrarEmpresa.fxml", "Registro Empresa");
    }

    private void cargarVista(ActionEvent event, String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo cargar la vista: " + titulo);
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
