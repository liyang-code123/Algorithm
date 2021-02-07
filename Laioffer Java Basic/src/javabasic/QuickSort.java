package javabasic;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	Random random = new Random();
	public int[] quickSort(int[] array) {
		// corner case
		if (array == null || array.length <= 1) {
			return array;
		}
		
		quickSort(array, 0, array.length - 1);
		return array;

	}
	
	private void quickSort(int[] array, int left, int right) {
		// base case
		if (left >= right) {
			return;
		}
		
		int pivotIndex = left + random.nextInt(right - left + 1);
		
		// swap pivot to right most;
		swap(array, pivotIndex, right);
	
	int i = left;
	int j = right - 1;
	while (i <= j) {
		if (array[i] < array[right]) {
			i++;
		} else {
			swap(array, i, j);
			j--;
		}
	}
	
	//swap pivot back;
	swap(array, right, i);

}

	private void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {5, 2, 7, 4, 1, 3, 8, 6};
		QuickSort solution = new QuickSort();
		System.out.println(Arrays.toString(solution.quickSort(a)));
	}
}


