public class Leetcode1706 {
    public int[] finalBall(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{};
        }

        int[] res = new int[grid[0].length];
        for (int c = 0; c < grid[0].length; c++) {
            int x = c;
            outer:
            for (int r = 0; r < grid.length; r++) {
                int xNext = x + grid[r][x];
                if (xNext < 0 || xNext >= grid[0].length || grid[r][x] != grid[r][xNext]) {
                    res[c] = -1;
                    continue outer;
                }
            }
            res[c] = x;
        }
        return res;
    }
}
