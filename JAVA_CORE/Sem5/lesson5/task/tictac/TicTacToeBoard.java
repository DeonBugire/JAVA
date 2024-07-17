package lesson5.task.tictac;


public class TicTacToeBoard {
    private int[] board;

    public TicTacToeBoard(int[] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException("Board must have 9 elements.");
        }
        this.board = board;
    }

    public int[] getBoard() {
        return board.clone();
    }

    public void setBoard(int[] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException("Board must have 9 elements.");
        }
        this.board = board;
    }

    public byte[] toBytes() {
        byte[] bytes = new byte[3]; // 3 байта для хранения 9 значений по 2 бита каждое
        for (int i = 0; i < 9; i++) {
            bytes[i / 3] |= (board[i] << (2 * (i % 3)));
        }
        return bytes;
    }

    public static TicTacToeBoard fromBytes(byte[] bytes) {
        if (bytes.length != 3) {
            throw new IllegalArgumentException("Byte array must have 3 elements.");
        }
        int[] board = new int[9];
        for (int i = 0; i < 9; i++) {
            board[i] = (bytes[i / 3] >> (2 * (i % 3))) & 0x03;
        }
        return new TicTacToeBoard(board);
    }
}
