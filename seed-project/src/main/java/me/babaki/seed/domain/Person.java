package me.babaki.seed.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;

import java.util.Objects;

/**
 * A planning entity is a JavaBean (POJO) that changes during solving.
 * A planning problem has multiple planning entities, but there is usually only one planning entity class.
 * Each planning entity class has one or more planning variables
 */

@PlanningEntity
public class Person {

    /**
     * For some functionality (such as multi-threaded solving and real-time planning),
     * Timefold Solver needs to map problem facts and planning entities to an ID.
     * <p>
     * A PlanningEntity property must be:
     * - Unique for that specific class
     * - An instance of a type that implements Object.hashCode() and Object.equals().
     * (It’s recommended to use the type Integer, int, Long, long, String or UUID.)
     * - Never null by the time Solver.solve() is called.
     */
    @PlanningId
    private String id;

    /**
     * A planning variable is a JavaBean property (so a getter and setter) on a planning entity.
     * It points to a planning value, which changes during planning.
     */
    @PlanningVariable
    private Shoe shoe;

    @PlanningVariable
    private Hat hat;

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public Hat getHat() {
        return hat;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getShoeColor() {
        return getShoe().getColor();
    }

    public Color getHatColor() {
        return getHat().getColor();
    }

    /**
     * Planning entity hashCode() implementations must remain constant,
     * therefore entity hashCode() must not depend on any planning variables.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
