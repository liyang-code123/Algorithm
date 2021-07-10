import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    Random rand = new Random();

    public int[] quickSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return arr;
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = left + rand.nextInt(right - left + 1);
        swap(arr, pivotIndex, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (arr[i] < arr[right]) {
                i++;
            } else {
                swap(arr, i, j);
                j--;
            }
        }
        swap(arr, i, right); // swap i-th and right. the arr[right] is the pivot right now!!!
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main (String[] args) {
        QuickSort test = new QuickSort();
        int[] arr = {4, -2, 3, 1, 4, 5};
        System.out.println(Arrays.toString(test.quickSort(arr)));
    }
}
