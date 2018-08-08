package edu.omsu.jesper;

import edu.omsu.jesper.enums.SalaryCurrency;

public class Converter {

    static SalaryCurrency currencyFromString(String salary) {
        switch (salary) {
            case "RUB":
                return SalaryCurrency.RUB;
            case "EUR":
                return SalaryCurrency.EUR;
            case "USD":
                return SalaryCurrency.USD;
            default:
                throw new IllegalArgumentException("Can't parse String to known currency");
        }

    }

    static String currencyToString(SalaryCurrency salaryCurrency) {
        return salaryCurrency.toString();
    }
}
