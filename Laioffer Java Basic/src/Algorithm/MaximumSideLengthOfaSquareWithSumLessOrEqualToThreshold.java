/* LeetCode 1292*/

public class MaximumSideLengthOfaSquareWithSumLessOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            int sum = 0;
            for (int j = 1; j <= n; ++j) {
                sum += mat[i - 1][j - 1];
                prefixSum[i][j] = prefixSum[i - 1][j] + sum;
            }
        }

        for (int k = Math.min(m, n) - 1; k > 0; --k) {
            for (int i = 1; i + k <= m; ++i) {
                for (int j = 1; j + k <= n; ++j) {
                    if (prefixSum[i + k][j + k] - prefixSum[i - 1][j + k] - prefixSum[i + k][j - 1]
                    + prefixSum[i - 1][j - 1] <= threshold) {
                        return k + 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main (String[] args) {
        MaximumSideLengthOfaSquareWithSumLessOrEqualToThreshold test = new MaximumSideLengthOfaSquareWithSumLessOrEqualToThreshold();
        int[][] mat = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int threshold = 6;
        System.out.println(test.maxSideLength(mat, threshold));
    }
}
