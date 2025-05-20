package com.ecotributario.controllers;

import com.ecotributario.database.Conexion;
import com.ecotributario.utils.SesionEmpresa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistorialSolicitudesController {

    @FXML private VBox listaSolicitudes;
    @FXML private VBox panelDetalles;

    @FXML private Label lblEmpresa;
    @FXML private Label lblImpacto;
    @FXML private Label lblDescripcion;
    @FXML private Label lblFecha;

    @FXML private TextArea txtComentario;
    @FXML private Button btnAprobar;
    @FXML private Button btnRechazar;
    @FXML private Button btnVolver;

    @FXML
    public void initialize() {
        panelDetalles.setVisible(false);  // Ocultar detalles inicialmente
        if (SesionEmpresa.getNit() == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No hay empresa autenticada.");
            return;
        }
        cargarSolicitudesDesdeBD();
    }

    private void cargarSolicitudesDesdeBD() {
        try (Connection conn = Conexion.getConnection()) {
            if (conn == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de conexión", "No se pudo conectar a la base de datos.");
                return;
            }

            String sql = "SELECT id, nombre_empresa, descripcion, fecha_ejecucion FROM solicitudes WHERE nit = ? ORDER BY fecha_ejecucion DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, SesionEmpresa.getNit());
            ResultSet rs = stmt.executeQuery();

            listaSolicitudes.getChildren().clear();

            while (rs.next()) {
                final String empresa = rs.getString("nombre_empresa");
                final String descripcion = rs.getString("descripcion");
                final String fecha = rs.getString("fecha_ejecucion");

                final HBox tarjeta = new HBox();
                tarjeta.setSpacing(10);
                tarjeta.setStyle("-fx-padding: 10; -fx-background-color: #ffffff; -fx-border-color: #ccc;");

                Label lblTitulo = new Label(empresa);
                lblTitulo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                Label lblFechaTarjeta = new Label("Fecha: " + fecha);

                tarjeta.getChildren().addAll(lblTitulo, lblFechaTarjeta);

                tarjeta.setOnMouseClicked((MouseEvent event) -> {
                    panelDetalles.setVisible(true);
                    lblEmpresa.setText("Empresa: " + empresa);
                    lblImpacto.setText("Impacto: por definir");
                    lblDescripcion.setText("Descripción: " + descripcion);
                    lblFecha.setText("Fecha: " + fecha);
                });

                listaSolicitudes.getChildren().add(tarjeta);
            }

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Hubo un problema al cargar las solicitudes.");
        }
    }

    @FXML
    private void onVolverAlPanel(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ecotributario/views/inicioEmpresa.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Ecotributario - Inicio Empresa");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo cargar la vista de inicio.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
