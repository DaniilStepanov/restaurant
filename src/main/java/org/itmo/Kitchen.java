package org.itmo;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {

    List<Cook> cooks;

    public Kitchen(int numOfCooks) {
        cooks = new ArrayList<>(numOfCooks);
        for (int i = 0; i < numOfCooks; i++) {
            cooks.add(new Cook());
        }
    }

}
