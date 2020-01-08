package real_spring.quoters;

import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class TerminatorQuoter implements Quoter {

    @Setter
    private List<String> messages;

    @Override
    public void sayQuoter() {
        messages.forEach(System.out::println);
    }
}
