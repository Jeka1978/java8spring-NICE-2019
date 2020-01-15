package real_spring.profile_example;

import org.springframework.context.annotation.*;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class Conf {
    public static void main(String[] args) {
        //spring.profiles.active=PROD
        System.setProperty("spring.profiles.active", "dev");
        new AnnotationConfigApplicationContext(Conf.class);
    }
}
