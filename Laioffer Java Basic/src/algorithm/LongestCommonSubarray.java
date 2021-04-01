package algorithm;

public class LongestCommonSubarray {
    public String longestCommon(String source, String target) {
        int[][] dp = new int[source.length() + 1][target.length() + 1];
        dp[0][0] = 0;
        int maxLength = 0;
        int end = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) dp[i][j] = 0;
                else if (j ==0) dp[i][j] = 0;
                else {
                    if (source.charAt(i - 1) == target.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if (dp[i][j] > maxLength) {
                            maxLength = dp[i][j];
                            end = i;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        if (maxLength != 0) {
            return source.substring(end - maxLength, end);
        }
        return "";
    }
}
