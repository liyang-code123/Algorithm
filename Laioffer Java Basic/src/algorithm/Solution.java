import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String remove(String input, String t) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); ++i) {
            set.add(t.charAt(i));
        }

        for (int i = 0; i < input.length(); ++i) {
            if (!set.contains(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}