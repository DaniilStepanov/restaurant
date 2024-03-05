package org.itmo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Restaurant {

    AtomicInteger tablesFor2;
    AtomicInteger tablesFor4;
    AtomicInteger tablesFor8;

    Menu m = new Menu();
    Kitchen k = new Kitchen(4);

    AtomicLong income = new AtomicLong(0L);


    public Restaurant(int tablesFor2, int tablesFor4, int tablesFor8) {
        this.tablesFor2 = new AtomicInteger(tablesFor2);
        this.tablesFor4 = new AtomicInteger(tablesFor4);
        this.tablesFor8 = new AtomicInteger(tablesFor8);
    }

    public void serveVisitors(GroupOfVisitors visitors) {
        return;
        //TODO main cycle
    }

}
