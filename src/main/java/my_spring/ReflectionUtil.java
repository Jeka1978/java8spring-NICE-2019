package my_spring;

/**
 * @author Evgeny Borisov
 */
public class ReflectionUtil {
    public static <T> T createObjectWithTryCatch(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("go to eat!");
        }

    }
}
