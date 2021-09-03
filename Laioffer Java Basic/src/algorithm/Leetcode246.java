import java.util.HashMap;
import java.util.Map;

public class Leetcode246 {
    public boolean strobogrammaticNumber(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');

        int left = 0;
        int right = num.length() - 1;
        while(left <= right) {
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode246 test = new Leetcode246();
        System.out.println(test.strobogrammaticNumber("99996666"));
        System.out.println(test.strobogrammaticNumber("18881"));
    }
}
