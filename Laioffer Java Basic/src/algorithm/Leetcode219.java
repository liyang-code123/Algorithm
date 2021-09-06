import java.util.HashSet;
import java.util.Set;

public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode219 test = new Leetcode219();
        int[] nums = {1, 1, 2, 4, 5, 6, 6, 7};
        int k = 3;
        System.out.println(test.containsNearbyDuplicate(nums, k));
    }
}
