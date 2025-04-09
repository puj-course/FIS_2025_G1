package ecotributario.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Label;
import java.io.IOException;

public class UsuarioMainController {

    @FXML
    private Label lblBienvenida;

    // Puedes usar esta función si quieres pasar el nombre del usuario después del login
    public void setNombreUsuario(String nombre) {
        lblBienvenida.setText("¡Bienvenido, " + nombre + "!");
    }

    @FXML
    private void abrirRegistroActividad(ActionEvent event) {
        cambiarVista(event, "/ecotributario/views/registro_actividad.fxml");
    }

    @FXML
    private void abrirVistaIncentivos(ActionEvent event) {
        cambiarVista(event, "/ecotributario/views/ver_incentivos.fxml");
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        cambiarVista(event, "/ecotributario/views/login.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

