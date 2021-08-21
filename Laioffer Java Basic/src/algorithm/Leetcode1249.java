import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1249 {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }

    public static void main(String[] args) {
        Leetcode1249 test = new Leetcode1249();
        System.out.println(test.minRemoveToMakeValid("a)b(c)d)"));
    }
}
