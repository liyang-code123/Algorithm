import java.util.ArrayDeque;
import java.util.Deque;

// Leetcode 716
public class MaxStack {
    static Deque<Integer> stack;
    Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            int max = Math.max(x, maxStack.peek());
            maxStack.push(max);
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        Deque<Integer> temp = new ArrayDeque<>();
        while(top() != max) {
            temp.push(stack.pop());
        }
        stack.pop();
        maxStack.pop();
        while(!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }

    public static void main(String[] args) {
        MaxStack test = new MaxStack();
        test.push(5);
        test.push(1);
        test.push(5);
        System.out.println(test.top());
        System.out.println(test.popMax());
        System.out.println(test.top());
        System.out.println(test.peekMax());
        System.out.println(test.pop());
        System.out.println(test.top());
    }
}
