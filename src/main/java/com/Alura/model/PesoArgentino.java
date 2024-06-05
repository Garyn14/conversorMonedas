package com.Alura.model;

import com.Alura.model.exchangeApiRecord.CambioExchangeRecord;
import lombok.Data;

@Data
public class PesoArgentino {
    private Double dolar;
    private Double realBrasilero;
    private Double pesoColombiano;

    public PesoArgentino(CambioExchangeRecord cambioExchangeRecord) {
        this.dolar = cambioExchangeRecord.conversion_rates().get("USD");
        this.realBrasilero = cambioExchangeRecord.conversion_rates().get("BRL");
        this.pesoColombiano = cambioExchangeRecord.conversion_rates().get("COP");
    }
}
