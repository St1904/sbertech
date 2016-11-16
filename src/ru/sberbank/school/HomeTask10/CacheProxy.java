package ru.sberbank.school.HomeTask10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy {
    public static Calculator makeCached(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Calculator.class}, new CacheHandler(calculator));
    }

    private static class CacheHandler implements InvocationHandler {
        private final Object delegate;
        private Map<Method, Map<Integer, Integer>> cache;

        CacheHandler (Object delegate) {
            this.delegate = delegate;
            cache = new HashMap<>();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Invoking method " + method.getName() + "...");

            Object result;

            if (method.isAnnotationPresent(Cache.class)) {
                if (cache.get(method) == null) {
                    cache.put(method, new HashMap<>());
                }
                if (cache.get(method).containsKey(args[0])) {
                    System.out.println("Результат из кэша");
                    result = cache.get(method).get(args[0]);
                } else {
                    result = method.invoke(delegate, args[0]);
                    Map<Integer, Integer> innerMap = cache.get(method);
                    innerMap.put((Integer) args[0], (Integer) result);
                }
            } else {
                System.out.println("no annotation");
                result = method.invoke(delegate, args[0]);
            }

            return result;
        }
    }
}
