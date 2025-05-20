package com.ecotributario.dao;

import com.ecotributario.models.Empresa;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaDAOTest {

    @Test
    public void testListarEmpresasNoLanzaExcepcion() {
        try {
            List<Empresa> empresas = EmpresaDAO.obtenerEmpresas();
            assertNotNull(empresas);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }
}
