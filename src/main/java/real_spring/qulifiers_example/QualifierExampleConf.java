package real_spring.qulifiers_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */

@Configuration
@ComponentScan
@EnableScheduling
public class QualifierExampleConf {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(QualifierExampleConf.class);
    }
}
