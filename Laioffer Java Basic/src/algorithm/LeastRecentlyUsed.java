package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsed {
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private int size = 0;
    private int capacity;
    private DLinkedNode head, tail;
    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LeastRecentlyUsed() {
        this.size = size;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)  return -1;
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addToHead(newNode);
            ++size;

            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LeastRecentlyUsed test = new LeastRecentlyUsed();
        int key = 1;
        int value = 2;
        int capacity = 3;
        DLinkedNode head = new DLinkedNode();
        head.key = 1;
        head.value = 2;
        System.out.println(test.get(key));
    }
}
