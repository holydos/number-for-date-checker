package vutichenko.checker;

import vutichenko.checker.dao.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vutichenko.checker.model.Dates;

import java.util.Date;
import java.util.List;


/**
 * Created by vutichenko on 24.05.2016.
 */
public class Checker {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DateDao dateDao = context.getBean(DateDao.class);
        Dates dateAndNumber = new Dates();
        dateAndNumber.setDate(new Date());
        dateAndNumber.setNumber(10);
        dateDao.save(dateAndNumber);
        final List<Dates> list = dateDao.list();
        if(list.isEmpty()) System.out.println("bad");
        else System.out.println( list.iterator().next().getDate());
    }
}
