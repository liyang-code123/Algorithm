public class EditDistance {
    // another solution is to use only one row and one column to save space!
    public int editDistance(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        System.out.println(test.editDistance("aaab", "b"));
    }
}
