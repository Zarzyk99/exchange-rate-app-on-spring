package pl.kurs.exchangerateapponspring.services;



import pl.kurs.exchangerateapponspring.exceptions.InvalidInputDataException;

import java.math.BigDecimal;

public interface IRateService {
    BigDecimal getRate(String fromCurrencyMark, String toCurrencyMark) throws InvalidInputDataException;
}
