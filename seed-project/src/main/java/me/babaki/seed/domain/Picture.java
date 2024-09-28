package me.babaki.seed.domain;

import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Picture {
    @PlanningEntityCollectionProperty
    private List<Person> people;

    @ProblemFactCollectionProperty
    @ValueRangeProvider
    private List<Shoe> shoes;

    @ProblemFactCollectionProperty
    @ValueRangeProvider
    private List<Hat> hats;


    @PlanningScore
    private HardSoftScore score;


    public Picture() {
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }

    public List<Hat> getHats() {
        return hats;
    }

    public void setHats(List<Hat> hats) {
        this.hats = hats;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }


}
