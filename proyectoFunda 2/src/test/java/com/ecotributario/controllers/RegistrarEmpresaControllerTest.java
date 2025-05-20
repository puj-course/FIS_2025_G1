package com.ecotributario.controllers;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrarEmpresaControllerTest {

    RegistrarEmpresaController controller;

    @BeforeEach
    public void setUp() {
        controller = new RegistrarEmpresaController();
        controller.nombreEmpresaField = new TextField();
        controller.nitField = new TextField();
        controller.direccionField = new TextField();
        controller.contactoField = new TextField();
        controller.sectorField = new TextField();
        controller.contrasenaField = new PasswordField();
    }

    @Test
    public void testCamposCompletos() {
        controller.nombreEmpresaField.setText("Verde S.A.");
        controller.nitField.setText("900999888");
        controller.direccionField.setText("Calle 45");
        controller.contactoField.setText("contacto@verde.com");
        controller.sectorField.setText("Ambiental");
        controller.contrasenaField.setText("clave123");

        assertEquals("Verde S.A.", controller.nombreEmpresaField.getText());
        assertEquals("900999888", controller.nitField.getText());
    }
}
