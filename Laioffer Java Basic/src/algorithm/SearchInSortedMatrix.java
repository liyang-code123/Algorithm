package algorithm;

import java.util.Arrays;

//LaiCode 267
public class SearchInSortedMatrix {
    public int[] searchInSortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) return new int[]{-1, -1};
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = m * n - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / m][mid % m] < target) {
                left = mid + 1;
            } else if (matrix[mid / m][mid % m] > target) {
                right = mid - 1;
            } else {
                return new int[]{mid / m, mid % m};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        SearchInSortedMatrix test = new SearchInSortedMatrix();
        int[][] matrix = {{1,2,3}, {4, 5, 7}, {8, 9, 10}};
        int target = 7;
        System.out.println(Arrays.toString(test.searchInSortedMatrix(matrix, target)));
    }
}
