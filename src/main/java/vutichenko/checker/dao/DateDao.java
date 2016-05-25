package vutichenko.checker.dao;

import vutichenko.checker.model.Dates;

import java.util.List;

/**
 * Created by vutichenko on 24.05.2016.
 */
public interface DateDao {
    void save(Dates d);

    List<Dates> list();

    List<Dates> getValuesBeforeDate(java.util.Date date);
}
