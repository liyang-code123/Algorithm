package javabasic;

public class ClosestInSortedArray {
	public static int closestElementIndex(int[] array, int target) {
		// sanity check
		if (array == null || array.length == 0) {
			return -1;
		}
		
		//initialize
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
				left = mid;
			} else if (array[mid] > target) {
				right = mid;
			} else {
				return mid;
			}
		}
		
		if (Math.abs(array[left] - target) >= Math.abs(array[right] - target)) {
			return right;
		}
		
		return left;
	}

	public static void main(String[] args) {
		int[] a = {3,4,5,6,6,12,16};
		int target = 10;
		System.out.println(closestElementIndex(a, target));
	}
}
