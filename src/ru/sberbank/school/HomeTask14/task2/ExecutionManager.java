package ru.sberbank.school.HomeTask14.task2;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
