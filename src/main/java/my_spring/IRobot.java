package my_spring;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.rmi.dgc.DGC;

/**
 * @author Evgeny Borisov
 */
@Benchmark
public class IRobot {
    @InjectByType
    private ConsoleSpeaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init(){
        System.out.println(speaker.getClass());
        System.out.println(cleaner.getClass());
    }


    public void cleanRoom() {
        speaker.say("I started");
        cleaner.clean();
        speaker.say("I finished");
    }
}
