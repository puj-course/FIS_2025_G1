package com.ecotributario.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudTest {

    @Test
    public void testConstructorBasicoYGetters() {
        int id = 101;
        String nombreEmpresa = "EcoSolutions S.A.S.";
        String nit = "900123456";
        String direccion = "Calle 123 #45-67";

        Solicitud solicitud = new Solicitud(id, nombreEmpresa, nit, direccion);

        assertEquals(id, solicitud.getId());
        assertEquals(nombreEmpresa, solicitud.getNombreEmpresa());
        assertEquals(nit, solicitud.getNit());
        assertEquals(direccion, solicitud.getDireccion());
    }
}