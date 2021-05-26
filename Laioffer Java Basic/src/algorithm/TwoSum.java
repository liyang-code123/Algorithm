package algorithm;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LeetCode 1
public class TwoSum {
    public int[] twoSum(int[] array, int target) {
        if (array == null || array.length == 0) return new int[]{-1, -1};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int remaining = target - array[i];
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }
            map.put(array[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[]array = {1, 2, 2, 3, 4, 5, 5, 6};
        int target = 8;
        System.out.println(Arrays.toString(test.twoSum(array, target)));
    }
}
