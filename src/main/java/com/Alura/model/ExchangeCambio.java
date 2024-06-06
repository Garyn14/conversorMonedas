package com.Alura.model;

import com.Alura.model.exchangeApiRecord.CambioExchangeRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ExchangeCambio implements TipoCambio{

    private Gson gson;
    private HttpClient cliente;

    private HttpRequest solicitud;

    private HttpResponse<String> respuesta;

    private final String URL = "https://v6.exchangerate-api.com/v6/52a89a9b84e4a01b9238343a/latest/";

    public ExchangeCambio(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.cliente = HttpClient.newHttpClient();
    }

    @Override
    public Double fromDolarToPesoArgentino(Double dolares) throws IOException, InterruptedException {
        String json = enviarSolicitud(Divisas.DOLAR.getCodigoDivisa()); // obtener el JSON de la consulta
        // clase record intermedia
        CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
        Dolar divisaDolar = new Dolar(cambioExchangeRecord); // mapeo de la clase record a la clase dolar
        double respuesta = dolares * divisaDolar.getPesoArgentino(); // realizar el tipo de cambio
        return Math.round(respuesta * 100.0) / 100.0; // formatear el número a 2 dígitos
    }

    @Override
    public Double fromPesoArgentinoToDolar(Double pesosArgentinos) throws IOException, InterruptedException {
        String json = enviarSolicitud(Divisas.PESO_ARGENTINO.getCodigoDivisa());
        CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
        PesoArgentino divisaPeso = new PesoArgentino(cambioExchangeRecord);
        double respuesta = pesosArgentinos * divisaPeso.getDolar();
        return Math.round(respuesta * 100.0) / 100.0;
    }

    @Override
    public Double fromDolarToRealBrasilero(Double dolares) throws IOException, InterruptedException {
        String json = enviarSolicitud(Divisas.DOLAR.getCodigoDivisa());
        CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
        Dolar divisaDolar = new Dolar(cambioExchangeRecord);
        double respuesta = dolares * divisaDolar.getRealBrasilero();
        return Math.round(respuesta * 100.0) / 100.0;
    }

    @Override
    public Double fromRealBrasileroToDolar(Double realesBrasilero) throws IOException, InterruptedException {
        String json = enviarSolicitud(Divisas.REAL_BRASILERO.getCodigoDivisa());
        CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
        RealBrasilero divisaReal = new RealBrasilero(cambioExchangeRecord);
        double respuesta = realesBrasilero * divisaReal.getDolar();
        return Math.round(respuesta * 100.0) / 100.0;
    }

    @Override
    public Double fromDolarToPesoColombiano(Double dolares) throws IOException, InterruptedException {
        String json = enviarSolicitud(Divisas.DOLAR.getCodigoDivisa());
        CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
        Dolar divisaDolar = new Dolar(cambioExchangeRecord);
        double respuesta = dolares * divisaDolar.getPesoColombiano();
        return Math.round(respuesta * 100.0) / 100.0;
    }

    @Override
    public Double fromPesoColombianoToDolar(Double pesosColombiano) throws IOException, InterruptedException {
        String json = enviarSolicitud(Divisas.PESO_COLOMBIANO.getCodigoDivisa());
        CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
        PesoColombiano divisaPeso = new PesoColombiano(cambioExchangeRecord);
        double respuesta = pesosColombiano * divisaPeso.getDolar();
        return Math.round(respuesta * 100.0) / 100.0;
    }

    private String enviarSolicitud(String divisa) throws IOException, InterruptedException {
        solicitud = HttpRequest.newBuilder().uri(URI.create(URL + divisa)).build();
        respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        return respuesta.body();
    }
}
