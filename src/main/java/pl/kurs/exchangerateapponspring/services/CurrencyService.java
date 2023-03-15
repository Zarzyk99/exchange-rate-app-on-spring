package pl.kurs.exchangerateapponspring.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspring.exceptions.InvalidInputDataException;
import pl.kurs.exchangerateapponspring.models.ExchangeEvent;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CurrencyService implements ICurrencyService {

    private IRateService rateService;
    private IExchangeEventService exchangeEventService;

    public CurrencyService(IRateService rateService, IExchangeEventService exchangeEventService) {
        this.rateService = rateService;
        this.exchangeEventService = exchangeEventService;
    }

    @Override
    public BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException {
        if (currencyFrom.isBlank() || currencyTo.isBlank())
            throw new InvalidInputDataException("Przekazano błędne dane!");
        if (amount.doubleValue() <= 0)
            throw new InvalidInputDataException("Wartość musi być większa od 0!");
        BigDecimal rate = rateService.getRate(currencyFrom, currencyTo);


        BigDecimal exchangeResult = rate.multiply(amount);

        exchangeEventService.saveEvent(
                new ExchangeEvent(
                        Timestamp.from(Instant.now()),
                        currencyFrom,
                        amount,
                        currencyTo,
                        exchangeResult,
                        rate
                )
        );

        return exchangeResult;
    }
}
