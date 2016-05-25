package vutichenko.checker;

import org.joda.time.LocalDate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vutichenko.checker.api.DatabaseDummyFiller;
import vutichenko.checker.api.NumbCalculator;
import vutichenko.checker.dao.DateDao;
import vutichenko.checker.model.Dates;

import static org.junit.Assert.assertEquals;

/**
 * Created by vutichenko on 25.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public class CheckerTest{
    @Autowired
    DateDao dateDao;
    @Autowired
    DatabaseDummyFiller filler;
    @Autowired
    NumbCalculator calculator;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void testMain() throws Exception {
        LocalDate dateBefore = new LocalDate("1665-10-10");
        for(int i=0;i<5;i++){
            Dates date = new Dates();
            date.setDate(dateBefore.toDate());
            date.setNumber(10);
            dateDao.save(date);
        }
        LocalDate dateAfter = new LocalDate("1995-10-10");
        for(int i=0;i<5;i++){
            Dates date = new Dates();
            date.setDate(dateAfter.toDate());
            date.setNumber(20);
            dateDao.save(date);
        }
        int calculatedValue = calculator.calculateNumbersBeforeToday();
        assertEquals(50, calculatedValue);
    }
}