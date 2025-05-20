package com.ecotributario.controllers;

import com.ecotributario.database.Conexion;
import com.ecotributario.utils.SesionEmpresa;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearSolicitudController {

    @FXML private TextField nombreEmpresaField;
    @FXML private TextField direccionField;
    @FXML private TextField telefonoField;
    @FXML private TextArea descripcionActividadField;
    @FXML private TextField ubicacionField;
    @FXML private TextField fechaEjecucionField;
    @FXML private ComboBox<String> tipoActividadCombo;

    @FXML private ToggleButton biomecanicaSi;
    @FXML private ToggleButton biomecanicaNo;
    @FXML private ToggleButton prediosSi;
    @FXML private ToggleButton prediosNo;
    @FXML private ToggleButton monitoreoSi;
    @FXML private ToggleButton monitoreoNo;

    @FXML private TextField reduccionEmisionesField;
    @FXML private TextField reduccionAguaField;
    @FXML private TextField coberturaVegetalField;
    @FXML private TextField otrosImpactosField;
    @FXML private TextField valorInversionField;

    @FXML private TextField telegramIdField;  // <--- Nuevo campo Telegram Chat ID

    @FXML private Button btnEnviar;
    @FXML private Button btnVolver;

    @FXML
    public void initialize() {
        tipoActividadCombo.getItems().addAll(
                "Reforestación", "Energía Renovable", "Gestión de residuos", "Educación ambiental", "Otra"
        );

        ToggleGroup biomecanicaGroup = new ToggleGroup();
        biomecanicaSi.setToggleGroup(biomecanicaGroup);
        biomecanicaNo.setToggleGroup(biomecanicaGroup);

        ToggleGroup prediosGroup = new ToggleGroup();
        prediosSi.setToggleGroup(prediosGroup);
        prediosNo.setToggleGroup(prediosGroup);

        ToggleGroup monitoreoGroup = new ToggleGroup();
        monitoreoSi.setToggleGroup(monitoreoGroup);
        monitoreoNo.setToggleGroup(monitoreoGroup);
    }

    @FXML
    private void onEnviarSolicitud() {
        String nitEmpresa = SesionEmpresa.getNit();

        if (nitEmpresa == null || nitEmpresa.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No hay empresa autenticada. Inicia sesión nuevamente.");
            return;
        }

        String telegramId = telegramIdField.getText();
        if (telegramId == null || telegramId.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "El campo Telegram Chat ID es obligatorio.");
            return;
        }

        try (Connection conn = Conexion.getConnection()) {
            if (conn == null || conn.isClosed()) {
                showAlert(Alert.AlertType.ERROR, "Error", "No se pudo conectar a la base de datos.");
                return;
            }

            String sql = "INSERT INTO solicitudes (nombre_empresa, nit, direccion, telefono, descripcion, ubicacion, fecha_ejecucion, tipo_actividad, biomecanica, predios, monitoreo, reduccion_emisiones, reduccion_agua, cobertura_vegetal, otros_impactos, valor_inversion, telegram_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombreEmpresaField.getText());
            stmt.setString(2, nitEmpresa);
            stmt.setString(3, direccionField.getText());
            stmt.setString(4, telefonoField.getText());
            stmt.setString(5, descripcionActividadField.getText());
            stmt.setString(6, ubicacionField.getText());
            stmt.setString(7, fechaEjecucionField.getText());
            stmt.setString(8, tipoActividadCombo.getValue());
            stmt.setBoolean(9, biomecanicaSi.isSelected());
            stmt.setBoolean(10, prediosSi.isSelected());
            stmt.setBoolean(11, monitoreoSi.isSelected());
            stmt.setString(12, reduccionEmisionesField.getText());
            stmt.setString(13, reduccionAguaField.getText());
            stmt.setString(14, coberturaVegetalField.getText());
            stmt.setString(15, otrosImpactosField.getText());
            stmt.setString(16, valorInversionField.getText());
            stmt.setString(17, telegramId);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Éxito", "✅ Solicitud enviada correctamente.");
                limpiarCampos();
            } else {
                showAlert(Alert.AlertType.WARNING, "Advertencia", "⚠️ No se pudo guardar la solicitud.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "❌ Error al guardar: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        nombreEmpresaField.clear();
        direccionField.clear();
        telefonoField.clear();
        descripcionActividadField.clear();
        ubicacionField.clear();
        fechaEjecucionField.clear();
        tipoActividadCombo.getSelectionModel().clearSelection();
        biomecanicaSi.setSelected(false);
        biomecanicaNo.setSelected(false);
        prediosSi.setSelected(false);
        prediosNo.setSelected(false);
        monitoreoSi.setSelected(false);
        monitoreoNo.setSelected(false);
        reduccionEmisionesField.clear();
        reduccionAguaField.clear();
        coberturaVegetalField.clear();
        otrosImpactosField.clear();
        valorInversionField.clear();
        telegramIdField.clear();  // Limpia el nuevo campo
    }

    @FXML
    private void onVolverAlInicioEmpresa(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ecotributario/views/inicioEmpresa.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel Empresa");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "No se pudo cargar la vista de inicio.");
        }
    }

    private void showAlert(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
