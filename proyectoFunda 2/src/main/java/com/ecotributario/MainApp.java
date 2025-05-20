package com.ecotributario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static Stage mainStage;

    public static Stage getMainStage() {
        return mainStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        cambiarVista("/com/ecotributario/views/inicio.fxml", "Ecotributario - Inicio");
    }

    public static void cambiarVista(String rutaFXML, String tituloVentana) {
        try {
            System.out.println("Intentando cargar: " + rutaFXML);
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(rutaFXML));
            Parent root = loader.load();

            if (mainStage == null) {
                mainStage = new Stage();
            }

            mainStage.setTitle(tituloVentana);
            mainStage.setScene(new Scene(root));
            mainStage.show();

        } catch (Exception e) {
            System.err.println("❌ ERROR: No se pudo cargar la vista: " + rutaFXML);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
