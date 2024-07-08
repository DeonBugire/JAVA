package file;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public boolean fileExists() {
        return Files.exists(Paths.get(fileName));
    }

    public void createFile() {
        try {
            Files.createFile(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    public String readFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return "";
        }
    }

    public void writeFile(String content) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}