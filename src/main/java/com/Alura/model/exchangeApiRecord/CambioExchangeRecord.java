package com.Alura.model.exchangeApiRecord;

import java.util.Map;

public record CambioExchangeRecord(Map <String, Double> conversion_rates) {
}
