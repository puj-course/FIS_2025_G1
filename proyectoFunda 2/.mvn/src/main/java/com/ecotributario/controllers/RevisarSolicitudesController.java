package com.ecotributario.controllers;

import com.ecotributario.MainApp;
import com.ecotributario.database.Conexion;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RevisarSolicitudesController {

    @FXML private VBox listaSolicitudes;
    @FXML private VBox detallePane;
    @FXML private Label empresaLabel;
    @FXML private Label impactoLabel;
    @FXML private Label descripcionLabel;
    @FXML private Label fechaLabel;
    @FXML private TextArea comentarioField;

    private int solicitudSeleccionadaId = -1;

    private static final String TELEGRAM_BOT_TOKEN = "8145286400:AAFdn1uF5M7EAORPvd4Dk4dXJPa9VhRUhZA";

    @FXML
    public void initialize() {
        detallePane.setVisible(false);
        cargarTodasSolicitudes();
    }

    private void cargarTodasSolicitudes() {
        try (Connection conn = Conexion.getConnection()) {
            String sql = "SELECT id, nombre_empresa, descripcion, fecha_ejecucion, reduccion_emisiones, estado FROM solicitudes ORDER BY fecha_ejecucion DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                listaSolicitudes.getChildren().clear();

                while (rs.next()) {
                    final int id = rs.getInt("id");
                    final String empresa = rs.getString("nombre_empresa");
                    final String descripcion = rs.getString("descripcion");
                    final String fecha = rs.getString("fecha_ejecucion");
                    final String impacto = rs.getString("reduccion_emisiones");
                    final String estadoActual = rs.getString("estado") == null ? "Pendiente" : rs.getString("estado");

                    Button btnSolicitud = new Button(empresa + " - Estado: " + estadoActual);
                    btnSolicitud.setMaxWidth(Double.MAX_VALUE);
                    btnSolicitud.setOnAction(e -> mostrarDetalle(id, empresa, impacto, descripcion, fecha));

                    listaSolicitudes.getChildren().add(btnSolicitud);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Hubo un problema al cargar las solicitudes.");
        }
    }

    private void mostrarDetalle(int id, String empresa, String impacto, String descripcion, String fecha) {
        solicitudSeleccionadaId = id;
        empresaLabel.setText("Empresa: " + empresa);
        impactoLabel.setText("Impacto: " + impacto);
        descripcionLabel.setText("Descripción: " + descripcion);
        fechaLabel.setText("Fecha: " + fecha);

        try (Connection conn = Conexion.getConnection()) {
            String sql = "SELECT comentario FROM solicitudes WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String comentarioGuardado = rs.getString("comentario");
                        comentarioField.setText(comentarioGuardado != null ? comentarioGuardado : "");
                    } else {
                        comentarioField.clear();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            comentarioField.clear();
        }

        detallePane.setVisible(true);
    }

    @FXML
    private void onAprobar() {
        System.out.println("Botón Aprobar clickeado para solicitud ID: " + solicitudSeleccionadaId);
        actualizarEstado("Aprobada");
    }

    @FXML
    private void onRechazar() {
        System.out.println("Botón Rechazar clickeado para solicitud ID: " + solicitudSeleccionadaId);
        actualizarEstado("Rechazada");
    }

    private void actualizarEstado(String estadoNuevo) {
        if (solicitudSeleccionadaId == -1) {
            mostrarAlerta("Selecciona una solicitud primero.");
            return;
        }

        System.out.println("Intentando actualizar solicitud ID: " + solicitudSeleccionadaId + " con estado: " + estadoNuevo);
        String comentario = comentarioField.getText();

        try (Connection conn = Conexion.getConnection()) {
            System.out.println("Conexión a BD exitosa");

            String telegramId = null;
            String queryTelegram = "SELECT telegram_id FROM solicitudes WHERE id = ?";
            try (PreparedStatement psTelegram = conn.prepareStatement(queryTelegram)) {
                psTelegram.setInt(1, solicitudSeleccionadaId);
                try (ResultSet rs = psTelegram.executeQuery()) {
                    if (rs.next()) {
                        telegramId = rs.getString("telegram_id");
                        System.out.println("telegram_id obtenido: " + telegramId);
                    } else {
                        System.out.println("No se encontró telegram_id para la solicitud.");
                    }
                }
            }

            String sql = "UPDATE solicitudes SET estado = ?, comentario = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, estadoNuevo);
                stmt.setString(2, comentario);
                stmt.setInt(3, solicitudSeleccionadaId);

                int filas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filas);

                if (filas > 0) {
                    mostrarAlerta("✅ Solicitud actualizada a " + estadoNuevo + ".");
                    comentarioField.clear();
                    detallePane.setVisible(false);
                    solicitudSeleccionadaId = -1;
                    cargarTodasSolicitudes();

                    if (telegramId != null && !telegramId.isEmpty()) {
                        enviarNotificacionTelegram(telegramId, estadoNuevo);
                    }
                } else {
                    mostrarAlerta("⚠️ No se actualizó la solicitud.");
                }
            }

        } catch (Exception e) {
            System.err.println("Error en actualizarEstado: " + e.getMessage());
            e.printStackTrace();
            mostrarAlerta("❌ Error al actualizar estado.");
        }
    }

    private void enviarNotificacionTelegram(String chatId, String estadoNuevo) {
        try {
            String mensaje = "Tu solicitud ha sido actualizada a: " + estadoNuevo;
            String urlString = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN + "/sendMessage?chat_id=" + URLEncoder.encode(chatId, StandardCharsets.UTF_8) + "&text=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8);

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Notificación enviada a Telegram correctamente.");
            } else {
                System.err.println("Error enviando notificación a Telegram. Código: " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Error al enviar notificación Telegram: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void onVolver() {
        MainApp.cambiarVista("/com/ecotributario/views/inicioAdministrador.fxml", "Panel Administrador");
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Estado de solicitud");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
