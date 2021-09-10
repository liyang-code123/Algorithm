import java.util.ArrayDeque;
import java.util.Deque;

// basic calculatorIII
public class Leetcode772 {
    public int calculator(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Deque<Integer> stackNum = new ArrayDeque<>();
        Deque<Character> stackOps = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                }
                stackNum.push(num);
                num = 0;
            } else if (c == '(') {
                stackOps.push(c);
            } else if (c == ')') {
                while(!stackOps.isEmpty() && stackOps.peek() != '(') {
                    stackNum.push(operations(stackNum.pop(), stackNum.pop(), stackOps.pop()));
                }
                stackOps.pop();
            } else if (c == '+' || c == '-' || c == '*' || c== '/') {
                while(!stackOps.isEmpty() && priority(c, stackOps.peek())) {
                    stackNum.push(operations(stackNum.pop(), stackNum.pop(), stackOps.pop()));
                }
                stackOps.push(c);
            }
        }

        while(!stackOps.isEmpty()) {
            stackNum.push(operations(stackNum.pop(), stackNum.pop(), stackOps.pop()));
        }
        return stackNum.pop();
    }

    private int operations(int a, int b, char c) {
        switch(c){
            case'+' : return a + b;
            case'-' : return a - b;
            case'*' : return a * b;
            case'/' : return a / b;
        }
        return 0;
    }

    private boolean priority(char c1, char c2) {
        if (c2 == '(' || c2 == ')') {
            return false;
        }
        if ((c1 == '*' || c1 == '/')&&(c2 =='+' || c2 =='-')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode772 test = new Leetcode772();
        System.out.println(test.calculator("((3+2)*8+5)"));
    }
}
