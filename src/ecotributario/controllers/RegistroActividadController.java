package ecotributario.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RegistroActividadController {

    @FXML
    private TextField txtDescripcion;

    @FXML
    private ComboBox<String> cmbTipoActividad;

    @FXML
    private DatePicker fechaActividad;

    @FXML
    public void initialize() {
        cmbTipoActividad.getItems().addAll(
                "Reciclaje",
                "Energía renovable",
                "Otros"
        );
    }

    @FXML
    private void guardarActividad() {
        String descripcion = txtDescripcion.getText();
        String tipo = cmbTipoActividad.getValue();
        String fecha = (fechaActividad.getValue() != null) ? fechaActividad.getValue().toString() : "";

        if (descripcion.isEmpty() || tipo == null || fecha.isEmpty()) {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
            return;
        }

        // Aquí luego irá la lógica de guardado en base de datos

        mostrarAlerta("✅ Registro exitoso", "Actividad guardada correctamente.");
        limpiarFormulario();
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ecotributario/views/usuario_main.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
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

    private void limpiarFormulario() {
        txtDescripcion.clear();
        cmbTipoActividad.setValue(null);
        fechaActividad.setValue(null);
    }
}
