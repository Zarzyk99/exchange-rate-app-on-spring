package pl.kurs.exchangerateapponspring.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspring.exceptions.InvalidInputDataException;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CurrencyService implements ICurrencyService {

    private IRateService rateService;


    public CurrencyService(IRateService rateService) {
        this.rateService = rateService;
    }

    @Override
    public BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException {
        if (currencyFrom.isBlank() || currencyTo.isBlank())
            throw new InvalidInputDataException("Przekazano błędne dane!");
        if (amount.doubleValue() <= 0)
            throw new InvalidInputDataException("Wartość musi być większa od 0!");
        BigDecimal rate = rateService.getRate(currencyFrom, currencyTo);


        BigDecimal exchangeResult = rate.multiply(amount);


        return exchangeResult;
    }
}
