package com.Alura.model;

import com.Alura.model.exchangeApiRecord.CambioExchangeRecord;
import lombok.Data;

@Data
public class PesoColombiano {
    private Double dolar;
    private Double realBrasilero;
    private Double pesoArgentino;

    public PesoColombiano(CambioExchangeRecord cambioExchangeRecord) {
        this.dolar = cambioExchangeRecord.conversion_rates().get("USD");
        this.realBrasilero = cambioExchangeRecord.conversion_rates().get("BRL");
        this.pesoArgentino = cambioExchangeRecord.conversion_rates().get("ARS");
    }
}
