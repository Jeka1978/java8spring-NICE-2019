package real_spring.quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
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

    @PreDestroy
    public void killAll(){
        new Thread(() -> System.out.println("You are terminated...")).start();

    }

    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = asList(messages);
    }

    @Override
    public void sayQuoter() {
        messages.forEach(System.out::println);
    }
}
