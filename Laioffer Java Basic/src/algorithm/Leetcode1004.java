public class Leetcode1004 {
    public int maxConsecutiveOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        int left = 0;
        int res = 0;
        int zero = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
            }
            if (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1004 test = new Leetcode1004();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(test.maxConsecutiveOnes(nums, 2));
    }
}
