package algorithm;

//LaiCode 14
public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        ClassicalBinarySearch test = new ClassicalBinarySearch();
        int[] array = {1, 2, 3, 3, 4, 5, 6, 9, 9, 10};
        int target = 9;
        System.out.println(test.binarySearch(array, target));
    }
}
