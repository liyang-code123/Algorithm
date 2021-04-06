package algorithm;

public class LongestAscendingSubsequence {
    public static int longest(int[] array) {
        // corner case
        if (array == null || array.length == 0) return 0;

        int[] dp = new int[array.length];
        dp[0] = 1;
        int globalMax = 1;

        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            // this is wrong code... because dp[i] should be inherited from its previous max. not dp[i - 1]
//            if (array[i] > array[ i - 1]) {
//                dp[i] = dp[i - 1] + 1;
//            } else {
                for (int j = 0; j < i; j++) {
                    if (array[i] > array[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
//            }
            globalMax = Math.max(globalMax, dp[i]);
        }
        return globalMax;
    }

    public static void main (String[] args) {
        int[] array = new int[]{5, 2, 6, 3, 4, 7, 5};
        System.out.println(LongestAscendingSubsequence.longest(array));
    }
}

