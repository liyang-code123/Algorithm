import java.util.Arrays;

public class Sudoku {
    public boolean validSudoku(char[][] board) {
        boolean[] exist = new boolean[9];
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.fill(exist, false);
            for (int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                if(exist[board[i][j] - '0']) return false;
                exist[board[i][j] - '0'] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(exist, false);
            for (int j = 0; j < n; j++) {
                if(board[j][i] == '.') continue;
                if(exist[board[j][i] - '0']) return false;
                exist[board[j][i] - '0'] = true;
            }
        }

        for (int k = 1; k <= 3; k++) {
            for (int l = 1; l <= 3; l++) {
                Arrays.fill(exist, false);
                for (int i = (k - 1) * 3; i < k * 3; i++) {
                    for (int j = (l - 1) * 3; j < l * 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (exist[board[i][j] - '0']) return false;
                        exist[board[i][j] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main (String[] args) {
        Sudoku test = new Sudoku();

    }
}
