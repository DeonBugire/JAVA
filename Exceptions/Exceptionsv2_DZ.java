import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exceptionsv2_DZ {

    private static final int COUNT_FIELDS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введите данные (Фамилия, имя, отчество, дата рождения, номер телефона и пол) через пробел:");
            String input = scanner.nextLine();
            String[] fields = input.split(" ");

            try {
                ValidateFieldsCount(fields);
                String lastName = ValidateName(fields[0], "Фамилия");
                String firstName = ValidateName(fields[1], "Имя");
                String middleName = ValidateName(fields[2], "Отчество");
                LocalDate birthDate = ValidateDate(fields[3]);
                long phoneNumber = ValidatePhoneNumber(fields[4]);
                String gender = ValidateGender(fields[5]);

                WriteToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                validInput = true;

            } catch (IllegalArgumentException | IOException e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static void ValidateFieldsCount(String[] fields) {
        if (fields.length != COUNT_FIELDS) {
            throw new IllegalArgumentException(
                    "Wrong number of fields, you entered " + fields.length + ", but should enter " + COUNT_FIELDS);
        }
    }

    private static String ValidateName(String name, String fieldName) {
        if (!name.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Incorrect " + fieldName + " format. Use only letters.");
        }
        return name;
    }

    private static LocalDate ValidateDate(String dateStr) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateStr, format);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Incorrect date format. Use dd.MM.yyyy");
        }
    }

    private static long ValidatePhoneNumber(String phoneStr) {
        if (!phoneStr.matches("\\d+")) {
            throw new IllegalArgumentException("Incorrect phone number format. Use only digits");
        }
        return Long.parseLong(phoneStr);
    }

    private static String ValidateGender(String gender) {
        if (!"m".equals(gender) && !"f".equals(gender)) {
            throw new IllegalArgumentException("Incorrect gender format. Use 'm' for male or 'f' for female");
        }
        return gender;
    }

    private static void WriteToFile(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, String gender) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Error while writing to file: " + e.getMessage(), e);
        }
    }
}