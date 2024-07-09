package equation;

import java.util.Random;

public class EquationGenerator {
    private static final Random RANDOM = new Random();

    public String generateEquation() {
        int a = RANDOM.nextInt(10) + 1; // Coefficient of the squared term
        int b = RANDOM.nextInt(21) - 10; // Coefficient of the linear term
        int c = RANDOM.nextInt(21) - 10; // Constant term

        StringBuilder equation = new StringBuilder();
        equation.append(a).append("x^2");
        if (b != 0) equation.append(b > 0 ? " + " : " - ").append(Math.abs(b)).append("x");
        if (c != 0) equation.append(c > 0 ? " + " : " - ").append(Math.abs(c));
        equation.append(" = 0");

        return equation.toString();
    }
}