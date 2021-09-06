package algorithm2;

//LaiCode 9
// Solution 1: initialize one array at each call.
//public class MergeSort {
//    public int[] mergeSort(int[] array) {
//        if (array == null || array.length == 0) return array;
//        return mergeSort(array, 0, array.length - 1);
//    }
//
//    public int[] mergeSort(int[] array, int left, int right) {
//        if (left == right) return new int[]{array[left]};
//        int mid = left + (right - left) / 2;
//        int[] leftResult = mergeSort(array, left, mid);
//        int[] rightResult = mergeSort(array, mid + 1, right);
//        int[] result = merge(leftResult, rightResult);
//        return result;
//    }
//
//    public int[] merge(int[] leftResult, int[] rightResult) {
//        int[] result = new int[leftResult.length + rightResult.length];
//        int i = 0, j = 0, k = 0;
//        while (i < leftResult.length && j < rightResult.length) {
//            if (leftResult[i] < rightResult[j]){
//                result[k++] = leftResult[i++];
//            } else {
//                result[k++] = rightResult[j++];
//            }
//        }
//        while (i < leftResult.length) {
//            result[k++] = leftResult[i++];
//        }
//        while (j < rightResult.length) {
//            result[k++] = rightResult[j++];
//        }
//        return result;
//    }
//
//    public static void main (String[] args) {
//        MergeSort ms = new MergeSort();
//        int[] array = new int[]{3, 4, 5, 7, 2, 1, 0};
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(ms.mergeSort(array)[i]);
//        }
//    }
//}

import java.util.Arrays;

// Solution 2: only use one helper array at all times.
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] array = {4, 2, 2, 1, 3};
        System.out.println(Arrays.toString(test.mergeSort(array)));
    }
}
