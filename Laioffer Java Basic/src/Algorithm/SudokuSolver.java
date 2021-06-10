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
                        if(isValid(board, i, j)) {
                            return true;
                        } else {

                        }
                    }
                }
            }
        }
    }
}
