package com.Alura.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class HistorialCambio {
    private String divisaOrigen;
    private Double montoInicial;
    private String divisaDestino;
    private Double montoFinal;
    private String fechaOperacion;
    private String horaOperacion;
}
