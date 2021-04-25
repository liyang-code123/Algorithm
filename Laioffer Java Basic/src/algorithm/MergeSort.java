package algorithm;

//LaiCode 9
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) return array;
        return mergeSort(array, 0, array.length - 1);
    }

    public int[] mergeSort(int[] array, int left, int right) {
        if (left == right) return new int[]{array[left]};
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        int[] result = merge(leftResult, rightResult);
        return result;
    }

    public int[] merge(int[] leftResult, int[] rightResult) {
        int[] result = new int[leftResult.length + rightResult.length];
        int i = 0, j = 0, k = 0;
        while (i < leftResult.length && j < rightResult.length) {
            if (leftResult[i] < rightResult[j]){
                result[k++] = leftResult[i++];
            } else {
                result[k++] = rightResult[j++];
            }
        }
        while (i < leftResult.length) {
            result[k++] = leftResult[i++];
        }
        while (j < rightResult.length) {
            result[k++] = rightResult[j++];
        }
        return result;
    }

    public static void main (String[] args) {
        MergeSort ms = new MergeSort();
        int[] array = new int[]{3, 4, 5, 7, 2, 1, 0};
        System.out.println(ms.mergeSort(array));
    }
}
