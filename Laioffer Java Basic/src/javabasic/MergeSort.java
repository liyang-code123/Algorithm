package javabasic;

import java.util.Arrays;

public class MergeSort {
public int[] mergeSort(int[] array) {
	// sanity check
	if ( array == null || array.length <=1) {
		return array;
	}
	return mergeSort(array, 0, array.length - 1);
}

private int[] mergeSort(int[]array, int left, int right) {
	// base case
	if (left == right) {
		return new int[]{array[left]}; 
	}
	
int mid = left + (right - left) / 2;
	int[] leftResult = mergeSort(array, left, mid);
	int[] rightResult = mergeSort(array, mid + 1, right);
	return merge(leftResult, rightResult);

}

private int[] merge(int[] left, int[] right) {
	int[] result = new int[left.length + right.length];

	int i = 0;
	int j = 0;
	int k = 0;
	while(i < left.length && j < right.length) {
		if(left[i] < right[j]) {
			result[k++] = left[i++];
		} else {
			result[k] = right[j];
			j++;
			k++;
		}
}

while (i < left.length) {
	result[k] = left[i];
	i++;
	k++;
}
while (j < right.length) {
	result[k] = right[j];
	j++;
	k++;
}
return result;
}

public static void main(String[] args) {
	int[] a = {5, 2, 7, 4, 1, 3, 8, 6};
	MergeSort solution = new MergeSort();
	System.out.println(Arrays.toString(solution.mergeSort(a)));
}
}


