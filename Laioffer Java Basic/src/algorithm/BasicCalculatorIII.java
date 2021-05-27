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
                    nums.push(operations(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(operations(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private int operations (char c, int a, int b) {
        switch(c) {
            case '+' : return b + a;
            case '-' : return b - a;
            case '*' : return b * a;
            case '/' : return b / a;
        }
        return 0;
    }

    private boolean precedent(char c1, char c2) {
        if (c2 == '(') return false;
        if ((c1 == '*' || c1 == '/') && (c2 == '+' || c2 =='-')) return false;
        return true;
    }

    public static void main (String[] args) {
        BasicCalculatorIII test = new BasicCalculatorIII();
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(test.basicCalculatorIII(s));
    }
}
