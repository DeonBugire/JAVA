package ru.gb.zhuchkov.utils;

/**
 * Класс для выполнения основных математических операций.
 */
public class Calculator {
    /**
     * Сложение двух чисел.
     *
     * @param a первое число.
     * @param b второе число.
     * @return сумма a и b.
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Вычитание второго числа из первого.
     *
     * @param a уменьшаемое.
     * @param b вычитаемое.
     * @return разность a и b.
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Умножение двух чисел.
     *
     * @param a первый множитель.
     * @param b второй множитель.
     * @return произведение a и b.
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Деление первого числа на второе.
     *
     * @param a делимое.
     * @param b делитель.
     * @return частное от деления a на b.
     * @throws ArithmeticException если b равно 0.
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        return a / b;
    }
}
