package ecotributario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://mysql-sarix.alwaysdata.net:3306/sarix_ecotributario";
    private static final String USER = "sarix"; // tu usuario en AlwaysData
    private static final String PASSWORD = "Javeriana1"; // cámbiala por la tuya real

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
