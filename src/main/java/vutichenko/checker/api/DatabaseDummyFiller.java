package vutichenko.checker.api;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import vutichenko.checker.dao.DateDao;
import vutichenko.checker.model.Dates;

/**
 * Created by vutichenko on 24.05.2016.
 */
@Component
public class DatabaseDummyFiller {

    public static void fillDatabaseWithRandomDummies(int dummiesCount, DateDao dao) {
        for (int i = 0; i < dummiesCount; i++) {
            Dates date = new Dates();
            date.setNumber((int) (Math.random() * 100));
            DateTime now = DateTime.now();
            DateTime afterMinus = now.minusYears((int) (Math.random() * 100));
            DateTime result = afterMinus.plusYears((int) (Math.random() * 100));
            date.setDate(result.toDate());
            dao.save(date);
        }
    }
}
