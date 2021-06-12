public class SudokuSolver {
    public boolean sudokuSolver(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        return solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; ++c) {
                        board[i][j] = c;
                        if(isValid(board, i, j, c)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if(board[i][k] !='.' && board[i][k] == c) {
                return false;
            }
            if(board[k][j] != '.' && board[k][j] == c) {
                return false;
            }
            if(board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] != '.' &&
                    board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
