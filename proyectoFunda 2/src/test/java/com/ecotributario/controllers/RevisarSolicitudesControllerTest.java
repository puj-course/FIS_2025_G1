package com.ecotributario.controllers;

import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RevisarSolicitudesControllerTest {

    RevisarSolicitudesController controller;

    @BeforeEach
    public void setUp() {
        controller = new RevisarSolicitudesController();
        controller.comentarioField = new TextArea();
        controller.empresaLabel = new Label();
        controller.detallePane = new VBox();
    }

    @Test
    public void testComentarioInicialVacio() {
        assertEquals("", controller.comentarioField.getText());
    }

    @Test
    public void testAsignarEmpresa() {
        controller.empresaLabel.setText("Eco S.A.S.");
        assertEquals("Eco S.A.S.", controller.empresaLabel.getText());
    }
}
