package javabasic;

public class SearchInSortedMatrixI {
	public static int[] searchMatrix (int[][] matrix, int target) {
		int[] res = new int[]{-1, -1};
		// sanity check
		if (matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0;
		int right = m * n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == matrix[mid/n][mid%n]) {
				res[0] = mid / n;
				res[1] = mid % n;
				return res;
			} else if (target < matrix[mid/n][mid%n]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
		int target = 10;
		System.out.println(searchMatrix(matrix, target));
	}
}
