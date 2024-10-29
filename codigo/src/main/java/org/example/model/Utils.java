package org.example.model;

import java.time.Month;

public class Utils {
    public final String traduzirNomeDoMes(Month mes) {
        switch (mes) {
            case JANUARY:
                return "Janeiro";
            case FEBRUARY:
                return "Fevereiro";
            case MARCH:
                return "Março";
            case APRIL:
                return "April";
            case MAY:
                return "Maio";
            case JUNE:
                return "Junho";
            case JULY:
                return "Julho";
            case AUGUST:
                return "Agosto";
            case SEPTEMBER:
                return "Setembro";
            case OCTOBER:
                return "Outubro";
            case NOVEMBER:
                return "Novembro";
            case DECEMBER:
                return "Dezembro";
        }
        return "";
    }
}