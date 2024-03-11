package org.itmo;

import java.util.Comparator;

public class CookComparator implements Comparator<CookTask> {
    @Override
    public int compare(CookTask o1, CookTask o2) {
        int o11d = o1.getTime();
        int o21d = o2.getTime();
        return Integer.compare(o11d, o21d);
    }
}
