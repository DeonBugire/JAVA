package ru.gb.zhuchkov.utils;
/**
 * Класс для форматированного вывода результатов математических операций.
 */
public class Formatter {
    /**
     * Форматированный вывод результата математической операции.
     *
     * @param operation название операции.
     * @param a первое число.
     * @param b второе число.
     * @param result результат операции.
     */
    public static void printFormattedResult(String operation, double a, double b, double result) {
        System.out.printf("%s (%.2f и %.2f) = %.2f%n", operation, a, b, result);
    }
}