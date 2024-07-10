package equation;

import file.FileManager;

import java.util.List;

public class EquationManager {
    private final FileManager fileManager;
    private final EquationValidator validator;
    private final EquationGenerator generator;
    private final EquationSolver solver;

    public EquationManager(String fileName) {
        this.fileManager = new FileManager(fileName);
        this.validator = new EquationValidator();
        this.generator = new EquationGenerator();
        this.solver = new EquationSolver();
    }

    public void processEquationFile() {
        if (!fileManager.fileExists()) {
            generateAndSolveEquation();
        } else {
            String content = fileManager.readFile();
            if (!validator.isValidEquationSystem(content)) {
                generateAndSolveEquation();
            } else {
                System.out.println("Valid equation system found:");
                System.out.println(content);
                List<String> solutions = solver.solveEquation(content);
                writeSolutions(solutions);
            }
        }
    }

    private void generateAndSolveEquation() {
        String equations = generator.generateEquations();
        fileManager.writeFile(equations);
        System.out.println("Generated and saved new equation system:");
        System.out.println(equations);

        List<String> solutions = solver.solveEquation(equations);
        writeSolutions(solutions);
    }


    private void writeSolutions(List<String> solutions) {
        if (solutions == null || solutions.isEmpty()) {
            fileManager.appendToFile("No solutions.\n");
        } else {
            for (String solution : solutions) {
                fileManager.appendToFile(solution + "\n");
            }
        }
    }
}
