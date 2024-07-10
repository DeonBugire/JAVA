package equation;

import java.util.Random;

public class EquationGenerator {
    private final Random random = new Random();

    public String generateEquations() {
        StringBuilder equations = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            equations.append(generateEquation()).append("\n");
        }
        return equations.toString();
    }

    private String generateEquation() {
        int A = random.nextInt(21) - 10;
        int B = random.nextInt(21) - 10;
        int C = random.nextInt(21) - 10;
        int D = random.nextInt(21) - 10;
        int E = random.nextInt(21) - 10;
        
        StringBuilder equation = new StringBuilder();

        // Добавляем первый коэффициент
        equation.append(A >= 0 ? String.format("%d", A) : String.format("%d", A)).append("x");

        // Добавляем второй коэффициент
        equation.append(B >= 0 ? String.format(" +%d", B) : String.format(" %d", B)).append("y");

        // Добавляем третий коэффициент
        equation.append(C >= 0 ? String.format(" +%d", C) : String.format(" %d", C)).append("z");

        // Добавляем свободный член
        equation.append(D >= 0 ? String.format(" +%d", D) : String.format(" %d", D));

        // Добавляем знак равенства и результат
        equation.append(" = ").append(E);

        return equation.toString().replaceAll("\\+0\\w", "").replaceAll("  ", " ").trim();
    }
}
