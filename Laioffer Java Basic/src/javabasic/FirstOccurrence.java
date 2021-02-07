package javabasic;

public class FirstOccurrence {
	public static int firstOccurence(int[] arr, int target) {
		// sanity check
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		// initialize left and right
		int left = 0;
		int right = arr.length - 1;
		while (left < right -1) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < target) {
				left = mid;
			} else if (arr[mid] == target) {
				right = mid;
			} else { // arr[mid] > target
				right = mid;
			}
		}
		
		
		if (arr[left] == target) {
			return left;
		} else if (arr[right] == target) {
			return right;
		} else {
			return -1; 
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,3,5,8,3,10,12,18};
		int target = 3;
		System.out.println(firstOccurence(a, target));
	}
}
