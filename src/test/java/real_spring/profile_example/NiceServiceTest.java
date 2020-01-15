package real_spring.profile_example;

import com.google.errorprone.annotations.concurrent.LazyInit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.junit.Assert.*;
import static real_spring.profile_example.InfraConst.DEV;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Conf.class)
@ActiveProfiles(DEV)
@MockBean(NiceService.class)
public class NiceServiceTest {

    @MockBean
    private NiceService niceService;

    @PostConstruct
    public void configureMocks(){
        Mockito.when(niceService.doWork()).thenReturn("1");
    }

    @Autowired
    private NiceRepo niceRepo;

    @Test
    public void doWork() {

       niceRepo.crud();
    }
}