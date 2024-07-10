package equation;

import java.util.regex.Pattern;

public class EquationValidator {
    // Шаблон для проверки линейного уравнения с четырьмя переменными
    private static final Pattern PATTERN = Pattern.compile(
        "([-+]?\\d*\\.?\\d*)x\\s*([-+]?\\d*\\.?\\d*)y\\s*([-+]?\\d*\\.?\\d*)z\\s*([-+]?\\d*\\.?\\d*)\\s*=\\s*([-+]?\\d*\\.?\\d*)"
    );


    public boolean isValidEquationSystem(String content) {
        String[] lines = content.split("\\R");
        if (lines.length != 4) {
            return false;
        }
        for (String line : lines) {
            if (!PATTERN.matcher(line.trim()).matches()) {
                return false;
            }
        }
        return true;
    }
}
