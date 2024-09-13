package org.example;

public class Main {
    public static void main(String[] args) {
        CalculatorFacade calculator = new CalculatorFacade();

        ComplexNumber num1 = new ComplexNumber(4, 5);
        ComplexNumber num2 = new ComplexNumber(2, 3);

        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
        System.out.println("Division: " + calculator.divide(num1, num2));
    }
}