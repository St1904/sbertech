package ru.sberbank.school.HomeTask7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy {
    public static Calculator makeCached(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Calculator.class}, new CacheHandler(new CacheCalc()));
    }

    private static class CacheHandler implements InvocationHandler {
        private final Object delegate;
        private Map<Integer, Integer> cache;

        CacheHandler (Object delegate) {
            this.delegate = delegate;
            cache = new HashMap<>();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("Invoking method " + method.getName() + "...");

            Object result;

            if (method.isAnnotationPresent(Cache.class)) {
                if (cache.containsKey(args[0])) {
                    System.out.println("Результат из кэша");
                    result = cache.get(args[0]);
                } else {
                    System.out.println("Вычисление делегировано кэширующему калькулятору");
                    result = method.invoke(delegate, args[0]);
                    cache.put((Integer) args[0], (Integer) result);
                }
            } else {
                System.out.println("Вычисление делегировано кэширующему калькулятору");
                result = method.invoke(delegate, args[0]);
                cache.put((Integer) args[0], (Integer) result);
            }

//            Object result = method.invoke(delegate, args);

//            System.out.println("Method " + method.getName() + "invoked, returned value = " + result);

            return result;
        }
    }
}
