package ecotributario;

import ecotributario.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerUsuarios {

    public static void mostrarUsuarios() {
        String query = "SELECT * FROM Usuarios";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Lista de usuarios:");
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String rol = rs.getString("rol");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Email: " + email + ", Rol: " + rol);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener usuarios: " + e.getMessage());
        }
    }

    // Método de prueba
    public static void main(String[] args) {
        mostrarUsuarios();
    }
}
