package com.Alura;

import com.Alura.model.Divisas;
import com.Alura.model.ExchangeCambio;
import com.Alura.model.HistorialCambio;
import com.Alura.model.TipoCambio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<HistorialCambio> transacciones = new ArrayList<>();
        TipoCambio cambioExchange = new ExchangeCambio();
        Scanner entrada = new Scanner(System.in);
        double montoConvertido;
        String divisaInicial;
        FileWriter archivo;
        String divisaFinal;
        double monto;
        int opc = 0;

        while(opc != 7){
            try{
                System.out.println("""
                    ***********************************************************************
                    Sea bienvenido/a al Conversor de Monedas =]
                    
                    1) Dólar  =>> Peso Argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real Brasilero
                    4) Real Brasilero =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    Elija una opción válida: 
                    ***********************************************************************
                    """);
                                opc = entrada.nextInt();
                if(opc == 7) break;
                System.out.println("Ingrese el valor que desea convertir:");
                monto = entrada.nextDouble();

                switch (opc){
                    case 1:{
                        montoConvertido = cambioExchange.fromDolarToPesoArgentino(monto);
                        divisaInicial = Divisas.DOLAR.getCodigoDivisa();
                        divisaFinal = Divisas.PESO_ARGENTINO.getCodigoDivisa();
                        break;
                    }
                    case 2:{
                        montoConvertido = cambioExchange.fromPesoArgentinoToDolar(monto);
                        divisaInicial = Divisas.PESO_ARGENTINO.getCodigoDivisa();
                        divisaFinal = Divisas.DOLAR.getCodigoDivisa();
                        break;
                    }
                    case 3:{
                        montoConvertido = cambioExchange.fromDolarToRealBrasilero(monto);
                        divisaInicial = Divisas.DOLAR.getCodigoDivisa();
                        divisaFinal = Divisas.REAL_BRASILERO.getCodigoDivisa();
                        break;
                    }
                    case 4:{
                        montoConvertido = cambioExchange.fromRealBrasileroToDolar(monto);
                        divisaInicial = Divisas.REAL_BRASILERO.getCodigoDivisa();
                        divisaFinal = Divisas.DOLAR.getCodigoDivisa();
                        break;
                    }
                    case 5:{
                        montoConvertido = cambioExchange.fromDolarToPesoColombiano(monto);
                        divisaInicial = Divisas.DOLAR.getCodigoDivisa();
                        divisaFinal = Divisas.PESO_COLOMBIANO.getCodigoDivisa();
                        break;
                    }
                    case 6:{
                        montoConvertido = cambioExchange.fromPesoColombianoToDolar(monto);
                        divisaInicial = Divisas.PESO_COLOMBIANO.getCodigoDivisa();
                        divisaFinal =Divisas.DOLAR.getCodigoDivisa();
                        break;
                    }
                    default:{
                        System.out.println("La opción ingresado no es válida, intente otra vez");
                        continue;
                    }
                }

                System.out.println("El valor de " + monto + " " + divisaInicial + " corresponde al valor final de =>>> " + montoConvertido + " " + divisaFinal);

                // historial de transacciones
                HistorialCambio historialCambio = new HistorialCambio();
                historialCambio.setDivisaOrigen(divisaInicial);
                historialCambio.setDivisaDestino(divisaFinal);
                historialCambio.setMontoInicial(monto);
                historialCambio.setMontoFinal(montoConvertido);
                historialCambio.setFechaOperacion(LocalDate.now().toString());
                historialCambio.setHoraOperacion(LocalTime.now().toString());

                transacciones.add(historialCambio);

            } catch (IOException | InterruptedException e2){
                System.out.println("Se ha producido un error, intente denuevo");
            } catch (InputMismatchException e1){
                System.out.println("La opción ingresada no es válida");
                entrada.nextLine(); // limpiar buffer del scanner+
            } catch (Exception e){
                System.out.println("Ha ocurrido un error");
            }
        }

        try{
            archivo = new FileWriter("transacciones.json");
            archivo.write(gson.toJson(transacciones));
            archivo.close();
            System.out.println("PROGRAMA FINALIZADO");
            System.out.println("El historial de las transacciones ha sido creado");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error en el guardado del archivo");
        } catch (Exception e){
            System.out.println("Ha ocurrido un error con el archivo");
        }

    }
}