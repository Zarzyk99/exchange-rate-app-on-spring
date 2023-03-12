package pl.kurs.exchangerateapponspring.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspring.dao.IExchangeEventDao;
import pl.kurs.exchangerateapponspring.models.ExchangeEvent;


import java.util.Optional;

@Service
public class ExchangeEventService implements IExchangeEventService {

    private IExchangeEventDao exchangeEventDao;

    public ExchangeEventService(IExchangeEventDao exchangeEventDao) {
        this.exchangeEventDao = exchangeEventDao;
    }

    @Override
    public void saveEvent(ExchangeEvent exchangeEvent) {
        exchangeEventDao.save(Optional.ofNullable(exchangeEvent).orElseThrow());
    }
}
