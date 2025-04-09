package ecotributario;

public class DBConfig {
    // Cambia entre "sqlite" y "mariadb"
    public static final String DB_TYPE = "sqlite"; // o "mariadb"

    // Devuelve la URL de conexión según el tipo de base de datos
    public static String getConnectionURL() {
        if (DB_TYPE.equals("sqlite")) {
            return "jdbc:sqlite:ecotributario.db";
        } else if (DB_TYPE.equals("mariadb")) {
            // IMPORTANTE: reemplaza usuario y contraseña según lo que configures
            return "jdbc:mariadb://localhost:3306/ecotributario?user=tu_usuario&password=tu_contraseña";
        } else {
            throw new RuntimeException("Tipo de base de datos no soportado: " + DB_TYPE);
        }
    }
}
