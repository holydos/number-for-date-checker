package vutichenko.checker;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import vutichenko.checker.api.NumbCalculator;
import vutichenko.checker.dao.DateDao;
import vutichenko.checker.dao.DateDaoImpl;
import vutichenko.checker.model.Dates;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by vutichenko on 25.05.2016.
 */

@Configuration
public class AppConfig {


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS ccmc");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setAnnotatedClasses(Dates.class);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        hibernateProperties.put("hibernate.show_sql","true");
        hibernateProperties.put("hibernate.hbm2ddl.auto","create");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean;
    }

    @Bean
    NumbCalculator calculator(){
        NumbCalculator numbCalculator = new NumbCalculator();
        numbCalculator.setToday(new java.util.Date());
        return numbCalculator;
    }

    @Bean
    public DateDao dateDto(SessionFactory s) {
        DateDaoImpl dateDao = new DateDaoImpl();
        dateDao.setSessionFactory(s);
        return dateDao;
    }

}
