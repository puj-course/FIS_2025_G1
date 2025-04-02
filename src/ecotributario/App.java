package ecotributario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Conexión a la base de datos
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Conexión exitosa");
        } else {
            System.out.println("❌ Conexión fallida");
        }

        // Cargar vista
        System.out.println(getClass().getResource("/ecotributario/views/login.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ecotributario/views/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Ecotributario – Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
