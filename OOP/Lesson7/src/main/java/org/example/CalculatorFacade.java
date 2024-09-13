package org.example;

public class CalculatorFacade {
    private final ComplexCalculator calculator;

    public CalculatorFacade() {
        this.calculator = new ComplexCalculator();
    }

    public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        LoggerFactory.log("Adding: " + a + " + " + b);
        return calculator.add(a, b);
    }

    public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        LoggerFactory.log("Multiplying: " + a + " * " + b);
        return calculator.multiply(a, b);
    }

    public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        LoggerFactory.log("Dividing: " + a + " / " + b);
        return calculator.divide(a, b);
    }
}
