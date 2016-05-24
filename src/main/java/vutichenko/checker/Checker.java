package vutichenko.checker;

import vutichenko.checker.api.DatabaseDummyFiller;
import vutichenko.checker.dao.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vutichenko.checker.model.Dates;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by vutichenko on 24.05.2016.
 */
public class Checker {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DateDao dateDao = context.getBean(DateDao.class);
        DatabaseDummyFiller filler = context.getBean(DatabaseDummyFiller.class);
        filler.fillDatabaseWithRandomDummies(50);
        final List<Dates> list = dateDao.list();
        List<Date>datesFromMeasurements = list.stream().map(Dates::getDate).collect(Collectors.toList());

        datesFromMeasurements.forEach(d->
                System.out.println(d.getTime()));

    }
}
