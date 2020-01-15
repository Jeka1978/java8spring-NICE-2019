package real_spring.profile_example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static real_spring.profile_example.InfraConst.PROD;

/**
 * @author Evgeny Borisov
 */
@Repository
@Profile(PROD)
public class ProdNiceRepo implements NiceRepo {


    @Override
    public void crud() {
        System.out.println("saving to prod db");
    }
}
