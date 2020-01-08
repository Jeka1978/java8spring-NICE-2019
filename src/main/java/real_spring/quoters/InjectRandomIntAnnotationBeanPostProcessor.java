package real_spring.quoters;

import my_spring.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private InjectRandomIntAnnotationObjectConfigurator configurator = new InjectRandomIntAnnotationObjectConfigurator();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return configurator.configure(bean);
    }
}
