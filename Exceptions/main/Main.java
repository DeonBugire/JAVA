import console.ConsoleHandler;
import validation.DataValidator;
import file.FileWriterHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final int COUNT_FIELDS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleHandler consoleHandler = new ConsoleHandler(scanner);
        DataValidator validator = new DataValidator();
        FileWriterHandler fileWriterHandler = new FileWriterHandler();

        boolean validInput = false;

        while (!validInput) {
            String input = consoleHandler.getInput();
            String[] fields = input.split(" ");

            try {
                validator.validateFieldsCount(fields, COUNT_FIELDS);
                String lastName = validator.validateName(fields[0], "Фамилия");
                String firstName = validator.validateName(fields[1], "Имя");
                String middleName = validator.validateName(fields[2], "Отчество");
                LocalDate birthDate = validator.validateDate(fields[3]);
                long phoneNumber = validator.validatePhoneNumber(fields[4]);
                String gender = validator.validateGender(fields[5]);

                fileWriterHandler.writeToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                validInput = true;

            } catch (IllegalArgumentException | IOException e) {
                consoleHandler.printError(e.getMessage());
            }
        }

        scanner.close();
    }
}