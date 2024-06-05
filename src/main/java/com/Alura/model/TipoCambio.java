package com.Alura.model;

import java.io.IOException;

public interface TipoCambio {
    Double fromDolarToPesoArgentino(Double dolar) throws IOException, InterruptedException;
    Double fromPesoArgentinoToDolar(Double pesoArgentino) throws IOException, InterruptedException;
    Double fromDolarToRealBrasilero(Double dolar) throws IOException, InterruptedException;
    Double fromRealBrasileroToDolar(Double realBrasilero) throws IOException, InterruptedException;
    Double fromDolarToPesoColombiano(Double dolar) throws IOException, InterruptedException;
    Double fromPesoColombianoToDolar(Double pesoColombiano) throws IOException, InterruptedException;
}
