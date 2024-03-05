package org.itmo;

import java.util.List;

public class GroupOfVisitors {

    private List<Visitor> visitors;
    int maxNoiseLevel;
    int presenceTime;

    public GroupOfVisitors(List<Visitor> visitors, int maxNoiseLevel, int presenceTime) {
        this.visitors = visitors;
        this.maxNoiseLevel = maxNoiseLevel;
        this.presenceTime = presenceTime;
    }

}
