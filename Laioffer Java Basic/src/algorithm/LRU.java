import java.util.HashMap;
import java.util.Map;

// Leetcode 146
// hashmap to store key and value
// doubly-linked list to store key and value as well as keep the LRU sequence.
public class LRU {
    static class DDListNode {
        DDListNode pre;
        DDListNode next;
        int val;
        int key;
    }

    private Map<Integer, DDListNode> map = map = new HashMap<>();
    private DDListNode head, tail;
    private int size;
    private int capacity;

    public LRU(int size, int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DDListNode();
        this.tail = new DDListNode();

        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        DDListNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.val;
    }

    public void put (int key, int value) {
        DDListNode node = map.get(key);
        if (node == null) {
            DDListNode newNode = new DDListNode();
            newNode.key = key;
            newNode.val = value;

            map.put(key, newNode);
            addNode(newNode);
            ++size;

            if (size > capacity) {
                DDListNode popTail = tail.pre;
                removeNode(popTail);
                map.remove(popTail.key);
                --size;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }


    private void moveToHead(DDListNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(DDListNode node) {
        node.next = head.next;
        node.pre = head.pre;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DDListNode node) {
        DDListNode pre = node.pre;
        DDListNode next = node.next;

        pre.next = next;
        next.pre= pre;
    }

    public static void main(String[] args) {
        LRU test = new LRU(0, 3);

        System.out.println(test.get(2));
        test.put(1, 10);
        test.put(2, 20);
        test.put(3, 30);
        System.out.println(test.get(2));

        test.put(4, 40);
        test.put(5, 50);
        test.put(6, 60);
        System.out.println(test.get(1));






    }

}
