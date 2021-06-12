import java.util.Arrays;
import java.util.TreeSet;

// LeetCode 363
public class MaxSumOfRectangleNoLargerThanK {
    int result = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[] rowSum = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(rowSum, 0);
            for (int row = i; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    rowSum[col] += matrix[row][col];
                }
                sortedPrefixSumFindK(rowSum, k);
                if (result == k) return result;
            }
        }
        return result;
    }

    public void sortedPrefixSumFindK(int[] nums, int k) {
        int sum = 0;
        TreeSet<Integer> sortSum = new TreeSet<>();
        sortSum.add(0);
        for (int num : nums) {
            sum += num;
            Integer x = sortSum.ceiling(sum - k);
            if (x != null) result = Math.max(result, sum - x);
            sortSum.add(sum);
        }
    }

    public static void main (String[] args) {
        MaxSumOfRectangleNoLargerThanK test = new MaxSumOfRectangleNoLargerThanK();
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        System.out.println(test.maxSumSubmatrix(matrix, k));
    }
}
