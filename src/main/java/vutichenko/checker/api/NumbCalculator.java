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
    private Date today;

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Integer calculateNumbersBeforeToday(){
        final List<Dates> valuesBeforeDate = dao.getValuesBeforeDate(today);
        int result = 0;
        for (Dates dates : valuesBeforeDate) {
          result = result + dates.getNumber();
        }
        return result;
    }
}
