package org.itmo;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

public class Kitchen implements Closeable {

    private final BlockingQueue<CookTask> queue;
    final Thread[] cooks;

    public Kitchen(int numOfCooks) {
        this.queue = new PriorityBlockingQueue<>(1024, new CookComparator());
        this.cooks = new Thread[numOfCooks];
        for (int i = 0; i < numOfCooks; i++) {
            Thread cook = new Thread(this::cook);
            cook.setName("cook-" + i);
            cook.start();
            cooks[i] = cook;
        }
    }

    private void cook() {
        while (!Thread.interrupted()) {
            try {
                CookTask cookTask = queue.take();
                cookTask.doCook();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public Future<Integer> cook(final Dish dish) {
        CookTask cookTask = new CookTask(dish.getTime(), dish.getPrice());
        queue.add(cookTask);
        return cookTask;
    }

    @Override
    public void close() throws IOException {
        while (!queue.isEmpty()) {
            try {
                Thread.sleep(cooks.length * 100L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                for (Thread cook : cooks) {
                    cook.interrupt();
                }
                throw new RuntimeException(e);
            }
        }
        for (Thread cook : cooks) {
            cook.interrupt();
        }
    }
}
