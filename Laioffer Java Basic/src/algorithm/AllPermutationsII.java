import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    public List<Integer> allPermutations(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> res) {
        if (start == nums.length) {
            int total = 0;
            for (int i : nums) {
                total = total * 10 + i;
            }
            res.add(total);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (set.add(nums[i])) {
                swap(nums, i, start);
                dfs(nums, start + 1, res);
                swap(nums, i, start);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args) {
        AllPermutationsII test = new AllPermutationsII();
        int[] nums = {1, 1};
        List<Integer> res = test.allPermutations(nums);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
