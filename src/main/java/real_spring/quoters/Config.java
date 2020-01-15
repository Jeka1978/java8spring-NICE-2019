package real_spring.quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@PropertySource("classpath:quotes.properties")
@Configuration
@ComponentScan
public class Config {


}
