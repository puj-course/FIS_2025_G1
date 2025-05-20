package com.ecotributario.database;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class ConexionTest {

    @Test
    public void testObtenerConexion() {
        Connection conn = Conexion.getConnection();
        assertNotNull(conn);
    }
}
