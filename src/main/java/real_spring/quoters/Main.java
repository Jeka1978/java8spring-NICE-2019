package real_spring.quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
//        String[] names = context.getBeanDefinitionNames();
//        Arrays.stream(names).forEach(System.out::println);
//        context.close();
    }
}
