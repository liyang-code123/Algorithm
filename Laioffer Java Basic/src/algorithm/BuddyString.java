import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode 859
public class BuddyString {
    public boolean buddyString(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }

        if (source.equals(target)) {
            Set<Character> set = new HashSet<>();
            for (Character c : source.toCharArray()) {
                set.add(c);
            }
            return set.size() < source.length();
        }

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < source.length(); ++i) {
            if (source.charAt(i) != target.charAt(i)) {
                diff.add(i);
            }
        }
        return diff.size() == 2
                && source.charAt(diff.get(0)) == target.charAt(diff.get(1))
                && source.charAt(diff.get(1)) == target.charAt(diff.get(0));
    }

    public static void main(String[] args) {
        BuddyString test = new BuddyString();
        String source = "aaaabbbc";
        String target = "aaaacbbb";
        System.out.println(test.buddyString(source, target));
    }
}
