package com.ecotributario.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10779866?useSSL=false&serverTimezone=UTC";
    private static final String USER = "sql10779866";
    private static final String PASSWORD = "8WcBFGfYcD";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo cargar el driver JDBC: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            throw e; // relanza para que el controlador lo maneje
        }
    }
}
