package lesson5.task.tictac;


import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TicTacToeFileManager {
    public static void saveToFile(String fileName, TicTacToeBoard board) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(board.toBytes());
        }
    }

    public static TicTacToeBoard loadFromFile(String fileName) throws IOException {
        byte[] bytes = new byte[3];
        try (FileInputStream fis = new FileInputStream(fileName)) {
            if (fis.read(bytes) != -1) {
                return TicTacToeBoard.fromBytes(bytes);
            } else {
                throw new IOException("Failed to read from file.");
            }
        }
    }
}