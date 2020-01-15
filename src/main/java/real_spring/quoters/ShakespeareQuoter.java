package real_spring.quoters;

import lombok.Setter;
import my_spring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Book
public class ShakespeareQuoter implements Quoter {

    @Value("${shake}")
    @Setter
    private String message;

    @InjectRandomInt(min = 3, max = 7)
    private int repeat;

    @Override
    public void sayQuoter() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }


    public String getMessage() {
        return message;
    }
}




