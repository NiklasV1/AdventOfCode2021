package utils.day4;

public class BingoBoard {
    public BingoField[][] board;
    public int size;
    public int lastMarked;

    public BingoBoard(int[][] values, int size) {
        this.size = size;
        board = new BingoField[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[x][y] = new BingoField(values[x][y]);
            }
        }

        lastMarked = 0;
    }

    public void markValue(int val) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (board[x][y].value == val) {
                    board[x][y].marked = true;
                }
            }
        }
        lastMarked = val;
    }

    public int calculateScore() {
        int sum = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!board[x][y].marked) {
                    sum += board[x][y].value;
                }
            }
        }

        return sum * lastMarked;
    }

    public boolean checkWin() {
        return checkColumns() || checkRows();
    }

    private boolean checkColumns() {
        for (int y = 0; y < size; y++) {
            boolean won = true;
            for (int x = 0; x < size; x++) {
                if (!board[x][y].marked) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRows() {
        for (int x = 0; x < size; x++) {
            boolean won = true;
            for (int y = 0; y < size; y++) {
                if (!board[x][y].marked) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }
        return false;
    }
}
