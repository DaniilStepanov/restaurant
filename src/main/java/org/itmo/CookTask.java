package org.itmo;

import java.util.concurrent.CompletableFuture;

public class CookTask extends CompletableFuture<Integer> {

    private final int time;

    private final int cost;

    public CookTask(int time, int cost) {
        this.time = time;
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public int getCost() {
        return cost;
    }

    public void doCook() {
        System.out.println("[" + Thread.currentThread().getName() + "] Start cooking for " + time + "ms. Cost: " + cost);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Finished cooking for " + time + "ms. Cost: " + cost);
        this.complete(cost);
    }
}
