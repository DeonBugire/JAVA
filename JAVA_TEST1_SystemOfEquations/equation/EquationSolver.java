package equation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationSolver {
    /**
     * Решает систему уравнений.
     * @param equations строка с системой уравнений.
     * @return список решений.
     */
    public List<String> solveEquation(String equations) {
        double[][] matrix = parseCoefficients(equations);

        if (matrix == null) {
            return null;
        }

        double[] solutions = solveGaussian(matrix);
        List<String> solutionStrings = new ArrayList<>();
        if (solutions == null) {
            solutionStrings.add("No solutions.");
        } else {
            solutionStrings.add("x = " + solutions[0]);
            solutionStrings.add("y = " + solutions[1]);
            solutionStrings.add("z = " + solutions[2]);
        }

        return solutionStrings;
    }

    /**
     * Парсит коэффициенты из системы уравнений.
     * @param equations строка с системой уравнений.
     * @return матрица коэффициентов.
     */
    private double[][] parseCoefficients(String equations) {
        String[] lines = equations.split("\\R");
        double[][] matrix = new double[4][4];
        String regex = "([-+]?\\d*\\.?\\d*)x\\s*([-+]?\\d*\\.?\\d*)y\\s*([-+]?\\d*\\.?\\d*)z\\s*([-+]?\\d*\\.?\\d*)\\s*=\\s*([-+]?\\d*\\.?\\d*)";

        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < 4; i++) {
            Matcher matcher = pattern.matcher(lines[i].trim());
            if (matcher.matches()) {
                matrix[i][0] = parseCoefficient(matcher.group(1));
                matrix[i][1] = parseCoefficient(matcher.group(2));
                matrix[i][2] = parseCoefficient(matcher.group(3));
                matrix[i][3] = Double.parseDouble(matcher.group(5)) - parseCoefficient(matcher.group(4)); // Переносим свободный член в правую часть
            } else {
                return null; // Если парсинг не удался
            }
        }
        return matrix;
    }

    /**
     * Преобразует строковый коэффициент в число, учитывая случаи с пустыми строками и знаками.
     * @param coefficient строка с коэффициентом.
     * @return числовое значение коэффициента.
     */
    private double parseCoefficient(String coefficient) {
        if (coefficient == null || coefficient.isEmpty()) {
            return 1;
        } else if (coefficient.equals("-")) {
            return -1;
        } else if (coefficient.equals("+")) {
            return 1;
        } else {
            return Double.parseDouble(coefficient);
        }
    }

    /**
     * Решает систему уравнений методом Гаусса.
     * @param matrix матрица коэффициентов.
     * @return массив решений.
     */
    private double[] solveGaussian(double[][] matrix) {
        int n = 3; // Размерность системы
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[max][i])) {
                    max = k;
                }
            }

            double[] temp = matrix[i];
            matrix[i] = matrix[max];
            matrix[max] = temp;

            if (Math.abs(matrix[i][i]) <= 1e-10) {
                return null; // Нет решений
            }

            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i] / matrix[i][i];
                matrix[k][i] = 0;
                for (int j = i + 1; j <= n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }

        double[] solutions = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solutions[j];
            }
            solutions[i] = (matrix[i][n] - sum) / matrix[i][i];
        }

        return solutions;
    }

    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver();
        String equations = "10x +4y +2z -3 = 1\n2x +10y +10z -8 = 0\n-5x +10y -2z -8 = -6\nx +10y -8z -3 = -7";
        List<String> solutions = solver.solveEquation(equations);
        if (solutions != null) {
            for (String solution : solutions) {
                System.out.println(solution);
            }
        } else {
            System.out.println("Failed to parse or solve the equation system.");
        }
    }
}