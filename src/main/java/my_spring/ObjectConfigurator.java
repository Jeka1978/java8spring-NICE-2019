package my_spring;

/**
 * @author Evgeny Borisov
 */
public interface ObjectConfigurator {
    <T> T configure(T t);
}
