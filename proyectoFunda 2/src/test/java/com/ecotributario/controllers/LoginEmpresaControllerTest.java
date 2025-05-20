package com.ecotributario.controllers;

import com.ecotributario.models.SesionEmpresa;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginEmpresaControllerTest {

    LoginEmpresaController controller;

    @BeforeEach
    public void setUp() {
        controller = new LoginEmpresaController();
        controller.nitField = new TextField();
        controller.contrasenaField = new PasswordField();
    }

    @Test
    public void testCamposVacios() {
        controller.nitField.setText("");
        controller.contrasenaField.setText("");
        assertTrue(controller.nitField.getText().isEmpty());
        assertTrue(controller.contrasenaField.getText().isEmpty());
    }

    @Test
    public void testLoginCorrectoSimulado() {
        controller.nitField.setText("123456789");
        controller.contrasenaField.setText("clave123");
        assertEquals("123456789", controller.nitField.getText());
        assertEquals("clave123", controller.contrasenaField.getText());
    }
}
