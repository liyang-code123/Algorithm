package algorithm;

public class RainbowSort26 {
    public int[] rainbowSort26(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 ) return array;
        int[] indices = new int[k];

        while (indices[k - 1] <= array.length - 1) {
            int cur = array[indices[k - 1]];
            int swapTimes = indices[k - 1] - cur;
            int swapIndex = indices[k - 1];
            for (int i = 0; i < swapTimes; i++) {
                swap(array, swapIndex, indices[k - i - 1]);
                swapIndex = indices[k - i - 1];
                indices[k - 1]++;
            }
        }
        return array;
    }

    private void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        RainbowSort26 test = new RainbowSort26();
        int[] array = {1, 2, 1, 3, 4, 5, 6, 1, 2, 7, 7, 8, 3, 9};
        int k = 9;
        System.out.println(test.rainbowSort26(array, k));
    }
}
