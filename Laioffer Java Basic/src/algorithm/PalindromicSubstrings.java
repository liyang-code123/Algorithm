// LeetCode 647
public class PalindromicSubstrings {
    public int palindromicSubstrings (String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += helper(s, i, i);
            res += helper(s, i, i + 1);
        }
        return res;
    }

    private int helper(String s, int low, int high) {
        int ans = 0;
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            low--;
            high++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstrings test = new PalindromicSubstrings();
        String s = "abcabccba";
        System.out.println(test.palindromicSubstrings(s));
    }
}
