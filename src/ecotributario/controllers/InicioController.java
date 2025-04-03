package ecotributario.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class InicioController {

    public void abrirLogin(ActionEvent event) {
        cambiarEscena("/ecotributario/views/login.fxml", event);
    }

    public void abrirRegistro(ActionEvent event) {
        cambiarEscena("/ecotributario/views/registro.fxml", event);
    }

    private void cambiarEscena(String rutaFXML, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Ecotributario");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
