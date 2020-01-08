package my_spring;

/**
 * @author Evgeny Borisov
 */
public interface ProxyConfigurator {
    <T> T replaceByProxyIfNeeded(T t, Class<T> type);
}
