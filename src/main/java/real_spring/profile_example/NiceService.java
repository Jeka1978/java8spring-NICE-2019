package real_spring.profile_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class NiceService {

    @Autowired
    private NiceRepo niceRepo;




    @EventListener(ContextRefreshedEvent.class)
    public String doWork(){
        niceRepo.crud();
        return "ok";
    }




}





