package validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataValidator {
    public void validateFieldsCount(String[] fields, int expectedCount) {
        if (fields.length != expectedCount) {
            throw new IllegalArgumentException(
                    "Wrong number of fields, you entered " + fields.length + ", but should enter " + expectedCount);
        }
    }

    public String validateName(String name, String fieldName) {
        if (!name.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Incorrect " + fieldName + " format. Use only letters.");
        }
        return name;
    }

    public LocalDate validateDate(String dateStr) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateStr, format);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Incorrect date format. Use dd.MM.yyyy");
        }
    }

    public long validatePhoneNumber(String phoneStr) {
        if (!phoneStr.matches("\\d+")) {
            throw new IllegalArgumentException("Incorrect phone number format. Use only digits");
        }
        return Long.parseLong(phoneStr);
    }

    public String validateGender(String gender) {
        if (!"m".equals(gender) && !"f".equals(gender)) {
            throw new IllegalArgumentException("Incorrect gender format. Use 'm' for male or 'f' for female");
        }
        return gender;
    }
}

