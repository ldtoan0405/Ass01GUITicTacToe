public class TicTacToe {

    private String[][] board;
    private final int ROWS = 3;
    private final int COLS = 3;

    public TicTacToe() {
        board = new String[ROWS][COLS];
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }

    public boolean makeMove(int row, int col, String player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    public boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    public boolean isTie() {
        boolean xFlag = false;
        boolean oFlag = false;

        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals("X") || board[row][1].equals("X") || board[row][2].equals("X")) {
                xFlag = true;
            }
            if (board[row][0].equals("O") || board[row][1].equals("O") || board[row][2].equals("O")) {
                oFlag = true;
            }

            if (!(xFlag && oFlag)) {
                return false;
            }

            xFlag = oFlag = false;
        }

        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals("X") || board[1][col].equals("X") || board[2][col].equals("X")) {
                xFlag = true;
            }
            if (board[0][col].equals("O") || board[1][col].equals("O") || board[2][col].equals("O")) {
                oFlag = true;
            }

            if (!(xFlag && oFlag)) {
                return false;
            }
        }

        xFlag = oFlag = false;

        if (board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X")) {
            xFlag = true;
        }
        if (board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }

        xFlag = oFlag = false;

        if (board[0][2].equals("X") || board[1][1].equals("X") || board[2][0].equals("X")) {
            xFlag = true;
        }
        if (board[0][2].equals("O") || board[1][1].equals("O") || board[2][0].equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }

        return true;
    }
}
