package ecotributario.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    // Encriptar una cadena usando SHA-256
    public static String encriptar(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            // Convertir bytes a hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Verificar una contraseña ingresada contra su hash
    public static boolean verificar(String textoPlano, String hashGuardado) {
        String hashCalculado = encriptar(textoPlano);
        return hashCalculado != null && hashCalculado.equals(hashGuardado);
    }
}
