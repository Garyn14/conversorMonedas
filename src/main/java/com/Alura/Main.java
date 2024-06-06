package com.Alura;

import com.Alura.model.Divisas;
import com.Alura.model.ExchangeCambio;
import com.Alura.model.TipoCambio;

import java.io.IOException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opc = 0;
        double monto;
        double montoConvertido;
        TipoCambio cambioExchange = new ExchangeCambio();
        String divisaInicial;
        String divisaFinal;

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
                monto = entrada.nextInt();

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

            } catch (IOException | InterruptedException e2){
                System.out.println("Se ha producido un error, intente denuevo");
            } catch (InputMismatchException e1){
                System.out.println("La opción ingresada no es válida");
                entrada.nextLine(); // limpiar buffer del scanner+
            }
        }
    }
}