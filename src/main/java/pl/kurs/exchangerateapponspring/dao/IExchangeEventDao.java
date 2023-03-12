package pl.kurs.exchangerateapponspring.dao;


import pl.kurs.exchangerateapponspring.models.ExchangeEvent;

public interface IExchangeEventDao {
    void save(ExchangeEvent event);

    ExchangeEvent getById(long id);
}
