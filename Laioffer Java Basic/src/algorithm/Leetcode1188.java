import java.util.ArrayDeque;
import java.util.Queue;

// Design Bounded Blocking Queue
public class Leetcode1188 {
    Queue<Integer> queue = new ArrayDeque<>();
    Object lock = new Object();
    int capacity;

    public Leetcode1188(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() > capacity) {
                lock.wait();
            }
            queue.add(element);
            notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int val = 0;
        synchronized (lock) {
            while (queue.size() == 0) {
                lock.wait();;
            }
            val = queue.remove();
            lock.notifyAll();;
        }
        return val;
    }

    public int size() {
        return queue.size();
    }
}
