package my_spring;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> T replaceByProxyIfNeeded(T t, Class<T> type) {
        if (type.isAnnotationPresent(Benchmark.class)) {
            if (type.getInterfaces().length == 0) {
                return (T) Enhancer.create(type, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> invoke(t, method, args));
            }
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> invoke(t, method, args));
        }
        return t;
    }

    private <T> Object invoke(T t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("****** BENCHMARK started for method " + method.getName() + " ********");
        long start = System.nanoTime();
        Object retVal = method.invoke(t, args);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("****** BENCHMARK ended for method " + method.getName() + " ********");

        return retVal;
    }
}
