package console;

import java.util.Scanner;

public class ConsoleHandler {
    private final Scanner scanner;

    public ConsoleHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол) через пробел:");
        return scanner.nextLine();
    }

    public void printError(String message) {
        System.err.println(message);
    }
}