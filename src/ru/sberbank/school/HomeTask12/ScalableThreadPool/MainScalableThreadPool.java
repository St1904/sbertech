package ru.sberbank.school.HomeTask12.ScalableThreadPool;

public class MainScalableThreadPool {
    public static void main(String[] args) {
        ScalableThreadPool scalableThreadPool = new ScalableThreadPool(5, 10);

        scalableThreadPool.start();

        for (int i = 0; i < 30; i++) {
            scalableThreadPool.execute(new Task());
        }


    }
}
