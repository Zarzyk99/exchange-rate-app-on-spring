package pl.kurs.exchangerateapponspring.services;



import pl.kurs.exchangerateapponspring.exceptions.InvalidInputDataException;

import java.math.BigDecimal;

public interface ICurrencyService {
    BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException;
}
