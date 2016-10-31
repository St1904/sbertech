package ru.sberbank.school.HomeTask14.task2;

public interface Context {

    int getCompletedTaskCount();


    int getFailedTaskCount();


    int getInterruptedTaskCount();


    void interrupt();


    boolean isFinished();
}
