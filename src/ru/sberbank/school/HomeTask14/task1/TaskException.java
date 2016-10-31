package ru.sberbank.school.HomeTask14.task1;

public class TaskException extends RuntimeException {
    public TaskException(Exception e) {
        super(e);
    }
}
