package javabasic;

public class LastOccurrence {
	public static int lastOccurrence(int[] arr, int target) {
		// sanity check
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		// initialize
		int left = 0;
		int right = arr.length -1;
		while (left < right -1) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		if (arr[right] == target) {
			return right;
		} else if (arr[left] == target) {
			return left;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] a = {1,3,3,3,3,10,12,18};
		int target = 3;
		System.out.println(lastOccurrence(a, target));
	}
}
