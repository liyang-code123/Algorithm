public class NumberOfIslands {
    public int numberOfIslands(char[][] board) {
        if (board == null || board.length == 0) return 0;

        int n = board.length;
        int m = board[0].length;
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == '1') {
                    res++;
                    dfs(board, row, col);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '0') {
            return;
        }
        board[row][col] = '0';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        char[][] board = {{'1' , '1' , '0' , '1' , '0'},
                          {'1' , '1' , '0' , '1' , '0'},
                          {'1' , '1' , '0' , '0' , '0'},
                          {'0' , '0' , '0' , '0' , '0'}};
        System.out.println(test.numberOfIslands(board));
    }
}
