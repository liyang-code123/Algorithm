package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorIII {
    public int basicCalculatorIII (String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num = c - '0';
            if (Character.isDigit(c)) {
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    nums.push(operations(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedent(c, ops.peek())) {

                }
            }

        }
    }
}
