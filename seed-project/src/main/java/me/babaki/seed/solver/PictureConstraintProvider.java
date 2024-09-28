package me.babaki.seed.solver;

import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;
import me.babaki.seed.domain.Person;

import static ai.timefold.solver.core.api.score.stream.Joiners.equal;

public class PictureConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                variedShoeColors(constraintFactory),
                variedHatColors(constraintFactory),
                multiColorPerson(constraintFactory),
                useShoeAtMostOnce(constraintFactory),
                useHatAtMostOnce(constraintFactory)};
    }

    private Constraint variedShoeColors(ConstraintFactory constraintFactory) {
        return constraintFactory.forEachUniquePair(Person.class,
                        equal(Person::getShoeColor)
                ).penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("varied shoe colors");
    }

    private Constraint variedHatColors(ConstraintFactory constraintFactory) {
        return constraintFactory.forEachUniquePair(Person.class,
                        equal(Person::getHatColor)
                ).penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("varied hat colors");

    }

    private Constraint multiColorPerson(ConstraintFactory constraintFactory) {
        return constraintFactory.forEach(Person.class)
                .filter(person -> person.getHatColor() == person.getShoeColor())
                .penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("multicolor person");
    }

    private Constraint useShoeAtMostOnce(ConstraintFactory constraintFactory) {
        return constraintFactory.forEachUniquePair(Person.class,
                        equal(Person::getShoe)
                )
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Use shoe at most once");
    }

    private Constraint useHatAtMostOnce(ConstraintFactory constraintFactory) {
        return constraintFactory.forEachUniquePair(Person.class,
                        equal(Person::getHat)
                )
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Use hat at most once");
    }
}
