package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public Object configure(Object t) {

        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.set(t,object);
            }
        }
        return t;
    }
}
