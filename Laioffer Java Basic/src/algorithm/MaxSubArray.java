public class MaxSubArray {
    public int maxSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int pre = array[0];
        int globalMax = array[0]; // globalMax needs to be set as array[0], rather than Integer.MIN_VALUE
        for (int i = 1; i < array.length; i++) {
            if (pre + array[i] >= array[i]) {
                pre = pre + array[i];
            } else {
                pre = array[i];
            }
            globalMax = Math.max(globalMax, pre);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        MaxSubArray test = new MaxSubArray();
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] array1 = {0};
        int[] array2 = {};
        int[] array3 = {1, 2, 3, 4, 5};
        int[] array4 = {-1, -2, -3, -4, -5};
        System.out.println(test.maxSubarray(array));
        System.out.println(test.maxSubarray(array1));
        System.out.println(test.maxSubarray(array2));
        System.out.println(test.maxSubarray(array3));
        System.out.println(test.maxSubarray(array4));
    }
}
