package ru.sberbank.school.HomeTask12.FixedThreadPool;

public class MainFixedThreadPool {
    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            fixedThreadPool.execute(new Task());
        }
        fixedThreadPool.start();

        for (int i = 0; i < 20; i++) {
            fixedThreadPool.execute(new Task());
        }
    }
}
