package com.ecotributario.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CampoValidadorTest {

    @Test
    public void testValidacionCampoTexto() {
        assertTrue(CampoValidador.esTextoValido("Nombre válido"));
        assertFalse(CampoValidador.esTextoValido(""));
    }

    @Test
    public void testValidacionNumerica() {
        assertTrue(CampoValidador.esNumeroValido("12345"));
        assertFalse(CampoValidador.esNumeroValido("abc123"));
    }
}
