package algorithm2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            if (aster > 0) {
                stack.push(aster);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(aster)) {
                    stack.pop();
                }
                if (stack.isEmpty() || aster < 0) {
                    stack.push(aster);
                } else if (aster + stack.peek() == 0) {
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main (String[] args) {
        AsteroidCollision test = new AsteroidCollision();
        int[] array = {1, 2, -3, 3, -4, 5};
        System.out.println(Arrays.toString(test.asteroidCollision(array)));
    }
}
