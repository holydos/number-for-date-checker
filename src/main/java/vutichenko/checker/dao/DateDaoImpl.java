package vutichenko.checker.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vutichenko.checker.model.Dates;

import java.util.Date;
import java.util.List;

/**
 * Created by vutichenko on 24.05.2016.
 */
public class DateDaoImpl implements DateDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Dates d) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(d);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dates> list() {
        Session session = this.sessionFactory.openSession();
        List<Dates> result = (List<Dates>) session.createQuery("from Dates").list();
        session.close();
        return result;
    }

    @Override
    public List<Dates> getValuesBeforeDate(Date date) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Dates where date <=:before_date");
        query.setDate("before_date",date);
        List<Dates> result = (List<Dates>) query.list();
        session.close();
        return result;
    }
}
