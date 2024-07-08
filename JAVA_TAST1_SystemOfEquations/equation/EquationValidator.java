package equation;

public class EquationValidator {
    private static final String REGEX = "\\d*x\\^2 \\+ \\d*y \\+ \\d* = 0\\n\\d*y\\^2 \\+ \\d*x \\+ \\d* = 0";

    public boolean isValid(String content) {
        return content != null && content.trim().matches(REGEX);
    }
}