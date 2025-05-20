package com.ecotributario.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TelegramBot {

    private static final String BOT_TOKEN = "8145286400:AAFdn1uF5M7EAORPvd4Dk4dXJPa9VhRUhZA"; // Tu token aquí
    private static final String API_URL = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";

    public static boolean enviarMensaje(String chatId, String texto) {
        try {
            String urlParameters = "chat_id=" + URLEncoder.encode(chatId, StandardCharsets.UTF_8)
                    + "&text=" + URLEncoder.encode(texto, StandardCharsets.UTF_8);

            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (OutputStream os = conn.getOutputStream()) {
                os.write(postData);
            }

            int responseCode = conn.getResponseCode();
            return (responseCode == 200);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
/*Done! Congratulations on your new bot. You will find it at t.me/Ecotributario_bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.

Use this token to access the HTTP API:
8145286400:AAFdn1uF5M7EAORPvd4Dk4dXJPa9VhRUhZA
Keep your token secure and store it safely, it can be used by anyone to control your bot.

For a description of the Bot API, see this page: https://core.telegram.org/bots/api*/
