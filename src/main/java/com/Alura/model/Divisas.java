package com.Alura.model;

public enum Divisas {
    DOLAR("USD"),
    PESO_ARGENTINO("ARS"),
    PESO_COLOMBIANO("COP"),
    REAL_BRASILERO("BRL");

    private String codigoDivisa;

    Divisas(String codigoDivisa){
        this.codigoDivisa = codigoDivisa;
    }

    public String getCodigoDivisa(){
        return codigoDivisa;
    }
}
