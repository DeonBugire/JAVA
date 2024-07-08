package equation;

import java.util.Random;

public class EquationGenerator {
    private final Random random = new Random();

    public String generateEquations() {
        String equation1 = generateFirstEquation();
        String equation2 = generateSecondEquation();

        return equation1 + "\n" + equation2;
    }

    private String generateFirstEquation() {
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(10);

        StringBuilder equation = new StringBuilder();

        appendTerm(equation, a, "x^2");
        appendTerm(equation, b, "y");
        appendTerm(equation, c, "");

        equation.append(" = 0");

        return equation.toString();
    }

    private String generateSecondEquation() {
        int d = random.nextInt(10);
        int e = random.nextInt(10);
        int f = random.nextInt(10);

        StringBuilder equation = new StringBuilder();

        appendTerm(equation, d, "y^2");
        appendTerm(equation, e, "x");
        appendTerm(equation, f, "");

        equation.append(" = 0");

        return equation.toString();
    }

    private void appendTerm(StringBuilder equation, int coefficient, String variable) {
        if (coefficient == 0) {
            return;
        }

        if (equation.length() > 0 && equation.charAt(equation.length() - 1) != '=') {
            equation.append(coefficient > 0 ? " + " : " - ");
        } else if (coefficient < 0) {
            equation.append("-");
        }

        int absCoefficient = Math.abs(coefficient);

        if (absCoefficient != 1 || variable.isEmpty()) {
            equation.append(absCoefficient);
        }

        if (!variable.isEmpty()) {
            equation.append(variable);
        }
    }
}