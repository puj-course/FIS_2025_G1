package ecotributario.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class VerIncentivosController {

    @FXML
    private ListView<String> listaIncentivos;

    @FXML
    public void initialize() {
        // Ejemplo: incentivos de prueba (más adelante, vendrán desde la base de datos)
        listaIncentivos.getItems().addAll(
                "🌱 Reciclaje - $50000 COP - 2025-03-01",
                "☀️ Energía renovable - $80000 COP - 2025-03-10",
                "♻️ Otros - $30000 COP - 2025-03-15"
        );
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
}
