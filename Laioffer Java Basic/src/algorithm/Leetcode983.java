import java.util.HashSet;
import java.util.Set;

public class Leetcode983 {
    public int minCost(int[] days, int costs[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : days) {
            set.add(i);
        }

        int[] dp = new int[366];
        for (int i = 1; i < 366; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            }
        }
        return dp[365];
    }

    public static void main(String[] args) {
        Leetcode983 test = new Leetcode983();
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(test.minCost(days, costs));
    }
}
