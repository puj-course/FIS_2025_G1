package ecotributario.utils;

public class IncentivoCalculator {
    public static double calcularIncentivo(String tipoAccion, int frecuencia, String categoriaUsuario) {
        double base;

        switch (tipoAccion.toLowerCase()) {
            case "reciclaje": base = 10; break;
            case "uso de energías renovables": base = 20; break;
            case "reducción de emisiones": base = 25; break;
            default: base = 5;
        }

        double factorFrecuencia = frecuencia >= 5 ? 1.5 : 1.0;
        double factorCategoria = categoriaUsuario.equalsIgnoreCase("empresa") ? 2.0 : 1.0;

        return base * factorFrecuencia * factorCategoria;
    }
}
