package com.ecotributario.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TelegramTest {

    private static final String TELEGRAM_BOT_TOKEN = "8145286400:AAFdn1uF5M7EAORPvd4Dk4dXJPa9VhRUhZA";
    private static final String CHAT_ID = "6226504584";

    public static void main(String[] args) {
        try {
            String mensaje = "Hola! Este es un mensaje de prueba desde el bot Ecotributario.";
            String urlString = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN
                    + "/sendMessage?chat_id=" + URLEncoder.encode(CHAT_ID, StandardCharsets.UTF_8)
                    + "&text=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8);

            System.out.println("URL para Telegram: " + urlString);

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

            if (responseCode == 200) {
                // Leer la respuesta del servidor para confirmar
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    System.out.println("Respuesta Telegram: " + response.toString());
                }
                System.out.println("Mensaje enviado correctamente.");
            } else {
                System.err.println("Error al enviar mensaje. Código: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
