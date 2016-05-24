package main.java.vutichenko.checker.model;

import org.hibernate.annotations.Entity;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;

/**
 * Created by vutichenko on 24.05.2016.
 */
@Entity
@Table(name = "DATES")
public class DatePojo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int number;

    private BaseCalendar.Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BaseCalendar.Date getDate() {
        return date;
    }

    public void setDate(BaseCalendar.Date date) {
        this.date = date;
    }
}
