package com.ecotributario.utils;

public class SesionEmpresa {
    private static String nitEmpresa = null;

    public static void setNit(String nit) {
        nitEmpresa = nit;
    }

    public static String getNit() {
        return nitEmpresa;
    }

    public static void clear() {
        nitEmpresa = null;
    }
}
