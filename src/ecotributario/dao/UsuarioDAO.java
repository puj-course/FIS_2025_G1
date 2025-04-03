package ecotributario.dao;

import ecotributario.DBConnection;
import ecotributario.model.Usuario;
import ecotributario.utils.HashUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),                        // ← idUsuario
                        rs.getString("nombre"),
                        rs.getString("correo"),                 // ← email
                        rs.getString("contraseña"),             // ← password
                        rs.getString("tipo_usuario")            // ← rol
                );
                lista.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Crear nuevo usuario (registro)
    public boolean crearUsuario(String nombre, String correo, String password, String tipoUsuario) {
        String sql = "INSERT INTO Usuarios (nombre, correo, contraseña, tipo_usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, HashUtil.encriptar(password));
            stmt.setString(4, tipoUsuario);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Autenticar usuario (login)
    public Usuario autenticar(String correo, String passwordPlano) {
        String sql = "SELECT * FROM Usuarios WHERE correo = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashEnBD = rs.getString("contraseña");
                if (HashUtil.verificar(passwordPlano, hashEnBD)) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contraseña"),
                            rs.getString("tipo_usuario")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Usuario no encontrado o contraseña incorrecta
    }
}
