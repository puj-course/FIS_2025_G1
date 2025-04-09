package ecotributario.dao;

import ecotributario.model.Incentivo;
import ecotributario.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncentivoDAO {
    public void guardarIncentivo(Incentivo incentivo) {
        String sql = "INSERT INTO Incentivos (usuario_id, tipo_accion, frecuencia, categoria_usuario, monto) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, incentivo.getUsuarioId());
            stmt.setString(2, incentivo.getTipoAccion());
            stmt.setInt(3, incentivo.getFrecuencia());
            stmt.setString(4, incentivo.getCategoriaUsuario());
            stmt.setDouble(5, incentivo.getMontoCalculado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
