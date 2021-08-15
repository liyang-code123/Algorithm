import java.util.ArrayList;
import java.util.List;

public class TestJustification {
    public List<String> testJustification (String[] words, int maxLength) {
        List<String> result = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRight(words, left, maxLength);
            result.add(justify(words, left, right, maxLength));
            left = right + 1;
        }
        return result;
    }

    private int findRight(String[] words, int left, int maxLength) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && sum + 1 + words[right].length() <= maxLength) {
            sum += 1 + words[right++].length();
        }
        return right - 1;
    }

    private String justify(String[] words, int left, int right, int maxLength) {
        if (right - left == 0) {
            return padResult(words[left], maxLength);
        }

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpaces = maxLength - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpaces / numSpaces);
        int remainder = isLastLine ? 0 : totalSpaces % numSpaces;

        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");
        }

        return padResult(sb.toString().trim(), maxLength);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }
        return wordsLength;
    }

    private String padResult(String word, int maxLength) {
        return word + blank(maxLength - word.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

    public static void main (String[] args) {
        TestJustification test = new TestJustification();
        String[] words = {"I", "love", "coding","wish", "me", "good", "luck", "blessing"};
        int maxLength = 10;
        System.out.println(test.testJustification(words, maxLength));
    }
}
