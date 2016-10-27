package ru.sberbank.school.HomeTask12.FixedThreadPool;

public class Task implements Runnable {
    volatile static int i = 0;

    @Override
    public void run() {
        synchronized (Task.class) {
            i++;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
