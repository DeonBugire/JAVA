package lesson5.task.tictac;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] initialBoard = {0, 1, 2, 3, 0, 1, 2, 3, 0};
        TicTacToeBoard board = new TicTacToeBoard(initialBoard);

        try {
            TicTacToeFileManager.saveToFile("save1.out", board);
            TicTacToeBoard loadedBoard = TicTacToeFileManager.loadFromFile("save1.out");
            System.out.println(Arrays.toString(loadedBoard.getBoard()));
        } catch (IOException e) {
            System.err.println("An error occurred during file operations");
            e.printStackTrace();
        }
    }
}
