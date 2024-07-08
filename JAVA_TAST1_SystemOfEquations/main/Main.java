package main;

import equation.EquationValidator;
import equation.EquationGenerator;
import file.FileManager;

public class Main {
    private static final String FILE_NAME = "equations.txt";

    public static void main(String[] args) {
        FileManager fileManager = new FileManager(FILE_NAME);
        EquationValidator validator = new EquationValidator();
        EquationGenerator generator = new EquationGenerator();

        if (!fileManager.fileExists()) {
            fileManager.createFile();
        }

        String content = fileManager.readFile();

        if (!validator.isValid(content)) {
            String equations = generator.generateEquations();
            fileManager.writeFile(equations);
            System.out.println("Generated and wrote new equations: \n" + equations);
        } else {
            System.out.println("File contains valid equations: \n" + content);
        }
    }
}
