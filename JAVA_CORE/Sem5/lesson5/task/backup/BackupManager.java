package lesson5.task.backup;

import java.io.IOException;
import java.nio.file.*;

public class BackupManager {
    private final Path sourceDir;
    private final Path backupDir;

    // Конструктор, принимающий пути к исходной и резервной директориям
    public BackupManager(String sourceDir, String backupDir) {
        this.sourceDir = Path.of(sourceDir);
        this.backupDir = Path.of(backupDir);
    }

    // Метод для создания директории резервных копий
    public void createBackupDirectory() throws IOException {
        if (!Files.exists(backupDir)) {
            Files.createDirectory(backupDir);
            System.out.println("Backup directory created at: " + backupDir.toString());
        } else {
            System.out.println("Backup directory already exists at: " + backupDir.toString());
        }
    }

    // Метод для копирования файлов в директорию резервных копий
    public void backupFiles() throws IOException {
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(sourceDir)) {
            for (Path file : dir) {
                if (Files.isDirectory(file)) continue;
                Files.copy(file, backupDir.resolve(file.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File " + file.getFileName().toString() + " backed up to " + backupDir.toString());
            }
        }
    }
}
