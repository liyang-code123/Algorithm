import java.util.HashMap;
import java.util.Map;

//LeetCode 1248

public class CountNumberOfNiceSubarrays {
    public int countOfSubarrays(int[] nums, int k) {
        int res = 0;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i] % 2 == 1 ? 1 : 0;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            res += map.getOrDefault(cur - k, 0);
        }
        return res;
    }

    public static void main (String[] arg) {
        CountNumberOfNiceSubarrays test = new CountNumberOfNiceSubarrays();
        int[] nums = {1, 1, 2, 1, 2};
        int k = 3;
        System.out.println(test.countOfSubarrays(nums, k));
    }
}
