package pl.kurs.exchangerateapponspring.services;


import pl.kurs.exchangerateapponspring.models.ExchangeEvent;

public interface IExchangeEventService {
    void saveEvent(ExchangeEvent exchangeEvent);
}
