package ecotributario.model;

public class Incentivo {
    private int id;
    private int usuarioId;
    private String tipoAccion;
    private int frecuencia;
    private String categoriaUsuario;
    private double montoCalculado;

    public Incentivo(int id, int usuarioId, String tipoAccion, int frecuencia, String categoriaUsuario, double montoCalculado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipoAccion = tipoAccion;
        this.frecuencia = frecuencia;
        this.categoriaUsuario = categoriaUsuario;
        this.montoCalculado = montoCalculado;
    }

    // Getters y Setters
    // ...
}
