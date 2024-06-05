package com.Alura;

import com.Alura.model.Divisas;
import com.Alura.model.Dolar;
import com.Alura.model.ExchangeCambio;
import com.Alura.model.exchangeApiRecord.CambioExchangeRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        /*
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest= HttpRequest.newBuilder()
                        .uri(URI.create
                                ("https://v6.exchangerate-api.com/v6/52a89a9b84e4a01b9238343a/latest/USD"))
                        .build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            CambioExchangeRecord cambioExchangeRecord = gson.fromJson(json, CambioExchangeRecord.class);
            Dolar dolar = new Dolar(cambioExchangeRecord);
            System.out.println(dolar);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        System.out.println("Hola mundo");*/
        ExchangeCambio exchangeCambio = new ExchangeCambio();
        try {
            System.out.println(exchangeCambio.fromDolarToPesoArgentino(232.15));
            System.out.println(exchangeCambio.fromPesoArgentinoToDolar(1000.0));
            System.out.println(exchangeCambio.fromDolarToRealBrasilero(100.0));
            System.out.println(exchangeCambio.fromRealBrasileroToDolar(100.0));
            System.out.println(exchangeCambio.fromDolarToPesoColombiano(1.0));
            System.out.println(exchangeCambio.fromPesoColombianoToDolar(1000.0));
            System.out.println(Divisas.DOLAR.getCodigoDivisa());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("PIPIPI");;
        }
    }
}