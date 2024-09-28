package me.babaki.seed.domain;

import ai.timefold.solver.core.api.domain.lookup.PlanningId;

/**
 * A planning variable is a JavaBean property (so a getter and setter) on a planning entity.
 * It points to a planning value, which changes during planning.
 */
public class Hat {
    @PlanningId
    private String id;
    private Color color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
