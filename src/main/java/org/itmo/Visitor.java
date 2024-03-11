package org.itmo;

public class Visitor {
    private final String order;
    private final int noiseLevel;

    public Visitor(String order, int noiseLevel) {
        this.order = order;
        this.noiseLevel = noiseLevel;
    }

    public String getOrder() {
        return order;
    }

}
