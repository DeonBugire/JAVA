package equation;

import java.util.regex.Pattern;

public class EquationValidator {
    private static final Pattern PATTERN = Pattern.compile(
        "\\d*x\\^2\\s*([-+]?\\s*\\d*x)?\\s*([-+]?\\s*\\d*)?\\s*=\\s*0"
    );

    public boolean isValidEquation(String content) {
        return PATTERN.matcher(content.trim()).matches();
    }
}