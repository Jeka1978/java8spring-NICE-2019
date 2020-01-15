package real_spring.profile_example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static real_spring.profile_example.InfraConst.DEV;

/**
 * @author Evgeny Borisov
 */
@Repository
@Profile(DEV)
public class DevNiceRepo implements NiceRepo {
    @Override
    public void crud() {
        System.out.println("saving to local db");
    }
}
