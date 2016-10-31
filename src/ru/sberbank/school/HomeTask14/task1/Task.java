package ru.sberbank.school.HomeTask14.task1;

import java.util.concurrent.Callable;

public class Task<T> {
    private Callable<? extends T> callable;
    private TaskException exception;
    private T result;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws TaskException {
        if (exception != null) {
            throw exception;
        }
        if (result == null)  {
            synchronized (this) {
                try {
                    result = callable.call();
                } catch (Exception e) {
                    if (exception != null)
                        exception = new TaskException(e);
                    throw exception;
                }

            }
        }
        return result;
    }

}
