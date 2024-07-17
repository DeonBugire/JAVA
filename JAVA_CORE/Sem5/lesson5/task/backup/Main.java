package lesson5.task.backup;

import java.io.IOException;

public class Main {
    // Директории по умолчанию
    private static final String DEFAULT_SOURCE_DIR = ".";
    private static final String DEFAULT_BACKUP_DIR = "./backup";

    public static void main(String[] args) {
        String sourceDir = DEFAULT_SOURCE_DIR;
        String backupDir = DEFAULT_BACKUP_DIR;

        if (args.length >= 2) {
            sourceDir = args[0];
            backupDir = args[1];
        } else {
            System.out.println("Using default directories: sourceDir = " + sourceDir + ", backupDir = " + backupDir);
        }

        try {
            BackupManager backupManager = new BackupManager(sourceDir, backupDir);
            backupManager.createBackupDirectory();
            backupManager.backupFiles();
            System.out.println("Backup process completed successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred during the backup process");
            e.printStackTrace();
        }
    }
}
