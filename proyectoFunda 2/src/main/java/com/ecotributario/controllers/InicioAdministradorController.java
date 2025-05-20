package com.ecotributario.controllers;

import com.ecotributario.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class InicioAdministradorController {

    @FXML
    private StackPane panelContenido;

    @FXML
    private void mostrarRevisionesPendientes(ActionEvent event) {
        cargarVista("/com/ecotributario/views/revisionesPendientes.fxml");
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ecotributario/views/inicio.fxml"));
            Parent root = loader.load();
            panelContenido.getScene().setRoot(root);
        } catch (IOException e) {
            mostrarError("Error al cerrar sesión");
            e.printStackTrace();
        }
    }

    private void cargarVista(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Node contenido = loader.load();
            panelContenido.getChildren().setAll(contenido);
        } catch (IOException e) {
            mostrarError("No se pudo cargar la vista: " + rutaFXML);
            e.printStackTrace();
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void onRevisarSolicitudes(ActionEvent event) {
        System.out.println("Click en Revisar Solicitudes");
        MainApp.cambiarVista("/com/ecotributario/views/revisarSolicitudes.fxml", "Revisión de Solicitudes");
    }
}
