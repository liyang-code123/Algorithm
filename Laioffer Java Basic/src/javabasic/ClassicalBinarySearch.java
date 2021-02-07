package javabasic;



public class ClassicalBinarySearch {
	public static int binarySearch(int[] array, int target) {
		// sanity check
		if (array == null || array.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
				left = mid + 1;
			} else if (array[mid] == target) {
				return mid;
			} else {
				right = mid - 1;
			}
		}
		
		return -1;	
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,4,5,8,9,10,12,18};
		int target = 12;
		System.out.println(binarySearch(a, target));
	}
}
