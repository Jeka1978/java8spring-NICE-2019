package real_spring.screen_saver;

import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class ScreenSaverConf {
    private Random random = new Random();


    @Bean
    @Scope(value = "twoSeconds",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {

        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }


    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConf.class);

        ColorFrame bean = context.getBean(ColorFrame.class);
        System.out.println(bean.getClass());
        while (true) {
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(50);
        }
    }
}
