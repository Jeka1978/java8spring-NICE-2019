package real_spring.quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */

@Film
@Book
public class TerminatorQuoter implements Quoter {


    private List<String> messages;











    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = asList(messages);
    }

    @Override
    public void sayQuoter() {
        messages.forEach(System.out::println);
    }
}
