package edu.omsu.jesper;

import edu.omsu.jesper.enums.SalaryCurrency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void currencyFromString() {
        assertEquals(SalaryCurrency.RUB, Converter.currencyFromString("RUB"));
        assertEquals(SalaryCurrency.USD, Converter.currencyFromString("USD"));
        assertEquals(SalaryCurrency.EUR, Converter.currencyFromString("EUR"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void currencyFromStringException() {
        Converter.currencyFromString("HAH");
    }

    @Test
    public void currencyToString() {
        assertEquals("RUB", Converter.currencyToString(SalaryCurrency.RUB));
        assertEquals("EUR", Converter.currencyToString(SalaryCurrency.EUR));
        assertEquals("USD", Converter.currencyToString(SalaryCurrency.USD));
    }
}