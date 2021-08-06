// Shortest Word Distance
public class Leetcode243 {
    public int shortestDistance(String[] wordDict, String word1, String word2) {
        int index1 = -1, index2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < wordDict.length; ++i) {
            if (word1.equals(wordDict[i])) {
                index1 = i;
            }
            if (word2.equals(wordDict[i])) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode243 test = new Leetcode243();
        String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(test.shortestDistance(wordDict, "coding", "practice"));
    }
}
