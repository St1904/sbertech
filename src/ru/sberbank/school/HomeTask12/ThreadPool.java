package ru.sberbank.school.HomeTask12;

public interface ThreadPool {
    void start();
    void execute(Runnable runnable);
}
