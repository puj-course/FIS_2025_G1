package com.ecotributario.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Solicitud {
    private final StringProperty fecha;
    private final StringProperty estado;
    private final StringProperty comentario;

    public Solicitud(String fecha, String estado, String comentario) {
        this.fecha = new SimpleStringProperty(fecha);
        this.estado = new SimpleStringProperty(estado);
        this.comentario = new SimpleStringProperty(comentario);
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public StringProperty comentarioProperty() {
        return comentario;
    }
}
