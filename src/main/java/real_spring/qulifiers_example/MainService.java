package real_spring.qulifiers_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class MainService {

    @DBType(DBMode.PROD)
    private Dao mainDao;

    @DBType(DBMode.BACKUP)
    private Dao backupDao;



    @Scheduled(fixedDelay = 1500)
    public void backup(){
        backupDao.saveAll();
    }


    @Scheduled(fixedDelay = 500)
    public void save(){
        mainDao.saveAll();
    }
}





