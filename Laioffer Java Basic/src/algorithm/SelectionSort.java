package algorithm;

// LaiCode 4
public class SelectionSort {
    public int[] selectionSort(int[] array) {
        // base case
        if (array == null || array.length == 0) return array;

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    public void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main (String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] array = new int[]{3, 4, 5, 7, 1, 2};
        System.out.println(sort.selectionSort(array));
    }
}
