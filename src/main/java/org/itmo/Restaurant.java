package org.itmo;

import kotlin.Pair;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Restaurant implements Closeable {

    private final Queue<Pair<AtomicInteger, List<Future<Integer>>>> waiterQueue;
    private final Thread waiter;

    final AtomicInteger tablesFor2;
    final AtomicInteger tablesFor4;
    final AtomicInteger tablesFor8;

    final Menu m = new Menu();
    final Kitchen k = new Kitchen(4);

    public final AtomicLong income = new AtomicLong(0L);


    public Restaurant(int tablesFor2, int tablesFor4, int tablesFor8) {
        this.tablesFor2 = new AtomicInteger(tablesFor2);
        this.tablesFor4 = new AtomicInteger(tablesFor4);
        this.tablesFor8 = new AtomicInteger(tablesFor8);
        this.waiterQueue = new ConcurrentLinkedQueue<>();
        this.waiter = new Thread(() -> {
            while (!Thread.interrupted()) {
                Pair<AtomicInteger, List<Future<Integer>>> pair = waiterQueue.poll();
                if (pair != null) {
                    pair.getSecond().forEach(future -> {
                        try {
                            income.addAndGet(future.get());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    pair.getFirst().addAndGet(-1);
                }
            }
        });
        waiter.setName("waiter");
        waiter.start();
    }

    public void serveVisitors(final GroupOfVisitors visitors) {
        int visitorsSize = visitors.visitors.size();
        if (visitorsSize == 0 || visitorsSize > 8) return;
        if (visitorsSize <= 2) {
            // tablesFor2
            if (tablesFor2.addAndGet(-1) + 1 <= 0) {
                tablesFor2.addAndGet(1);
                return;
            }
            List<Future<Integer>> futureStream = visitors.visitors.stream().map(visitor -> {
                        Dish dish = m.dishes.get(visitor.getOrder());
                        return k.cook(dish);
                    }
            ).collect(Collectors.toList());
            waiterQueue.add(new Pair<>(tablesFor2, futureStream));
        } else if (visitorsSize <= 4) {
            // tablesFor4
            if (tablesFor4.addAndGet(-1) + 1 <= 0) {
                tablesFor4.addAndGet(1);
                return;
            }
            List<Future<Integer>> futureStream = visitors.visitors.stream().map(visitor -> {
                        Dish dish = m.dishes.get(visitor.getOrder());
                        return k.cook(dish);
                    }
            ).collect(Collectors.toList());
            waiterQueue.add(new Pair<>(tablesFor4, futureStream));
        } else {
            // tablesFor8
            if (tablesFor8.addAndGet(-1) + 1 <= 0) {
                tablesFor8.addAndGet(1);
                return;
            }
            List<Future<Integer>> futureStream = visitors.visitors.stream().map(visitor -> {
                        Dish dish = m.dishes.get(visitor.getOrder());
                        return k.cook(dish);
                    }
            ).collect(Collectors.toList());
            waiterQueue.add(new Pair<>(tablesFor8, futureStream));
        }
    }

    @Override
    public void close() throws IOException {
        k.close();
        while (!waiterQueue.isEmpty()) {
            Pair<AtomicInteger, List<Future<Integer>>> pair = waiterQueue.poll();
            if (pair != null) {
                pair.getSecond().forEach(future -> {
                    try {
                        income.addAndGet(future.get());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
                pair.getFirst().addAndGet(-1);
            }
        }
        waiter.interrupt();
    }
}
