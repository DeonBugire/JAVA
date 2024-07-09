package equation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationSolver {
    public List<String> solveEquation(String equation) {
        double[] coeffs = parseCoefficients(equation);

        if (coeffs == null) {
            return null;
        }

        List<String> solutions = new ArrayList<>();

        List<Double> xSolutions = solveQuadratic(coeffs[0], coeffs[1], coeffs[2]);
        if (xSolutions.isEmpty()) {
            solutions.add("No solutions.");
        } else {
            for (Double x : xSolutions) {
                solutions.add("x = " + x);
            }
        }

        return solutions;
    }

    private double[] parseCoefficients(String equation) {
        // Очищаем пробелы и приводим уравнение к стандартному виду
        equation = equation.replaceAll("\\s+", "");

        // Улучшенное регулярное выражение для разбора уравнения
        String regex = "([-+]?\\d*\\.?\\d*)x\\^2([-+]?\\d*\\.?\\d*)x?([-+]?\\d*\\.?\\d*)?=0";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equation.trim());  // Удаление лишних пробелов
        
        if (matcher.matches()) {
            // Парсим коэффициенты с учетом возможного отсутствия знаков или чисел
            double a = matcher.group(1).isEmpty() || matcher.group(1).equals("+") ? 1 : 
                       matcher.group(1).equals("-") ? -1 : Double.parseDouble(matcher.group(1));
            double b = matcher.group(2).isEmpty() || matcher.group(2).equals("+") ? 1 : 
                       matcher.group(2).equals("-") ? -1 : Double.parseDouble(matcher.group(2));
            double c = matcher.group(3) == null || matcher.group(3).isEmpty() ? 0 : Double.parseDouble(matcher.group(3));
            return new double[]{a, b, c};
        }
        return null;
    }

    private List<Double> solveQuadratic(double a, double b, double c) {
        List<Double> solutions = new ArrayList<>();
        if (a == 0) {
            if (b != 0) {
                solutions.add(-c / b);
            }
            return solutions;
        }
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return solutions; // Нет действительных решений
        } else if (discriminant == 0) {
            solutions.add(-b / (2 * a));
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double x1 = (-b + sqrtDiscriminant) / (2 * a);
            double x2 = (-b - sqrtDiscriminant) / (2 * a);
            solutions.add(x1);
            solutions.add(x2);
        }
        return solutions;
    }

    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver();
        List<String> solutions = solver.solveEquation("1x^2 + 2x - 1 = 0");
        if (solutions != null) {
            for (String solution : solutions) {
                System.out.println(solution);
            }
        } else {
            System.out.println("Failed to parse the equation.");
        }
    }
}
