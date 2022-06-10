package common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;

public class BenchmarkProxy implements java.lang.reflect.InvocationHandler {

    private Object obj;

    private final Consumer<Long> consumer;

    public static Object newInstance(Object obj, final Consumer<Long> consumer) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new BenchmarkProxy(obj, consumer));
    }

    private BenchmarkProxy(Object obj, final Consumer<Long> consumer) {
        this.consumer = consumer;
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable
    {
        Object result;
        try {
            Instant start = Instant.now();
            result = m.invoke(obj, args);
            Instant end = Instant.now();
            Duration duration = Duration.between(start,end);
            consumer.accept(duration.toMillis());
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
            //System.out.println("after method " + m.getName());
        }
        return result;
    }
}