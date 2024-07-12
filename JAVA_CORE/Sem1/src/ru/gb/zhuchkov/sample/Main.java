package ru.gb.zhuchkov.sample;

import ru.gb.zhuchkov.utils.Calculator;
import ru.gb.zhuchkov.utils.Formatter;

/**
 * Основной класс с точкой входа в программу.
 */
public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        double a = 12;
        double b = 8;

        // Выполнение математических операций
        double sum = Calculator.add(a, b);
        double difference = Calculator.subtract(a, b);
        double product = Calculator.multiply(a, b);
        double quotient = Calculator.divide(a, b);

        // Форматированный вывод результатов
        Formatter.printFormattedResult("Сумма", a, b, sum);
        Formatter.printFormattedResult("Разность", a, b, difference);
        Formatter.printFormattedResult("Произведение", a, b, product);
        Formatter.printFormattedResult("Частное", a, b, quotient);
    }
}
