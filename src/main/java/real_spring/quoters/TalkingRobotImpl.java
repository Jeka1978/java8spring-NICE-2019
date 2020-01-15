package real_spring.quoters;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Component
@RequiredArgsConstructor
public class TalkingRobotImpl implements TalkingRobot {



    @Autowired
    private List<Quoter> quoters;



    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuoter);
    }
}
