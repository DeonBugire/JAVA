package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileWriterHandler {
    public void writeToFile(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, String gender) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Error while writing to file: " + e.getMessage(), e);
        }
    }
}