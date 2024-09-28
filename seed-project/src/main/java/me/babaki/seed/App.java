package me.babaki.seed;


import ai.timefold.solver.core.api.solver.SolverFactory;
import ai.timefold.solver.core.config.solver.SolverConfig;
import me.babaki.seed.domain.Person;
import me.babaki.seed.domain.Picture;
import me.babaki.seed.io.ProblemReader;
import me.babaki.seed.io.SolutionWriter;
import me.babaki.seed.solver.PictureConstraintProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        String problemFilePath = args[0];
        String solutionFilePath = args[1];

        var reader = new ProblemReader();
        var maybeProblem = reader.readFromJson(problemFilePath);

        if (maybeProblem.isEmpty()) {
            System.exit(1);
        }

        var problem = maybeProblem.get();
        var solution = solve(problem);
        LOGGER.info(solution.getScore().toString());

        var writer = new SolutionWriter();
        writer.writeToJson(solution, solutionFilePath);
    }

    public static Picture solve(Picture problem) {
        SolverFactory<Picture> solverFactory = SolverFactory
                .create(new SolverConfig().withSolutionClass(Picture.class)
                        .withEntityClasses(Person.class)
                        .withConstraintProviderClass(PictureConstraintProvider.class)
                        // The solver runs only for 5 seconds on this small dataset.
                        // It's recommended to run for at least 5 minutes ("5m") otherwise.
                        .withTerminationSpentLimit(Duration.ofSeconds(5)));

        // Solve the problem
        var solver = solverFactory.buildSolver();
        var solution = solver.solve(problem);
        return solution;
    }


}