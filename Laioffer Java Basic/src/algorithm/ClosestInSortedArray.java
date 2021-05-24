package algorithm;

public class ClosestInSortedArray {
    public int closestInSortedArray(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid;
            } else { // array[mid] == target
                return mid;
            }
        }

        if (Math.abs(array[left] - target) >= Math.abs(array[right] - target)) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        ClosestInSortedArray test = new ClosestInSortedArray();
        int[] array = {1, 2, 4, 5, 6, 6, 7, 10};
        int target = 8;
        System.out.println(test.closestInSortedArray(array, target));
    }
}
