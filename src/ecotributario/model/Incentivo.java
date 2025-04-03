package ecotributario.model;

public class Incentivo {
    private int usuarioId;
    private String tipoAccion;
    private int frecuencia;
    private String categoriaUsuario;
    private double montoCalculado;

    public Incentivo(int usuarioId, String tipoAccion, int frecuencia, String categoriaUsuario, double montoCalculado) {
        this.usuarioId = usuarioId;
        this.tipoAccion = tipoAccion;
        this.frecuencia = frecuencia;
        this.categoriaUsuario = categoriaUsuario;
        this.montoCalculado = montoCalculado;
    }

    // Getters
    public int getUsuarioId() {
        return usuarioId;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public String getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public double getMontoCalculado() {
        return montoCalculado;
    }

    // Opcional: setters (solo si los necesitas)
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setCategoriaUsuario(String categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public void setMontoCalculado(double montoCalculado) {
        this.montoCalculado = montoCalculado;
    }
}
