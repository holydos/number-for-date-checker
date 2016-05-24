package vutichenko.checker.dao;

import vutichenko.checker.model.Dates;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
    public void save(Dates p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dates> list() {
        Session session = this.sessionFactory.openSession();
     //   List<DatePojo> personList = session.createQuery("from Dates").list();
        List<Dates> result = (List<Dates>) session.createQuery("from Dates").list();
        session.close();
        return result;
    }
}
