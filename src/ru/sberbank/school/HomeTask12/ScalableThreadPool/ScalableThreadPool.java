package ru.sberbank.school.HomeTask12.ScalableThreadPool;

import ru.sberbank.school.HomeTask12.ThreadPool;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScalableThreadPool implements ThreadPool {
    private final int min;
    private final int max;
    private final Worker[] threads;
    private static boolean[] isWorking;
    private final Deque<Runnable> deque;
    private int lastAdded;

    public ScalableThreadPool(int min, int max) {
        this.min = min;
        this.max = max;
        lastAdded = min - 1;
        threads = new Worker[max];
        isWorking = new boolean[max];
        deque = new ArrayDeque<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < min; i++) {
            Worker worker = new Worker(i);
            threads[i] = worker;
            isWorking[i] = false;
            worker.start();
        }
        addNewWorkers();
    }

    @Override
    public void execute(Runnable runnable) {
        addNewWorkers();
        deque.add(runnable);
    }

    private void addNewWorkers() {
        boolean allBusy = true;
        while (allBusy && lastAdded < max) {
            for (int i = 0; i < isWorking.length; i++) {
                allBusy &= isWorking[i];
            }
            if (!allBusy && lastAdded < max - 1) {
                lastAdded++;
                threads[lastAdded] = new Worker(lastAdded);
                threads[lastAdded].start();
            }
//            System.out.println(allBusy);
//            System.out.println(lastAdded);
        }
    }

    private class Worker extends Thread {
        int number;

        Worker(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            Runnable r;

            while (true) {
                synchronized (deque) {
                    while (deque.isEmpty()) {
                        try {
                            deque.wait();
                        } catch (InterruptedException e) {
                        }
                    }

                    r = deque.poll();

                }
                isWorking[number] = true;
                r.run();
                isWorking[number] = false;
            }
        }
    }
}