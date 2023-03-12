package pl.kurs.exchangerateapponspring.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.exchangerateapponspring.models.ExchangeEvent;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ExchangeEventDao implements IExchangeEventDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ExchangeEvent event) {
        entityManager.persist(event);
    }

    @Override
    public ExchangeEvent getById(long id) {
        return entityManager.find(ExchangeEvent.class, id);
    }
}
