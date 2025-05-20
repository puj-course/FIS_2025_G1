package com.ecotributario.models;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaRankingTest {

    @Test
    public void testGetters() {
        EmpresaRanking ranking = new EmpresaRanking("Eco S.A.S", new BigDecimal("12.5"), "123456789");
        assertEquals("Eco S.A.S", ranking.getNombreEmpresa());
        assertEquals(new BigDecimal("12.5"), ranking.getImpactoAmbiental());
        assertEquals("123456789", ranking.getNit());
    }
}
