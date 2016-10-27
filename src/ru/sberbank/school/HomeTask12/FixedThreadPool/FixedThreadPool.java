package ru.sberbank.school.HomeTask12.FixedThreadPool;

import ru.sberbank.school.HomeTask12.ThreadPool;

import java.util.ArrayDeque;
import java.util.Deque;

public class FixedThreadPool implements ThreadPool {
    private final int count;
    private final Worker[] threads;
    private final Deque<Runnable> deque;

    public FixedThreadPool(int count) {
        this.count = count;
        threads = new Worker[count];
        deque = new ArrayDeque<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < count; i++) {
            threads[i] = new Worker();
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        deque.add(runnable);
    }

    private class Worker extends Thread {
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
                r.run();
            }
        }
    }
}
