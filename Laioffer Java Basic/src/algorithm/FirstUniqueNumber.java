import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// LeetCode 1429
public class FirstUniqueNumber {
    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();


    public FirstUniqueNumber(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.poll();
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public void add(int value) {
        if (map.get(value) == null) {
            map.put(value, 1);
            queue.offer(value);
        } else {
            map.put(value, map.get(value) + 1);
            queue.offer(value);
        }
    }

    public static void main (String[] args) {
        int[] nums = {7, 7, 7, 4, 7, 3, 3, 4, 5, 3, 6};
        FirstUniqueNumber obj = new FirstUniqueNumber(nums);
        System.out.println(obj.showFirstUnique());
    }
}
