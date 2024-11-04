package org.example.model;

import java.time.Month;

public class Utils {
    public final String traduzirNomeDoMes(Month mes) {
        return switch (mes) {
            case JANUARY -> "Janeiro";
            case FEBRUARY -> "Fevereiro";
            case MARCH -> "Março";
            case APRIL -> "April";
            case MAY -> "Maio";
            case JUNE -> "Junho";
            case JULY -> "Julho";
            case AUGUST -> "Agosto";
            case SEPTEMBER -> "Setembro";
            case OCTOBER -> "Outubro";
            case NOVEMBER -> "Novembro";
            case DECEMBER -> "Dezembro";
        };
    }
}