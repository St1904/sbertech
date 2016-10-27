package ru.sberbank.school.HomeTask12.ScalableThreadPool;

public class Task implements Runnable {
    @Override
    public void run() {
        int k = 0;
        for (int i = 0; i < 1_000_000; i++) {
            k += 2;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": task done!");
    }
}
