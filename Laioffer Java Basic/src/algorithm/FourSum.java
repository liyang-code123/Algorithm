package algorithm;
import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public boolean fourSum (int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[i] + array[j];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(i, j));
                }
            }
        }
        return false;
    }

    static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main (String[] args) {
        FourSum four = new FourSum();
        int[] a = new int[]{1, 2, 4, 5, 6, 7, 8, 3};
        int b = 12;
        System.out.println(four.fourSum(a, b));
    }
}
