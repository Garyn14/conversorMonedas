package com.Alura.model;

import com.Alura.model.exchangeApiRecord.CambioExchangeRecord;
import lombok.Data;

@Data
public class RealBrasilero {
    private Double dolar;
    private Double pesoArgentino;
    private Double pesoColombiano;

    public RealBrasilero(CambioExchangeRecord cambioExchangeRecord) {
        this.dolar = cambioExchangeRecord.conversion_rates().get("USD");
        this.pesoArgentino = cambioExchangeRecord.conversion_rates().get("ARS");
        this.pesoColombiano = cambioExchangeRecord.conversion_rates().get("COP");
    }
}
