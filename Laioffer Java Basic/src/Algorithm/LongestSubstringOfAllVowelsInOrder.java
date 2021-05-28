package algorithm2;

// LeetCode 1839
public class LongestSubstringOfAllVowelsInOrder {
    public static int longest(String word) {
        // corner case
        if (word == null || word.length() < 5) return 0;

        int beatiCount = 0;
        int vCount = 1;
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i != 0 && word.charAt(i - 1) > word.charAt(i) ) {
                vCount = 0;
                beatiCount = 0;
            }
            beatiCount++;

            if (i != 0 && word.charAt(i - 1) != word.charAt(i)) {
                vCount++;
            }

            if (vCount == 5) {
                res = Math.max(res, beatiCount);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String word = "aeiouuuuuu";
        System.out.println(LongestSubstringOfAllVowelsInOrder.longest(word));
    }
}
