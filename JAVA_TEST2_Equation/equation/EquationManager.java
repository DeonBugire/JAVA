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
            if (!validator.isValidEquation(content)) {
                generateAndSolveEquation();
            } else {
                System.out.println("Valid equation found:");
                System.out.println(content);
                List<String> solutions = solver.solveEquation(content);
                writeSolutions(solutions);
            }
        }
    }

    private void generateAndSolveEquation() {
        String equation = generator.generateEquation();
        fileManager.writeFile(equation);
        System.out.println("Generated and saved new equation:");
        System.out.println(equation);

        List<String> solutions = solver.solveEquation(equation);
        writeSolutions(solutions);
    }

    private void writeSolutions(List<String> solutions) {
        // Добавляем перевод строки перед записью решений
        fileManager.appendToFile("\n");
        if (solutions == null || solutions.isEmpty()) {
            fileManager.appendToFile("No solutions.\n");
        } else {
            for (String solution : solutions) {
                fileManager.appendToFile(solution + "\n");
            }
        }
    }
}
