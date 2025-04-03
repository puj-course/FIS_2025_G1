package ecotributario.dao;

import ecotributario.DBConnection;
import ecotributario.model.Usuario;
import ecotributario.utils.HashUtil;

import java.sql.*;

public class UsuarioDAO {

    // Autenticación con contraseña encriptada
    public static Usuario autenticar(String email, String password) {
        String query = "SELECT * FROM Usuarios WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, HashUtil.encriptar(password)); // encriptar antes de comparar
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("rol")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al autenticar usuario: " + e.getMessage());
        }

        return null;
    }

    // Registro de usuario con contraseña encriptada
    public static boolean crearUsuario(String nombre, String email, String password, String rol) {
        String query = "INSERT INTO Usuarios (nombre, email, password, rol) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, HashUtil.encriptar(password)); // encriptar antes de guardar
            stmt.setString(4, rol);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            return false;
        }
    }
}
