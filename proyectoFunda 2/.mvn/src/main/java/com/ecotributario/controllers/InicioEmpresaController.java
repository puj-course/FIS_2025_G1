package com.ecotributario.controllers;

import com.ecotributario.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class InicioEmpresaController {

    private String nitEmpresa;

    public void setNitEmpresa(String nit) {
        this.nitEmpresa = nit;
    }

    @FXML
    private void onCrearSolicitud(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/ecotributario/views/crearSolicitud.fxml"));
            Parent root = loader.load();

            Stage stage = MainApp.getMainStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Crear Solicitud Ambiental");
            stage.show();
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al cargar la vista de Crear Solicitud.");
            e.printStackTrace();
        }
    }

    @FXML
    private void onVerHistorial(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/ecotributario/views/historialSolicitudes.fxml"));
            Parent root = loader.load();

            Stage stage = MainApp.getMainStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Historial de Solicitudes");
            stage.show();
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al cargar el historial de solicitudes.");
            e.printStackTrace();
        }
    }

    @FXML
    private void onVerRanking(ActionEvent event) {
        mostrarAlerta("Información", "Ranking aún no implementado.");
    }

    @FXML
    private void onCerrarSesion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ecotributario/views/inicio.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Ecotributario - Inicio");
            stage.show();

            // Limpia sesión de empresa al cerrar sesión
            com.ecotributario.utils.SesionEmpresa.setNit(null);

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al cerrar sesión.");
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
}
