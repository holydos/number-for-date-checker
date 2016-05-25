package vutichenko.checker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vutichenko.checker.api.DatabaseDummyFiller;
import vutichenko.checker.api.NumbCalculator;
import vutichenko.checker.dao.DateDao;

/**
 * Created by vutichenko on 24.05.2016.
 */
public class Checker {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DateDao dao = context.getBean(DateDao.class);
        DatabaseDummyFiller.fillDatabaseWithRandomDummies(15, dao);
        final NumbCalculator calculator = context.getBean(NumbCalculator.class);
        System.out.println(calculator.getToday().toString());
        System.out.println(calculator.calculateNumbersBeforeToday());


    }
}
