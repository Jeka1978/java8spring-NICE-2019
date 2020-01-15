package real_spring.qulifiers_example;

import org.springframework.stereotype.Repository;

import static real_spring.qulifiers_example.DBMode.PROD;

/**
 * @author Evgeny Borisov
 */
@DBType(PROD)
public class OracleDao implements Dao {
    @Override
    public void saveAll() {
        System.out.println("Saved to oracle");
    }
}
