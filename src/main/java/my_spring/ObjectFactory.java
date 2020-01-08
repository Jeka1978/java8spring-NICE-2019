package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators;
    private List<ProxyConfigurator> proxyConfigurators;
    private Reflections scanner = new Reflections("my_spring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        configurators = scanner.getSubTypesOf(ObjectConfigurator.class)
                .stream()
                .filter(aClass -> !Modifier.isAbstract(aClass.getModifiers()))
                .map(ReflectionUtil::createObjectWithTryCatch)
                .collect(toList());
        proxyConfigurators = scanner.getSubTypesOf(ProxyConfigurator.class)
                .stream()
                .filter(aClass -> !Modifier.isAbstract(aClass.getModifiers()))
                .map(ReflectionUtil::createObjectWithTryCatch)
                .collect(toList());

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);

        T t = type.newInstance();

        t = configure(t);

        secondPhaseConstructor(type, t);

        t = replaceWithProxyIfNeeded(type, t);


        return t;

    }

    private <T> T replaceWithProxyIfNeeded(Class<T> type, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = proxyConfigurator.replaceByProxyIfNeeded(t, type);
        }
        return t;
    }


    private <T> void secondPhaseConstructor(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> T configure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            t = configurator.configure(t);
        }
        return t;
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }
        return type;
    }


}
