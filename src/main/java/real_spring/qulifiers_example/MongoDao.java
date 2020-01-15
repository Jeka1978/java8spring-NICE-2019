package real_spring.qulifiers_example;

import org.springframework.stereotype.Repository;

import static real_spring.qulifiers_example.DBMode.BACKUP;
import static real_spring.qulifiers_example.DBMode.PROD;

/**
 * @author Evgeny Borisov
 */
@DBType(BACKUP)
public class MongoDao implements Dao {
    @Override
    public void saveAll() {
        System.out.println("Saved to mongo");
    }
}
