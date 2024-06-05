package com.Alura.model;

import com.Alura.model.exchangeApiRecord.CambioExchangeRecord;
import lombok.Data;

@Data
public class Dolar {
    private Double pesoArgentino;
    private Double realBrasilero;
    private Double pesoColombiano;

    public Dolar(CambioExchangeRecord cambioExchangeRecord) {
        this.pesoArgentino = cambioExchangeRecord.conversion_rates().get("ARS");
        this.realBrasilero = cambioExchangeRecord.conversion_rates().get("BRL");
        this.pesoColombiano = cambioExchangeRecord.conversion_rates().get("COP");
    }
}
