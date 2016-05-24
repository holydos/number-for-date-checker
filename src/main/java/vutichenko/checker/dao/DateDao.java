package vutichenko.checker.dao;

import vutichenko.checker.model.Dates;

import java.util.List;

/**
 * Created by vutichenko on 24.05.2016.
 */
public interface DateDao {
    public void save(Dates p);

    public List<Dates> list();
}
