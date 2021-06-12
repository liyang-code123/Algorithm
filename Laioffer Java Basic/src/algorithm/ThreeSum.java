package algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            int temp = array[left] + array[right];
            while (left < right) {
                if (temp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (temp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum three = new ThreeSum();
        int[] a = new int[]{1, 2, 3, 3, 4, 6, 5, 7};
        int target = 9;
        System.out.println(three.threeSum(a, target));
    }

}
