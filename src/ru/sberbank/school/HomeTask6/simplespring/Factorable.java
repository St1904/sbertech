package ru.sberbank.school.HomeTask6.simplespring;

public interface Factorable {

    <T> T getBean(Class<T> cls);

    void close();

    void registryShutdownHook();
}
