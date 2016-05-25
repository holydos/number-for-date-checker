package vutichenko.checker.api;
import org.springframework.beans.factory.annotation.Autowired;
import vutichenko.checker.dao.DateDao;
import vutichenko.checker.model.Dates;

import java.util.Date;
import java.util.List;

/**
 * Created by vutichenko on 24.05.2016.
 */
public class NumbCalculator {
    @Autowired
    private DateDao dao;
    @Autowired
    private CurrentDateUtil dateUtil;

    public Integer calculateNumbersBeforeToday(){
        final List<Dates> valuesBeforeDate = dao.getValuesBeforeDate(dateUtil.getToday());
        int result = 0;
        for (Dates dates : valuesBeforeDate) {
          result = result + dates.getNumber();
        }
        return result;
    }
}
