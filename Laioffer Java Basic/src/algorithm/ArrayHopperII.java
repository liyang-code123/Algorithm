package algorithm;

import java.util.Arrays;

public class ArrayHopperII {
    public int arrayHopperII (int[] array) {
        int[] dp = new int[array.length];
        Arrays.fill(dp, array.length);
        dp[0] = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length && j < array[i]; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[array.length - 1] == array.length ? -1 : dp[array.length - 1];
    }

    public static void main (String[] args) {
        ArrayHopperII test = new ArrayHopperII();
        int[] array = {1, 2, 0, 3, 4, 1};
        System.out.println(test.arrayHopperII(array));
    }
}
