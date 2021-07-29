import java.time.chrono.IsoChronology;
import java.util.HashMap;
import java.util.Map;

// Leetcode 205
public class IsomorphicString {
    public boolean isIsomorphic(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c1 = source.charAt(i);
            char c2 = target.charAt(i);
            if (!map.containsKey(c1)) {
                if (!map.containsValue(c1)) {
                    map.put(c1, c2);
                } else {
                    return false;
                }
            } else {
                if (map.get(c1) == c2) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicString test = new IsomorphicString();
        System.out.println(test.isIsomorphic("aaaabbcddd", "aaaaddcddd"));
    }
}
